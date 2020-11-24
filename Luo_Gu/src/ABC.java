import java.util.Arrays;
import java.util.Scanner;


public class ABC {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] num = new int[3];
		for (int i = 0; i < num.length; i++) {
			num[i] = input.nextInt();
		}
		String str = input.next();
		Arrays.sort(num);
		if (str.equals("ABC")) {
			System.out.printf("%d %d %d", num[0], num[1], num[2]);
		} else if (str.equals("ACB")) {
			System.out.printf("%d %d %d", num[0], num[2], num[1]);
		} else if (str.equals("BAC")) {
			System.out.printf("%d %d %d", num[1], num[0], num[2]);
		} else if (str.equals("BCA")) {
			System.out.printf("%d %d %d", num[1], num[2], num[0]);
		} else if (str.equals("CAB")) {
			System.out.printf("%d %d %d", num[2], num[0], num[1]);
		} else {
			System.out.printf("%d %d %d", num[2], num[1], num[0]);
		}
	}


}
