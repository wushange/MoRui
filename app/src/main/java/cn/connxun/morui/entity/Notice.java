package cn.connxun.morui.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wushange on 2017/8/14.
 */

@Entity
public class Notice {


    /**
     * id : 1
     * noticeId : 4028823d5ddf26b4015ddf276eae0000
     * noticeName : 的萨达
     * noticeContent : 萨达萨达所啊
     * isConfirm : 0
     * userId : 123
     * isRead : 0
     * createDate : 2017-08-14 13:11:30
     */

    @Id
    private long id;
    private String noticeId;
    private String noticeName;
    private String noticeContent;
    private int    isConfirm;
    private int    userId;
    private int    isRead;
    private String createDate;


    @Generated(hash = 190309289)
    public Notice(long id, String noticeId, String noticeName, String noticeContent,
            int isConfirm, int userId, int isRead, String createDate) {
        this.id = id;
        this.noticeId = noticeId;
        this.noticeName = noticeName;
        this.noticeContent = noticeContent;
        this.isConfirm = isConfirm;
        this.userId = userId;
        this.isRead = isRead;
        this.createDate = createDate;
    }

    @Generated(hash = 1880392847)
    public Notice() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public int getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(int isConfirm) {
        this.isConfirm = isConfirm;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
