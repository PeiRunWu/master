import java.util.ArrayList;

public class Manage extends User {
    public Manage() {
    }

    public Manage(String name, int money) {
        super(name, money);
    }

    public ArrayList<java.lang.Integer> send(int totalMoney, int count) {
        ArrayList<java.lang.Integer> arrayList =new ArrayList<>();
        //获取群主现在的money
        int nowMoney = super.getMoney();
        if (totalMoney > nowMoney) {
            System.out.println("余额不足");
            return arrayList;
        }
        //剩余的money
        int lastMoney = nowMoney - totalMoney;
        super.setMoney(lastMoney);

        int avg = totalMoney / count;
        int mod =totalMoney % count;
        for(int i =0;i<count-1;i++){
            arrayList.add(avg);
        }
        arrayList.add(avg+mod);
        return arrayList;
    }

}
