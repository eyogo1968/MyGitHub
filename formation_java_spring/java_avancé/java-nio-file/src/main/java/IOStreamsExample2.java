import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class IOStreamsExample2 {
    public static void main(String args[]) throws IOException {
        //Creating FileReader object
        File file = new File("C:/Users/jbeyogo/Desktop/java avancé/java-nio-file/myFile2.txt");
        FileReader reader = new FileReader(file);
        char chars[] = new char[(int) file.length()];
        //Reading data from the file
        reader.read(chars);
        //Writing data to another file
        File out = new File("C:/Users/jbeyogo/Desktop/java avancé/java-nio-file/CopyOfmyFile2.txt");
        FileWriter writer = new FileWriter(out);
        //Writing data to the file
        writer.write(chars);
        writer.flush();
        System.out.println("Data successfully written in the specified file");
    }
}
