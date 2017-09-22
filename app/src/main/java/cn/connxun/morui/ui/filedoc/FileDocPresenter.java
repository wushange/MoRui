package cn.connxun.morui.ui.filedoc;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;

import java.util.List;

import javax.inject.Inject;

import cn.connxun.morui.api.DocumentApi;
import cn.connxun.morui.data.local.DocumentStorge;
import cn.connxun.morui.di.PerActivity;
import cn.connxun.morui.entity.Document;
import cn.connxun.morui.entity.ListBean;
import cn.connxun.morui.ui.base.BasePresenter;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by wanglj on 16/7/4.
 */


@PerActivity
public class FileDocPresenter extends BasePresenter<FileDocContract.FileDocView> implements FileDocContract.FileDocPresenter {


    private DocumentApi    documentApi;
    private DocumentStorge storge;

    @Inject
    public FileDocPresenter(DocumentApi documentApi, DocumentStorge storge) {
        this.documentApi = documentApi;
        this.storge = storge;
    }

    @Override
    public void getList() {
        if (!NetworkUtils.isConnected()) {
            LogUtils.e("offline mode...");
            List<Document>     documents        = storge.getOfflineList();
            ListBean<Document> documentListBean = new ListBean<>();
            documentListBean.setTotal(documents.size());
            documentListBean.setList(documents);
            mView.showList(documentListBean);
            return;
        }
        mDisposable.add(documentApi.getList("1", "20", "").subscribe(new Consumer<ListBean<Document>>() {
            @Override
            public void accept(@NonNull ListBean<Document> documentListBean) throws Exception {
                storge.saveList(documentListBean.getList());
                mView.showList(documentListBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {

            }
        }));
    }
}
