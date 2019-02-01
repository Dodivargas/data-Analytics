package br.com.dodivargas.dataAnalytics.model;

public class Customer implements Model {

    private String cnpj;
    private String name;
    private String bussinesArea;

    public Customer() {
    }

    public Customer(String cnpj, String name, String bussinesArea) {
        this.cnpj = cnpj;
        this.name = name;
        this.bussinesArea = bussinesArea;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBussinesArea() {
        return bussinesArea;
    }

    public void setBussinesArea(String bussinesArea) {
        this.bussinesArea = bussinesArea;
    }


}
