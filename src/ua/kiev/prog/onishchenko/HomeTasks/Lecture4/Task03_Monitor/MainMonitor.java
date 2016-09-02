package ua.kiev.prog.onishchenko.HomeTasks.Lecture4.Task03_Monitor;

/*
    3. Добавить в проект «монитор» функцию вывода даты создания файла на экран
    4. Добавить в проект ф-ю мониторинга более одного файла.
    5. Написать код для мониторинга каталога. Выводить на экран предупреждение если в каталог добавляется текстовый файл (*.txt).
 */
public class MainMonitor {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "\\src\\ua\\kiev\\prog\\onishchenko\\HomeTasks\\Lecture4\\Task03_Monitor\\";
        String[] files = {path+"1.txt", path+"2.txt", path+"3.txt",path+"4.txt", path};
        Monitor m = new Monitor(files, new FileEvent(), new DirectoryEvent());
        m.removeFileFromWatch(path+"4.txt");
        m.start();
   }
}
