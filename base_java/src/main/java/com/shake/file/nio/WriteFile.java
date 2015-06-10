package com.shake.file.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by zhaoqunqi on 15/4/26.
 */
public class WriteFile {
    private static final int SIZE = 1024;

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/zhaoqunqi/tmp/out.file");
//        writeToFile(file);
//        readFile(file);
        long start = System.currentTimeMillis();
        for(int i =0;i<100;i++){
            readFile(file);
        }
        long end = System.currentTimeMillis();
        for(int i =0;i<100;i++){
            readFileForNormal(file);
        }
        long relEnd = System.currentTimeMillis();
        System.out.println("end:"+(end-start));
        System.out.println("end2:"+(relEnd-end));
    }

    private static void readFile(File file) throws IOException {
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            FileChannel channel = in.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(SIZE);
            byte[] bs = new byte[SIZE];
            while (channel.read(buffer) != -1) {
                int pos = buffer.position();
                buffer.rewind();
                buffer.get(bs);
                buffer.clear();
                System.out.println(new String(bs, 0, pos));
            }

        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    private static void readFileForNormal(File file) throws IOException {
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            byte[] bs = new byte[SIZE];
            int tmpSize =0;
            while ((tmpSize =in.read(bs))!= -1) {
                  System.out.println(new String(bs,0,tmpSize));
            }

        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    private static void writeToFile(File file) throws IOException {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            FileChannel channel = out.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String str = "hello nio";
            buffer.put(str.getBytes());
            buffer.flip();
            channel.write(buffer);
            channel.close();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
