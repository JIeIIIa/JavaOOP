package ua.kiev.prog.onishchenko.HomeTasks.Lecture4.Task03_Monitor;

import java.io.File;

/**
 * Created by JIeIIIa on 02.09.2016.
 */
public class DirectoryEvent implements IDirectoryEvent {
    @Override
    public void onDirectoryAdded(String catalog) {
        System.out.println("Catalog added: " + catalog );
        File f = new File(catalog);
        int cnt = 0;
        for (String file : f.list()) {
            File current = new File(catalog + "\\" + file);
            if (current.isFile() && file.endsWith(".txt")) {
                cnt++;
            }
        }
        if (cnt > 0) {
            System.out.println("    WARNING! Catalog contains " + cnt + " txt-file(-s)");
        }


    }
}
