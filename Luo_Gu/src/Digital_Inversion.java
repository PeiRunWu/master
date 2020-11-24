import java.util.Scanner;

public class Digital_Inversion {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		String resStr = "";
		if (str.indexOf("/") != -1) {// 判断为分数的时候
			String[] strArray = str.split("/");
			String numerator=strArray[0];
			String denominator =strArray[1];
			resStr=reverseInt(numerator)+"/"+reverseInt(denominator);
		} else if (str.indexOf("%") != -1) {// 判断为百分数的时候
			String[] strArray = str.split("%");
			String numerator=strArray[0];
			resStr=reverseInt(numerator)+"%";
		} else if (str.indexOf(".") != -1) {// 判断为小数的时候
			String[] strArray = str.split("\\.");
			String numerator=strArray[0];
			String denominator =strArray[1];
			denominator=""+reverseInt(denominator);
			if (denominator.length() == 1 && denominator.charAt(0) == '0') {
                
            } else {
                while (denominator.charAt(denominator.length() - 1) == '0') {
                	denominator = denominator.substring(0, denominator.length() - 1);
                }
            }
			resStr=reverseInt(numerator)+"."+denominator;
		}else if(str.indexOf("-") !=-1){// 判断为负数的时候
			String[] strArray =str.split("-");
			String numerator=strArray[1];
			resStr="-"+reverseInt(numerator);
		} else {// 判断为整数的时候
			resStr=""+reverseInt(str);
		}
		System.out.println(resStr);
	}

	private static String reverseInt(String originalNumber) {
		String result ="";
		if (originalNumber.length() < 19) {
			long sum = 0;
			for (int i = originalNumber.length() - 1; i >= 0; i--) {
				sum += Math.pow(10, i) *(originalNumber.charAt(i)-'0');
			}
			result=""+sum;
		}else {
			int count =0;
			for (int i = originalNumber.length()-1; i >= 0; i--) {
				if(originalNumber.charAt(i)=='0') {
					count++;
				}else {
					break;
				}
			}
			for(int i=originalNumber.length()-count-1;i>=0;i--) {
				result+=originalNumber.charAt(i);
			}
		}
		return result;

	}

}
