package ua.kiev.prog.onishchenko.HomeTasks.Lecture08.Task04_Monitor;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

public class Monitor implements Runnable {
    private String path;
    private int timeout;
    private TreeMap<String, Long> prev = new TreeMap<>();
    private TreeMap<String, Long> curr = new TreeMap<>();
    private IFileEvents events;
    private boolean doWatch = true;

    public Monitor(String path) {
        this.path = path;
        createMap(prev);
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setEvents(IFileEvents events) {
        this.events = events;
    }

    @Override
    public void run() {
        while (doWatch) {
            createMap(curr);
            compareArrays(prev, curr);
            prev.clear();
            prev.putAll(curr);

            System.out.println("Waiting...");
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void start() {
        new Thread(this).start();
    }

    public void stop() {
        doWatch = false;
    }

    private void doFileAdded(String path) {
        if (events != null) {
            events.onFileAdded(path);
        }
    }

    private void doFileDeleted(String path) {
        if (events != null) {
            events.onFileDeleted(path);
        }
    }

    private void doFileChanged(String path, Long last, Long current) {
        if (events != null) {
            events.onFileChanged(path, last, current);
        }
    }

    private void compareArrays(TreeMap<String, Long> m1, TreeMap<String, Long> m2) {
        Iterator<String> it = m1.keySet().iterator();
        String path;

        while (it.hasNext()) {
            path = it.next();
            if (!m2.containsKey(path)) {
                doFileDeleted(path);
            } else if (!m1.get(path).equals(m2.get(path))) {
                doFileChanged(path, m1.get(path), m2.get(path));
            }
        }

        it = m2.keySet().iterator();
        while (it.hasNext()) {
            path = it.next();
            if (!m1.containsKey(path)) {
                doFileAdded(path);
            }
        }
    }

    private void createMap(TreeMap<String, Long> output) {
        try {
            File file = new File(path);
            File[] list = file.listFiles();

            output.clear();
            for (File f : list) {
                output.put(f.getCanonicalPath(), f.lastModified());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
