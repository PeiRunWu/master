public class Static_Field {
    public static void main(String[] args) {
        student student1 =new student("郭靖",18);
        student1.room="教室101";
        System.out.println("姓名："+student1.getName()+" 年龄："+student1.getAge()+" 教室："+student1.room+" 学号:"+student1.getId());

        student student2 =new student("黄蓉",17);
        System.out.println("姓名："+student2.getName()+" 年龄："+student2.getAge()+" 教室："+student2.room+" 学号:"+student2.getId());

        student student3 =new student("黄蓉",17);
        System.out.println("姓名："+student3.getName()+" 年龄："+student3.getAge()+" 教室："+student3.room+" 学号:"+student3.getId());

    }

    private static void methodStatic(){
        System.out.println("This is Static Method !!!");
    }
}
