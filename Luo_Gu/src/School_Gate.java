import java.util.Scanner;

public class School_Gate {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int L =input.nextInt();//马路的长度
		int M =input.nextInt();//区域的数目
		int num[] =new int[L+1],s=0;
        for(int i =0;i<=L;i++)
        	num[i]=0; //这些树都是没有被访问过的
        for(int i =0;i<M;i++) { //输入区域的起始点和终点
        	int first=input.nextInt();
        	int end =input.nextInt();
        	for(int j=first;j<=end;j++) { //起点到终点树木全被访问过赋于1
        			num[j]=1;  
        	}
        }
        for(int i =0;i<=L;i++) { //如果树木没有被访问过，则S++
        	if(num[i]==0) {
        		s++;
        	}
        }
        System.out.println(s);
	}

}
