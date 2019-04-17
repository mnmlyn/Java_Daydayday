/* 基本的输入输出操作
 * 分支结构，和C++没太大区别，注意判断条件不能直接是int类型
*/
import java.util.Scanner;

public class BasicIOTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int a = sc.nextInt();
		System.out.println("你输入的是：" + a);
		
		//if (a)//Java 不能将整形隐式转换为boolean
		if (a > 20) {
			System.out.println("大于20");
		}
		else if (a %2 == 1) {
			System.out.println("不大于20的奇数");
		}
		else {
			System.out.println("其他");
		}
	}
}