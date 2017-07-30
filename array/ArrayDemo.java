package array;

import java.util.Arrays;

public class ArrayDemo {

	public static void main(String[] args) {
		// 声明数组的3种方式：
		int[] intArray1 = new int[5];
		int[] intArray2 = new int[] { 1, 3, 2 };
		int[] intArray3 = { 1, 3, 2 };

		intArray1[0] = 1;
		// length只是返回array的容量，不是array真实元素的个数
		System.out.println(intArray1.length);

		Arrays.sort(intArray3);
		System.out.println(Arrays.toString(intArray3));
	}

}
