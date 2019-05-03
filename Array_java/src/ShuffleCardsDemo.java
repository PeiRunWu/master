
public class ShuffleCardsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// /13可取得花色 ，%13可取得花色
		final int N = 52;//定义牌数
		int[] card = new int[N];
		//牌的花色组
		String[] cardColors= {"黑桃","红心","方块","梅花"};
		String[] cardValus= {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for(int i=0;i<card.length;i++) {
			card[i]=i;
		}
		System.out.print("洗牌前:"+"\n");
		for(int i=0;i<card.length;i++) {
			System.out.print(" "+cardColors[card[i]/13]+cardValus[card[i]%13]+" ");//打印花色+牌面
			if((i+1)%13==0)
				System.out.print("\n");
			else
				System.out.print("\t");
		}
		//洗牌，随机生成0-51之间的数字
		for(int i=0;i<card.length;i++) {
			int newIndex=(int)(Math.random()*N);//随机52个数
			//将牌进行打乱
			int temp=card[i];
			card[i]=card[newIndex];
			card[newIndex]=temp;
		}
		System.out.print("洗牌后:"+"\n");
		for(int i=0;i<card.length;i++) {
			System.out.print(" "+cardColors[card[i]/13]+cardValus[card[i]%13]+" ");
			if((i+1)%13==0)
				System.out.print("\n");
			else
				System.out.print("\t");
		}
		
	}

}
