package br.com.dodivargas.dataAnalytics.service;

import br.com.dodivargas.dataAnalytics.dto.Customer;
import br.com.dodivargas.dataAnalytics.dto.Sale;
import br.com.dodivargas.dataAnalytics.dto.SaleItem;
import br.com.dodivargas.dataAnalytics.dto.Salesman;
import br.com.dodivargas.dataAnalytics.dto.builder.CustomerBuilder;
import br.com.dodivargas.dataAnalytics.dto.builder.SaleBuilder;
import br.com.dodivargas.dataAnalytics.dto.builder.SaleItemBuilder;
import br.com.dodivargas.dataAnalytics.dto.builder.SalesmanBuilder;
import br.com.dodivargas.dataAnalytics.stubs.ModelsStubs;
import org.junit.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class MetricsServiceTest {

    private MetricsService metricsService;

    public MetricsServiceTest() {
        this.metricsService = new MetricsService();
    }

    @Test
    public void getCustomerQuantity() {
        List<Customer> customers = new ArrayList<>();
        customers.add(ModelsStubs.getCustomer());
        customers.add(ModelsStubs.getCustomer());
        customers.add(ModelsStubs.getCustomer());

        assertEquals(Integer.valueOf(3), metricsService.getCustomerQuantity(customers));
    }

    @Test
    public void getSalesamnQuantity() {
        List<Salesman> salesman = new ArrayList<>();
        salesman.add(ModelsStubs.getSalesman());
        salesman.add(ModelsStubs.getSalesman());
        salesman.add(ModelsStubs.getSalesman());
        assertEquals(Integer.valueOf(3), metricsService.getSalesamnQuantity(salesman));

    }

    @Test
    public void mostExpansiveSale() {
        List<Sale> sales = new ArrayList<>();
        sales.add(ModelsStubs.getSaleWorstSalesman());
        sales.add(ModelsStubs.getSalePedro());

        assertEquals(Integer.valueOf(1), metricsService.mostExpansiveSale(sales));
    }

    @Test
    public void worstSalesman() {
        List<Sale> sales = new ArrayList<>();
        sales.add(ModelsStubs.getSaleWorstSalesman());
        sales.add(ModelsStubs.getSalePedro());

        assertEquals("worstSalesman", metricsService.worstSalesman(sales));
    }
}