import java.util.Scanner;

public class Buy_Pencil {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rice, rice1, rice2;
        int sum = input.nextInt();//铅笔数量
        int num1 = input.nextInt();//包装内铅笔的数量1
        int price1 = input.nextInt();//单价1
        int num2 = input.nextInt();//包装内铅笔的数量2
        int price2 = input.nextInt();//单价2
        int num3 = input.nextInt();//包装内铅笔的数量3
        int price3 = input.nextInt();//单价3
        if (sum % num1 == 0) {
            rice = (int) (sum / num1 * price1);
        } else {
            rice = (int) (((sum / num1) + 1) * price1);
        }
        if (sum % num2 == 0) {
            rice1 = (int) (sum / num2 * price2);
        } else {
            rice1 = (int) (((sum / num2) + 1) * price2);
        }
        if (sum % num3 == 0) {
            rice2 = (int) (sum / num3 * price3);
        } else {
            rice2 = (int) (((sum / num3) + 1) * price3);
        }

        if (rice > rice1 && rice1 > rice2) {
            System.out.println(rice2);
        } else if (rice > rice2 && rice2 > rice1) {
            System.out.println(rice1);
        } else if (rice1 > rice2 && rice2 > rice) {
            System.out.println(rice);
        } else if (rice1 > rice && rice > rice2) {
            System.out.println(rice2);
        } else if (rice2 > rice && rice > rice1) {
            System.out.println(rice1);
        } else {
            System.out.println(rice);
        }

    }

}
