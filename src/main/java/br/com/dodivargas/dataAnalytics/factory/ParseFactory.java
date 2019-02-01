package br.com.dodivargas.dataAnalytics.factory;

import br.com.dodivargas.dataAnalytics.factory.parser.CustomerParser;
import br.com.dodivargas.dataAnalytics.factory.parser.LineParser;
import br.com.dodivargas.dataAnalytics.factory.parser.SalesManParser;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ParseFactory {

    private CustomerParser customerParser;
    private SalesManParser salesManParser;

    public ParseFactory(CustomerParser customerParser, SalesManParser salesManParser) {
        this.customerParser = customerParser;
        this.salesManParser = salesManParser;
    }

    public Stream<LineParser> get() {
        return Stream.of(customerParser, salesManParser);
    }
}
