import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Number_of_days_to_live {
    public static void main(String[] args) throws ParseException {
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入你的出生年龄:  YYYY-MM-DD :");
        String born_day = scanner.next();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
        Date date =simpleDateFormat.parse(born_day);
        long nowtime =  new Date().getTime();
        long brithday_time = date.getTime();
        long day = (nowtime-brithday_time) / 86400000;
        System.out.println("出生"+day+"天");

    }
}
