//基本的输入输出操作
import java.util.Scanner;

public class BasicIOTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int a = sc.nextInt();
		System.out.println("你输入的是：" + a);
	}
}