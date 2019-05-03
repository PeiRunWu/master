import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		// 定义数组
		int[] array ={ 2, 5, 7, 8, 10, 12 };
		System.out.print("请输入要删除的数：");
		int searchNumer = input.nextInt();
		int delectIndex = -1;// 要删除的下标
		int count = array.length;
		boolean isFind = false;// 判断是否查找到
		int low = 0;// 下界下标
		int high = array.length - 1;// 上界下标
		while (high >= low) {
			int mid = (high + low) / 2;// 中间下标
			if (searchNumer > array[mid])// 如果查找的数大于中间的
				low = mid + 1;
			else if (searchNumer < array[mid])// 如果查找的数小于中间的
				high = mid - 1;
			else {// 如果相等
				isFind = true;
				delectIndex = mid;
				break;
			}
		}
		if (!isFind||delectIndex==-1) {
			System.out.println("没有找到要找到的下标");
			System.exit(0);
		}
		for (int i = delectIndex; i < array.length-1; i++) {
			array[i] = array[i + 1];
		}
		System.out.print("删除排序后:" + "\n");
		count--;
		for (int i = 0; i < count; i++)
			System.out.print(array[i]);

		System.out.print("\n"+"****************"+"\n");
		
		Arrays.sort(array);//排序
		System.out.print("请输入要插入的数:");
		int searcharray = input.nextInt();
		int insertIndex =array.length-1;// 定义插入的下标
		for(int i=0;i<array.length;i++) {
			if(searcharray<array[i]) {//如果输入的数小于数组第i个数，则下标为i
				insertIndex=i;
				break;
			}
		}
		for(int i=array.length-1;i>insertIndex;i--) {//将前面的数赋值给后面
			array[i]=array[i-1];
		}
		array[insertIndex]=searcharray;//输入的数赋值给下标的值
		System.out.print("插入排序后:" + "\n");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i]+" ");
	}
}
