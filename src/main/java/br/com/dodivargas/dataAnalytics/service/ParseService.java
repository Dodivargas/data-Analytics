package br.com.dodivargas.dataAnalytics.service;

import br.com.dodivargas.dataAnalytics.dto.Model;
import br.com.dodivargas.dataAnalytics.factory.ParseFactory;
import br.com.dodivargas.dataAnalytics.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParseService {

    private ParseFactory parseFactory;

    public ParseService(ParseFactory parseFactory) {
        this.parseFactory = parseFactory;
    }

    List<Model> parseModels(List<String> lines) {
        return lines.stream()
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
                    .orElseThrow(() -> new NoSuchElementException("Not such parser for this line"))
                    .parse(line);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }


}
