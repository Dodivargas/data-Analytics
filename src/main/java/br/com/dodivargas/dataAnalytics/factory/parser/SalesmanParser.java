package br.com.dodivargas.dataAnalytics.factory.parser;

import br.com.dodivargas.dataAnalytics.dto.Model;
import br.com.dodivargas.dataAnalytics.dto.builder.SalesmanBuilder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class SalesmanParser implements LineParser {

    private static final String SALESMAN_PATTERN = "^(001)ç([0-9]{13})ç([\\s\\S]+)ç([0-9]*\\.?[0-9]+)";

    @Override
    public Optional<Model> parse(String line) {
        Matcher matcher = getMatcher(line);
        return Optional.of(new SalesmanBuilder()
                .builder()
                .id(matcher.group(1))
                .cpf(matcher.group(2))
                .name(matcher.group(3))
                .salary(new BigDecimal(matcher.group(4)))
                .build());
    }

    @Override
    public boolean isElegible(String line) {
        return getMatcher(line).matches();
    }

    private Matcher getMatcher(String line) {
        Pattern pattern = Pattern.compile(SALESMAN_PATTERN);
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        return matcher;
    }

}
