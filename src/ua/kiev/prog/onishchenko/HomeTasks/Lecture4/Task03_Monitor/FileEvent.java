package ua.kiev.prog.onishchenko.HomeTasks.Lecture4.Task03_Monitor;

import java.io.File;
import java.util.Date;

public class FileEvent implements IFileEvent {
    @Override
    public void onFileAdded(String s) {
        System.out.println("File added: " + s);
        System.out.println("    Last modified: " + new Date(new File(s).lastModified()));
    }
}
