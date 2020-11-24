import java.util.Scanner;

public class Number_Games {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
        int num[]=new int[10],s=0;
        for(int i=0;i<num.length;i++) {
        	num[i]=input.nextInt();
             if(num[i]==0) {
            	 break;
             }
             s++;
        }
        for(int i =s-1;i>=0;i--) {
        	System.out.print(num[i]+" ");
        }
		
	}

}
