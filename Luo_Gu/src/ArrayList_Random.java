import java.util.ArrayList;
import java.util.Random;

public class ArrayList_Random {
    public static void main(String[] args) {
        Random random =new Random();
        ArrayList<java.lang.Integer> arrayList =new ArrayList<>();
        for(int i =0;i<6;i++){
            int number=random.nextInt(32)+1;
            arrayList.add(number);
        }
        for (int i =0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
    }
}
