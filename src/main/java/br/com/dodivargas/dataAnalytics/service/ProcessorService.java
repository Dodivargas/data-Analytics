package br.com.dodivargas.dataAnalytics.service;

import br.com.dodivargas.dataAnalytics.model.Customer;
import br.com.dodivargas.dataAnalytics.model.Model;
import br.com.dodivargas.dataAnalytics.model.Sale;
import br.com.dodivargas.dataAnalytics.model.Salesman;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Service
public class ProcessorService {

    private ParseService parseService;
    private MetricsService metricsService;


    public ProcessorService(ParseService parseService, MetricsService metricsService) {
        this.parseService = parseService;
        this.metricsService = metricsService;
    }

    public void fileProcess(Path file) {
        try {
            List<Model> models = parseService.parseModels(file);

            List<Customer> customers = new Customer().getCustomers(models);
            List<Salesman> salesmans = new Salesman().getSalesmans(models);
            List<Sale> sales = new Sale().getSales(models);

            salesmans.forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
