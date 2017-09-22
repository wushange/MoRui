package cn.connxun.morui.constants.enums;

/**
 * 任务上传状态
 */
public enum TASK_SYNCUPLOAD {
        NOUPLOAD(0), UPLOADDONE(2);
        final int value;

        TASK_SYNCUPLOAD(int i) {
            this.value = i;
        }

        public int value() {
            return value;
        }
    }