import java.util.Scanner;

public class Electricity {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		float electricity =input.nextFloat();
		if(electricity<=150) {
			System.out.printf("%.1f",electricity*0.4463);
		}else if(151<=electricity&&electricity<=400) {
			System.out.printf("%.1f",150*0.4463+(electricity-150)*0.4663);
		}else {
			System.out.printf("%.1f",150*0.4463+(electricity-400)*0.5663+(400-150)*0.4663);
		}

	}

}
