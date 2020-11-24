import java.util.Scanner;

public class Boy_Password {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int n=input.nextInt();
		n=n%(122-97+1);
		String str =input.next();
		char[] ch=str.toCharArray();
		char[] arry =new char[ch.length];
		int length=0;
        for(int i=0;i<str.length();i++) {
        	if(ch[i]>96&&ch[i]<123) {
        		if(ch[i]+n>122) {
        			arry[length]=(char)(ch[i]+n-122+97-1);
        		}else {
        			arry[length]=(char)(ch[i]+n);
        		}
        		length++;
        	}
        	
        }
    	for(int i=0;i<length;i++) {
    		System.out.print(arry[i]);
    	}

	}

}
