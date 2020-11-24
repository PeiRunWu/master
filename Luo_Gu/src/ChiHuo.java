public class ChiHuo extends Thread {
    private Baozi baozi;
    int i=0;
    public ChiHuo(Baozi baozi) {
        this.baozi = baozi;
    }

    @Override
    public void run() {
        while (i<=3) {
            synchronized (baozi) {
                if (baozi.flag == false) {
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("吃货正在吃包子 ： " + baozi.pi + baozi.xian + "包子");
                baozi.flag = false;
                baozi.notify();
                System.out.println("吃货已经把: " + baozi.pi + baozi.xian + "包子吃完");
                System.out.println("====================================");
            }
            i++;
        }
    }
}
