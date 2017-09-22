package cn.connxun.morui.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wushange on 2017/9/6.
 */

@Entity
public class AllotUser {


    /**
     * id : 174
     * realname : 孙经理
     * enterpriseId : 1
     * departmentId : 10
     * jobsId : 25
     */

    @Id
    private long id;
    private String realname;
    private int enterpriseId;
    private int departmentId;
    private int jobsId;
    private long userId;
    @Generated(hash = 1476179774)
    public AllotUser(long id, String realname, int enterpriseId, int departmentId,
            int jobsId, long userId) {
        this.id = id;
        this.realname = realname;
        this.enterpriseId = enterpriseId;
        this.departmentId = departmentId;
        this.jobsId = jobsId;
        this.userId = userId;
    }

    @Generated(hash = 1157338841)
    public AllotUser() {
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getJobsId() {
        return jobsId;
    }

    public void setJobsId(int jobsId) {
        this.jobsId = jobsId;
    }

    @Override
    public String toString() {
        return "AllotUser{" +
                "id=" + id +
                ", realname='" + realname + '\'' +
                ", enterpriseId=" + enterpriseId +
                ", departmentId=" + departmentId +
                ", jobsId=" + jobsId +
                '}';
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
