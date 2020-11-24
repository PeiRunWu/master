import java.util.Scanner;

public class Sum_of_factorial {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		float num = input.nextFloat(), temp = 1, sum = 0;
		for (int i = 0; i < num; i++) {
			for (int j = 1; j <= num - i; j++) {
				temp = temp * j;
			}
			sum = sum + temp;
			temp=1;
		}
		System.out.println(sum);

	}

}
