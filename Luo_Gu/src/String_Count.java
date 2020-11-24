import java.util.Scanner;

public class String_Count {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String string =scanner.next();
        char[] chars =string.toCharArray();
        int countUpper=0;
        int countLower=0;
        int countNumber=0;
        int countOther=0;

        for(int i=0;i<chars.length;i++){
            char ch =chars[i];
            if('A'<=ch && ch<='Z'){
                countUpper++;
            }else if('a'<=ch && ch<='z'){
                countLower++;
            }else if('0'<=ch && ch <='9'){
                countNumber++;
            }else {
                countOther++;
            }
        }
        System.out.println("大写字母有:"+countUpper);
        System.out.println("小写字母有:"+countLower);
        System.out.println("数字有:"+countNumber);
        System.out.println("其他有:"+countOther);
    }
}
