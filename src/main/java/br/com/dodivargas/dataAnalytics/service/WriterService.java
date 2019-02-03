package br.com.dodivargas.dataAnalytics.service;

import br.com.dodivargas.dataAnalytics.dto.DataAnalysis;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class WriterService {

    private String pathOut;
    private String fileNameOut;

    public WriterService(@Value("${app.files.directory.pathOut}") String pathOut, @Value("${app.files.nameFile.out}") String fileNameOut) {
        this.pathOut = pathOut;
        this.fileNameOut = fileNameOut;
    }

    void writeFile(DataAnalysis dataAnalysis, String outFileName) {
        Path outPath = Paths.get(System.getProperty("user.home").concat(pathOut), outFileName.concat(fileNameOut));
        try {
            Files.write(outPath, dataAnalysis.getDataAnlysis());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
