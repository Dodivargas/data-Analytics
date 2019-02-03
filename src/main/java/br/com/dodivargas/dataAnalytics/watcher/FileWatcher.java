package br.com.dodivargas.dataAnalytics.watcher;

import br.com.dodivargas.dataAnalytics.service.ProcessorService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;


@Component
public class FileWatcher {

    private static ProcessorService processorService;
    private static String pathIn;
    private static String fileNameIn;

    public FileWatcher(ProcessorService processorService, @Value("${app.files.directory.pathIn}") String pathIn, @Value("${app.files.nameFile.in}") String fileNameIn) {
        FileWatcher.processorService = processorService;
        FileWatcher.pathIn = pathIn;
        FileWatcher.fileNameIn = fileNameIn;
    }

    public static void fileWatcher() throws Exception {
        FileAlterationObserver observer = new FileAlterationObserver(System.getProperty("user.home") + pathIn);
        FileAlterationMonitor monitor = new FileAlterationMonitor(5);
        FileAlterationListener listener = new FileAlterationListenerAdaptor() {
            @Override
            public void onFileCreate(File file) {
                try {
                    if (file.toPath().endsWith(fileNameIn)) {
                        processorService.fileProcess(FileUtils.readLines(file, "UTF-8"), file.getName().replace(fileNameIn, ""));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFileChange(File file) {
                try {
                    if (file.toString().endsWith(fileNameIn)) {
                        processorService.fileProcess(FileUtils.readLines(file, "UTF-8"), file.getName().replace(fileNameIn, ""));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        observer.addListener(listener);
        monitor.addObserver(observer);
        monitor.start();
    }

}





