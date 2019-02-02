package br.com.dodivargas.dataAnalytics.service;

import br.com.dodivargas.dataAnalytics.model.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MetricsService {

    public Integer getCustomerQuantity(List<Customer> customers) {
        return customers.size();
    }

    public Integer getSalesamnQuantity(List<Salesman> salesmans) {
        return salesmans.size();
    }

    String mostExpansiveSale(List<Sale> sales) {
        Map<String, BigDecimal> salePrice = sales.stream().collect(Collectors.toMap(Sale::getSaleId, x -> getSalePrice(x.getSaleItems())));
        return Collections.max(salePrice.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    Salesman worstSalesman(List<Salesman> salesmen, List<Sale> sales) {
        Map<String, BigDecimal> map = sales.stream()
                .collect(Collectors.toMap(Sale::getSalesmanName, x -> getSalePrice(x.getSaleItems()), BigDecimal::add));

        String worstsalesman = Collections.min(map.entrySet(), Map.Entry.comparingByValue()).getKey();

        return salesmen.stream()
                .filter(x -> x.getName().equals(worstsalesman))
                .findFirst().get();
    }

    private BigDecimal getSalePrice(List<SaleItem> saleItems) {
        return saleItems.stream().map(x -> x.getItemPrice().multiply(new BigDecimal(x.getItemQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}


