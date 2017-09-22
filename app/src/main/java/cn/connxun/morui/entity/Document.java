package cn.connxun.morui.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wushange on 2017/8/16.
 */

@Entity
public class Document {

    @Id
    private String id;
    private String category;
    private String fileName;
    private String filePath;

    @Generated(hash = 1406368167)
    public Document(String id, String category, String fileName, String filePath) {
        this.id = id;
        this.category = category;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    @Generated(hash = 91234483)
    public Document() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", category=" + category +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
