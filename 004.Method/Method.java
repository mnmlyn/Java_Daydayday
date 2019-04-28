/*
 * 1. 方法的定义：
 * 修饰符 返回值类型 方法名(形参类型1 形参名1,...) {
	 方法体;
	 return 返回值;
 * }
 * 修饰符比如public static都是修饰符，其他和C++没区别
 * 
 * 2. 可变参数的方法定义
 * func(int ... arr)
 * 注意，
 * 可变参数arr在方法内被当做数组，会与参数为数组的方法冲突
 * 可变参数必须放在参数表的最后一个，他会接收之后的所有参数
 * 可变参数，可以传入0到理论无限个参数
*/
public class Method {
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 3;
		int result = twoSum(num1, num2);
		System.out.println(result);
		
		//使用可变参数的函数sum
		System.out.println(sum(1, 2, 3, 4, 5));
	}
	
	public static int twoSum(int a, int b) {
		return a + b;
	}
	
	//定义可变参数的函数
	public static int sum(int ... arr) {
		int ret = 0;
		for (int i = 0; i < arr.length; ++i) {
			ret += arr[i];
		}
		return ret;
	}
	
	//报错：无法在Method中同时声明sum(int[])和sum(int...)
	//public static int sum(int[] arr) {
	//	return 0;
	//}
}