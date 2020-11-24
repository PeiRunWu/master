public class Computer {
    public void poweron(){
        System.out.println("笔记本电脑开机");
    }

    public void poweroff(){
        System.out.println("笔记本电脑关机");
    }

    public void useDevice(USB usb){
        usb.open();
        usb.off();
    }

}
