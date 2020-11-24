
import java.util.Scanner;

public class Lottery_draw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a[] = new int[8], b[] = new int[8], c[] = new int[8];
        int count = 0;
        int n = scanner.nextInt();
        for (int i = 1; i <= 7; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            count = 0;
            for (int j = 1; j <= 7; j++) {
                b[j] = scanner.nextInt();
                for(int m =1;m <=7;m++){
                    if(a[m]==b[m]){
                        count++;
                    }
                }
            }
            c[count]++;
        }
        for (int i = 7; i > 1; i--) {
            System.out.println(c[i]);
        }
        System.out.println(c[1]);
    }

}
