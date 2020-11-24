import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }

    public void receive(ArrayList<java.lang.Integer> arrayList){
        int index = new Random().nextInt(arrayList.size());
        //收到红包减一个，相减
        int del=arrayList.remove(index);
        int myself=super.getMoney();
        super.setMoney(del+myself);
    }
}
