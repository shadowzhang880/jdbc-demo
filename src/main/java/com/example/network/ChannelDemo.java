package com.example.network;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("nio_test.txt", "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("Hello NIO".getBytes());
        buffer.flip();

        channel.write(buffer);

        channel.close();
        file.close();
        System.out.println("写入成功");
    }
}