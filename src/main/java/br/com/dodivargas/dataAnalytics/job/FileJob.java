package br.com.dodivargas.dataAnalytics.job;

import br.com.dodivargas.dataAnalytics.service.ProcessorService;
import br.com.dodivargas.dataAnalytics.util.StringUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@EnableScheduling
public class FileJob {

    private ProcessorService processorService;

    public FileJob(ProcessorService processorService) {
        this.processorService = processorService;
    }

    @Scheduled(fixedRate = 5000)
    public void readFile() {
        try {
            Path inPath = Paths.get(System.getProperty("user.home") + "/data/in");

            Files.list(inPath)
                    .filter(path -> path.toString().endsWith(".dat"))
                    .forEach(file -> {
                        try {
                            Files.lines(file)
                                    .filter(StringUtils::isNotBlank)
                                    .map(x -> processorService.processorLine(x))
                                    .filter(Optional::isPresent)
                                    .collect(Collectors.toList()).forEach(System.out::println);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
