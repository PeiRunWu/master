import java.util.ArrayList;

public class ArrayList_student {
    public static void main(String[] args) {
        ArrayList<student> arrayList =new ArrayList<>();
        student one =new student("��ɮ",18);
        student two =new student("�����",200);
        student three =new student("��˽�",210);
        student four =new student("ɳ��",220);

        arrayList.add(one);
        arrayList.add(two);
        arrayList.add(three);
        arrayList.add(four);
        for(int i =0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i).getName());
        }
    }
}
