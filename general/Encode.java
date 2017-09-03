package general;

import java.io.UnsupportedEncodingException;

public class Encode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("中");
		System.out.printf("%30s : %s\n", "stringBuilder length", stringBuilder.length());
		System.out.printf("%30s : %s\n", "stringBuilder", stringBuilder);
		try {
			byte[] bytes = stringBuilder.toString().getBytes("gbk");
			StringBuilder stringBuilder2 = new StringBuilder(new String(bytes,"gbk"));
			System.out.println(bytes);
			System.out.printf("%30s : %s\n", "stringBuilder getBytes", bytes);
			System.out.printf("%30s : %s\n", "stringBuilder getBytes", stringBuilder.toString().getBytes("utf-8"));
			System.out.printf("%30s : %s\n", "stringBuilder getBytes", stringBuilder.toString().getBytes("utf-16"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
