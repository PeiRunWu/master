package packag_java;

/**
 * 密码6-18 位，只能包含数字，字母，特殊符号
 * 纯数字，纯字母，密码强度为弱
 * 纯数字+纯字母，纯字母+纯符号，纯数字+纯符号，密码强度为中
 * 纯数字+纯符号+纯字母 密码强度为高
 * @param password
 * @return
 */
public class StringUtil {
	public static String vaildatePassword(String password) {
		String power ="";//密码的强度
		if(password==null)return power;
		if(password.length()<6||password.length()>18)return power;
		//判断字符串合法
		String part ="_@#$!";
		for(int i=0;i<password.length();i++) {
			//判断是否为数字或字母
			if(!Character.isLetterOrDigit(password.charAt(i))){
				//如果不是字母或数字，并且也不是合法的特殊符号，就证明是非法的格式
				if(!part.contains(Character.toString(password.charAt(i)))){
					return power;
				}
			}
		}
		if(isDigit(password)||isLetter(password)) {
			power="★★☆☆☆☆";
		}else if(isContainsSymble(password)) {
			power="★★★★★★";
		}else if(isDigAndLetter(password)) {
			power="★★★★☆☆";
		}
		return power;
	}
	/**
	 * 是否包含数字和字母
	 * @param value
	 * @return
	 */
	private static boolean isDigAndLetter(String value) {
		for(int i=0;i<value.length();i++) {
			if(!Character.isLetterOrDigit(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 判断一个字符串是不是纯数字
	 * @param value
	 * @return
	 */
	private static boolean isDigit(String value) {
		for(int i=0;i<value.length();i++) {
			if(!Character.isDigit(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 判断一个字符串是不是纯字母
	 */
	private static boolean isLetter(String value) {
		for(int i=0;i<value.length();i++) {
			if(!Character.isLetter(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 判断一个字符里是否为纯字符
	 */
	private static boolean isContainsSymble(String value) {
		String part ="_@#$!";
		for(int i=0;i<value.length();i++) {
			if(part.contains(Character.toString(value.charAt(i)))) {
				return true;
			}
		}
		return false;
	}
}
