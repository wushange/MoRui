package cn.connxun.morui.entity;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.io.Serializable;
import java.util.List;

import cn.connxun.morui.db.DaoSession;
import cn.connxun.morui.db.TaskDao;
import cn.connxun.morui.db.TaskSubDao;

/**
 * Created by wushange on 2017/8/19.
 */
@Entity
public class Task implements Serializable{

    private static final long serialVersionUID = 6977402643848374753L;
    /**
     * id : 4028823d5def74b6015def8d218e009b
     * name : 2017-08-18保全车间日常巡检
     * content : 保全车间日常巡检
     * pointQuantity : null
     * pointQuantityAbnormality : null
     * departmentCode : DK205
     * departmentName : 保全车间
     * jobsCode :
     * jobsName :
     * planId : 4028823d5def74b6015def7bb46f0003
     * startDate : 2017-08-18 20:00
     * endDate : 2017-08-18 22:00
     * type : 1
     * checkUserEnterpriseId : 1
     * checkUserDepartmentId : 10
     * checkUserJobsId : 19
     * checkUserId : 174
     * taskSubList : [{"id":"4028823d5def74b6015def8d21a100ca","taskId":"4028823d5def74b6015def8d218e009b","pointId":"4028823d5def74b6015def7a30c30000","pointName":"设备本体-压力","departmentCode":"DK205","departmentName":"保全车间","jobsCode":"DK205003","jobsName":"保全车间员工","equipmentName":"制冷循环水泵（东）","objectName":"设备本体","tag":"5020","gps":"空","isSubJudge":0,"subjectiveJudgment":null,"unit":"Mpa","minValue":"0.4","standardValue":"0.42","bigValue":"","yellowWarning":"0.39","orangeWarning":"0.38","redWarning":"0.3","displayOrder":2,"contingencyScene":"紧急关闭","contingencyInfoCode":"","importantLevel":"2","dangerLevel":"2","governmentPolicy":"2","checkResultValue":null,"checkResult":null,"remark":null,"filePath":null},{"id":"4028823d5def74b6015def8d21a100cb","taskId":"4028823d5def74b6015def8d218e009b","pointId":"4028823d5def74b6015def7a82a80001","pointName":"设备本体-温度","departmentCode":"DK205","departmentName":"保全车间","jobsCode":"DK205003","jobsName":"保全车间员工","equipmentName":"制冷循环水泵（东）","objectName":"设备本体","tag":"5020","gps":"空","isSubJudge":1,"subjectiveJudgment":1,"unit":"","minValue":"","standardValue":"","bigValue":"","yellowWarning":"","orangeWarning":"","redWarning":"","displayOrder":2,"contingencyScene":"","contingencyInfoCode":"","importantLevel":"2","dangerLevel":"2","governmentPolicy":"2","checkResultValue":null,"checkResult":null,"remark":null,"filePath":null},{"id":"4028823d5def74b6015def8d21a100cc","taskId":"4028823d5def74b6015def8d218e009b","pointId":"4028823d5def74b6015def7adffb0002","pointName":"压力表-压力","departmentCode":"DK205","departmentName":"保全车间","jobsCode":"DK205003","jobsName":"保全车间员工","equipmentName":"三车间循环水泵","objectName":"压力表","tag":"5024","gps":"空","isSubJudge":1,"subjectiveJudgment":1,"unit":"","minValue":"","standardValue":"","bigValue":"","yellowWarning":"","orangeWarning":"","redWarning":"","displayOrder":3,"contingencyScene":"","contingencyInfoCode":"","importantLevel":"313","dangerLevel":"3","governmentPolicy":"3","checkResultValue":null,"checkResult":null,"remark":null,"filePath":null}]
     */

    @Id
    private String id;
    private String name;
    private String content;
    private String pointQuantity;
    private String pointQuantityAbnormality;
    private String departmentCode;
    private String departmentName;
    private String jobsCode;
    private String jobsName;
    private String planId;
    private String startDate;
    private String endDate;
    private int    type;
    private String checkUserName;
    private int    checkUserEnterpriseId;
    private int    checkUserDepartmentId;
    private int    checkUserJobsId;
    private int    checkUserId;
    private String uploadDate;
    private int    status;//  0 未分配待分配    1 已分配待确认    2已确认待执行  3已执行

    /**
     * local var
     */
    private int           checkStatus;//0 未检查 1 检查中 2 检查完成
    private int           uploadStatus;//0 未上传  2上传成功
    private long          userId;
    @ToMany(referencedJoinProperty = "taskId")
    private List<TaskSub> taskSubList;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1469429066)
    private transient TaskDao myDao;
    @Generated(hash = 1367250536)
    public Task(String id, String name, String content, String pointQuantity, String pointQuantityAbnormality, String departmentCode, String departmentName, String jobsCode, String jobsName, String planId, String startDate, String endDate, int type, String checkUserName, int checkUserEnterpriseId, int checkUserDepartmentId, int checkUserJobsId, int checkUserId, String uploadDate, int status, int checkStatus, int uploadStatus, long userId) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.pointQuantity = pointQuantity;
        this.pointQuantityAbnormality = pointQuantityAbnormality;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.jobsCode = jobsCode;
        this.jobsName = jobsName;
        this.planId = planId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.checkUserName = checkUserName;
        this.checkUserEnterpriseId = checkUserEnterpriseId;
        this.checkUserDepartmentId = checkUserDepartmentId;
        this.checkUserJobsId = checkUserJobsId;
        this.checkUserId = checkUserId;
        this.uploadDate = uploadDate;
        this.status = status;
        this.checkStatus = checkStatus;
        this.uploadStatus = uploadStatus;
        this.userId = userId;
    }
    @Generated(hash = 733837707)
    public Task() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getPointQuantity() {
        return this.pointQuantity;
    }
    public void setPointQuantity(String pointQuantity) {
        this.pointQuantity = pointQuantity;
    }
    public String getPointQuantityAbnormality() {
        return this.pointQuantityAbnormality;
    }
    public void setPointQuantityAbnormality(String pointQuantityAbnormality) {
        this.pointQuantityAbnormality = pointQuantityAbnormality;
    }
    public String getDepartmentCode() {
        return this.departmentCode;
    }
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
    public String getDepartmentName() {
        return this.departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getJobsCode() {
        return this.jobsCode;
    }
    public void setJobsCode(String jobsCode) {
        this.jobsCode = jobsCode;
    }
    public String getJobsName() {
        return this.jobsName;
    }
    public void setJobsName(String jobsName) {
        this.jobsName = jobsName;
    }
    public String getPlanId() {
        return this.planId;
    }
    public void setPlanId(String planId) {
        this.planId = planId;
    }
    public String getStartDate() {
        return this.startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return this.endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getCheckUserName() {
        return this.checkUserName;
    }
    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName;
    }
    public int getCheckUserEnterpriseId() {
        return this.checkUserEnterpriseId;
    }
    public void setCheckUserEnterpriseId(int checkUserEnterpriseId) {
        this.checkUserEnterpriseId = checkUserEnterpriseId;
    }
    public int getCheckUserDepartmentId() {
        return this.checkUserDepartmentId;
    }
    public void setCheckUserDepartmentId(int checkUserDepartmentId) {
        this.checkUserDepartmentId = checkUserDepartmentId;
    }
    public int getCheckUserJobsId() {
        return this.checkUserJobsId;
    }
    public void setCheckUserJobsId(int checkUserJobsId) {
        this.checkUserJobsId = checkUserJobsId;
    }
    public int getCheckUserId() {
        return this.checkUserId;
    }
    public void setCheckUserId(int checkUserId) {
        this.checkUserId = checkUserId;
    }
    public String getUploadDate() {
        return this.uploadDate;
    }
    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }
    public int getStatus() {
        return this.status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public int getCheckStatus() {
        return this.checkStatus;
    }
    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }
    public int getUploadStatus() {
        return this.uploadStatus;
    }
    public void setUploadStatus(int uploadStatus) {
        this.uploadStatus = uploadStatus;
    }
    public long getUserId() {
        return this.userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 603852898)
    public List<TaskSub> getTaskSubList() {
        if (taskSubList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TaskSubDao targetDao = daoSession.getTaskSubDao();
            List<TaskSub> taskSubListNew = targetDao._queryTask_TaskSubList(id);
            synchronized (this) {
                if (taskSubList == null) {
                    taskSubList = taskSubListNew;
                }
            }
        }
        return taskSubList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 307750721)
    public synchronized void resetTaskSubList() {
        taskSubList = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1442741304)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTaskDao() : null;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", pointQuantity='" + pointQuantity + '\'' +
                ", pointQuantityAbnormality='" + pointQuantityAbnormality + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", jobsCode='" + jobsCode + '\'' +
                ", jobsName='" + jobsName + '\'' +
                ", planId='" + planId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", type=" + type +
                ", checkUserName='" + checkUserName + '\'' +
                ", checkUserEnterpriseId=" + checkUserEnterpriseId +
                ", checkUserDepartmentId=" + checkUserDepartmentId +
                ", checkUserJobsId=" + checkUserJobsId +
                ", checkUserId=" + checkUserId +
                ", uploadDate='" + uploadDate + '\'' +
                ", status=" + status +
                ", checkStatus=" + checkStatus +
                ", uploadStatus=" + uploadStatus +
                ", userId=" + userId +
                ", taskSubList=" + taskSubList +
                '}';
    }
}
