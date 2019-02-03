package br.com.dodivargas.dataAnalytics.dto.builder;

import br.com.dodivargas.dataAnalytics.dto.Salesman;

import java.math.BigDecimal;

public class SalesmanBuilder {

    private Salesman salesman;

    public SalesmanBuilder() {
        this.salesman = new Salesman();
    }

    public SalesmanBuilder builder() {
        return new SalesmanBuilder();
    }

    public SalesmanBuilder id(String salesmanId) {
        this.salesman.setId(salesmanId);
        return this;
    }

    public SalesmanBuilder cpf(String salesmanCpf) {
        this.salesman.setCpf(salesmanCpf);
        return this;
    }

    public SalesmanBuilder name(String salesmanName) {
        this.salesman.setName(salesmanName);
        return this;
    }

    public SalesmanBuilder salary(BigDecimal salesmanSalary) {
        this.salesman.setSalary(salesmanSalary);
        return this;
    }

    public Salesman build() {
        return this.salesman;
    }

}
