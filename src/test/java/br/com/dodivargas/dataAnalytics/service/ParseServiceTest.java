package br.com.dodivargas.dataAnalytics.service;

import br.com.dodivargas.dataAnalytics.dto.Model;
import br.com.dodivargas.dataAnalytics.factory.ParseFactory;
import br.com.dodivargas.dataAnalytics.factory.parser.CustomerParser;
import br.com.dodivargas.dataAnalytics.factory.parser.SaleParser;
import br.com.dodivargas.dataAnalytics.factory.parser.SalesmanParser;
import br.com.dodivargas.dataAnalytics.stubs.ModelsStubs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ParseServiceTest {


    @InjectMocks
    private ParseService parseService;

    @Mock
    private ParseFactory parseFactory;

    @Mock
    private CustomerParser customerParser;

    @Mock
    private SalesmanParser salesmanParser;

    @Mock
    private SaleParser saleParser;


    @Test
    public void parseModelsForCustomerSuccess() {
        when(customerParser.isElegible(any())).thenReturn(true);
        when(customerParser.parse(any())).thenReturn(Optional.of(ModelsStubs.getCustomer()));
        when(parseFactory.get()).thenReturn(Stream.of(customerParser, salesmanParser, saleParser));

        List<String> lines = new ArrayList<>();
        lines.add("001ç12345678910çPedroç50000");

        List<Model> models = parseService.parseModels(lines);

        assertNotNull(models);
    }

    @Test
    public void parseModelsForSalesmanSuccess() {
        when(salesmanParser.isElegible(any())).thenReturn(true);
        when(salesmanParser.parse(any())).thenReturn(Optional.of(ModelsStubs.getSalesman()));
        when(parseFactory.get()).thenReturn(Stream.of(customerParser, salesmanParser, saleParser));

        List<String> lines = new ArrayList<>();
        lines.add("002ç2345675434544345çJose da SilvaçRural");

        List<Model> models = parseService.parseModels(lines);

        assertNotNull(models);
    }

    @Test
    public void parseModelsForSaleSuccess() {
        when(saleParser.isElegible(any())).thenReturn(true);
        when(saleParser.parse(any())).thenReturn(Optional.of(ModelsStubs.getSalePedro()));
        when(parseFactory.get()).thenReturn(Stream.of(customerParser, salesmanParser, saleParser));

        List<String> lines = new ArrayList<>();
        lines.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");

        List<Model> models = parseService.parseModels(lines);

        assertNotNull(models);
    }

    @Test
    public void parseModelsForInvalidLine() {
        when(customerParser.isElegible(any())).thenReturn(false);
        when(saleParser.isElegible(any())).thenReturn(false);
        when(salesmanParser.isElegible(any())).thenReturn(false);
        when(parseFactory.get()).thenReturn(Stream.of(customerParser, saleParser, salesmanParser));

        List<String> lines = new ArrayList<>();
        lines.add("InvalidLine");


        assertTrue(parseService.parseModels(lines).isEmpty());
    }

    @Test
    public void parseModelsForBlankLine() {
        when(customerParser.isElegible(any())).thenReturn(false);
        when(customerParser.parse(any())).thenReturn(Optional.empty());
        when(parseFactory.get()).thenReturn(Stream.of(customerParser, salesmanParser, saleParser));

        List<String> lines = new ArrayList<>();
        lines.add("");

        List<Model> models = parseService.parseModels(lines);

        assertEquals(0, models.size());
    }


}