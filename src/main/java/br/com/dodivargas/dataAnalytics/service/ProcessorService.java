package br.com.dodivargas.dataAnalytics.service;

import br.com.dodivargas.dataAnalytics.dto.*;
import br.com.dodivargas.dataAnalytics.dto.builder.DataAnalysisBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessorService {

    private ParseService parseService;
    private MetricsService metricsService;
    private WriterService writerService;

    public ProcessorService(ParseService parseService, MetricsService metricsService, WriterService writerService) {
        this.parseService = parseService;
        this.metricsService = metricsService;
        this.writerService = writerService;
    }

    public void fileProcess(List<String> lines, String fileName) {
        List<Model> models = parseService.parseModels(lines);

        List<Customer> customers = new Customer().getCustomers(models);
        List<Salesman> salesmans = new Salesman().getSalesmans(models);
        List<Sale> sales = new Sale().getSales(models);

        DataAnalysis dataAnalysis = new DataAnalysisBuilder()
                .customersAmounts(customers.size() != 0 ? metricsService.getCustomerQuantity(customers) : 0)
                .salesmanAmounts(salesmans.size() != 0 ? metricsService.getSalesamnQuantity(salesmans) : 0)
                .mostExpansiveSaleId(sales.size() != 0 ? metricsService.mostExpansiveSale(sales) : 0)
                .worstSalesman(sales.size() != 0 ? metricsService.worstSalesman(sales) : "")
                .build();

        writerService.writeFile(dataAnalysis, fileName);
    }

}
