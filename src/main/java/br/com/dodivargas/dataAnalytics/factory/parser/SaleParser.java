package br.com.dodivargas.dataAnalytics.factory.parser;

import br.com.dodivargas.dataAnalytics.dto.Model;
import br.com.dodivargas.dataAnalytics.dto.SaleItem;
import br.com.dodivargas.dataAnalytics.dto.builder.SaleBuilder;
import br.com.dodivargas.dataAnalytics.dto.builder.SaleItemBuilder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class SaleParser implements LineParser {

    private static final String SALE_PATTERN = "^(003)ç([0-9]{0,})ç(\\[[0-9\\-\\,\\.]+\\])ç([\\s\\S]+)";
    private static final String SALES_ITENS_PATTERN = "([-+]?[0-9]*\\.?[0-9]*)-([-+]?[0-9]*\\.?[0-9]*)-([-+]?[0-9]*\\.?[0-9]*)";

    @Override
    public Optional<Model> parse(String line) {
        Matcher matcher = getMatcher(line, SALE_PATTERN);

        return Optional.of(new SaleBuilder()
                .builder()
                .id(matcher.group(1))
                .saleId(Integer.valueOf(matcher.group(2)))
                .saleItems(getSaleItems(matcher.group(3)))
                .salesmanName(matcher.group(4)).build());
    }

    @Override
    public boolean isElegible(String line) {
        return getMatcher(line, SALE_PATTERN).matches();
    }

    private List<SaleItem> getSaleItems(String list) {
        return Arrays.stream(list.split(","))
                .map(x -> getSaleItem(getMatcher(x, SALES_ITENS_PATTERN)))
                .collect(Collectors.toList());
    }

    private SaleItem getSaleItem(Matcher matcher) {
        return new SaleItemBuilder()
                .builder()
                .id(matcher.group(1))
                .quantity(matcher.group(2))
                .price(new BigDecimal(matcher.group(3)))
                .build();
    }

    private Matcher getMatcher(String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        return matcher;
    }
}
