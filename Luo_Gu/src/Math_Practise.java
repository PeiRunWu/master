public class Math_Practise {
    public static void main(String[] args) {
        double Min = -10.8;
        double Max = 5.8;
        int count = 0;
        for (int i = (int) Min; i < Max; i++) {
            int num = Math.abs(i);
            if (num > 6 || num < 2.1) {
                System.out.print(i+" ");
                count++;
            }
        }
        System.out.println();
        System.out.println("总共："+count);
    }
}
