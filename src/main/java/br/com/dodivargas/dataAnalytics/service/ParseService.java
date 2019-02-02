package br.com.dodivargas.dataAnalytics.service;

import br.com.dodivargas.dataAnalytics.factory.ParseFactory;
import br.com.dodivargas.dataAnalytics.model.Customer;
import br.com.dodivargas.dataAnalytics.model.Model;
import br.com.dodivargas.dataAnalytics.model.Sale;
import br.com.dodivargas.dataAnalytics.model.Salesman;
import br.com.dodivargas.dataAnalytics.util.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParseService {

    private ParseFactory parseFactory;

    public ParseService(ParseFactory parseFactory) {
        this.parseFactory = parseFactory;
    }

    List<Model> parseModels(Path file) throws IOException {
        return Files.lines(file)
                .filter(StringUtils::isNotBlank)
                .map(this::getModelFactory)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private Optional<Model> getModelFactory(String line) {
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
