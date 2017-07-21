package course.javaweb.model;

public class Product extends Content{
    //继承Content来获得商品属性
    private boolean isBuy;
    private boolean isSell;
    private Integer buyNum; //用于统计购买人数
    private Integer buyPrice;
    private Long time;

    public boolean getIsBuy(){
        return this.isBuy;
    }

    public void setIsBuy(boolean isBuy){
        this.isBuy = isBuy;
    }

    public boolean getIsSell(){
        return this.isSell;
    }

    public void setIsSell(boolean isSell){
        this.isSell = isSell;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "Product{ " +super.toString()+
                ", isBuy=" + isBuy +
                ", isSell=" + isSell +
                ", buyNum=" + buyNum +
                ", buyPrice=" + buyPrice +
                ", time=" + time +
                '}';
    }
}
