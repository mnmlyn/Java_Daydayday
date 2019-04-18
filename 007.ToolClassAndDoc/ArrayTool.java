/**
这个类用于演示如何写一个工具类，并使用javadoc工具生成说明书
生成方法是，执行（docdir为指定路径，可以自己指定）
javadoc -d docdir -version -author ArrayTool.java
@author mnmlyn@153.com
@version v0.1
*/
public class ArrayTool {//必须使用public修饰类名
	private ArrayTool(){}//不允许实例化工具类，
						 //直接使用类名.方法名
	
	/**
	打印数组
	@param arr 接收一个整形数组
	*/
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	/**
	获取数组最大值
	@param arr 接收一个整形数组
	@return 数组最大元素的值
	*/
	public static int getMax(int[] arr) {
		//不考虑空数组
		int imax = arr[0];
		for (int i = 1; i < arr.length; ++i) {
			if (arr[i] > imax)
				imax = arr[i];
		}
		return imax;
	}
}