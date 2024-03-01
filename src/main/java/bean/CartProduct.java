package bean;

import java.util.Objects;

public class CartProduct {
    private int quantity;
    private String size;
    private String color;
    private int quantityExist;
    private int productId;
    private ProductResponse product;

    public CartProduct(int quantity, String size, String color, int productId) {
        this.quantity = quantity;
        this.size = size;
        this.color = color;
        this.productId = productId;
        this.product = new ProductResponse();
    }

    public int getQuantityExist() {
        return quantityExist;
    }

    public void setQuantityExist(int quantityExist) {
        this.quantityExist = quantityExist;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartProduct that = (CartProduct) o;
        return productId == that.productId && Objects.equals(size, that.size) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, size, color, productId);
    }

    @Override
    public String toString() {
        return "CartProduct{" +
                "quantity=" + quantity +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", productId=" + productId +
                '}';
    }
}
