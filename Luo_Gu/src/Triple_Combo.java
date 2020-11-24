
public class Triple_Combo {

	public static void main(String[] args) {
		int a ,b,c;
		for(a =123;a<=333;a++) {
			b =a*2;
			c=a*3;
			if((((a/100 +a%100/10+a%100%10+b/100 +b%100/10+b%100%10+c/100 +c%100/10+c%100%10)==45))&&(((a/100)*(a%100/10)*(a%100%10)*(b/100) *(b%100/10)*(b%100%10)*(c/100)*(c%100/10)*(c%100%10))==(1*2*3*4*5*6*7*8*9))) {
	             System.out.println(a+" "+b+" "+c);
			}
		}

	}

}
