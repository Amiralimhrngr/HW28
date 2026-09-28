package ir.maktabsharif.model;

import java.math.BigDecimal;

public class Order {

    private String customerName;
    private String productName;
    private BigDecimal productPrice;
    private int quantity;
    private BigDecimal totalPrice;

    public Order() {
    }

    public Order(String customerName,
                 String productName,
                 BigDecimal productPrice,
                 int quantity) {

        this.customerName = customerName;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.totalPrice = productPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
