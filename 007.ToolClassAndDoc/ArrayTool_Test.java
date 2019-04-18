/*
 * 测试工具类ArrayTool的使用
*/
public class ArrayTool_Test {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		//ArrayTool at = new ArrayTool();//不允许实例化，编译会报错
		ArrayTool.printArray(arr);
	}
}