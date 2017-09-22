package cn.connxun.morui.db;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.Arrays;
import java.util.List;

import cn.connxun.morui.entity.TaskSub;

public class TaskSubListConverter implements PropertyConverter<List<TaskSub>, TaskSub> {


    @Override
    public List<TaskSub> convertToEntityProperty(TaskSub databaseValue) {
        if (databaseValue == null) {
            return null;
        } else {
            List<TaskSub> list = Arrays.asList(databaseValue);
            return list;
        }
    }

    @Override
    public TaskSub convertToDatabaseValue(List<TaskSub> entityProperty) {
        if (entityProperty == null) {
            return null;
        } else {
            TaskSub sb = new TaskSub();
            for (TaskSub link : entityProperty) {
                sb = link;

            }
            return sb;
        }
    }
}