package br.com.dodivargas.dataAnalytics.dto.builder;

import br.com.dodivargas.dataAnalytics.dto.SaleItem;

import java.math.BigDecimal;

public class SaleItemBuilder {

    private SaleItem saleItem;

    public SaleItemBuilder() {
        this.saleItem = new SaleItem();
    }

    public SaleItemBuilder builder() {
        return new SaleItemBuilder();
    }

    public SaleItemBuilder id(String saleId) {
        this.saleItem.setId(saleId);
        return this;
    }

    public SaleItemBuilder quantity(String quantity) {
        this.saleItem.setItemQuantity(quantity);
        return this;
    }

    public SaleItemBuilder price(BigDecimal price) {
        this.saleItem.setItemPrice(price);
        return this;
    }

    public SaleItem build() {
        return this.saleItem;
    }
}
