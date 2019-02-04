package br.com.dodivargas.dataAnalytics.service;

import br.com.dodivargas.dataAnalytics.dto.Customer;
import br.com.dodivargas.dataAnalytics.dto.Sale;
import br.com.dodivargas.dataAnalytics.dto.SaleItem;
import br.com.dodivargas.dataAnalytics.dto.Salesman;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
class MetricsService {

    Integer getCustomerQuantity(List<Customer> customers) {
        return customers.size();
    }

    Integer getSalesmanQuantity(List<Salesman> salesmans) {
        return salesmans.size();
    }

    Integer mostExpansiveSale(List<Sale> sales) {
        Map<Integer, BigDecimal> salePrice = sales.stream()
                .collect(Collectors.toMap(Sale::getSaleId, x -> getSalePrice(x.getSaleItems()), (sale1, sale2) -> sale1));
        return Collections.max(salePrice.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    String worstSalesman(List<Sale> sales) {
        Map<String, BigDecimal> map = sales.stream()
                .collect(Collectors.toMap(Sale::getSalesmanName, x -> getSalePrice(x.getSaleItems()), BigDecimal::add));
        return Collections.min(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private BigDecimal getSalePrice(List<SaleItem> saleItems) {
        return saleItems.stream().map(x -> x.getItemPrice().multiply(new BigDecimal(x.getItemQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}


