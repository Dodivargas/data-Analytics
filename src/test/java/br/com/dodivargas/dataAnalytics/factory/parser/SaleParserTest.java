package br.com.dodivargas.dataAnalytics.factory.parser;

import br.com.dodivargas.dataAnalytics.dto.Sale;
import br.com.dodivargas.dataAnalytics.stubs.ModelsStubs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class SaleParserTest {

    @InjectMocks
    private SaleParser saleParser;

    @Test
    public void parseForValidLine() {
        Sale sale = saleParser.parse("003ç01ç[1-10-100,3-40-3.10]çPedro").map(x -> (Sale) x).get();
        Sale saleExpected = ModelsStubs.getSalePedro();
        assertEquals(saleExpected.getId(), sale.getId());
        assertEquals(saleExpected.getSaleId(), sale.getSaleId());
        assertEquals(saleExpected.getSaleItems().size(), sale.getSaleItems().size());
        assertEquals(saleExpected.getSalesmanName(), sale.getSalesmanName());
    }

    @Test(expected = IllegalStateException.class)
    public void parseForInvalidLine() {
        saleParser.parse("fdasfad234çPefasfdroç50000");
    }

    @Test
    public void isElegibleForValidLine() {
        assertTrue(saleParser.isElegible("003ç01ç[1-10-100,2-30-2.50,3-40-3.10]çPedro"));
    }

    @Test
    public void isElegibleForInvalidLine() {
        assertFalse(saleParser.isElegible("fdasfad234çPefasfdroçfsaf5555"));
    }
}