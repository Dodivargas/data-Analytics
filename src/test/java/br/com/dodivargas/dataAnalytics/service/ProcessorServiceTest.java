package br.com.dodivargas.dataAnalytics.service;

import br.com.dodivargas.dataAnalytics.stubs.ModelsStubs;
import br.com.dodivargas.dataAnalytics.watcher.FileWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProcessorServiceTest {

    @InjectMocks
    private ProcessorService processorService;
    @Mock
    private ParseService parseService;
    @Mock
    private MetricsService metricsService;
    @Mock
    private FileWriter fileWriter;

    @Test
    public void fileProcess() {
        when(parseService.parseModels(any())).thenReturn(ModelsStubs.getModels());
        String fileName = "file";
        processorService.fileProcess(ModelsStubs.getInputFileLines(), fileName);

        Mockito.verify(parseService, times(1)).parseModels(Mockito.any());
        Mockito.verify(metricsService, times(1)).getCustomerQuantity(Mockito.any());
        Mockito.verify(metricsService, times(1)).getSalesamnQuantity(Mockito.any());
        Mockito.verify(metricsService, times(1)).mostExpansiveSale(Mockito.any());
        Mockito.verify(metricsService, times(1)).worstSalesman(Mockito.any());
        Mockito.verify(fileWriter, times(1)).writeFile(Mockito.any(), Mockito.any());
    }
}