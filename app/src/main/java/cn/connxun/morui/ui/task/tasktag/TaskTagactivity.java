package cn.connxun.morui.ui.task.tasktag;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.stetho.common.LogUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import cn.connxun.morui.R;
import cn.connxun.morui.ui.base.BaseSwipeBackActivity;
import cn.connxun.morui.ui.task.taskstep.TaskStepActivity;

import static cn.connxun.morui.nfc.NFCUtils.dumpTagData;
import static cn.connxun.morui.nfc.NFCUtils.toHex;

/**
 * 识别TAG点
 * Created by wushange on 2017/7/20.
 */

public class TaskTagactivity extends BaseSwipeBackActivity {


    private static final String TASK_ID = "TASK_ID";

    public static void callMe(Context context, String taskId) {
        Intent intent = new Intent(context, TaskTagactivity.class);
        intent.putExtra(TASK_ID, taskId);
        context.startActivity(intent);
    }


    @BindView(R.id.avloadingview)
    AVLoadingIndicatorView avloadingview;
    @BindView(R.id.btn_tasktag)
    Button                 btnTasktag;
    @BindView(R.id.tv_result)
    TextView               tvResult;
    private NfcAdapter    mAdapter;
    private PendingIntent mPendingIntent;
    private NdefMessage   mNdefPushMessage;
    private List<Tag> mTags = new ArrayList<>();

    private String taskId = "";

    @Override
    public int bindLayout() {
        return R.layout.activity_task_tag;
    }

    @Override
    public void initParms(Bundle parms) {
        taskId = parms.getString(TASK_ID);
    }

    @Override
    public void initView(View view) {
        btnTasktag.setOnLongClickListener(v -> {
            TaskStepActivity.callMe(getContext(), taskId, "e00401500F71B223");
            return true;
        });
    }

    @Override
    public void doBusiness(Context mContext) {
        resolveIntent(getIntent());
        mAdapter = NfcAdapter.getDefaultAdapter(this);
        if (mAdapter == null) {
            mOperation.showBasicDialog(R.string.error, R.string.nfc_notsupport, (dialog, which) -> finish());
            tvResult.setText(R.string.nfc_notsupport);
            return;
        }

        tvResult.setText(R.string.nfc_init_ok);
        mPendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
        mNdefPushMessage = new NdefMessage(new NdefRecord[]{newTextRecord(
                "Message from NFC Reader :-)", Locale.ENGLISH, true)});
    }

    @Override
    public void initInjector() {

    }


    @Override
    protected void onResume() {
        super.onResume();
        if (mAdapter != null) {
            if (!mAdapter.isEnabled()) {
                tvResult.setText(R.string.nfc_disabled);
                mOperation.showBasicDialog(R.string.error, R.string.nfc_disabled, (dialog, which) -> {
                    Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                    startActivity(intent);
                });
            }
            mAdapter.enableForegroundDispatch(this, mPendingIntent, null, null);
            mAdapter.enableForegroundNdefPush(this, mNdefPushMessage);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAdapter != null) {
            mAdapter.disableForegroundDispatch(this);
            mAdapter.disableForegroundNdefPush(this);
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        setIntent(intent);
        resolveIntent(intent);
    }


    private NdefRecord newTextRecord(String text, Locale locale, boolean encodeInUtf8) {
        byte[]  langBytes   = locale.getLanguage().getBytes(Charset.forName("US-ASCII"));
        Charset utfEncoding = encodeInUtf8 ? Charset.forName("UTF-8") : Charset.forName("UTF-16");
        byte[]  textBytes   = text.getBytes(utfEncoding);
        int     utfBit      = encodeInUtf8 ? 0 : (1 << 7);
        char    status      = (char) (utfBit + langBytes.length);
        byte[]  data        = new byte[1 + langBytes.length + textBytes.length];
        data[0] = (byte) status;
        System.arraycopy(langBytes, 0, data, 1, langBytes.length);
        System.arraycopy(textBytes, 0, data, 1 + langBytes.length, textBytes.length);
        return new NdefRecord(NdefRecord.TNF_WELL_KNOWN, NdefRecord.RTD_TEXT, new byte[0], data);
    }

    private void resolveIntent(Intent intent) {
        Tag    tag    = null;
        String action = intent.getAction();
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {
            Parcelable[]  rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
            NdefMessage[] msgs;
            if (rawMsgs != null) {//
                msgs = new NdefMessage[rawMsgs.length];
                for (int i = 0; i < rawMsgs.length; i++) {
                    msgs[i] = (NdefMessage) rawMsgs[i];
                }
            } else {
                // Unknown tag type
                byte[] empty = new byte[0];
                byte[] id    = intent.getByteArrayExtra(NfcAdapter.EXTRA_ID);
                tag = (Tag) intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
                byte[]      payload = dumpTagData(tag).getBytes();
                NdefRecord  record  = new NdefRecord(NdefRecord.TNF_UNKNOWN, empty, id, payload);
                NdefMessage msg     = new NdefMessage(new NdefRecord[]{record});
                msgs = new NdefMessage[]{msg};
                mTags.add(tag);
//                tvResult.setText(dumpTagData(tag));

            }
            String tagValue = toHex(tag.getId()).replaceAll("\\s", "");
            LogUtil.e("-tagValue==>>" + tagValue);
            TaskStepActivity.callMe(getContext(), taskId, tagValue);
        }
    }


}
