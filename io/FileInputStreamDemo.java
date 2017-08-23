package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
	static String fileName = "byteFile.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// 方法1：
			File file = new File("byteFile.txt");
			FileInputStream fileInputStream1 = new FileInputStream(file);

			// 方法2：
			FileInputStream fileInputStream2 = new FileInputStream(fileName);

			// 方法3：
			FileDescriptor fileDescriptor = fileInputStream2.getFD();
			FileInputStream fileInputStream3 = new FileInputStream(fileDescriptor);

			// 方法4:
			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream3);

			char char1 = (char) fileInputStream1.read();
			System.out.println("FileInputStream读取的第一个字符为：" + char1);

			fileInputStream1.skip(2);

			byte[] bytes = new byte[10];
			fileInputStream1.read(bytes, 0, bytes.length);
			System.out.println("FileInputStream读取的字节数组：" + new String(bytes));

			char char2 = (char) bufferedInputStream.read();
			System.out.println("BufferedInputStream读取的第一个字符为：" + char2);

			fileInputStream1.close();
			fileInputStream2.close();
			fileInputStream3.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
