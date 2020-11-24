import java.util.Scanner;

public class Crafts_making {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int high = scanner.nextInt();
        int grow = scanner.nextInt();
        int width = scanner.nextInt();
        int q = scanner.nextInt();
        int count = 0;
        int num[][][] = new int[32][32][32];
        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            int e = scanner.nextInt();
            int f = scanner.nextInt();
            for (int j = a; j <=d; j++) {
                for (int k = b; k <= e; k++) {
                    for (int l = c; l <=f; l++) {
                        num[j][k][l] = 1;
                    }
                }
            }
        }
        for (int i = 1; i <=high; i++) {
            for (int j = 1; j <=grow; j++) {
                for (int z = 1; z <=width; z++) {
                    if(num[i][j][z]==0){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
