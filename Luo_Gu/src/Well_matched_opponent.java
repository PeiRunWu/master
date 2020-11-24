import java.util.Scanner;

public class Well_matched_opponent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count=0;
        int linguistic[] = new int[1000];
        int mathematics[] = new int[1000];
        int english[] = new int[1000];
        for (int i = 0; i < n; i++) {
            linguistic[i] = scanner.nextInt();
            mathematics[i] = scanner.nextInt();
            english[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++){
                if(Math.abs(linguistic[i]-linguistic[j])<=5
                        && Math.abs(mathematics[i]-mathematics[j])<=5
                        && Math.abs(english[i]-english[j])<=5
                        && Math.abs((english[i]+mathematics[i]+linguistic[i])-(english[j]+mathematics[j]+linguistic[j]))<=10){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
