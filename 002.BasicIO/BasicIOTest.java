/* 基本的输入输出操作
 * 分支结构，和C++没太大区别，注意判断条件不能直接是int类型
*/
import java.util.Scanner;

public class BasicIOTest {
	public static void main(String[] args) {
		//基本键盘输入
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int a = sc.nextInt();
		System.out.println("你输入的是：" + a);
		
		//if语句
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
		
		//switch语句
		//可以接受的表达式类型，byte,short,char,int等基本类型
		//		以及枚举(from JDK1.5)，String(from JDK1.7)
		System.out.println("请输入成绩(0~100)");
		int score = sc.nextInt();
		switch(score/10) {
			case 9:
				System.out.println("优秀");
				break;
			case 8:
			case 7:
			case 6:
				System.out.println("及格");
				break;
			case 5:
			case 4:
			case 3:
			case 2:
			case 1:
			case 0:
				System.out.println("回去等通知");
				break;
			default:
				System.out.println("输入有误");
				break;
		}
	}
}