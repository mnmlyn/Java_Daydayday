/*
 * 1. Java创建数组
 * 数据类型[] 数组名 = new 数据类型[数组长度];
 * 比如：int[] arr = new int[5];
 * 
 * 创建数组另一种方式
 * int[] arr2 = new int[]{11,22,33,44,55};
 * int[] arr3 = {11,22,33,44,55};
 *
 * 错误写法1：简写的初始化列表，只能声明与赋值在同一行
 * int[] arr4;
 * arr4 = {11,22,33,44,55};
 * 错误写法2：new后边的括号中写明了大小，就不能同时赋初值
 * int[] arr5 = new int[5]{11,22,33,44};
 * 
 * 2. 默认初始化值：
 * 整数类型：byte,short,int,long默认值都是0
 * 浮点类型：float,double默认值都是0.0
 * 布尔类型：boolean默认初始值false
 * 字符类型：char默认初始值'\u0000'，
 * 注意Java中char占两字节，Unicode编码
 *
 * 3. 打印数组标记arr，得到[I@15db9742
 * 其中，[代表一维数组，I代表整形，@是固定标记，后边是地址
 *
 * 4. int[] arr只是一个数组引用，可以把一个数组引用赋给另一个
 * int[] arr1 = arr;
 *
 * 5. 数组的长度，可以用arr.length来获得
 *
 * 6. 函数传参，传递数组
 * 可以看到在函数中的修改直接改了原数组，
 * 说明传的是引用，且可修改
 *
 * 7. 二维数组
 * int[][] arr6 = new int[3][2];
 * 以及其他各种写法：
 * int arr7[][] = new int[3][2];
 * int[] arr8[] = new int[3][2];
 * 其中，int[] x,y[];，x是一维数组，y是二维数组
 *
 * 8. 二维数组，可以只写第一维的维数，也就是每个位置都是null
 * 然后，再初始化第一维的每个位置，每个第二维可以不一样大
 * int arr9[][] = new int[2][];
 * arr9[0] = new int[3];
 * arr9[1] = new int[4];
 *
 * 9. 二维数组，可以直接大括号初始化
 * int[][] arr10 = {{1,2},{3,4,5,6},{7,8,9}};
*/
public class Array {
	public static void main(String[] args) {
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = i + 1;
		}
		for (int i = 0; i < 5; ++i) {
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
		
		printIntArray(arr);
		printIntArray(arr);
		System.out.println(arr);//[I@15db9742
		int[] arr1 = arr;
		System.out.println(arr1);
		arr1=null;
		System.out.println(arr1);
		//System.out.println(arr1[0]);//java.lang.NullPointerException
		twoDimArrayTest();
	}
	
	public static void printIntArray(int[] arr) {
		System.out.println("--------------");
		for (int i = 0; i < arr.length; ++i) {
			System.out.println(arr[i]);
		}
		System.out.println("--------------");
		arr[0]++;
	}
	
	public static void twoDimArrayTest() {
		int[][] arr1 = new int[3][2];//第一种写法
		printTwoDimArray(arr1);
		
		int[] arr2[] = new int[3][2];//第二种写法
		printTwoDimArray(arr2);
		
		int arr3[][] = new int[3][2];//第三种写法
		printTwoDimArray(arr3);
		
		System.out.println(arr3);//[[I@6d06d69c
		System.out.println(arr3[0]);//[I@7852e922
		System.out.println(arr3[1]);//[I@4e25154f
		System.out.println(arr3[2]);//[I@70dea4e
		//可以看到，二维数组中的每一个一维数组，
		//都是不同的位置，并不是连续的
		
		//单独初始化每个维度
		int arr4[][] = new int[2][];
		arr4[0] = new int[3];
		arr4[1] = new int[4];
		printTwoDimArray(arr4);
		
		//大括号初始化
		int[][] arr5 = {{1,2},{3,4,5,6},{7,8,9}};
		printTwoDimArray(arr5);
	}
	
	public static void printTwoDimArray(int[][] arr) {
		for(int i=0;i<arr.length;++i) {
			for(int j=0;j<arr[i].length;++j) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}
}