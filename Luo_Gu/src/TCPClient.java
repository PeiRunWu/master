import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //创建一个本地字节输入流
        FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\Shine\\Documents\\qq飞车\\470481357\\截图\\20191207_132906_014726_情迷法兰西_Mark晰.jpg"));
        //创建一个客户端socket对象，地址为127.0.0.1 端口为88
        Socket socket = new Socket("127.0.0.1", 8888);
        //创建socket 字节输出流
        OutputStream outputStream = socket.getOutputStream();
        //读取字节流，写入到服务器当中
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        outputStream.write("收到信息".getBytes());
        //读取服务器写入的数据
        fileInputStream.close();
        socket.close();
    }
}
