package ua.kiev.prog.onishchenko.HomeTasks.Lecture08.Task04_Monitor;

import java.util.Date;

public interface IFileEvents {
    void onFileAdded(String path);
    void onFileDeleted(String path);
    void onFileChanged(String path, Long last, Long current);
}
