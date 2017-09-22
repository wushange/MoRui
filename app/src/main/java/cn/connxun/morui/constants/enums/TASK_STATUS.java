package cn.connxun.morui.constants.enums;

/**
 * 任务状态 是否检查 是否检查完成 是否分配状态
 */
public enum TASK_STATUS {
    NOCHECK(0), CHECKING(1),
    CHECKDONE(2), ALLOT_NONE(0), ALLOT_GOBACK(4),ALLOT_ALREADY(1), ALLOT_CONFIRMED(2), ALLOT_EXE(3);
    final int value;

    TASK_STATUS(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}







