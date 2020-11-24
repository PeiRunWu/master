import java.util.Scanner;

public class Pick_Apples {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int num[]=new int[10],s=0;
       for(int i =0;i<num.length;i++) { //将输入的10个苹果到地面的高度写进数组中
    	   num[i]=input.nextInt();
       }
       int height =input.nextInt()+30;
       for(int i:num) { //遍历整个数组，进行比较
    	   if(height>=i) {
    		   s++;
    	   }
       }
       System.out.println(s);
	}

}
