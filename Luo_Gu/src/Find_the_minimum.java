import java.util.Arrays;
import java.util.Scanner;

public class Find_the_minimum {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int length=input.nextInt();
		int[] num=new int[length];
		for(int i=0;i<num.length;i++) {
			num[i]=input.nextInt();
		}
		Arrays.sort(num);
		System.out.println(num[0]);
	}

}
