package com.wowowo.view;

import com.alibaba.fastjson.JSON;
import com.wowowo.model.Player;
import com.wowowo.model.Poker;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 服务器端窗口
 */
public class MainFrame {
    //创建玩家列表
    public List<Player> players = new ArrayList<Player>();
    public int index = 0;
    //创建扑克列表
    public List<Poker> pokers = new ArrayList<Poker>();
    //创建底牌
    public List<Poker> sortpokers = new ArrayList<Poker>();


    public MainFrame() throws IOException {
        //创建扑克列表
        createPoker();
        //创建服务器端socket
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            Socket socket = serverSocket.accept();
            //开启线程处理客户端socket
            AccrptThread accrptThread = new AccrptThread(socket);
            accrptThread.start();
        }
    }

    //创建所有的扑克列表
    private void createPoker() {
        //创建大王小王
        Poker dawang = new Poker(0, "大王", 17);
        Poker xiangwang = new Poker(1, "小王", 16);
        pokers.add(dawang);
        pokers.add(xiangwang);

        //创建其他的扑克牌
        String[] names = new String[]{"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        String[] colors = new String[]{"♠", "♥", "♣", "♦"};
        int id = 2;
        int num = 15;
        for (String name : names) {
            for (String color : colors) {
                Poker poker = new Poker(id++, color + name, num);
                pokers.add(poker);
            }
            num--;
        }
        //洗牌
        Collections.shuffle(pokers);
    }

    private void fapai() throws IOException {
        for (int i = 0; i < pokers.size(); i++) {
            if (i > 51) {
                sortpokers.add(pokers.get(i));
            } else if (i % 3 == 0) {
                players.get(0).getPokers().add(pokers.get(i));
            } else if (i % 3 == 1) {
                players.get(1).getPokers().add(pokers.get(i));
            } else {
                players.get(2).getPokers().add(pokers.get(i));
            }
        }
        //将玩家的信息发送到客户端
        for (int i = 0; i < players.size(); i++) {
            DataOutputStream outputStream =new DataOutputStream(players.get(i).getSocket().getOutputStream());
            String jsonString = JSON.toJSONString(players);
            outputStream.writeUTF(jsonString);
        }
    }

    //创建一个接收线程，处理客户端信息
    class AccrptThread extends Thread {
        Socket socket;

        public AccrptThread(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                //字节流转换为数据输入流
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                while (true) {
                    String msg = dataInputStream.readUTF();
                    //创建player对象
                    Player player = new Player(index++, msg);
                    player.setSocket(socket);
                    players.add(player);
                    System.out.println(msg + "上线了");
                    System.out.println("当前上线人数：" + players.size());
                    if (players.size() == 3) {
                        fapai();
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
