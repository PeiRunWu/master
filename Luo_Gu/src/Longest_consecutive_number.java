import java.util.Scanner;

public class Longest_consecutive_number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int list[] = new int[num];
        int n = 1, max = 0;
        for (int i = 0; i < num; i++) {
            list[i] = scanner.nextInt();
        }
        for (int i = 0; i < list.length -1; i++) {
            if (list[i] == list[i + 1] - 1) {
                n++;
            } else {
                n = 1;
            }
            if (n > max) {
                max = n;
            }
        }
        System.out.println(max);
    }
}
