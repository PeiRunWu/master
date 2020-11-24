import java.util.Scanner;

public class Swimming {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		double swim =input.nextDouble();//输入游泳的距离
		double Step_count=2;//游泳的总共步数
		int i =1;
	    if(swim<=2) {
		   System.out.println(1);
	    }else {
           while(i>0) {
        	Step_count +=Math.pow(0.98, i)*2;
        	i++;
        	//System.out.println(Step_count);
        	if(Step_count>=swim) {
        		System.out.println(i);
        		break;
        	}
         }
	    }
	}

}
