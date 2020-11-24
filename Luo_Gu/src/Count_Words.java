import java.util.Scanner;

public class Count_Words {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int k=0,first = 0;;
		String str=input.nextLine().toLowerCase();//输入要查找的数
		String str2=input.nextLine().toLowerCase();//输入文章
		String[] strPer =str2.split(" ");//把文章切割用空格切分开,每个单词存入strPer数组中
		for(int i=0;i<strPer.length;i++) {
			if(str.equals(strPer[i])){
				k++;
			}
		}
		if(k==0) {
			System.out.println(-1);
		}else {
			if(str.equals(str2.substring(0,str.length()))){
				System.out.println(0);
			}else {
				System.out.println(k+" "+str2.indexOf(" "+str+" ")+1);
			}
		}
	}

}
