package course.javaweb.model;

public class Content {

    /** 主键 */
    private Integer id;

    /** 当前价格 */
    private Long price;

    /** 卖家ID */
    private Integer sellerId;

    /** 贩卖数量 */
    private Integer num;

    /** 标题 */
    private String title;

    /** 图片 */
    private String image;

    /** 摘要 */
    private String summary;

    /** 正文 */
    private String detail;

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
     * 获取当前价格
     * 
     * @return 当前价格
     */
    public Long getPrice() {
        return this.price;
    }

    /**
     * 设置当前价格
     * 
     * @param price
     *          当前价格
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取标题
     * 
     * @return 标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置标题
     * 
     * @param title
     *          标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取图片
     * 
     * @return 图片
     */
    public String getImage() {
        return this.image;
    }

    /**
     * 设置图片
     * 
     * @param image
     *          图片
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取摘要
     * 
     * @return 摘要
     */
    public String getSummary() {
        return this.summary;
    }

    /**
     * 设置摘要
     * 
     * @param summary
     *          摘要
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 获取正文
     * 
     * @return 正文
     */
    public String getDetail() {
        return this.detail;
    }

    /**
     * 设置正文
     * 
     * @param detail
     *          正文
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", price=" + price +
                ", sellerId=" + sellerId +
                ", num=" + num +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", summary='" + summary + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}