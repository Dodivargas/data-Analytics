package br.com.dodivargas.dataAnalytics.stubs;

import br.com.dodivargas.dataAnalytics.dto.*;
import br.com.dodivargas.dataAnalytics.dto.builder.CustomerBuilder;
import br.com.dodivargas.dataAnalytics.dto.builder.SaleBuilder;
import br.com.dodivargas.dataAnalytics.dto.builder.SaleItemBuilder;
import br.com.dodivargas.dataAnalytics.dto.builder.SalesmanBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ModelsStubs {

    public static List<String> getInputFileLines() {
        List<String> lines = new ArrayList<>();
        lines.add("001ç12345678910çPedroç50000");
        lines.add("002ç2345675434544345çJose da SilvaçRural");
        lines.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");
        return lines;
    }

    public static List<Model> getModels() {
        List<Model> models = new ArrayList<>();
        models.add(getCustomer());
        models.add(getSalesman());
        models.add(getSalePedro());
        return models;
    }

    public static Customer getCustomer() {
        return new CustomerBuilder().builder()
                .id("002")
                .cnpj("12345678910123")
                .name("paulo")
                .bussinesArea("rural")
                .build();
    }

    public static Salesman getSalesman() {
        return new SalesmanBuilder().builder()
                .id("001")
                .cpf("1234567891234")
                .name("Pedro")
                .salary(new BigDecimal(50000))
                .build();

    }

    public static Sale getSalePedro() {
        return new SaleBuilder().builder()
                .id("003")
                .saleId(1)
                .saleItems(getSaleItemsPedro())
                .salesmanName("pedro")
                .build();
    }

    private static List<SaleItem> getSaleItemsPedro() {
        List<SaleItem> saleItemList = new ArrayList<>();

        SaleItem saleItem1 = new SaleItemBuilder()
                .builder()
                .id("01")
                .quantity("10")
                .price(BigDecimal.valueOf(100))
                .build();

        SaleItem saleItem2 = new SaleItemBuilder()
                .builder()
                .id("02")
                .quantity("100")
                .price(BigDecimal.valueOf(150))
                .build();

        saleItemList.add(saleItem1);
        saleItemList.add(saleItem2);

        return saleItemList;
    }

    public static Sale getSaleWorstSalesman() {
        return new SaleBuilder().builder()
                .id("003")
                .saleId(2)
                .saleItems(getSaleItemsWorstSalesman())
                .salesmanName("worstSalesman")
                .build();
    }

    private static List<SaleItem> getSaleItemsWorstSalesman() {
        List<SaleItem> saleItemList = new ArrayList<>();

        SaleItem saleItem1 = new SaleItemBuilder()
                .builder()
                .id("01")
                .quantity("10")
                .price(BigDecimal.valueOf(100))
                .build();

        saleItemList.add(saleItem1);

        return saleItemList;
    }
}
