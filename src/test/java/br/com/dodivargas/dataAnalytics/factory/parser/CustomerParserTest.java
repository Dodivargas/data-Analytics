package br.com.dodivargas.dataAnalytics.factory.parser;

import br.com.dodivargas.dataAnalytics.dto.Customer;
import br.com.dodivargas.dataAnalytics.dto.Salesman;
import br.com.dodivargas.dataAnalytics.stubs.ModelsStubs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerParserTest {

    @InjectMocks
    private CustomerParser customerParser;

    @Test
    public void parseForValidLine() {
        Customer salesman = customerParser.parse("002ç1234567891023123çPauloçRural").map(x -> (Customer) x).get();
        Customer salesmanExpected = ModelsStubs.getCustomer();
        assertEquals(salesmanExpected.getId(), salesman.getId());
        assertEquals(salesmanExpected.getCnpj(), salesman.getCnpj());
        assertEquals(salesmanExpected.getName(), salesman.getName());
        assertEquals(salesmanExpected.getBussinesArea(), salesman.getBussinesArea());
    }

    @Test(expected = IllegalStateException.class)
    public void parseForInvalidLine() {
        customerParser.parse("fdasfad234çPefasfdroç50000");
    }

    @Test
    public void isElegibleForValidLine() {
        assertTrue(customerParser.isElegible("002ç2345675434544345çJose da SilvaçRural"));
    }

    @Test
    public void isElegibleForInvalidLine() {
        assertFalse(customerParser.isElegible("fdasfad234çPefasfdroçfsaf5555"));
    }
}