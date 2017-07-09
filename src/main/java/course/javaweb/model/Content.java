package course.javaweb.model;

import java.sql.Blob;

public class Content {

    /** 主键 */
    private Integer id;

    /** 当前价格 */
    private Long price;

    /** 标题 */
    private String title;

    /** 图片 */
    private Blob icon;

    /** 摘要 */
    private String abstractInfo;

    /** 正文 */
    private Blob text;

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
    public Blob getIcon() {
        return this.icon;
    }

    /**
     * 设置图片
     * 
     * @param icon
     *          图片
     */
    public void setIcon(Blob icon) {
        this.icon = icon;
    }

    /**
     * 获取摘要
     * 
     * @return 摘要
     */
    public String getAbstractInfo() {
        return this.abstractInfo;
    }

    /**
     * 设置摘要
     * 
     * @param abstractInfo
     *          摘要
     */
    public void setAbstractInfo(String abstractInfo) {
        this.abstractInfo = abstractInfo;
    }

    /**
     * 获取正文
     * 
     * @return 正文
     */
    public Blob getText() {
        return this.text;
    }

    /**
     * 设置正文
     * 
     * @param text
     *          正文
     */
    public void setText(Blob text) {
        this.text = text;
    }
}