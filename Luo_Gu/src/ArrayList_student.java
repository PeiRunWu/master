import java.util.ArrayList;

public class ArrayList_student {
    public static void main(String[] args) {
        ArrayList<student> arrayList =new ArrayList<>();
        student one =new student("ÌÆÉ®",18);
        student two =new student("ËïÎò¿Õ",200);
        student three =new student("Öí°Ë½ä",210);
        student four =new student("É³Îò¾»",220);

        arrayList.add(one);
        arrayList.add(two);
        arrayList.add(three);
        arrayList.add(four);
        for(int i =0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i).getName());
        }
    }
}
