package bean;

/*Khuyến khích sử dụng lớp Wrapper thay vì kiểu dữ liệu nguyên thủy
 *Khai báo lớp Entity (bean), đặt private và getter setter.
 */
public class ProductEntity {
    private Integer id;
    private String name;
    private String discountCodeId;
    private Integer price;
    private String categoryId;
    private String details;
    private String supplierId;
    private Integer quantity;
    private Short status;
    private String importDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscountCodeId() {
        return discountCodeId;
    }

    public void setDiscountCodeId(String discountCodeId) {
        this.discountCodeId = discountCodeId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }
}
