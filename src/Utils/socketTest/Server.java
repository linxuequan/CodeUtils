package Utils.socketTest;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("-----服务端启动成功-------");
        // 1、创建ServerSocket的对象，同时为服务端注册端口。
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            // 2、使用serverSocket对象，调用一个accept方法，等待客户端的连接请求
            Socket socket = serverSocket.accept();
            System.out.println("有人上线了：" + socket.getRemoteSocketAddress());
            // 接收数据
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String message = dis.readUTF(); // 读取UTF字符串
            System.out.println("接收到的消息: " + message);
        }
    }
}