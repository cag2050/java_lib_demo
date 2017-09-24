package gc;

public class GCDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		代码很简单，就是向内存中填充了 32MB 的数据，然后通过虚拟机进行垃圾收集。在 javac 编译后，在java_lib_demo目录下，我们执行如下指令：java -verbose:gc gc.GCDemo1 来查看垃圾收集的结果，得到如下输出信息：
//		[GC 208K->134K(5056K), 0.0017306 secs]
//		[Full GC 134K->134K(5056K), 0.0121194 secs]
//		[Full GC 32902K->32902K(37828K), 0.0094149 sec
//		注意第三行，“->”之前的数据表示垃圾回收前堆中存活对象所占用的内存大小，“->”之后的数据表示垃圾回收堆中存活对象所占用的内存大小，括号中的数据表示堆内存的总容量，0.0094149 sec 表示垃圾回收所用的时间。
//		从结果中可以看出，System.gc()运行后并没有回收掉这 32MB 的内存，这应该是意料之中的结果，因为变量 bytes 还处在作用域内，虚拟机自然不会回收掉 bytes 引用的对象所占用的内存。
		byte[] bytes = new byte[32 * 1024 * 1024];
		System.gc();

	}

}
