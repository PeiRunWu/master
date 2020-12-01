package com.wowowo.view;
/**
 * 创建窗口样式
 */

import com.wowowo.model.Player;
import com.wowowo.model.Poker;
import com.wowowo.model.PokerLabel;
import com.wowowo.thread.ReceiveThread;
import com.wowowo.thread.SendThread;
import com.wowowo.util.GameUtils;

import javax.swing.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    public Mypanel mypanel;
    public String unname;
    public Socket socket;
    public SendThread sendThread;
    public ReceiveThread receiveThread;
    public Player currentPlayer;
    public List<PokerLabel> pokerLabels = new ArrayList<PokerLabel>();
    public MainFrame(String name, Socket socket) {
        this.unname = name;
        //设置窗口属性
        this.setSize(2064, 1080);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //添加mypanl
        mypanel = new Mypanel();
        mypanel.setBounds(0, 0, 2064, 1080);
        this.add(mypanel);
        //线程启动
        sendThread = new SendThread(socket, name);
        sendThread.start();
        receiveThread = new ReceiveThread(socket, this);
        receiveThread.start();
    }
    public void shoAllPlayersInfo(List<Player> players)  {
        for(int i = 0;i<players.size();i++){
            if(players.get(i).getName().equals(unname)){
                currentPlayer =players.get(i);
            }
        }
        List<Poker> pokers = currentPlayer.getPokers();
        for(int i =0;i<pokers.size();i++){
            //创建扑克标签
            Poker poker = pokers.get(i);
            PokerLabel pokerLabel =new PokerLabel(poker.getId(),poker.getName(),poker.getNum());
            pokerLabel.turnUp();
            //添加到面板中
            this.mypanel.add(pokerLabel);
            this.pokerLabels.add(pokerLabel);
            //动态显示出来
            this.mypanel.setComponentZOrder(pokerLabel,0);

            try {
                GameUtils.move(pokerLabel,300+30*i,450);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
