package packag_java;
/**
 * 判断传入的用户名字是否为非法字符串 
 * 用户名最多为25个字符长度，不含空格等
 * @author 你是我的信仰
 *
 */
public class StringName {
	public static boolean isCorrectUserName(String userName) {
		boolean isCorrectUser = true;
		if (userName == null)
			return false;
		if (userName.length() > 25)
			return false;
		// 非法字符串
		char[] unValidChar = { ' ', '\'', '"', '?', '<', '>', ',' };
		for (char ch : unValidChar) {
			if (userName.contains(Character.toString(ch))) {
				isCorrectUser = false;
				break;
			}
		}
		return isCorrectUser;
	}
}
