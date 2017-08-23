package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FileOutputStreamDemo {
	static String fileName = "file.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			File file = new File(fileName);
//			FileOutputStream fileOutputStream = new FileOutputStream(file);
//			PrintStream printStream = new PrintStream(fileOutputStream);
			PrintStream printStream = new PrintStream(new FileOutputStream(file));
//			PrintStream printStream = new PrintStream(new FileOutputStream(new File(fileName)));
			printStream.print("abcdefghijk");
			printStream.close();

			FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
			PrintStream printStream2 = new PrintStream(fileOutputStream2);
			printStream2.print("123456");
			printStream2.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
