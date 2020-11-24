import java.io.*;
import java.util.ArrayList;

public class Positive_sequence {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<student> arrayList =new ArrayList<>();
        arrayList.add(new student("裴润悟",30));
        arrayList.add(new student("覃诗婷",27));
        arrayList.add(new student("baby",20));
        ObjectOutputStream objectOutputStream =new ObjectOutputStream(new FileOutputStream("src\\list.java"));
        objectOutputStream.writeObject(arrayList);
        ObjectInputStream objectInputStream =new ObjectInputStream(new FileInputStream("src\\list.java"));
        Object o =objectInputStream.readObject();
        ArrayList<student> studentArrayList = (ArrayList<student>)o;
        for(student student : studentArrayList){
            System.out.println(student);
        }
        objectOutputStream.close();
        objectInputStream.close();

    }
}
