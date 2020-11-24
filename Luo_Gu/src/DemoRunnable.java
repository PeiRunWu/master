import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.lang.Integer;
import java.util.stream.Stream;

public class DemoRunnable {
    public static void main(String[] args) {
        //第一个队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        Stream<String> stringStream = one.stream().filter(name -> name.length() == 3).limit(3);

        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("尼古拉斯");
        two.add("张天爱");
        two.add("张二狗");
        Stream<String> stringStream1 = two.stream().filter(name -> name.startsWith("张")).skip(2);
        Stream<Persion> persionStream = Stream.concat(stringStream, stringStream1).map(name -> new Persion(name));
        persionStream.forEach(name -> System.out.println(name));
    }
}

