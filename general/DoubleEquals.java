package general;

class DoubleEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("基本数据类型比较相等，用双等号（==）；双等号（==）用于比较复合数据类型时，比较的是堆内存地址。");
		String a = "a";
		String b = "b";
		System.out.println(a == a);
		System.out.println(a == b);
	}

}
