package com.example.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println("服务端启动，监听 8888 端口...");

            // 等待客户端连接（阻塞）
            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接：" + socket.getInetAddress());

            // 读取客户端发来的数据
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String msg = reader.readLine();
            System.out.println("收到客户端消息：" + msg);

            // 向客户端回复
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            writer.write("你好，客户端！我已收到你的消息。\n");
            writer.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}