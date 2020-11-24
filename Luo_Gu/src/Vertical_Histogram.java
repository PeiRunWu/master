import java.util.Scanner;

public class Vertical_Histogram {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str;
		int[] s = new int[26];
		char c;
		for (int i = 0; i < 4; i++) {
			str = input.nextLine();
			for (int j = 0; j < str.length(); j++) {
			    c = str.charAt(j);
				if (c >= 'A' && 'Z'>= c) {
					s[c - 'A']++;
				}
			}
		}
		int MAX = 0;
		for (int i = 0; i <=25; i++) {
			if (s[i] > MAX) {
				MAX = s[i];
			}
		}
		for(int i=MAX;i>=1;i--) { 
            for(int j =0; j<=25;j++) { 
                if(s[j]==i) {  
                    s[j]--;
                    System.out.print("* ");
                }else
                    System.out.print("  ");
            }
            System.out.println(); 
        }
        System.out.print("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
	}

}
