package br.com.dodivargas.dataAnalytics.dto;

public class DataAnalysis {

    private Integer customersAmounts;
    private Integer salesmanAmounts;
    private Integer mostExpansiveSaleId;
    private String worstSalesman;

    public Integer getCustomersAmounts() {
        return customersAmounts;
    }

    public void setCustomersAmounts(Integer customersAmounts) {
        this.customersAmounts = customersAmounts;
    }

    public Integer getSalesmanAmounts() {
        return salesmanAmounts;
    }

    public void setSalesmanAmounts(Integer salesmanAmounts) {
        this.salesmanAmounts = salesmanAmounts;
    }

    public Integer getMostExpansiveSaleId() {
        return mostExpansiveSaleId;
    }

    public void setMostExpansiveSaleId(Integer mostExpansiveSaleId) {
        this.mostExpansiveSaleId = mostExpansiveSaleId;
    }

    public String getWorstSalesman() {
        return worstSalesman;
    }

    public void setWorstSalesman(String worstSalesman) {
        this.worstSalesman = worstSalesman;
    }

    public byte[] getDataAnlysis() {
        return this.toString().getBytes();
    }

    @Override
    public String toString() {
        return "customersAmounts= " + customersAmounts +
                "\nsalesmanAmounts= " + salesmanAmounts +
                "\nmostExpansiveSaleId= " + mostExpansiveSaleId +
                "\nworstSalesman= " + worstSalesman;
    }
}
