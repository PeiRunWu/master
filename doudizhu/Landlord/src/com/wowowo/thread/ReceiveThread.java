package com.wowowo.thread;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wowowo.model.Player;
import com.wowowo.model.Poker;
import com.wowowo.view.MainFrame;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ReceiveThread extends Thread {
    public Socket socket;
    public MainFrame mainFrame;

    public ReceiveThread(Socket socket, MainFrame mainFrame) {
        this.socket = socket;
        this.mainFrame = mainFrame;
    }

    public void run() {
        try {
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            while (true) {
                String json = inputStream.readUTF();
                List<Player> players =new ArrayList<Player>();
                //解析json字符串
                //将json字符串转换为json数组
                JSONArray playerJsonArray = JSONArray.parseArray(json);
                for(int i =0;i<playerJsonArray.size();i++){
                    JSONObject playerJson = (JSONObject) playerJsonArray.get(i);
                    int id = playerJson.getInteger("id");
                    String name = playerJson.getString("name");
                    //存放扑克列表
                    List<Poker> poker = new ArrayList<Poker>();
                    JSONArray pokers = playerJson.getJSONArray("pokers");
                    for(int j = 0;j<pokers.size();j++){
                        //每循环一次获得一个扑克对象
                        JSONObject pokerJSON = (JSONObject) pokers.get(j);
                        int pid = pokerJSON.getInteger("id");
                        String pname = pokerJSON.getString("name");
                        int num = pokerJSON.getInteger("num");
                        Poker poker1 = new Poker(pid,pname,num);
                        poker.add(poker1);
                    }
                    Player player =new Player(id,name,poker);
                    players.add(player);
                }

                if(players.size() == 3 ){
                    mainFrame.shoAllPlayersInfo(players);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
