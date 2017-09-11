package classloader;

public class ClassLoaderDemo {

	public static void main(String[] args) {
//		每个 Java 类都维护着一个指向定义它的类加载器的引用，通过 getClassLoader()方法就可以获取到此引用。
//		代码中通过递归调用 getParent()方法来输出全部的父类加载器。
//		第一个输出的是 ClassLoaderTree类的类加载器，即系统类加载器。它是 sun.misc.Launcher$AppClassLoader类的实例；
//		第二个输出的是扩展类加载器，是 sun.misc.Launcher$ExtClassLoader类的实例。
//		需要注意的是这里并没有输出引导类加载器，这是由于有些 JDK 的实现对于父类加载器是引导类加载器的情况，getParent()方法返回 null。
		ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
		while (classLoader != null) {
			System.out.println(classLoader);
			classLoader = classLoader.getParent();
		}
	}

}
