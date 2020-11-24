import java.text.DecimalFormat;
import java.util.*;

public class Score {
    public static void main(String[] args) {
        List<java.lang.Integer> list = new ArrayList<>();
        List<java.lang.Integer> removelist = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int max = Collections.max(list);
        int min = Collections.min(list);
        for (int i = 0; i < list.size(); i++) {
            if (max == list.get(i)) {
                list.remove(list.get(i));
                break;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (min == list.get(i)) {
                list.remove(list.get(i));
                break;
            }
        }
        for(double i : list){
            sum =sum + i;
        }
        System.out.println(String.format("%.2f",sum / (list.size())));
    }
}
