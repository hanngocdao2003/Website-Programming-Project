package bean;

public class SizeEntity {
    private Integer id;
    private String size;
    private Integer productId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    @Override
    public String toString() {
        return "SizeEntity{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }
}
