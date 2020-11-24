import java.util.Scanner;

public class Luogu_team_system {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int topic =input.nextInt();
		if(topic * 5 < (topic * 3 +11)) {
			System.out.println("Local");
		}else {
			System.out.println("Luogu");
		}

	}

}
