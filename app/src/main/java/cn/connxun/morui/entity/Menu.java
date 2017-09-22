package cn.connxun.morui.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.connxun.morui.R;

/**
 * Created by wushange on 2017/7/19.
 */

public class Menu implements Serializable {
    private MENU_ID id;
    private String  menuName;
    private int     menuIcon;

    public Menu(MENU_ID id, String menuName, int menuIcon) {
        this.id = id;
        this.menuName = menuName;
        this.menuIcon = menuIcon;
    }

    public MENU_ID getId() {
        return id;
    }

    public void setId(MENU_ID id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(int menuIcon) {
        this.menuIcon = menuIcon;
    }


    public enum MENU_ID {
        TASK_ALLOCT,
        TASK_INSPECT,
        INSPECT_RECORD,
        HISTORY_RECORD,
        CONTINGENCY_PLAN,
        SCENE_DISPOSAL_PLAN,
        STATISTICAL_REPORT,
        SCENE_VIEDO,
        CONTACTS,
        SYNC_TASK,
        GUIDE,
        FILE_DOC,
        NOTICE,
        CHANGE_TASK
    }


    public static List<Menu> getHomeMenusByAdmin() {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu(Menu.MENU_ID.TASK_ALLOCT, "任务分配", R.mipmap.ic_home_rwfp));
        menuList.add(new Menu(Menu.MENU_ID.TASK_INSPECT, "巡检任务", R.mipmap.ic_home_xjrw));
        menuList.add(new Menu(Menu.MENU_ID.INSPECT_RECORD, "巡检记录", R.mipmap.ic_home_xjjl));
        menuList.add(new Menu(Menu.MENU_ID.HISTORY_RECORD, "历史纪录", R.mipmap.ic_home_lshjl));
        menuList.add(new Menu(Menu.MENU_ID.CONTINGENCY_PLAN, "应急预案", R.mipmap.ic_home_yjyan));
//        menuList.add(new Menu(Menu.MENU_ID.SCENE_DISPOSAL_PLAN,"现场处置方案", R.mipmap.ic_home_xchczhfan));
        menuList.add(new Menu(Menu.MENU_ID.STATISTICAL_REPORT, "统计报表", R.mipmap.ic_home_tjbb));
        menuList.add(new Menu(Menu.MENU_ID.SCENE_VIEDO, "现场视频", R.mipmap.ic_home_xcshp));
        menuList.add(new Menu(Menu.MENU_ID.CONTACTS, "通讯录", R.mipmap.ic_home_txl));
        menuList.add(new Menu(Menu.MENU_ID.SYNC_TASK, "同步任务", R.mipmap.ic_home_tbrw));
        menuList.add(new Menu(Menu.MENU_ID.GUIDE, "操作指南", R.mipmap.ic_home_czzhn));
        menuList.add(new Menu(Menu.MENU_ID.FILE_DOC, "文件文档", R.mipmap.ic_home_wjwd));
        menuList.add(new Menu(Menu.MENU_ID.NOTICE, "通知公告", R.mipmap.ic_home_tzhgg));
        menuList.add(new Menu(MENU_ID.CHANGE_TASK, "整改任务", R.mipmap.ic_home_tzhgg));
        return menuList;
    }

    public static List<Menu> getHomeMenusByWorks() {
        List<Menu> menuList = new ArrayList<>();
//        menuList.add(new Menu(Menu.MENU_ID.TASK_ALLOCT,"任务分配", R.mipmap.ic_home_rwfp));
        menuList.add(new Menu(Menu.MENU_ID.TASK_INSPECT, "巡检任务", R.mipmap.ic_home_xjrw));
        menuList.add(new Menu(Menu.MENU_ID.INSPECT_RECORD, "巡检记录", R.mipmap.ic_home_xjjl));
        menuList.add(new Menu(Menu.MENU_ID.HISTORY_RECORD, "历史纪录", R.mipmap.ic_home_lshjl));
        menuList.add(new Menu(Menu.MENU_ID.CONTINGENCY_PLAN, "应急预案", R.mipmap.ic_home_yjyan));
//        menuList.add(new Menu(Menu.MENU_ID.SCENE_DISPOSAL_PLAN,"现场处置方案", R.mipmap.ic_home_xchczhfan));
//        menuList.add(new Menu(Menu.MENU_ID.STATISTICAL_REPORT,"统计报表", R.mipmap.ic_home_tjbb));
//        menuList.add(new Menu(Menu.MENU_ID.SCENE_VIEDO,"现场视频", R.mipmap.ic_home_xcshp));
        menuList.add(new Menu(Menu.MENU_ID.CONTACTS, "通讯录", R.mipmap.ic_home_txl));
        menuList.add(new Menu(Menu.MENU_ID.SYNC_TASK, "同步任务", R.mipmap.ic_home_tbrw));
        menuList.add(new Menu(Menu.MENU_ID.GUIDE, "操作指南", R.mipmap.ic_home_czzhn));
        menuList.add(new Menu(Menu.MENU_ID.FILE_DOC, "文件文档", R.mipmap.ic_home_wjwd));
        menuList.add(new Menu(Menu.MENU_ID.NOTICE, "通知公告", R.mipmap.ic_home_tzhgg));
        menuList.add(new Menu(MENU_ID.CHANGE_TASK, "整改任务", R.mipmap.ic_home_tzhgg));
        return menuList;
    }
}
