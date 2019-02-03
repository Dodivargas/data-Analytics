package br.com.dodivargas.dataAnalytics.job;

import br.com.dodivargas.dataAnalytics.service.ProcessorService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.stereotype.Component;

import java.io.File;


@Component
public class FileWatcher {

    private static ProcessorService processorService;

    public FileWatcher(ProcessorService processorService) {
        FileWatcher.processorService = processorService;
    }

    public static void fileWatcher() throws Exception {
        FileAlterationObserver observer = new FileAlterationObserver(System.getProperty("user.home") + "/data/in");
        FileAlterationMonitor monitor = new FileAlterationMonitor(5);
        FileAlterationListener listener = new FileAlterationListenerAdaptor() {
            @Override
            public void onFileCreate(File file) {
                try {
                    if (file.toPath().endsWith(".dat")) {
                        processorService.fileProcess(FileUtils.readLines(file, "UTF-8"), file.getName().replace(".dat", ""));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFileChange(File file) {
                try {
                    if (file.toString().endsWith(".dat")) {
                        processorService.fileProcess(FileUtils.readLines(file, "UTF-8"), file.getName().replace(".dat", ""));
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





