package br.com.dodivargas.dataAnalytics.factory.parser;

import br.com.dodivargas.dataAnalytics.model.Model;

import java.util.Optional;

public interface LineParse {

    Optional<Model> parse(String line);
    boolean isElegible(String line);
}
