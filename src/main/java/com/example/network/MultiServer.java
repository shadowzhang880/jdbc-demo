package com.example.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端启动，监听 8888 端口...");

        while (true) {
            // 阻塞等待新客户端
            Socket socket = serverSocket.accept();
            System.out.println("新客户端连接：" + socket.getInetAddress());

            // 每个客户端交给一个新线程处理
            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))) {

                    String msg;
                    while ((msg = reader.readLine()) != null) {
                        System.out.println("收到：" + msg);
                    }
                } catch (IOException e) {
                    System.out.println("客户端断开：" + e.getMessage());
                }
            }).start();
        }
    }
}