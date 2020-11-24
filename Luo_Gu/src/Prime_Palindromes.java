import java.util.Scanner;

public class Prime_Palindromes {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt(), b = input.nextInt(), c = 0, d = 0;
		boolean flag = false;
		for (int i = a; i <= b; i++) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = true;
					break;
				}
				flag = false;
			}
			if (flag == false) {
				if (isPlalindrome(i) == true) {
					System.out.println(i);
				}
			}
		}

	}

	private static boolean isPlalindrome(int number) {
		String num = String.valueOf(number);
		return new StringBuffer(num).reverse().toString().equalsIgnoreCase(num);
	}

}
