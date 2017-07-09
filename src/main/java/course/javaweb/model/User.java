package course.javaweb.model;

public class User {

    /** 主键 */
    private Integer id;

    /** 用户名 */
    private String userName;

    /** 密码md5加密 */
    private String password;

    /** 用户昵称 */
    private String nickName;

    /** 类型，买家0，卖家1 */
    private Integer userType;

    /**
     * 获取主键
     * 
     * @return 主键
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置主键
     * 
     * @param id
     *          主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     * 
     * @return 用户名
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置用户名
     * 
     * @param userName
     *          用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取密码md5加密
     * 
     * @return 密码md5加密
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 设置密码md5加密
     * 
     * @param password
     *          密码md5加密
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户昵称
     * 
     * @return 用户昵称
     */
    public String getNickName() {
        return this.nickName;
    }

    /**
     * 设置用户昵称
     * 
     * @param nickName
     *          用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取类型，买家0，卖家1
     * 
     * @return 类型
     */
    public Integer getUserType() {
        return this.userType;
    }

    /**
     * 设置类型，买家0，卖家1
     * 
     * @param userType
     *          类型
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userType=" + userType +
                '}';
    }
}