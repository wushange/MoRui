package cn.connxun.morui.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wushange on 2017/8/16.
 */

@Entity
public class PlanDetail {


    /**
     * id : 1
     * name : 氮气泄露紧急预案
     * categoryName : 突发事故预案
     * content :
     * fileName : 安防综合管理平台部署文档.docx
     * filePath : /contingencyInfo/20170815/20170815012625798307.docx
     * createDate : 2017-08-15 01:26
     */

    @Id
    private long id;
    private String name;
    private String categoryName;
    private String content;
    private String fileName;
    private String filePath;
    private String createDate;

    @Generated(hash = 1729147415)
    public PlanDetail(long id, String name, String categoryName, String content,
            String fileName, String filePath, String createDate) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.content = content;
        this.fileName = fileName;
        this.filePath = filePath;
        this.createDate = createDate;
    }

    @Generated(hash = 1538846351)
    public PlanDetail() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "PlanDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", content='" + content + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
