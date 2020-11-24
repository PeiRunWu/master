public class BaoZiPu extends Thread {
    //需要在成员位置创建一个包子变量
    private Baozi baozi;
    int i = 0;

    public BaoZiPu(Baozi baozi) {
        this.baozi = baozi;
    }

    @Override
    public void run() {
        int count = 0;
        while (i <= 3) {
            synchronized (baozi) {
                if (baozi.flag) {
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //被唤醒执行
                if (count % 2 == 0) {
                    baozi.pi = "薄皮";
                    baozi.xian = "三鲜馅";
                } else {
                    baozi.pi = "冰皮";
                    baozi.xian = "牛肉馅";
                }
                count++;
                System.out.println("包子铺正在生产: " + baozi.pi + baozi.xian + "包子");
                //生产包子需要3秒钟
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baozi.flag = true;
                baozi.notify();
                System.out.println("包子铺已经生产好： " + baozi.pi + baozi.xian + "包子");
            }
            i++;
        }
    }
}
