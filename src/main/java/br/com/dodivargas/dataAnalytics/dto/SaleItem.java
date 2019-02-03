package br.com.dodivargas.dataAnalytics.dto;

import java.math.BigDecimal;

public class SaleItem {

    private String id;
    private String itemQuantity;
    private BigDecimal itemPrice;

    public SaleItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }
}
