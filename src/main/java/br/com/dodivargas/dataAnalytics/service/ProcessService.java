package br.com.dodivargas.dataAnalytics.service;

import br.com.dodivargas.dataAnalytics.dto.*;
import br.com.dodivargas.dataAnalytics.dto.builder.DataAnalysisBuilder;
import br.com.dodivargas.dataAnalytics.watcher.FileWriter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService {

    private ParseService parseService;
    private MetricsService metricsService;
    private FileWriter fileWriter;


    public ProcessService(ParseService parseService, MetricsService metricsService, FileWriter fileWriter) {
        this.parseService = parseService;
        this.metricsService = metricsService;
        this.fileWriter = fileWriter;
    }

    public void fileProcess(List<String> lines, String fileName) {
        List<Model> models = parseService.parseModels(lines);

        List<Customer> customers = new Customer().getCustomers(models);
        List<Salesman> salesmans = new Salesman().getSalesmans(models);
        List<Sale> sales = new Sale().getSales(models);

        DataAnalysis dataAnalysis = new DataAnalysisBuilder()
                .customersAmounts(customers.size() != 0 ? metricsService.getCustomerQuantity(customers) : 0)
                .salesmanAmounts(salesmans.size() != 0 ? metricsService.getSalesmanQuantity(salesmans) : 0)
                .mostExpansiveSaleId(sales.size() != 0 ? metricsService.mostExpansiveSale(sales) : 0)
                .worstSalesman(sales.size() != 0 ? metricsService.worstSalesman(sales) : "")
                .build();

        fileWriter.writeFile(dataAnalysis, fileName);
    }

}
