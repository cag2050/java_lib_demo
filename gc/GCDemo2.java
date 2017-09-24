package gc;

public class GCDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		这次 bytes 引用的对象所占的内存被回收了
//		为对象赋 null 值并不是控制变量回收的最好方法，以恰当的变量作用域来控制变量回收时间才是最优雅的解决办法。另外，赋 null 值的操作在经过虚拟机 JIT 编译器优化后会被消除掉，经过 JIT 编译后，System.gc()执行时就可以正确地回收掉内存，而无需赋 null 值。
		byte[] bytes = new byte[32 * 1024 * 1024];
		bytes = null;
		System.gc();

	}

}
