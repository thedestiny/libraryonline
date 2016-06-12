package com.qteng.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xieyue on 2016/6/12.
 */
public class Mycode {
	
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("xxx.jpg");
        FileOutputStream fos = new FileOutputStream("xxx.jpg");
        byte[] arr = new byte[1024 * 20];
        int len;
        while ((len = fis.read(arr)) != -1) {
            int i = 0;
            for (byte by : arr) {
                by ^= 1;
                arr[i++] = by;
            }

            fos.write(arr, 0, len);
        }
        System.out.println("success!");
        fis.close();
        fos.close();
    }
}
