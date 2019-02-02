package br.com.dodivargas.dataAnalytics.job;

import br.com.dodivargas.dataAnalytics.service.ProcessorService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Component
@EnableScheduling
public class FileJob {

    private ProcessorService processorService;

    public FileJob(ProcessorService processorService) {
        this.processorService = processorService;
    }

    @Scheduled(fixedRate = 500)
    public void directoryRead() {
        try {

            Path inPath = Paths.get(System.getProperty("user.home") + "/data/in");
            Files.list(inPath)
                    .filter(path -> path.toString().endsWith(".dat"))
                    .forEach(path -> processorService.fileProcess(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
