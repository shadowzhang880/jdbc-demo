package com.example.network;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8888)) {
            System.out.println("已连接到服务端");

            // 向服务端发送数据
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            writer.write("你好，服务端！我是客户端。\n");
            writer.flush();

            // 读取服务端回复
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String reply = reader.readLine();
            System.out.println("服务端回复：" + reply);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}