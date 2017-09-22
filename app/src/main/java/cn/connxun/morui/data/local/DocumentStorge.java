package cn.connxun.morui.data.local;

import android.content.Context;

import java.util.List;

import cn.connxun.morui.db.DocumentDao;
import cn.connxun.morui.entity.Document;

/**
 * Created by wushange on 2017/8/18.
 */

public class DocumentStorge {

    private Context     context;
    private DocumentDao documentDao;

    public DocumentStorge(Context mContext, DocumentDao dao) {
        this.documentDao = dao;
        this.context = mContext;
    }

    public void saveList(List<Document> documents) {
        documentDao.insertOrReplaceInTx(documents);
    }

    public List<Document> getOfflineList() {
        return documentDao.queryBuilder().build().list();
    }
}
