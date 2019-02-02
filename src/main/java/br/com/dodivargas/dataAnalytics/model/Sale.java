package br.com.dodivargas.dataAnalytics.model;

import java.util.List;
import java.util.stream.Collectors;

public class Sale implements Model {

    private String id;
    private String saleId;
    private List<SaleItem> saleItems;
    private String salesmanName;

    public Sale() {
    }

    public Sale(String id, String saleId, List<SaleItem> saleItems, String salesmanName) {
        this.id = id;
        this.saleId = saleId;
        this.saleItems = saleItems;
        this.salesmanName = salesmanName;
    }

    public List<Sale> getSales(List<Model> models) {
        return models.stream().filter(model -> model.getClass().equals(Sale.class)).map(sale -> (Sale) sale).collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
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
