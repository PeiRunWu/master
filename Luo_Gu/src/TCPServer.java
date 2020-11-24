import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建一个服务器serverSocket对象和指定的端口
        ServerSocket serverSocket = new ServerSocket(8080);
        //获取请求客户端的Socket对象
       /* Socket accept = serverSocket.accept();
        //获取网络对象的输入流
        InputStream inputStream = accept.getInputStream();
        //判断是否有此目录
        File file =new File("C:\\Users\\Shine\\Desktop\\新建文件夹");
        if(!file.exists()){
            file.mkdirs();
        }*/
        //使用多线程
        /*InputStream inputStream = accept.getInputStream();
        File file = new File("C:\\Users\\Shine\\Desktop\\新建文件夹");
        if (!file.exists()) {
            file.mkdirs();
        }
        //读取服务器文件，并进行写入到本地磁盘
        FileOutputStream fileOutputStream = new FileOutputStream(file + "\\20191207_132906_014726_情迷法兰西_Mark晰.jpg");
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        //发送信息上传成功
        accept.getOutputStream().write("上传成功".getBytes());*/
        //将网络字节流转换为字符输入流
       /*while (true) {
            Socket accept = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                        String line = bufferedReader.readLine();
                        System.out.println(line);
                        String[] arr = line.split(" ");
                        String substring = arr[1].substring(1);
                        System.out.println(substring);
                        FileInputStream fils = new FileInputStream(new File(substring));
                        System.out.println(fils);
                        OutputStream outputStream = accept.getOutputStream();
                        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                        outputStream.write("Content-Type:text/html\t\n".getBytes());
                        outputStream.write("\r\n".getBytes());
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = fils.read(bytes)) != -1) {
                            outputStream.write(bytes, 0, len);
                        }
                        fils.close();
                        //fileOutputStream.close();
                        accept.close();
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }*/
    }
}