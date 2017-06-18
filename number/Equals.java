package number;

public class Equals {
	public static void main(String[] args) {
		System.out.println(" Number 对象不为 Null，且与方法的参数类型与数值都相等返回 True，否则返回 False。");
		Integer x = 5;
		Integer y = 10;
		Integer z =5;
		Short a = 5;

		System.out.println(x.equals(y));  // false
		System.out.println(x.equals(z));  // false
		System.out.println(x.equals(a));  // false：参数类型不一致，所以是false
	}
}
