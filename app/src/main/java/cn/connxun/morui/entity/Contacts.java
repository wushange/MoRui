package cn.connxun.morui.entity;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import cn.connxun.morui.widget.treeview.TreeNodeId;
import cn.connxun.morui.widget.treeview.TreeNodeLabel;
import cn.connxun.morui.widget.treeview.TreeNodePid;

/**
 * Created by wushange on 2017/8/17.
 */

@Entity
public class Contacts {
    /**
     * id : DK200
     * name : 生产部
     * pId : 0
     */
    @Id
    @TreeNodeId
    private String id;
    @TreeNodeLabel
    private String name;
    @TreeNodePid
    private String pId;

    private long userId;

    @Generated(hash = 719121495)
    public Contacts(String id, String name, String pId, long userId) {
        this.id = id;
        this.name = name;
        this.pId = pId;
        this.userId = userId;
    }

    @Generated(hash = 1804918957)
    public Contacts() {
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pId='" + pId + '\'' +
                '}';
    }

    public String getPId() {
        return this.pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
