import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Hail_conjecture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<java.lang.Integer> list = new ArrayList<>();
        int n = scanner.nextInt();
        list.add(n);
        while (true) {
            if (n % 2 == 0) {
                n = n / 2;
                list.add(n);
                if (n == 1) {
                    break;
                }
            } else {
                n = n * 3 + 1;
                list.add(n);
            }
        }
        Collections.reverse(list);
        for (int i : list) {
            System.out.println(i);
        }
    }
}
