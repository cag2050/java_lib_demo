package gc;

public class GCDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
			byte[] bytes = new byte[32 * 1024 * 1024];
		}
//		bytes = null;
		String c = "str"; 
		System.out.println("gc");
		System.gc();

	}

}
