package general;

import java.io.UnsupportedEncodingException;

public class Encode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("%35s : %s\n", "System.getProperty('file.encoding')", System.getProperty("file.encoding"));
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("中");
		System.out.printf("%35s : %s\n", "stringBuilder initial value", stringBuilder);
		System.out.printf("%35s : %s\n", "stringBuilder length", stringBuilder.length());
		try {
			byte[] bytes = stringBuilder.toString().getBytes("gbk");
			StringBuilder stringBuilder2 = new StringBuilder(new String(bytes, "gbk"));
			System.out.printf("%35s : %s\n", "stringBuilder transform value", stringBuilder);
			int len = bytes.length;
			System.out.printf("%35s : %s\n", "stringBuilder bytes gbk", bytes);
			System.out.printf("%35s : %s\n", "stringBuilder bytes length", len);
			for (int i = 0; i < len; i++) {
				System.out.printf("%35s : %s\n", "bytes" + i, bytes[i]);
			}
			System.out.printf("%35s : %s\n", "stringBuilder getBytes", bytes);
			System.out.printf("%35s : %s\n", "stringBuilder getBytes utf-8", stringBuilder.toString().getBytes("utf-8"));
			System.out.printf("%35s : %s\n", "stringBuilder getBytes utf-16", stringBuilder.toString().getBytes("utf-16"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
