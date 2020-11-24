import java.util.Scanner;

public class Davor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = 0;
        int x = 1, max = 0;
        if( n % 364 == 0){
            num =n / 364;
        }else{
            num =n / 364 +1;
        }
        for (int i = 100; i >=1; i--) {
            if ((num - i) % 3 == 0 && (num -i) / 3 >0) {
                if(i < 100) {
                    max = i;
                    break;
                }
            }
        }
        if( n <1466){
            System.out.println(1);
            System.out.println(1);
        }else {
            System.out.println(max);
            System.out.println((num - max) / 3);
        }
    }
}
