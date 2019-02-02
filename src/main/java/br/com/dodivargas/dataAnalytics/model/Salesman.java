package br.com.dodivargas.dataAnalytics.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Salesman implements Model {

    private String id;
    private String cpf;
    private String name;
    private BigDecimal salary;

    public Salesman() {
    }

    public Salesman(String id, String cpf, String name, BigDecimal salary) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public List<Salesman> getSalesmans(List<Model> models) {
        return models.stream().filter(model -> model.getClass().equals(Salesman.class)).map(salesman -> (Salesman) salesman).collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
