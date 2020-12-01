package com.wowowo.thread;
/**
 * 信息发送线程
 */

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SendThread extends Thread {
    private String msg;
    private Socket socket;

    public SendThread(Socket socket, String msg) {
        this.socket = socket;
        this.msg = msg;
    }

    public SendThread() {
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void run() {
        //数据输出流
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true) {
                //判断消息是否为空，
                if (msg != null) {
                    dataOutputStream.writeUTF(msg);
                    //消息发送完毕，需要清空
                    msg = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
