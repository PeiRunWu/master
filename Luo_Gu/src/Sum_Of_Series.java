import java.util.Scanner;

public class Sum_Of_Series {

	public static void main(String[] args) {
      Scanner input =new Scanner(System.in);
      int k =input.nextInt();
      int n =0;
      double sum =0;
      for(double i =1;i<10000000;i++) {
    	   sum += 1 /(n+i);
    	  if(sum>k) {
    		 System.out.println((int)i);
    		 break;
    	  }
      }
	}

}
