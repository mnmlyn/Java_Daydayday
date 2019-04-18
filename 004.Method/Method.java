/*
 * 方法的定义：
 * 修饰符 返回值类型 方法名(形参类型1 形参名1,...) {
	 方法体;
	 return 返回值;
 * }
 * 修饰符比如public static都是修饰符，其他和C++没区别
*/
public class Method {
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 3;
		int result = twoSum(num1, num2);
		System.out.println(result);
	}
	
	public static int twoSum(int a, int b) {
		return a + b;
	}
}