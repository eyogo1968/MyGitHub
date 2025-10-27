import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class IOStreamsExample1 {
    public static void main(String args[]) throws IOException {
        //Creating FileInputStream object
        File file = new File("C:/Users/jbeyogo/Desktop/java avancé/java-nio-file/myFile1.txt");
        FileInputStream fis = new FileInputStream(file);
        byte bytes[] = new byte[(int) file.length()];
        //Reading data from the file
        fis.read(bytes);
        //Writing data to another file
        File out = new File("C:/Users/jbeyogo/Desktop/java avancé/java-nio-file/CopyOfmyFile1.txt");
        FileOutputStream outputStream = new FileOutputStream(out);
        //Writing data to the file
        outputStream.write(bytes);
        outputStream.flush();
        System.out.println("Data successfully written in the specified file");
    }
}
