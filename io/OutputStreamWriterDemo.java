package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {
	static String fileName = "charFile.txt";
	static String charsetName1 = "utf-8";
	static String charsetName2 = "gb2312";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File file = new File(fileName);
			OutputStreamWriter outputStreamWriterDemo = new OutputStreamWriter(new FileOutputStream(file),
					charsetName1);
			outputStreamWriterDemo.write("字符流写入");
			outputStreamWriterDemo.write("aaaa");
			outputStreamWriterDemo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
