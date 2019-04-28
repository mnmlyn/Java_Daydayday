/*
 * 循环的使用
 * 1. 打印100-999的所有水仙花数
 * 2. 打印三角形
 * #
 * ##
 * ###
 * 3. 打印99乘法表
 * 1*1=1
 * 1*2=2 2*2=4
 * ...
 * 4. 标号，可以用break跳出指定的循环
 * 5. 学了数组和集合之后，for循环新的写法
 * for(int x:arr){}
 * for(String str:list){}
*/
import java.util.ArrayList;

public class ForWhile {
	public static void main(String[] args) {
		//水仙花数
		for (int i=100; i < 1000; ++i) {
			int num = i;
			int sum = 0;
			while (num != 0) {
				int digit = num % 10;
				sum += digit * digit * digit;
				num /= 10;
			}
			if (sum == i)
				System.out.print(i + " ");
		}
		System.out.println("");
		
		//三角形
		for (int i = 1; i <= 3; ++i) {
			for (int j = 0; j < i; ++j) {
				System.out.print("#");
			}
			System.out.println("");
		}
		
		//乘法表
		for (int i = 1; i <= 9; ++i) {
			for (int j = 1; j <= i; ++j) {
				System.out.print(j + "x" + i + "=" + i*j + '\t');
			}
			System.out.println("");
		}
		
		//标号，跳出指定循环
		int sum = 0;
		outer: for (int i=0; i < 10; ++i) {
			inner: for (int j = 0; j < 10; ++j) {
				++sum;
				if (j == 1)break outer;
			}
		}
		System.out.println("sum=" + sum);
		
		//学了数组和集合之后，for循环新的写法
		int[] arr = {1, 2, 3, 4, 5};
		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		for (String str : list) {
			System.out.print(str + " ");
		}
		System.out.println();
	}
}