package cn.connxun.morui.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class TaskSub {
    /**
     * id : 4028823d5def74b6015def8d21a100ca
     * taskId : 4028823d5def74b6015def8d218e009b
     * pointId : 4028823d5def74b6015def7a30c30000
     * pointName : 设备本体-压力
     * departmentCode : DK205
     * departmentName : 保全车间
     * jobsCode : DK205003
     * jobsName : 保全车间员工
     * equipmentName : 制冷循环水泵（东）
     * objectName : 设备本体
     * tag : 5020
     * gps : 空
     * isSubJudge : 0
     * subjectiveJudgment : null
     * unit : Mpa
     * minValue : 0.4
     * standardValue : 0.42
     * bigValue :
     * yellowWarning : 0.39
     * orangeWarning : 0.38
     * redWarning : 0.3
     * displayOrder : 2
     * contingencyScene : 紧急关闭
     * contingencyInfoCode :
     * importantLevel : 2
     * dangerLevel : 2
     * governmentPolicy : 2
     * checkResultValue : null
     * checkResult : null
     * remark : null
     * filePath : null
     */

    @Id
    private String id;
    private String taskId;
    private String pointId;
    private String pointName;
    private String departmentCode;
    private String departmentName;
    private String jobsCode;
    private String jobsName;
    private String equipmentName;
    private String objectName;
    private String tag;
    private String tagValue;
    private String gps;
    private int    isSubJudge;
    private String subjectiveJudgment;
    private String unit;
    private String minValue;
    private String standardValue;
    private String bigValue;
    private String yellowWarning;
    private String orangeWarning;
    private String redWarning;
    private int    displayOrder;
    private String contingencyScene;
    private String contingencyInfoCode;
    private String importantLevel;
    private String dangerLevel;
    private String governmentPolicy;
    private String checkUserName;
    private String checkDate;
    private String checkResultValue;
    private String checkResult;
    private String remark;
    private String filePath;

    /**
     * local var
     */
    private int checkStatus ;//检测状态 0 未检查 2 检查完


    @Generated(hash = 915182945)
    public TaskSub(String id, String taskId, String pointId, String pointName,
            String departmentCode, String departmentName, String jobsCode,
            String jobsName, String equipmentName, String objectName, String tag,
            String tagValue, String gps, int isSubJudge, String subjectiveJudgment,
            String unit, String minValue, String standardValue, String bigValue,
            String yellowWarning, String orangeWarning, String redWarning,
            int displayOrder, String contingencyScene, String contingencyInfoCode,
            String importantLevel, String dangerLevel, String governmentPolicy,
            String checkUserName, String checkDate, String checkResultValue,
            String checkResult, String remark, String filePath, int checkStatus) {
        this.id = id;
        this.taskId = taskId;
        this.pointId = pointId;
        this.pointName = pointName;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.jobsCode = jobsCode;
        this.jobsName = jobsName;
        this.equipmentName = equipmentName;
        this.objectName = objectName;
        this.tag = tag;
        this.tagValue = tagValue;
        this.gps = gps;
        this.isSubJudge = isSubJudge;
        this.subjectiveJudgment = subjectiveJudgment;
        this.unit = unit;
        this.minValue = minValue;
        this.standardValue = standardValue;
        this.bigValue = bigValue;
        this.yellowWarning = yellowWarning;
        this.orangeWarning = orangeWarning;
        this.redWarning = redWarning;
        this.displayOrder = displayOrder;
        this.contingencyScene = contingencyScene;
        this.contingencyInfoCode = contingencyInfoCode;
        this.importantLevel = importantLevel;
        this.dangerLevel = dangerLevel;
        this.governmentPolicy = governmentPolicy;
        this.checkUserName = checkUserName;
        this.checkDate = checkDate;
        this.checkResultValue = checkResultValue;
        this.checkResult = checkResult;
        this.remark = remark;
        this.filePath = filePath;
        this.checkStatus = checkStatus;
    }


    @Generated(hash = 1751713313)
    public TaskSub() {
    }



    public String getId() {
        return this.id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getTaskId() {
        return this.taskId;
    }


    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }


    public String getPointId() {
        return this.pointId;
    }


    public void setPointId(String pointId) {
        this.pointId = pointId;
    }


    public String getPointName() {
        return this.pointName;
    }


    public void setPointName(String pointName) {
        this.pointName = pointName;
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


    public String getEquipmentName() {
        return this.equipmentName;
    }


    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }


    public String getObjectName() {
        return this.objectName;
    }


    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }


    public String getTag() {
        return this.tag;
    }


    public void setTag(String tag) {
        this.tag = tag;
    }


    public String getGps() {
        return this.gps;
    }


    public void setGps(String gps) {
        this.gps = gps;
    }


    public int getIsSubJudge() {
        return this.isSubJudge;
    }


    public void setIsSubJudge(int isSubJudge) {
        this.isSubJudge = isSubJudge;
    }


    public String getSubjectiveJudgment() {
        return this.subjectiveJudgment;
    }


    public void setSubjectiveJudgment(String subjectiveJudgment) {
        this.subjectiveJudgment = subjectiveJudgment;
    }


    public String getUnit() {
        return this.unit;
    }


    public void setUnit(String unit) {
        this.unit = unit;
    }


    public String getMinValue() {
        return this.minValue;
    }


    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }


    public String getStandardValue() {
        return this.standardValue;
    }


    public void setStandardValue(String standardValue) {
        this.standardValue = standardValue;
    }


    public String getBigValue() {
        return this.bigValue;
    }


    public void setBigValue(String bigValue) {
        this.bigValue = bigValue;
    }


    public String getYellowWarning() {
        return this.yellowWarning;
    }


    public void setYellowWarning(String yellowWarning) {
        this.yellowWarning = yellowWarning;
    }


    public String getOrangeWarning() {
        return this.orangeWarning;
    }


    public void setOrangeWarning(String orangeWarning) {
        this.orangeWarning = orangeWarning;
    }


    public String getRedWarning() {
        return this.redWarning;
    }


    public void setRedWarning(String redWarning) {
        this.redWarning = redWarning;
    }


    public int getDisplayOrder() {
        return this.displayOrder;
    }


    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }


    public String getContingencyScene() {
        return this.contingencyScene;
    }


    public void setContingencyScene(String contingencyScene) {
        this.contingencyScene = contingencyScene;
    }


    public String getContingencyInfoCode() {
        return this.contingencyInfoCode;
    }


    public void setContingencyInfoCode(String contingencyInfoCode) {
        this.contingencyInfoCode = contingencyInfoCode;
    }


    public String getImportantLevel() {
        return this.importantLevel;
    }


    public void setImportantLevel(String importantLevel) {
        this.importantLevel = importantLevel;
    }


    public String getDangerLevel() {
        return this.dangerLevel;
    }


    public void setDangerLevel(String dangerLevel) {
        this.dangerLevel = dangerLevel;
    }


    public String getGovernmentPolicy() {
        return this.governmentPolicy;
    }


    public void setGovernmentPolicy(String governmentPolicy) {
        this.governmentPolicy = governmentPolicy;
    }


    public String getCheckResultValue() {
        return this.checkResultValue;
    }


    public void setCheckResultValue(String checkResultValue) {
        this.checkResultValue = checkResultValue;
    }


    public String getCheckResult() {
        return this.checkResult;
    }


    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }


    public String getRemark() {
        return this.remark;
    }


    public void setRemark(String remark) {
        this.remark = remark;
    }


    public String getFilePath() {
        return this.filePath;
    }


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    public int getCheckStatus() {
        return this.checkStatus;
    }


    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }


    public String getTagValue() {
        return this.tagValue;
    }


    public void setTagValue(String tagValue) {
        this.tagValue = tagValue;
    }


    public String getCheckUserName() {
        return this.checkUserName;
    }


    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName;
    }


    public String getCheckDate() {
        return this.checkDate;
    }


    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    @Override
    public String toString() {
        return "TaskSub{" +
                "id='" + id + '\'' +
                ", taskId='" + taskId + '\'' +
                ", pointId='" + pointId + '\'' +
                ", pointName='" + pointName + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", jobsCode='" + jobsCode + '\'' +
                ", jobsName='" + jobsName + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", objectName='" + objectName + '\'' +
                ", tag='" + tag + '\'' +
                ", tagValue='" + tagValue + '\'' +
                ", gps='" + gps + '\'' +
                ", isSubJudge=" + isSubJudge +
                ", subjectiveJudgment='" + subjectiveJudgment + '\'' +
                ", unit='" + unit + '\'' +
                ", minValue='" + minValue + '\'' +
                ", standardValue='" + standardValue + '\'' +
                ", bigValue='" + bigValue + '\'' +
                ", yellowWarning='" + yellowWarning + '\'' +
                ", orangeWarning='" + orangeWarning + '\'' +
                ", redWarning='" + redWarning + '\'' +
                ", displayOrder=" + displayOrder +
                ", contingencyScene='" + contingencyScene + '\'' +
                ", contingencyInfoCode='" + contingencyInfoCode + '\'' +
                ", importantLevel='" + importantLevel + '\'' +
                ", dangerLevel='" + dangerLevel + '\'' +
                ", governmentPolicy='" + governmentPolicy + '\'' +
                ", checkUserName='" + checkUserName + '\'' +
                ", checkDate='" + checkDate + '\'' +
                ", checkResultValue='" + checkResultValue + '\'' +
                ", checkResult='" + checkResult + '\'' +
                ", remark='" + remark + '\'' +
                ", filePath='" + filePath + '\'' +
                ", checkStatus=" + checkStatus +
                '}';
    }
}