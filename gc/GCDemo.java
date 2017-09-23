package gc;

public class GCDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] bytes = new byte[32 * 1024 * 1024];
		System.out.println("gc");
		System.gc();

	}

}
