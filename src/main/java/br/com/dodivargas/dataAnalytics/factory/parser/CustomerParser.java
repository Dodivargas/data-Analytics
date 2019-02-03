package br.com.dodivargas.dataAnalytics.factory.parser;

import br.com.dodivargas.dataAnalytics.dto.Model;
import br.com.dodivargas.dataAnalytics.dto.builder.CustomerBuilder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CustomerParser implements LineParser {

    private static final String CUSTOMER_PATTERN = "^(002)ç([0-9]{16})ç([\\s\\S]+)ç([\\s\\S]+)";

    @Override
    public Optional<Model> parse(String line) {
        Matcher matcher = getMatcher(line);
        return Optional.of(new CustomerBuilder()
                .builder()
                .id(matcher.group(1))
                .cnpj(matcher.group(2))
                .name(matcher.group(3))
                .bussinesArea(matcher.group(4))
                .build());
    }

    @Override
    public boolean isElegible(String line) {
        return getMatcher(line).matches();
    }

    private Matcher getMatcher(String line) {
        Pattern pattern = Pattern.compile(CUSTOMER_PATTERN);
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        return matcher;
    }
}
