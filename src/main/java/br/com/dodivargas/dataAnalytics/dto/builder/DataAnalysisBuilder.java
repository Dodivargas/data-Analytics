package br.com.dodivargas.dataAnalytics.dto.builder;

import br.com.dodivargas.dataAnalytics.dto.DataAnalysis;

public class DataAnalysisBuilder {

    private DataAnalysis dataAnalysis;

    public DataAnalysisBuilder() {
        this.dataAnalysis = new DataAnalysis();
    }

    public  DataAnalysisBuilder builder() {
        return new DataAnalysisBuilder();
    }

    public DataAnalysisBuilder customersAmounts(Integer customersAmounts) {
        this.dataAnalysis.setCustomersAmounts(customersAmounts);
        return this;
    }

    public DataAnalysisBuilder salesmanAmounts(Integer salesmanAmounts) {
        this.dataAnalysis.setSalesmanAmounts(salesmanAmounts);
        return this;
    }

    public DataAnalysisBuilder mostExpansiveSaleId(Integer mostExpansiveSaleId) {
        this.dataAnalysis.setMostExpansiveSaleId(mostExpansiveSaleId);
        return this;
    }

    public DataAnalysisBuilder worstSalesman(String worstSalesman) {
        this.dataAnalysis.setWorstSalesman(worstSalesman);
        return this;
    }

    public DataAnalysis build() {
        return this.dataAnalysis;
    }
}
