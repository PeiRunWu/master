/**
 * 人类
 */
public class HumanPlayer{
	/**出拳时候的信息**/
	public static final int MESSAGE_TYPE_FISt=1;
    /**赢时候的信息**/
	public static final int MESSAGE_TYPE_WIN=2;
	/**输时候的信息**/
	public static final int MESSAGE_TYPE_LOSE=3;

	//属性：名称，分数,出拳,个性化台词
	private String name;
	private int score;
	private int fist;
    /**角色出拳的时候说的个性台词**/
	private String[] fistWords={"动感光波~biubiubiu~~","大象的鼻子为什么这么长~~","必杀露pp~~","吃我一拳","hahha,我来啦"};
	//**赢时候说的话**/
	private String[] winWords={"还有谁~~","猜拳有点意思","全军出击~~","在座的各位都是垃圾","hahahaha"};
	/**输的时候说的话**/
	private String[] loseWords={"嗷嗷嗷","我竟然输了","众人皆醉，我独醒","千万别忘了我","宁可天下负我，也不愿我负天下"};

	public void sendMessage(int messType){
		//随机生成0-4之间
		int Index=((int)(Math.random()*1000))%5;
		/**要打印的消息**/
		String message=null;
		switch(messType){
			case MESSAGE_TYPE_FISt:
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
			return fist;
		}
		public void setfist(int fist){
			this.fist=fist;
		}
	}
