package br.com.dodivargas.dataAnalytics.dto.builder;

import br.com.dodivargas.dataAnalytics.dto.Sale;
import br.com.dodivargas.dataAnalytics.dto.SaleItem;

import java.util.List;

public class SaleBuilder {
    private Sale sale;

    public SaleBuilder() {
        this.sale = new Sale();
    }

    public SaleBuilder builder() {
        return new SaleBuilder();
    }

    public SaleBuilder id(String saleId) {
        this.sale.setId(saleId);
        return this;
    }

    public SaleBuilder saleId(Integer saleId) {
        this.sale.setSaleId(saleId);
        return this;
    }

    public SaleBuilder saleItems(List<SaleItem> saleItems) {
        this.sale.setSaleItems(saleItems);
        return this;
    }

    public SaleBuilder salesmanName(String salesmanName) {
        this.sale.setSalesmanName(salesmanName);
        return this;
    }

    public Sale build() {
        return this.sale;
    }
}
