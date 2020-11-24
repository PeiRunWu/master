import java.util.Scanner;

public class Find_the_triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(), count = 0;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                count++;
                if (count < 10) {
                    System.out.print(0);
                }
                System.out.print(count);
            }
            System.out.println();
        }
        System.out.println();
        count =0;
        for (int i = 1; i <= num; i++) {
            for (int j = num; j > i; j--)
                System.out.print("  ");
            for (int k = 1; k <= i; k++) {
                count++;
                if (count < 10) {
                    System.out.print(0);
                }
                System.out.print(count);
            }
            System.out.println();
        }
    }
}
