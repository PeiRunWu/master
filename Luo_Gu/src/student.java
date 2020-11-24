import java.io.Serializable;

public class student  implements Serializable {
    private  String name;
    private  int age;
    private int Id;
    static int Idnumber =0;
    static String room;

    public student(String name, int age) {
        this.name = name;
        this.age = age;
        this.Id=++Idnumber;
    }

    public student(){

    }

    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
