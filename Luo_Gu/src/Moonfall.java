import java.util.Scanner;

public class Moonfall {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        double n =sc.nextDouble();
        double a=1;
        double b=1;
        double c=0;
        for(double i = 3;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        System.out.printf("%.2f",c);
    }
}
