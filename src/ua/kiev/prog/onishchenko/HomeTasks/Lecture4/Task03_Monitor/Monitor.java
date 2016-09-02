package ua.kiev.prog.onishchenko.HomeTasks.Lecture4.Task03_Monitor;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Monitor {
    private Set<String> list = new HashSet<>();
    private IDirectoryEvent directoryEvent;
    private IFileEvent event;

    public Monitor(String file, IFileEvent event, IDirectoryEvent directoryEvent) {
        list.add(file);
        this.event = event;
        this.directoryEvent = directoryEvent;
    }

    public Monitor(String[] files, IFileEvent event, IDirectoryEvent directoryEvent) {
        for (String file : files) {
            addFileToWatch(file);
        }

        this.event = event;
        this.directoryEvent = directoryEvent;
    }

    public void addFileToWatch(String file) {
        list.add(file);
    }

    public void removeFileFromWatch(String file) {
        list.remove(file);
    }

    public void clearWatch() {
        list.clear();
    }

    public void start() {
        while (true) {
            for (String file : list) {
                File f = new File(file);

                if (f.exists()) {
                    if (f.isFile()) {
                        if (event != null) {
                            event.onFileAdded(file);
                        }
                    } else if (f.isDirectory()){
                        if (directoryEvent != null) {
                            directoryEvent.onDirectoryAdded(file);
                        }
                    }
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println("Waiting...");
        }
    }

}
