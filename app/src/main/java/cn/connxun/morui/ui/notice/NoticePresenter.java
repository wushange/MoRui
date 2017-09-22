package cn.connxun.morui.ui.notice;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;

import java.util.List;

import cn.connxun.morui.api.NoticeApi;
import cn.connxun.morui.data.local.NoticeStorge;
import cn.connxun.morui.entity.ListBean;
import cn.connxun.morui.entity.Notice;
import cn.connxun.morui.ui.base.BasePresenter;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by wanglj on 16/7/4.
 */


public class NoticePresenter extends BasePresenter<NoticeContract.NoticeView> implements NoticeContract.NoticePresenter {

    private NoticeStorge storge;
    private NoticeApi    api;
    public NoticePresenter(NoticeApi api, NoticeStorge storge) {
        this.api = api;
        this.storge = storge;
    }

    @Override
    public void getList() {
        if (!NetworkUtils.isConnected()) {
            LogUtils.e("offline mode...");
            List<Notice> notices = storge.getOfflineList();
            ListBean<Notice> noticeListBean = new ListBean<>();
            noticeListBean.setTotal(notices.size());
            noticeListBean.setList(notices);
            mView.showList(noticeListBean);
            return;
        }
        mDisposable.add(api.getListByUser(mView.getPage(), "15", mView.getNoticeType()).subscribe(new Consumer<ListBean<Notice>>() {
            @Override
            public void accept(@NonNull ListBean<Notice> noticeListBean) throws Exception {
                storge.saveList(noticeListBean.getList());
                mView.showList(noticeListBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {

            }
        }));
    }
}
