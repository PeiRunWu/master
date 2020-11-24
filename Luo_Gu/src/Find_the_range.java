import java.util.Arrays;
import java.util.Scanner;

public class Find_the_range {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int[] num=new int[n];
        for(int i =0;i<num.length;i++){
            num[i]=sc.nextInt();
        }
        Arrays.sort(num);
        int range=num[num.length-1]-num[0];
        System.out.println(range);
    }
}
