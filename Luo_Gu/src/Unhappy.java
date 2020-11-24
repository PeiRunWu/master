import java.util.Scanner;

public class Unhappy {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int max_time=0;
		int fraction=0;
		for(int i=1;i<=7;i++) {
			int a =input.nextInt();
			int b =input.nextInt();
			if(a+b>8&&a+b>max_time) {
				max_time=a+b;
			}
		}
      System.out.println(fraction);
	}

}
