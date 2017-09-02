package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("charFile.txt")));
			char char1 = (char) inputStreamReader.read();
			System.out.println("读取的第一个字符为：" + char1);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
