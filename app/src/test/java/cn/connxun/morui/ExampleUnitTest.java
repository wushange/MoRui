package cn.connxun.morui;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import org.junit.Test;

import java.util.List;

import cn.connxun.morui.entity.Task;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <HttpManager href="http://d.android.com/tools/testing">Testing documentation</HttpManager>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void str2json(){

        String str ="{\n" +
                "  \"success\": true,\n" +
                "  \"message\": \"请求成功\",\n" +
                "  \"data\": {\n" +
                "    \"total\": 35,\n" +
                "    \"list\": [\n" +
                "      {\n" +
                "        \"id\": \"297edff85e552e0b015e565fd84c0a09\",\n" +
                "        \"name\": \"保全车间日常巡检二2017-09-04\",\n" +
                "        \"content\": \"保全车间日常巡检二\",\n" +
                "        \"departmentCode\": \"DK205\",\n" +
                "        \"departmentName\": \"保全车间\",\n" +
                "        \"jobsCode\": \"DK20501\",\n" +
                "        \"jobsName\": \"保全车间制冷工序\",\n" +
                "        \"planId\": \"4028efee5e1c258a015e1c62f5450003\",\n" +
                "        \"startDate\": \"2017-09-04 04:00\",\n" +
                "        \"endDate\": \"2017-09-04 08:00\",\n" +
                "        \"type\": 1,\n" +
                "        \"status\": 0,\n" +
                "        \"checkUserEnterpriseId\": 0,\n" +
                "        \"checkUserDepartmentId\": 0,\n" +
                "        \"checkUserJobsId\": 0,\n" +
                "        \"checkUserId\": 0,\n" +
                "        \"checkUserName\": null,\n" +
                "        \"taskSubList\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"297edff85e552e0b015e565fd8dd0a0a\",\n" +
                "        \"name\": \"保全车间日常巡检二2017-09-04\",\n" +
                "        \"content\": \"保全车间日常巡检二\",\n" +
                "        \"departmentCode\": \"DK205\",\n" +
                "        \"departmentName\": \"保全车间\",\n" +
                "        \"jobsCode\": \"DK20501\",\n" +
                "        \"jobsName\": \"保全车间制冷工序\",\n" +
                "        \"planId\": \"4028efee5e1c258a015e1c62f5450003\",\n" +
                "        \"startDate\": \"2017-09-04 08:00\",\n" +
                "        \"endDate\": \"2017-09-04 12:00\",\n" +
                "        \"type\": 1,\n" +
                "        \"status\": 0,\n" +
                "        \"checkUserEnterpriseId\": 0,\n" +
                "        \"checkUserDepartmentId\": 0,\n" +
                "        \"checkUserJobsId\": 0,\n" +
                "        \"checkUserId\": 0,\n" +
                "        \"checkUserName\": null,\n" +
                "        \"taskSubList\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"297edff85e552e0b015e565fd9640a0b\",\n" +
                "        \"name\": \"保全车间日常巡检二2017-09-04\",\n" +
                "        \"content\": \"保全车间日常巡检二\",\n" +
                "        \"departmentCode\": \"DK205\",\n" +
                "        \"departmentName\": \"保全车间\",\n" +
                "        \"jobsCode\": \"DK20501\",\n" +
                "        \"jobsName\": \"保全车间制冷工序\",\n" +
                "        \"planId\": \"4028efee5e1c258a015e1c62f5450003\",\n" +
                "        \"startDate\": \"2017-09-04 12:00\",\n" +
                "        \"endDate\": \"2017-09-04 16:00\",\n" +
                "        \"type\": 1,\n" +
                "        \"status\": 0,\n" +
                "        \"checkUserEnterpriseId\": 0,\n" +
                "        \"checkUserDepartmentId\": 0,\n" +
                "        \"checkUserJobsId\": 0,\n" +
                "        \"checkUserId\": 0,\n" +
                "        \"checkUserName\": null,\n" +
                "        \"taskSubList\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"297edff85e552e0b015e565fd9e30a0c\",\n" +
                "        \"name\": \"保全车间日常巡检二2017-09-04\",\n" +
                "        \"content\": \"保全车间日常巡检二\",\n" +
                "        \"departmentCode\": \"DK205\",\n" +
                "        \"departmentName\": \"保全车间\",\n" +
                "        \"jobsCode\": \"DK20501\",\n" +
                "        \"jobsName\": \"保全车间制冷工序\",\n" +
                "        \"planId\": \"4028efee5e1c258a015e1c62f5450003\",\n" +
                "        \"startDate\": \"2017-09-04 16:00\",\n" +
                "        \"endDate\": \"2017-09-04 20:00\",\n" +
                "        \"type\": 1,\n" +
                "        \"status\": 0,\n" +
                "        \"checkUserEnterpriseId\": 0,\n" +
                "        \"checkUserDepartmentId\": 0,\n" +
                "        \"checkUserJobsId\": 0,\n" +
                "        \"checkUserId\": 0,\n" +
                "        \"checkUserName\": null,\n" +
                "        \"taskSubList\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"297edff85e552e0b015e565fda5f0a0d\",\n" +
                "        \"name\": \"保全车间日常巡检二2017-09-04\",\n" +
                "        \"content\": \"保全车间日常巡检二\",\n" +
                "        \"departmentCode\": \"DK205\",\n" +
                "        \"departmentName\": \"保全车间\",\n" +
                "        \"jobsCode\": \"DK20501\",\n" +
                "        \"jobsName\": \"保全车间制冷工序\",\n" +
                "        \"planId\": \"4028efee5e1c258a015e1c62f5450003\",\n" +
                "        \"startDate\": \"2017-09-04 20:00\",\n" +
                "        \"endDate\": \"2017-09-05 00:00\",\n" +
                "        \"type\": 1,\n" +
                "        \"status\": 0,\n" +
                "        \"checkUserEnterpriseId\": 0,\n" +
                "        \"checkUserDepartmentId\": 0,\n" +
                "        \"checkUserJobsId\": 0,\n" +
                "        \"checkUserId\": 0,\n" +
                "        \"checkUserName\": null,\n" +
                "        \"taskSubList\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"297edff85e552e0b015e565fdae10a0e\",\n" +
                "        \"name\": \"保全车间日常巡检二2017-09-05\",\n" +
                "        \"content\": \"保全车间日常巡检二\",\n" +
                "        \"departmentCode\": \"DK205\",\n" +
                "        \"departmentName\": \"保全车间\",\n" +
                "        \"jobsCode\": \"DK20501\",\n" +
                "        \"jobsName\": \"保全车间制冷工序\",\n" +
                "        \"planId\": \"4028efee5e1c258a015e1c62f5450003\",\n" +
                "        \"startDate\": \"2017-09-05 00:00\",\n" +
                "        \"endDate\": \"2017-09-05 04:00\",\n" +
                "        \"type\": 1,\n" +
                "        \"status\": 0,\n" +
                "        \"checkUserEnterpriseId\": 0,\n" +
                "        \"checkUserDepartmentId\": 0,\n" +
                "        \"checkUserJobsId\": 0,\n" +
                "        \"checkUserId\": 0,\n" +
                "        \"checkUserName\": null,\n" +
                "        \"taskSubList\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"297edff85e552e0b015e565fdb600a0f\",\n" +
                "        \"name\": \"保全车间日常巡检二2017-09-05\",\n" +
                "        \"content\": \"保全车间日常巡检二\",\n" +
                "        \"departmentCode\": \"DK205\",\n" +
                "        \"departmentName\": \"保全车间\",\n" +
                "        \"jobsCode\": \"DK20501\",\n" +
                "        \"jobsName\": \"保全车间制冷工序\",\n" +
                "        \"planId\": \"4028efee5e1c258a015e1c62f5450003\",\n" +
                "        \"startDate\": \"2017-09-05 04:00\",\n" +
                "        \"endDate\": \"2017-09-05 08:00\",\n" +
                "        \"type\": 1,\n" +
                "        \"status\": 0,\n" +
                "        \"checkUserEnterpriseId\": 0,\n" +
                "        \"checkUserDepartmentId\": 0,\n" +
                "        \"checkUserJobsId\": 0,\n" +
                "        \"checkUserId\": 0,\n" +
                "        \"checkUserName\": null,\n" +
                "        \"taskSubList\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"297edff85e552e0b015e5c1aecc91411\",\n" +
                "        \"name\": \"保全车间日常巡检二2017-09-08\",\n" +
                "        \"content\": \"保全车间日常巡检二\",\n" +
                "        \"departmentCode\": \"DK205\",\n" +
                "        \"departmentName\": \"保全车间\",\n" +
                "        \"jobsCode\": \"DK20501\",\n" +
                "        \"jobsName\": \"保全车间制冷工序\",\n" +
                "        \"planId\": \"4028efee5e1c258a015e1c62f5450003\",\n" +
                "        \"startDate\": \"2017-09-08 04:00\",\n" +
                "        \"endDate\": \"2017-09-08 08:00\",\n" +
                "        \"type\": 1,\n" +
                "        \"status\": 0,\n" +
                "        \"checkUserEnterpriseId\": 0,\n" +
                "        \"checkUserDepartmentId\": 0,\n" +
                "        \"checkUserJobsId\": 0,\n" +
                "        \"checkUserId\": 0,\n" +
                "        \"checkUserName\": null,\n" +
                "        \"taskSubList\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"297edff85e552e0b015e5c1aed391412\",\n" +
                "        \"name\": \"保全车间日常巡检二2017-09-08\",\n" +
                "        \"content\": \"保全车间日常巡检二\",\n" +
                "        \"departmentCode\": \"DK205\",\n" +
                "        \"departmentName\": \"保全车间\",\n" +
                "        \"jobsCode\": \"DK20501\",\n" +
                "        \"jobsName\": \"保全车间制冷工序\",\n" +
                "        \"planId\": \"4028efee5e1c258a015e1c62f5450003\",\n" +
                "        \"startDate\": \"2017-09-08 08:00\",\n" +
                "        \"endDate\": \"2017-09-08 12:00\",\n" +
                "        \"type\": 1,\n" +
                "        \"status\": 0,\n" +
                "        \"checkUserEnterpriseId\": 0,\n" +
                "        \"checkUserDepartmentId\": 0,\n" +
                "        \"checkUserJobsId\": 0,\n" +
                "        \"checkUserId\": 0,\n" +
                "        \"checkUserName\": null,\n" +
                "        \"taskSubList\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"297edff85e552e0b015e5c1d0d311697\",\n" +
                "        \"name\": \"0907 检查方案2017-09-08\",\n" +
                "        \"content\": \"1111\",\n" +
                "        \"departmentCode\": \"DK205\",\n" +
                "        \"departmentName\": \"保全车间\",\n" +
                "        \"jobsCode\": \"\",\n" +
                "        \"jobsName\": \"请选择岗位\",\n" +
                "        \"planId\": \"297edff85e552e0b015e5c1ceff71692\",\n" +
                "        \"startDate\": \"2017-09-08 08:00\",\n" +
                "        \"endDate\": \"2017-09-08 16:00\",\n" +
                "        \"type\": 1,\n" +
                "        \"status\": 0,\n" +
                "        \"checkUserEnterpriseId\": 0,\n" +
                "        \"checkUserDepartmentId\": 0,\n" +
                "        \"checkUserJobsId\": 0,\n" +
                "        \"checkUserId\": 0,\n" +
                "        \"checkUserName\": null,\n" +
                "        \"taskSubList\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"297edff85e552e0b015e5c1aedb91413\",\n" +
                "        \"name\": \"保全车间日常巡检二2017-09-08\",\n" +
                "        \"content\": \"保全车间日常巡检二\",\n" +
                "        \"departmentCode\": \"DK205\",\n" +
                "        \"departmentName\": \"保全车间\",\n" +
                "        \"jobsCode\": \"DK20501\",\n" +
                "        \"jobsName\": \"保全车间制冷工序\",\n" +
                "        \"planId\": \"4028efee5e1c258a015e1c62f5450003\",\n" +
                "        \"startDate\": \"2017-09-08 12:00\",\n" +
                "        \"endDate\": \"2017-09-08 16:00\",\n" +
                "        \"type\": 1,\n" +
                "        \"status\": 0,\n" +
                "        \"checkUserEnterpriseId\": 0,\n" +
                "        \"checkUserDepartmentId\": 0,\n" +
                "        \"checkUserJobsId\": 0,\n" +
                "        \"checkUserId\": 0,\n" +
                "        \"checkUserName\": null,\n" +
                "        \"taskSubList\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"297edff85e552e0b015e5c1aee3f1414\",\n" +
                "        \"name\": \"保全车间日常巡检二2017-09-08\",\n" +
                "        \"content\": \"保全车间日常巡检二\",\n" +
                "        \"departmentCode\": \"DK205\",\n" +
                "        \"departmentName\": \"保全车间\",\n" +
                "        \"jobsCode\": \"DK20501\",\n" +
                "        \"jobsName\": \"保全车间制冷工序\",\n" +
                "        \"planId\": \"4028efee5e1c258a015e1c62f5450003\",\n" +
                "        \"startDate\": \"2017-09-08 16:00\",\n" +
                "        \"endDate\": \"2017-09-08 20:00\",\n" +
                "        \"type\": 1,\n" +
                "        \"status\": 0,\n" +
                "        \"checkUserEnterpriseId\": 0,\n" +
                "        \"checkUserDepartmentId\": 0,\n" +
                "        \"checkUserJobsId\": 0,\n" +
                "        \"checkUserId\": 0,\n" +
                "        \"checkUserName\": null,\n" +
                "        \"taskSubList\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"297edff85e552e0b015e5c1d0da01698\",\n" +
                "        \"name\": \"0907 检查方案2017-09-08\",\n" +
                "        \"content\": \"1111\",\n" +
                "        \"departmentCode\": \"DK205\",\n" +
                "        \"departmentName\": \"保全车间\",\n" +
                "        \"jobsCode\": \"\",\n" +
                "        \"jobsName\": \"请选择岗位\",\n" +
                "        \"planId\": \"297edff85e552e0b015e5c1ceff71692\",\n" +
                "        \"startDate\": \"2017-09-08 16:00\",\n" +
                "        \"endDate\": \"2017-09-09 00:00\",\n" +
                "        \"type\": 1,\n" +
                "        \"status\": 0,\n" +
                "        \"checkUserEnterpriseId\": 0,\n" +
                "        \"checkUserDepartmentId\": 0,\n" +
                "        \"checkUserJobsId\": 0,\n" +
                "        \"checkUserId\": 0,\n" +
                "        \"checkUserName\": null,\n" +
                "        \"taskSubList\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"297edff85e552e0b015e5c1aeeaf1415\",\n" +
                "        \"name\": \"保全车间日常巡检二2017-09-08\",\n" +
                "        \"content\": \"保全车间日常巡检二\",\n" +
                "        \"departmentCode\": \"DK205\",\n" +
                "        \"departmentName\": \"保全车间\",\n" +
                "        \"jobsCode\": \"DK20501\",\n" +
                "        \"jobsName\": \"保全车间制冷工序\",\n" +
                "        \"planId\": \"4028efee5e1c258a015e1c62f5450003\",\n" +
                "        \"startDate\": \"2017-09-08 20:00\",\n" +
                "        \"endDate\": \"2017-09-09 00:00\",\n" +
                "        \"type\": 1,\n" +
                "        \"status\": 0,\n" +
                "        \"checkUserEnterpriseId\": 0,\n" +
                "        \"checkUserDepartmentId\": 0,\n" +
                "        \"checkUserJobsId\": 0,\n" +
                "        \"checkUserId\": 0,\n" +
                "        \"checkUserName\": null,\n" +
                "        \"taskSubList\": null\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        List<Task> tasks = JSON.parseObject(str, new TypeReference<List<Task>>() {}.getType());

        int s  = tasks.size();
    }

}