import java.util.Scanner;

public class over_weight_problem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double body_weight = input.nextDouble();
		double height = input.nextDouble();
		double BMI = body_weight / Math.pow(height,2);
		if(BMI<18.5) {
			System.out.println("Underweight");
		}else if(BMI>=18.5 && BMI <24) {
			System.out.println("Normal");
		}else {
			double d =Math.ceil(Math.log10(BMI <0 ? -BMI :BMI));
			int power =6 -(int)d;
			double magnitude =Math.pow(10, power);
			long shifted =Math.round(BMI *magnitude);
			System.out.println(shifted /magnitude);
			System.out.println("Overweight");
		}
	}

}
