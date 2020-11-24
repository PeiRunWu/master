import java.util.ArrayList;

public class MainRedPacket {
    public static void main(String[] args) {
        Manage manage =new Manage("群主",100);
        Member one =new Member("one",0);
        Member two =new Member("two",0);
        Member three =new Member("three",0);
        ArrayList<java.lang.Integer> arrayList = manage.send(20,3);
        one.receive(arrayList);
        two.receive(arrayList);
        three.receive(arrayList);
    }

}
