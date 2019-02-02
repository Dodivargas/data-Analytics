package br.com.dodivargas.dataAnalytics.service;

import br.com.dodivargas.dataAnalytics.model.Model;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;


@Service
public class ProcessorService {

    private ParseService parseService;

    public ProcessorService(ParseService parseService) {
        this.parseService = parseService;
    }

    public void fileProcess(Path file) {
        try {
            List<Model> models = parseService.getModels(file);

            List<Model> customers = parseService.getCustomer(models);
            List<Model> salesmans = parseService.getSalesman(models);
            List<Model> sale = parseService.getSale(models);




        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
