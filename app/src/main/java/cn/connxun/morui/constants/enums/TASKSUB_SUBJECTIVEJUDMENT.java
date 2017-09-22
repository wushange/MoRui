package cn.connxun.morui.constants.enums;

/**
 * 主观检车结果 正常or异常
 */
public enum TASKSUB_SUBJECTIVEJUDMENT {
        NORMAL(1),ABNORMAL(0);
        final int value;

        TASKSUB_SUBJECTIVEJUDMENT(int i) {
            this.value = i;
        }

        public int value() {
            return value;
        }
    }