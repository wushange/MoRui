package cn.connxun.morui.constants.enums;

/**
 * 子任务检查结果正常or异常
 */
public enum TASKSUB_CHECK_RESULT {
    NORMAL(0), ABNORMAL(1),YELLO(101),ORANGE(102),RED(103);
    final int value;

    TASKSUB_CHECK_RESULT(int i) {
        this.value = i;
    }

    public int value() {
        return value;
    }
}