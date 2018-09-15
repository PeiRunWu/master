package packag_java;

/**
 * 判断用户输入的email是否为非法字符串
 * 
 * @只能包含一个
 * @.不能在第一个和最后一个 email必须包含@和.
 * @author 你是我的信仰
 *
 */
public class StringEmail {
	public static boolean vaildateEmail(String email) {
		boolean vaildate = true;
		if (email == null)
			return false;
		String reg = "[A-Za-z0-9_]{1,}[@][0-9a-z]{2,3}[.][a-z]{2,3}";
		  if(email.matches(reg)){
			  vaildate=true;
         }else{

        	 vaildate=false;
         }
		return vaildate;
	}

}
