package br.com.dodivargas.dataAnalytics.factory;

import br.com.dodivargas.dataAnalytics.factory.parser.CustomerParse;
import br.com.dodivargas.dataAnalytics.factory.parser.LineParse;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ParseFactory {

    private CustomerParse customerParse;

    public ParseFactory(CustomerParse customerParse) {
        this.customerParse = customerParse;
    }

    public Stream<LineParse> get() {
        return Stream.of(customerParse);
    }
}
