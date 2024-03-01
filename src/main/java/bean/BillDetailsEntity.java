package bean;

public class BillDetailsEntity {
  private String id;
  private String billId;
  private String productId;
  private Integer quantity;
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getBillId() {
    return billId;
  }
  public void setBillId(String billId) {
    this.billId = billId;
  }
  public String getProductId() {
    return productId;
  }
  public void setProductId(String productId) {
    this.productId = productId;
  }
  public Integer getQuantity() {
    return quantity;
  }
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
  
}
