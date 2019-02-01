package br.com.dodivargas.dataAnalytics.factory.parser;

import br.com.dodivargas.dataAnalytics.model.Model;
import br.com.dodivargas.dataAnalytics.model.Sale;
import br.com.dodivargas.dataAnalytics.model.SaleItem;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class SaleParser implements LineParser {

    private static final String SALE_PATTERN = "^(003)ç([0-9]{0,})ç(\\[[0-9\\-\\,\\.]+\\])ç([\\s\\S]+)";
    public static final String SALES_ITENS_PATTERN = "(([0-9]+)-([0-9]+)-([0-9]*\\.?[0-9]+))+";

    @Override
    public Optional<Model> parse(String line) {
        Matcher matcher = getMatcher(line, SALE_PATTERN);
        return Optional.of(new Sale(matcher.group(2), getSaleItem(matcher.group(3)), matcher.group(4)));
    }

    @Override
    public boolean isElegible(String line) {
        return getMatcher(line, SALE_PATTERN).matches();
    }

    private List<SaleItem> getSaleItem(String list) {
        return Arrays.stream(list.split(","))
                .map(x -> getSaleItem(getMatcher(x, SALES_ITENS_PATTERN)))
                .collect(Collectors.toList());
    }

    private SaleItem getSaleItem(Matcher matcher) {
        return new SaleItem(matcher.group(1), matcher.group(2), matcher.group(3));
    }

    private Matcher getMatcher(String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        return matcher;
    }
}
