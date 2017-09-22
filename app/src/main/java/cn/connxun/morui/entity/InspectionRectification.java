package cn.connxun.morui.entity;

import java.io.Serializable;

/**
 * Created by 高宇飞 on 2017/8/24 13:34:18
 * 整改任务
 */
public class InspectionRectification implements Serializable {
    private String id;
    //整改任务名称
    private String name;
    //整改任务描述
    private String remark;
    //检查点id
    private String pointId;
    //检查点名称
    private String pointName;
    //部门编号
    private String departmentCode;
    //部门名称
    private String departmentName;
    //岗位编号
    private String jobsCode;
    //岗位名称
    private String jobsName;
    //设备名称
    private String equipmentName;
    //检查对象名称
    private String objectName;
    //异常图片
    private String abnormalityImg;
    //整改人企业id
    private Integer rectificationEnterpriseId;
    //整改人部门id
    private Integer rectificationDepartmentId;
    //整改人岗位id
    private Integer rectificationJobsId;
    //整改人用户id
    private Integer rectificationUserId;
    //整改人用户id
    private String rectificationUserName;
    //专项资金
    private String specialFunds;
    //是否整改完成
    private Integer status;
    //整改时间
    private String rectificationDate;
    //整改后图片
    private String rectificationImg;
    //创建时间
    private String createDate;

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

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getJobsCode() {
        return jobsCode;
    }

    public void setJobsCode(String jobsCode) {
        this.jobsCode = jobsCode;
    }

    public String getJobsName() {
        return jobsName;
    }

    public void setJobsName(String jobsName) {
        this.jobsName = jobsName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getAbnormalityImg() {
        return abnormalityImg;
    }

    public void setAbnormalityImg(String abnormalityImg) {
        this.abnormalityImg = abnormalityImg;
    }

    public Integer getRectificationEnterpriseId() {
        return rectificationEnterpriseId;
    }

    public void setRectificationEnterpriseId(Integer rectificationEnterpriseId) {
        this.rectificationEnterpriseId = rectificationEnterpriseId;
    }

    public Integer getRectificationDepartmentId() {
        return rectificationDepartmentId;
    }

    public void setRectificationDepartmentId(Integer rectificationDepartmentId) {
        this.rectificationDepartmentId = rectificationDepartmentId;
    }

    public Integer getRectificationJobsId() {
        return rectificationJobsId;
    }

    public void setRectificationJobsId(Integer rectificationJobsId) {
        this.rectificationJobsId = rectificationJobsId;
    }

    public Integer getRectificationUserId() {
        return rectificationUserId;
    }

    public void setRectificationUserId(Integer rectificationUserId) {
        this.rectificationUserId = rectificationUserId;
    }

    public String getRectificationUserName() {
        return rectificationUserName;
    }

    public void setRectificationUserName(String rectificationUserName) {
        this.rectificationUserName = rectificationUserName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRectificationDate() {
        return rectificationDate;
    }

    public void setRectificationDate(String rectificationDate) {
        this.rectificationDate = rectificationDate;
    }

    public String getRectificationImg() {
        return rectificationImg;
    }

    public void setRectificationImg(String rectificationImg) {
        this.rectificationImg = rectificationImg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getSpecialFunds() {
        return specialFunds;
    }

    public void setSpecialFunds(String specialFunds) {
        this.specialFunds = specialFunds;
    }
}
