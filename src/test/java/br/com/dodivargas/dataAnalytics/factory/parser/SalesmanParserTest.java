package br.com.dodivargas.dataAnalytics.factory.parser;

import br.com.dodivargas.dataAnalytics.dto.Salesman;
import br.com.dodivargas.dataAnalytics.stubs.ModelsStubs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class SalesmanParserTest {

    @InjectMocks
    private SalesmanParser salesmanParser;

    @Test
    public void parseForValidLine() {
        Salesman salesman = salesmanParser.parse("001ç1234567891234çPedroç50000").map(x -> (Salesman) x).get();
        Salesman salesmanExpected = ModelsStubs.getSalesman();
        assertEquals(salesmanExpected.getId(), salesman.getId());
        assertEquals(salesmanExpected.getCpf(),salesman.getCpf());
        assertEquals(salesmanExpected.getName(),salesman.getName());
        assertEquals(salesmanExpected.getSalary(),salesman.getSalary());
    }

    @Test(expected = IllegalStateException.class)
    public void parseForInvalidLine() {
        salesmanParser.parse("fdasfad234çPefasfdroç50000");
    }

    @Test
    public void isElegibleForValidLine() {
        assertTrue(salesmanParser.isElegible("001ç1234567891234çPedroç50000"));
    }
    @Test
    public void isElegibleForInvalidLine() {
        assertFalse(salesmanParser.isElegible("fdasfad234çPefasfdroç50000"));
    }

}