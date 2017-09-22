package cn.connxun.morui.constants.enums;

/**
 * 子任务是否需要主观判断
 */
public enum TASK_ISSUBJUDGE {
        ISSUBJUDGE(1), NOTISSUBJUDGE(0);
        final int value;

        TASK_ISSUBJUDGE(int i) {
            this.value = i;
        }

        public int value() {
            return value;
        }
    }