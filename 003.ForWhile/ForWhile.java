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
*/
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
	}
}