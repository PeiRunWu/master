import java.util.Arrays;

public class SortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//选择排序
		final int N=10;
        int[] array=new int[N];
        //打印排序前的数
        System.out.print("排序前:\n");
        for(int i=0;i<array.length;i++) {
        	array[i]=(int)(Math.random()*N);
        	System.out.print(" "+array[i]+" ");
        }
        System.out.print("\n");
        //进行选择排序
        for(int i=0;i<array.length;i++) {
        	int min=array[i];//假设最小值为第I个值
        	int minIndex=i;//最小值的下标
        	for(int j=i+1;j<array.length;j++) {
        		if(min>array[j]) {//最小值大于下一个数时，下一个数为最小值
        			min=array[j];
        			minIndex=j;
        		}
        	}
        	int temp=array[i];
        	array[i]=array[minIndex];
        	array[minIndex]=temp;
        }
        System.out.print("排序后:\n");
        for(int i=0;i<array.length;i++) {
        	System.out.print(" "+array[i]+" ");
        }
        System.out.print("\n");
        //sort排序
        Arrays.sort(array);
        System.out.print("排序后:\n");
        for(int i=0;i<array.length;i++) {
        	System.out.print(" "+array[i]+" ");
        }
	}

}
