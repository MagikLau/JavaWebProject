package course.javaweb.model;

public class Trx {

    /** 主键 */
    private Integer id;

    /** 内容ID */
    private Integer contentId;

    /** 用户ID */
    private Integer personId;

    /** 购买价格 */
    private Integer price;

    /** 购买时间 */
    private Long time;

    /** 购买数量 */
    private Integer num;

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
     * 获取内容ID
     * 
     * @return 内容ID
     */
    public Integer getContentId() {
        return this.contentId;
    }

    /**
     * 设置内容ID
     * 
     * @param contentId
     *          内容ID
     */
    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    /**
     * 获取用户ID
     * 
     * @return 用户ID
     */
    public Integer getPersonId() {
        return this.personId;
    }

    /**
     * 设置用户ID
     * 
     * @param personId
     *          用户ID
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    /**
     * 获取购买价格
     * 
     * @return 购买价格
     */
    public Integer getPrice() {
        return this.price;
    }

    /**
     * 设置购买价格
     * 
     * @param price
     *          购买价格
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取购买时间
     * 
     * @return 购买时间
     */
    public Long getTime() {
        return this.time;
    }

    /**
     * 设置购买时间
     * 
     * @param time
     *          购买时间
     */
    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Trx{" +
                "id=" + id +
                ", contentId=" + contentId +
                ", personId=" + personId +
                ", price=" + price +
                ", time=" + time +
                ", num=" + num +
                '}';
    }
}