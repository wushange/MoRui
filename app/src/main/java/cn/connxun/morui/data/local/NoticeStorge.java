package cn.connxun.morui.data.local;

import android.content.Context;

import java.util.List;

import cn.connxun.morui.db.NoticeDao;
import cn.connxun.morui.entity.Notice;

/**
 * Created by wushange on 2017/8/18.
 */

public class NoticeStorge {
    private Context   context;
    private NoticeDao dao;

    public NoticeStorge(Context mContext, NoticeDao dao) {
        this.dao = dao;
        this.context = mContext;
    }

    public void saveList(List<Notice> documents) {
        dao.insertOrReplaceInTx(documents);
    }
    public List<Notice> getOfflineListByType(String type) {
        return dao.queryBuilder().build().list();
    }
    public List<Notice> getOfflineList() {
        return dao.queryBuilder().build().list();
    }
}
