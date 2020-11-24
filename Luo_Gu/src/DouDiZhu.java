import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.lang.Integer;

public class DouDiZhu {
    public static void main(String[] args) {
        //1.准备牌
        //储存牌的序列和牌的花色
        HashMap<Integer, String> poker = new HashMap<>();
        //储存牌的索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        //定义牌的花色和牌的数字
        List<String> colors = List.of("♥", "♦", "♠", "♣");
        List<String> numbers = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        //添加大王小王
        int index = 0;
        poker.put(index, "大王");
        pokerIndex.add(index);
        index++;
        poker.put(index, "小王");
        pokerIndex.add(index);
        index++;
        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index, color + number);
                pokerIndex.add(index);
                index++;
            }
        }
        //2.洗牌
        Collections.shuffle(pokerIndex);
        //3.发牌
        ArrayList<Integer > poker01 = new ArrayList<>();
        ArrayList<Integer > poker02 = new ArrayList<>();
        ArrayList<Integer > poker03 = new ArrayList<>();
        ArrayList<Integer > dipai = new ArrayList<>();
        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer values = pokerIndex.get(i);
            if (i >= 51) {
                dipai.add(values);
            } else if (i % 3 == 0) {
                poker01.add(values);
            } else if (i % 3 == 1) {
                poker02.add(values);
            } else {
                poker03.add(values);
            }
        }
        //4.排序
        Collections.sort(dipai);
        Collections.sort(poker01);
        Collections.sort(poker02);
        Collections.sort(poker03);
        //5.看牌
        look("刘德华",poker,poker01);
        look("周杰伦",poker,poker02);
        look("刘亦菲",poker,poker03);
        look("底牌",poker,dipai);

    }

    private static void look(String name, HashMap<Integer, String> poker, ArrayList<Integer > pokerIndex) {
        System.out.print(name + ": ");
        for(Integer list : pokerIndex){
            String values = poker.get(list);
            System.out.print(values+" ");
        }
        System.out.println();
    }
}
