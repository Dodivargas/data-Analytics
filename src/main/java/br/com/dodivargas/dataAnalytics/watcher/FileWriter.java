package br.com.dodivargas.dataAnalytics.watcher;

import br.com.dodivargas.dataAnalytics.dto.DataAnalysis;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileWriter {

    private String pathOut;
    private String fileNameOut;

    public FileWriter(@Value("${app.files.directory.pathOut}") String pathOut, @Value("${app.files.nameFile.out}") String fileNameOut) {
        this.pathOut = pathOut;
        this.fileNameOut = fileNameOut;
    }

    public void writeFile(DataAnalysis dataAnalysis, String outFileName) {
        Path outPath = Paths.get(System.getProperty("user.home").concat(pathOut), outFileName.concat(fileNameOut));
        try {
            Files.write(outPath, dataAnalysis.getDataAnlysis());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
