package br.com.dodivargas.dataAnalytics;

import br.com.dodivargas.dataAnalytics.job.FileWatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        FileWatcher.fileWatcher();
    }
}
