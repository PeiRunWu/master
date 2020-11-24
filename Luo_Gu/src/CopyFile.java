import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream =new ObjectInputStream(new FileInputStream("C:\\java\\Luo_Gu\\src\\student.java"));
        Object o = objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(objectInputStream);

    }
}
