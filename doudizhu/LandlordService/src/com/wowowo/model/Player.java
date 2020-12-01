package com.wowowo.model;
/**
 * 创建玩家类
 */

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;//玩家名字
    private int id;//玩家ID
    private Socket socket;//玩家对应的Socket
    private List<Poker> pokers =new ArrayList<Poker>();//玩家对应的扑克列表

    public Player() {
    }

    public Player(int id) {
        this.id = id;
    }

    public Player(int id,String name) {
        this.name = name;
        this.id = id;
    }

    public Player(String name, int id, Socket socket, List<Poker> pokers) {
        this.name = name;
        this.id = id;
        this.socket = socket;
        this.pokers = pokers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public List<Poker> getPokers() {
        return pokers;
    }

    public void setPokers(List<Poker> pokers) {
        this.pokers = pokers;
    }
}
