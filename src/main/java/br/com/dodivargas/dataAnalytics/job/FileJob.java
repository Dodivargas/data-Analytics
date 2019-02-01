package br.com.dodivargas.dataAnalytics.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@EnableScheduling
public class ArquivoJob {


    @Scheduled(fixedRate = 5000)
    public void lerAquivo() {
        try {
            Path inPath = Paths.get(System.getProperty("user.home") + "/data/in");


            Files.list(inPath)
                    .filter(path -> path.toString().endsWith(".dat"))
                    .forEach(arquivo -> {
                        try {
                            Files.lines(arquivo);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
