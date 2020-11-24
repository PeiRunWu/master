import java.util.ArrayList;
import java.util.Random;

public class ArrayList_Return {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<java.lang.Integer> bigList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            bigList.add((random.nextInt(100) + 1));
        }
        System.out.println("Å¼Êý¹²ÓÐ£º" + smallList(bigList).size());
        System.out.println(smallList(bigList));
    }

    public static ArrayList<java.lang.Integer> smallList(ArrayList<java.lang.Integer> arrayList) {
        ArrayList<java.lang.Integer> smallList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            int num = arrayList.get(i);
            if (num % 2 == 0) {
                smallList.add(num);
            }
        }
        return smallList;
    }
}
