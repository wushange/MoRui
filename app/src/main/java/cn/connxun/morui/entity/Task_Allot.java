package cn.connxun.morui.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wushange on 2017/8/19.
 */
@Entity
public class Task_Allot {


    /**
     * id : 297edff85e552e0b015e565fdb600a0f
     * name : 保全车间日常巡检二2017-09-05
     * content : 保全车间日常巡检二
     * departmentCode : DK205
     * departmentName : 保全车间
     * jobsCode : DK20501
     * jobsName : 保全车间制冷工序
     * planId : 4028efee5e1c258a015e1c62f5450003
     * startDate : 2017-09-05 04:00
     * endDate : 2017-09-05 08:00
     * type : 1
     * status : 0
     * checkUserEnterpriseId : 0
     * checkUserDepartmentId : 0
     * checkUserJobsId : 0
     * checkUserId : 0
     * checkUserName : null
     * taskSubList : null
     */

    @Id
    private String id;
    private String name;
    private String content;
    private String departmentCode;
    private String departmentName;
    private String jobsCode;
    private String jobsName;
    private String planId;
    private String startDate;
    private String endDate;
    private int    type;
    private int    status;
    private int    checkUserEnterpriseId;
    private int    checkUserDepartmentId;
    private int    checkUserJobsId;
    private int    checkUserId;
    private String checkUserName;
    private String taskSubList;
    private long          userId;
    @Generated(hash = 1358801890)
    public Task_Allot(String id, String name, String content, String departmentCode,
            String departmentName, String jobsCode, String jobsName, String planId,
            String startDate, String endDate, int type, int status,
            int checkUserEnterpriseId, int checkUserDepartmentId,
            int checkUserJobsId, int checkUserId, String checkUserName,
            String taskSubList, long userId) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.jobsCode = jobsCode;
        this.jobsName = jobsName;
        this.planId = planId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.status = status;
        this.checkUserEnterpriseId = checkUserEnterpriseId;
        this.checkUserDepartmentId = checkUserDepartmentId;
        this.checkUserJobsId = checkUserJobsId;
        this.checkUserId = checkUserId;
        this.checkUserName = checkUserName;
        this.taskSubList = taskSubList;
        this.userId = userId;
    }

    @Generated(hash = 181705611)
    public Task_Allot() {
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

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getCheckUserName() {
        return this.checkUserName;
    }

    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName;
    }

    public String getTaskSubList() {
        return this.taskSubList;
    }

    public void setTaskSubList(String taskSubList) {
        this.taskSubList = taskSubList;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
