import java.util.Scanner;

public class Your_Ride_Is_Here {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
	    String str =input.nextLine();//输入彗星的名字
	    String str2=input.nextLine();//队伍的名字
	    int sum=1,num=1;
	    for(int i=0;i<str.length();i++) { //彗星的字母输出转数字在相乘
	    	sum=(str.charAt(i)-64)*sum;
	    }
	   for(int i=0;i<str2.length();i++) { //队伍的输出转数字在相乘
		   num=(str2.charAt(i)-64)*num;
	   }
	
      if(sum%47==num%47) {
    	  System.out.println("GO");
      }else {
    	  System.out.println("STAY");
      }
	}

}
