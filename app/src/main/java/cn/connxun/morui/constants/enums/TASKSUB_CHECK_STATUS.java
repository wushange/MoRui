package cn.connxun.morui.constants.enums;

/**
 * 子任务检查状态 未检查or检查完成
 */
public enum TASKSUB_CHECK_STATUS {
        NOCHECK(0), CHECKDONE(2);
        final int value;

        TASKSUB_CHECK_STATUS(int i) {
            this.value = i;
        }

        public int value() {
            return value;
        }
    }