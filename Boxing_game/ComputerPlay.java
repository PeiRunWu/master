/**
 * 电脑
 */
public class ComputerPlay{
		/**出拳时候的信息**/
	public static final int MESSAGE_TYPE_FIST=1;
    /**赢时候的信息**/
	public static final int MESSAGE_TYPE_WIN=2;
	/**输时候的信息**/
	public static final int MESSAGE_TYPE_LOSE=3;

	//属性：名称，分数,出拳,个性化台词
	private String name;
	private int score;
	private int fist;
    /**角色出拳的时候说的个性台词**/
	private String[] fistWords={"给你一勾拳","大王叫我来巡山","像我这样的可以躺着赚钱","吃我一拳","啦啦啦啦"};
	//**赢时候说的话**/
	private String[] winWords={"你想表达什么~~","找抽，是一种生活态度","抽，是一种生活艺术","真想只有一个，我赢了","hahahaha"};
	/**输的时候说的话**/
	private String[] loseWords={"通往成功的路上总在施工","等到潮水退去，就知道谁在裸泳了","没有想到，我竟然输了","看着我，记住我","你想表达什么"};

	public void sendMessage(int messType){
		//随机生成0-4之间
		int Index=((int)(Math.random()*1000))%5;
		/**要打印的消息**/
		String message=null;
		switch(messType){
			case MESSAGE_TYPE_FIST:
			 message=fistWords[Index];
			break;
			case MESSAGE_TYPE_LOSE:
			message=loseWords[Index];
			break;
			case MESSAGE_TYPE_WIN:
			message=winWords[Index];
			break;
		}
		System.out.print(message+"\n");
	}
		public String getname(){
			return name;
		}
		public void setname(String name){
			this.name=name;
		}
		public int getscore(){
			return score;
		}
		public void setscore(int score){
			this.score=score;
		}
		public int getfist(){
			//随机生成1-3的随机数字
			fist=((int)(Math.random()*30000))%3+1;
			return fist;
		}
	}