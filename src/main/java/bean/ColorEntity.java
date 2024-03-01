package bean;

public class ColorEntity {
  private Integer id;
  private String color;
  private String code;
  private Integer productId;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getColor() {
    return color;
  }
  public void setColor(String color) {
    this.color = color;
  }
  public Integer getProductId() {
    return productId;
  }
  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  @Override
  public String toString() {
    return "ColorEntity{" +
            "id=" + id +
            ", color='" + color + '\'' +
            ", code='" + code + '\'' +
            ", productId='" + productId + '\'' +
            '}';
  }
}

