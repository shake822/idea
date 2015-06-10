package com.shake.file.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by zhaoqunqi on 15/4/26.
 */
public class FileCopy {
    public static void main(String[] args){
        String fileName = "/Volumes/SOFTWARE/tools/eclipse-jee-luna-SR2-macosx-cocoa-x86_64.tar.gz";
        long start = System.currentTimeMillis();

            oldIOCopy(fileName, fileName + "copy_0");
        long end = System.currentTimeMillis();
            newIOCopy(fileName, fileName + "copy_1");
        long relEnd = System.currentTimeMillis();
        System.out.println("end:"+(end-start));
        System.out.println("end2:" + (relEnd - end));
    }

    static boolean isNull(String str){
        if(null == str || "".equals(str.trim()))
            return true;
        else
            return false;
    }

    static void oldIOCopy(String name, String copy){
        try{
            File f = new File(name);
            File ftmp = new File(copy);

            FileInputStream in = new FileInputStream(f);
            FileOutputStream out = new FileOutputStream(ftmp);

            byte[] buff = new byte[1024];

            int len = 0;
            while((len = in.read(buff)) != -1){
                out.write(buff, 0, len);
            }

            out.close();
            in.close();

        }catch(Exception e){
            System.out.println("Exception.");
        }
    }

    static void newIOCopy(String name, String copy){
        try{
            FileChannel in = new FileInputStream(new File(name)).getChannel();
            FileChannel out = new FileOutputStream(new File(copy)).getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while(in.read(buffer) != -1){
                buffer.flip(); // Prepare for writing
                out.write(buffer);
                buffer.clear();// Prepare for reading
            }

            out.close();
            in.close();
        }catch(Exception e){
            System.out.println("Exception");
        }
    }




}

