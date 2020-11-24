import java.util.Scanner;

public class Apples {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int apple = input.nextInt();
		if(apple == 1) {
			System.out.println("Today, I ate 1 apple.");
		}else if (apple >1) {
			System.out.println("Today, I ate "+apple+" apples.");
		}else {
			System.out.println("Today, I ate 0 apple.");
		}

	}

}
