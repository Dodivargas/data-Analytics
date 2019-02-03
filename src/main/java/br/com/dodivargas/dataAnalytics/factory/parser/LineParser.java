package br.com.dodivargas.dataAnalytics.factory.parser;

import br.com.dodivargas.dataAnalytics.dto.Model;

import java.util.Optional;

public interface LineParser {

    Optional<Model> parse(String line);

    boolean isElegible(String line);
}
