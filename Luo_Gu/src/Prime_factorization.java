import java.util.Scanner;

public class Prime_factorization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int max = 1, n = 1;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                System.out.println(num / i);
                break;
            }
        }
    }
}
