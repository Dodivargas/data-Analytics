package br.com.dodivargas.dataAnalytics.dto.builder;

import br.com.dodivargas.dataAnalytics.dto.Customer;

public class CustomerBuilder {

    private Customer customer;

    public CustomerBuilder() {
        this.customer = new Customer();
    }

    public CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    public CustomerBuilder id(String customerId) {
        this.customer.setId(customerId);
        return this;
    }

    public CustomerBuilder cnpj(String customerCnpj) {
        this.customer.setCnpj(customerCnpj);
        return this;
    }

    public CustomerBuilder name(String customerName) {
        this.customer.setName(customerName);
        return this;
    }

    public CustomerBuilder bussinesArea(String bussinesArea) {
        this.customer.setBussinesArea(bussinesArea);
        return this;
    }

    public Customer build() {
        return this.customer;
    }
}
