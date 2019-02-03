package br.com.dodivargas.dataAnalytics.service;

import br.com.dodivargas.dataAnalytics.dto.DataAnalysis;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class WriterService {

    void writeFile(DataAnalysis dataAnalysis, String outFileName) {
        Path outPath = Paths.get(System.getProperty("user.home") + "/data/out", outFileName.concat(".done.dat"));
        try {
            Files.write(outPath, dataAnalysis.getDataAnlysis());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
