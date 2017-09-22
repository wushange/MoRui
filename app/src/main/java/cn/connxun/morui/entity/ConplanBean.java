package cn.connxun.morui.entity;

/**
 * Created by wushange on 2017/7/24.
 */

public class ConplanBean {
    private String cpTitle;
    private String cpSubTitle;
    private String cpContent;

    public String getCpTitle() {
        return cpTitle;
    }

    public void setCpTitle(String cpTitle) {
        this.cpTitle = cpTitle;
    }

    public String getCpSubTitle() {
        return cpSubTitle;
    }

    public void setCpSubTitle(String cpSubTitle) {
        this.cpSubTitle = cpSubTitle;
    }

    public String getCpContent() {
        return cpContent;
    }

    public void setCpContent(String cpContent) {
        this.cpContent = cpContent;
    }

    @Override
    public String toString() {
        return "ConplanBean{" +
                "cpTitle='" + cpTitle + '\'' +
                ", cpSubTitle='" + cpSubTitle + '\'' +
                ", cpContent='" + cpContent + '\'' +
                '}';
    }


}
