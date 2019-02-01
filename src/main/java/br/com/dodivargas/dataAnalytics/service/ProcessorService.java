package br.com.dodivargas.dataAnalytics.service;

import br.com.dodivargas.dataAnalytics.factory.ParseFactory;
import br.com.dodivargas.dataAnalytics.model.Model;
import br.com.dodivargas.dataAnalytics.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProcessorService {

    @Autowired
    private Validator validator;
    @Autowired
    private ParseFactory parseFactory;

    public Model processorLine(String line) {
        return parseFactory.get()
                .filter(parseFactory -> parseFactory.isElegible(line))
                .findFirst()
                .flatMap(x -> x.parse(line))
                .get();
    }
}
