import java.io.File;


public class Main {
    public static void recDirectory(File dir) {
        if (dir.listFiles() == null) {
            return;
        } else {
            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    String access = "";
                    access = item.canRead() ? "r" : "-";
                    access += item.canWrite() ? "w" : "-";
                    access += item.canExecute() ? "x" : "-";
                    System.out.println(item.getAbsolutePath()+" <Dir> "+access);
                    recDirectory(item);
                } else {
                    String access = "";
                    access = item.canRead() ? "r" : "-";
                    access += item.canWrite() ? "w" : "-";
                    access += item.canExecute() ? "x" : "-";
                    System.out.println(item.getAbsolutePath()+" <FICH> "+access);
                }
            }

        }
    }


    public static void main(String[] args) {

        File directoryPath = new File("C:\\Users\\user\\Descktop\\Test");

        File[] files = directoryPath.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                String access = "";
                access = file.canRead() ? "r" : "-";
                access += file.canWrite() ? "w" : "-";
                access += file.canExecute() ? "x" : "-";
                System.out.println(file.getAbsolutePath() + " <FICH> " + access);

            } else if (file.isDirectory()) {
                recDirectory(file);
            }
        }
//    }

//public static  void main(String[] args) {
//    List<String> numbers = new ArrayList<>();
//    numbers.forEach((String n)-> System.out.println(n));
//
//}

}