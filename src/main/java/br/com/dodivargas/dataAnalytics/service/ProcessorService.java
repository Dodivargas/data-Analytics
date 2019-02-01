package br.com.dodivargas.dataAnalytics.service;

import br.com.dodivargas.dataAnalytics.factory.ParseFactory;
import br.com.dodivargas.dataAnalytics.model.Model;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProcessorService {

    private ParseFactory parseFactory;

    public ProcessorService(ParseFactory parseFactory) {
        this.parseFactory = parseFactory;
    }

    public Optional<Model> processorLine(String line) {
        try {
            return parseFactory.get()
                    .filter(parseFactory -> parseFactory.isElegible(line))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Not such parser for this line"))
                    .parse(line);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
