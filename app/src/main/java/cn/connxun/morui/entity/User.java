package cn.connxun.morui.entity;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.io.Serializable;
import java.util.List;

import cn.connxun.morui.db.AllotUserDao;
import cn.connxun.morui.db.ContactsDao;
import cn.connxun.morui.db.DaoSession;
import cn.connxun.morui.db.TaskDao;
import cn.connxun.morui.db.UserDao;

/**
 * Created by wushange on 2017/7/12.
 */

@Entity
public class User implements Serializable {
    static final long serialVersionUID  = 42L;


    /**
     * id : 1
     * role_id : 1
     * role_name : 系统管理员
     * username : admin
     * password : f87e483f8b40f78054335172d28e07cc
     * randomcode : 860232
     * status : 1
     * realname : 管理员
     * sex : 男
     * telephone : 13811111111
     * email : null
     * enterpriseId : 1
     * enterpriseName : 道可二厂
     * departmentId : 3
     * departmentName : 生产技术部
     * jobsId : 1
     * jobsName : 总经理
     * create_person : 开发者
     * create_date : 2017-05-10 19:24
     * rowIndex : 0
     */
    @Id
    private long   id;
    private int    role_id;
    private String role_name;
    private String username;
    private String password;
    private String randomcode;
    private int    status;
    private String realname;
    private String sex;
    private String telephone;
    private String email;
    private int    enterpriseId;
    private String enterpriseName;
    private int    departmentId;
    private String departmentName;
    private int    jobsId;
    private String jobsName;
    private String create_person;
    private String create_date;
    private int    rowIndex;
    private String token;
    private String realPwd;
    @ToMany(referencedJoinProperty = "userId")
    List<Task> taskList;
    @ToMany(referencedJoinProperty = "userId")
    List<AllotUser> allotUserList;
    @ToMany(referencedJoinProperty = "userId")
    List<Contacts> contactsList;


    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;


    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;
    @Generated(hash = 1253535963)
    public User(long id, int role_id, String role_name, String username,
            String password, String randomcode, int status, String realname,
            String sex, String telephone, String email, int enterpriseId,
            String enterpriseName, int departmentId, String departmentName,
            int jobsId, String jobsName, String create_person, String create_date,
            int rowIndex, String token, String realPwd) {
        this.id = id;
        this.role_id = role_id;
        this.role_name = role_name;
        this.username = username;
        this.password = password;
        this.randomcode = randomcode;
        this.status = status;
        this.realname = realname;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
        this.enterpriseId = enterpriseId;
        this.enterpriseName = enterpriseName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.jobsId = jobsId;
        this.jobsName = jobsName;
        this.create_person = create_person;
        this.create_date = create_date;
        this.rowIndex = rowIndex;
        this.token = token;
        this.realPwd = realPwd;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getRole_id() {
        return this.role_id;
    }
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
    public String getRole_name() {
        return this.role_name;
    }
    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRandomcode() {
        return this.randomcode;
    }
    public void setRandomcode(String randomcode) {
        this.randomcode = randomcode;
    }
    public int getStatus() {
        return this.status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getRealname() {
        return this.realname;
    }
    public void setRealname(String realname) {
        this.realname = realname;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getTelephone() {
        return this.telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getEnterpriseId() {
        return this.enterpriseId;
    }
    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
    public String getEnterpriseName() {
        return this.enterpriseName;
    }
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
    public int getDepartmentId() {
        return this.departmentId;
    }
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return this.departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public int getJobsId() {
        return this.jobsId;
    }
    public void setJobsId(int jobsId) {
        this.jobsId = jobsId;
    }
    public String getJobsName() {
        return this.jobsName;
    }
    public void setJobsName(String jobsName) {
        this.jobsName = jobsName;
    }
    public String getCreate_person() {
        return this.create_person;
    }
    public void setCreate_person(String create_person) {
        this.create_person = create_person;
    }
    public String getCreate_date() {
        return this.create_date;
    }
    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
    public int getRowIndex() {
        return this.rowIndex;
    }
    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }
    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getRealPwd() {
        return this.realPwd;
    }
    public void setRealPwd(String realPwd) {
        this.realPwd = realPwd;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1932007485)
    public List<Task> getTaskList() {
        if (taskList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TaskDao targetDao = daoSession.getTaskDao();
            List<Task> taskListNew = targetDao._queryUser_TaskList(id);
            synchronized (this) {
                if (taskList == null) {
                    taskList = taskListNew;
                }
            }
        }
        return taskList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1036990935)
    public synchronized void resetTaskList() {
        taskList = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 351425144)
    public List<AllotUser> getAllotUserList() {
        if (allotUserList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AllotUserDao targetDao = daoSession.getAllotUserDao();
            List<AllotUser> allotUserListNew = targetDao
                    ._queryUser_AllotUserList(id);
            synchronized (this) {
                if (allotUserList == null) {
                    allotUserList = allotUserListNew;
                }
            }
        }
        return allotUserList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 314886484)
    public synchronized void resetAllotUserList() {
        allotUserList = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1811564067)
    public List<Contacts> getContactsList() {
        if (contactsList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ContactsDao targetDao = daoSession.getContactsDao();
            List<Contacts> contactsListNew = targetDao._queryUser_ContactsList(id);
            synchronized (this) {
                if (contactsList == null) {
                    contactsList = contactsListNew;
                }
            }
        }
        return contactsList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1510983853)
    public synchronized void resetContactsList() {
        contactsList = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", randomcode='" + randomcode + '\'' +
                ", status=" + status +
                ", realname='" + realname + '\'' +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", enterpriseId=" + enterpriseId +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", jobsId=" + jobsId +
                ", jobsName='" + jobsName + '\'' +
                ", create_person='" + create_person + '\'' +
                ", create_date='" + create_date + '\'' +
                ", rowIndex=" + rowIndex +
                ", token='" + token + '\'' +
                ", realPwd='" + realPwd + '\'' +
                ", taskList=" + taskList +
                ", allotUserList=" + allotUserList +
                ", contactsList=" + contactsList +
                '}';
    }
}
