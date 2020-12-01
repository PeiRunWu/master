package com.wowowo.view;
/**
 * 登入窗口
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

public class Login extends JFrame {
    //创建一个用户名的JLabe类
    private JLabel unameJLabel;
    //创建用户名的输入框
    private JTextField unameJTextField;
    //创建一个登入按钮
    private JButton btnJButton;
    //创建一个取消按钮
    private JButton cancelJButton;
    public Login(){
        this.unameJLabel= new JLabel("用户名:");
        this.unameJTextField=new JTextField();
        this.btnJButton=new JButton("登入");
        this.cancelJButton =new JButton("取消");
        //设置窗口大小
        this.setSize(400,300);
        //设置窗口不可见
        this.setVisible(true);
        //设置屏幕居中
        this.setLocationRelativeTo(null);
        //设置窗口关闭的操作
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置布局方式
        this.setLayout(new GridLayout(2,2));
        //添加组件到窗口
        this.add(unameJLabel);
        this.add(unameJTextField);
        this.add(btnJButton);
        this.add(cancelJButton);
        //创建监听器对象绑定在按钮上
        MyEvent myEvent =new MyEvent();
        this.btnJButton.addActionListener(myEvent);
    }
    //创建事件监听器类
    class MyEvent implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //点击登入
            String name =unameJTextField.getText();
            //创建一个Socket连接服务器端
            Socket socket = null;
            try {
                socket = new Socket("127.0.0.1",8888);
                //跳转到主窗口
                new MainFrame(name,socket);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
    }
}
