/**
 * 游戏房间
 */
import java.util.Scanner;
public class GameRoom{
	//属性:记分牌，道具，参与游戏玩家，房间号，房间名字，房间密码
	private HumanPlayer humanPlayer=null;
	private ComputerPlay computerPlay=null;
	/**房间Id**/
	private long roomId;
	/**房间名称**/
	private String roomName;
	/**房间密码**/
	private String roomPass;

	public GameRoom(String roomName,String roomPass){
	if(!("admin".equals(roomName)&&"123".equals(roomPass))){
		System.out.print("房间密码错误，游戏强制退出");
		return;
	}
	   this.setroomName(roomName);
       initGame();
       startGame();
       going();
       endGame();
	}
	public void initGame(){
		//初始化玩家
		humanPlayer=new HumanPlayer();
		computerPlay=new ComputerPlay();
		//初始化游戏其他属性
		for(int i=0;i<20;i++){
			System.out.print("*");
		}
		try{
			Thread.sleep(50);
		}catch(InterruptedException e){
			
		}
	}
	public void startGame(){
		showMenu();
		choiceRole();
	}
	public void endGame(){
		System.out.print(humanPlayer.getname()+" "+computerPlay.getname()+"\n");
		System.out.print(humanPlayer.getscore()+" "+computerPlay.getscore());
        System.out.println("\n游戏结束，欢迎再来");
	}


	public void showMenu(){
		System.out.println("\n欢迎进入《"+roomName+"》 游戏房间");
		System.out.print("出拳规则: 1-剪刀，2-石头，3-布");
	}
	public void choiceRole(){
		System.out.println("\n对方角色:1-风间，2-妮妮，3-正南，4-阿呆");
		System.out.print("请选择：");
		int choice=new Scanner(System.in).nextInt();
		String[] nameArray={"风间","妮妮","正南","阿呆"};
		computerPlay.setname(nameArray[choice-1]);
		humanPlayer.setname("野原新之助");
		System.out.println(computerPlay.getname()+"VS"+humanPlayer.getname());
	}
	public int judge(int fist1,int fist2){
		if(fist2==fist1)
			return 0;
		if(fist1==1&&fist2==3||fist2==1&&fist1==2|fist1==3&&fist2==2){
			//人得分加1.电脑得分减1
             humanPlayer.setscore(humanPlayer.getscore()+1);
             computerPlay.setscore(computerPlay.getscore()-1);
             return -1;
		}else{
			humanPlayer.setscore(humanPlayer.getscore()-1);
             computerPlay.setscore(computerPlay.getscore()+1);
             return 1;
		}
	}
    public void going(){
    	while(true){
    	 //双方出拳
        System.out.print(humanPlayer.getname()+"请出拳");
        Scanner input=new Scanner(System.in);
        humanPlayer.setfist(input.nextInt());
        int fist1=humanPlayer.getfist();
        computerPlay.getfist();
        int fist2=computerPlay.getfist();
        //判断
        int result=judge(fist1,fist2);
        if(result==-1){
        	System.out.println("[吉水老师]:"+humanPlayer.getname()+"胜利");
        	humanPlayer.sendMessage(HumanPlayer.MESSAGE_TYPE_WIN);
            computerPlay.sendMessage(ComputerPlay.MESSAGE_TYPE_LOSE);
        }else if(result==0){
        	System.out.println("[吉水老师]: 游戏平局");
        	humanPlayer.sendMessage(HumanPlayer.MESSAGE_TYPE_FISt);
            computerPlay.sendMessage(ComputerPlay.MESSAGE_TYPE_FIST);
        }else{
        	System.out.println("[吉水老师]:"+computerPlay.getname()+"胜利");
        	computerPlay.sendMessage(ComputerPlay.MESSAGE_TYPE_WIN);
        	humanPlayer.sendMessage(HumanPlayer.MESSAGE_TYPE_LOSE);
        }
        System.out.print("是否继续游戏(y/n)");
        String answer=new Scanner(System.in).next();
        if(!"y".equalsIgnoreCase(answer)){
        	break;
        }
      }
    }

	public long getroomId(){
		return roomId;
	}
	public void setroomId(long roomId){
		this.roomId=roomId;
	}
	public String getroomName(){
		return roomName;
	}
	public void setroomName(String roomName){
		this.roomName=roomName;
	}
	public String getroomPass(){
		return roomPass;
	}
	public void setroomPass(String roomPass){
		this.roomPass=roomPass;
	}
}