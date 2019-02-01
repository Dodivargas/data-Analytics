package br.com.dodivargas.dataAnalytics.factory;

import br.com.dodivargas.dataAnalytics.factory.parser.CustomerParser;
import br.com.dodivargas.dataAnalytics.factory.parser.LineParser;
import br.com.dodivargas.dataAnalytics.factory.parser.SaleParser;
import br.com.dodivargas.dataAnalytics.factory.parser.SalesmanParser;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ParseFactory {

    private CustomerParser customerParser;
    private SalesmanParser salesManParser;
    private SaleParser saleParser;

    public ParseFactory(CustomerParser customerParser, SalesmanParser salesManParser, SaleParser saleParser) {
        this.customerParser = customerParser;
        this.salesManParser = salesManParser;
        this.saleParser = saleParser;
    }

    public Stream<LineParser> get() {
        return Stream.of(customerParser, salesManParser, saleParser);
    }
}
