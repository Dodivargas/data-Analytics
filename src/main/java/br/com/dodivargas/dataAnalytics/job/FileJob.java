package br.com.dodivargas.dataAnalytics.job;

import br.com.dodivargas.dataAnalytics.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private ProcessorService processorService;

    @Scheduled(fixedRate = 5000)
    public void readFile() {
        try {
            Path inPath = Paths.get(System.getProperty("user.home") + "/data/in");

            Files.list(inPath)
                    .filter(path -> path.toString().endsWith(".dat"))
                    .forEach(file -> {
                        try {
                            Files.lines(file)
                                    .map(x -> processorService.processorLine(x));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
