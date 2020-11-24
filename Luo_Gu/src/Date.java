import java.util.Scanner;

public class Date {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int a =input.nextInt();
		int b =input.nextInt();
		int c =input.nextInt();
		int d =input.nextInt();
        int hour =0;
        int min =0;
        if(d>b) {
         hour =c-a;	
         min  = d- b;
        }else {
         hour =c-a-1;
         min = d+60-b;
        }
        System.out.println(hour+"\t"+min);
	}

}
