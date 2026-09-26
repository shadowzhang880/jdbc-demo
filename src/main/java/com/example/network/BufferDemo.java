package com.example.network;

import java.nio.ByteBuffer;

public class BufferDemo {
    public static void main(String[] args) {
        // 创建容量为 10 的 ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(10);

        // 写入数据
        buffer.put((byte) 'H');
        buffer.put((byte) 'i');

        // 切换为读模式
        buffer.flip();

        // 读取数据
        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }
        System.out.println();
    }
}