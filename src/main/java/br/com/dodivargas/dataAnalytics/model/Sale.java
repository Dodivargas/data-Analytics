package br.com.dodivargas.dataAnalytics.model;

import java.util.List;

public class Sale implements Model {

    private String salaId;
    private List<SaleItem> saleItems;
    private String salesmanName;

    public Sale(String salaId, List<SaleItem> saleItems, String salesmanName) {
        this.salaId = salaId;
        this.saleItems = saleItems;
        this.salesmanName = salesmanName;
    }

     public String getSalaId() {
        return salaId;
    }

    public void setSalaId(String salaId) {
        this.salaId = salaId;
    }

    public List<SaleItem> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<SaleItem> saleItems) {
        this.saleItems = saleItems;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }
}
