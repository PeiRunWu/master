package packag_java;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名: ");
		String userName = input.next();
		System.out.println("请输入密码：");
		String password = input.next();
		System.out.print(StringUtil.vaildatePassword(password));
		System.out.println("请输入email：");
		String email = input.next();
		if (StringEmail.vaildateEmail(email) == true && StringName.isCorrectUserName(userName) == true) {
           System.out.println("格式正确，成功输入!!");
		}else {
			  System.out.println("格式错误!");
		}
	}

}
