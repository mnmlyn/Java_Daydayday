/* �����������������
 * ��֧�ṹ����C++û̫������ע���ж���������ֱ����int����
*/
import java.util.Scanner;

public class BasicIOTest {
	public static void main(String[] args) {
		//������������
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ��������");
		int a = sc.nextInt();
		System.out.println("��������ǣ�" + a);
		
		//if���
		//if (a)//Java ���ܽ�������ʽת��Ϊboolean
		if (a > 20) {
			System.out.println("����20");
		}
		else if (a %2 == 1) {
			System.out.println("������20������");
		}
		else {
			System.out.println("����");
		}
		
		//switch���
		//���Խ��ܵı��ʽ���ͣ�byte,short,char,int�Ȼ�������
		//		�Լ�ö��(from JDK1.5)��String(from JDK1.7)
		System.out.println("������ɼ�(0~100)");
		int score = sc.nextInt();
		switch(score/10) {
			case 9:
				System.out.println("����");
				break;
			case 8:
			case 7:
			case 6:
				System.out.println("����");
				break;
			case 5:
			case 4:
			case 3:
			case 2:
			case 1:
			case 0:
				System.out.println("��ȥ��֪ͨ");
				break;
			default:
				System.out.println("��������");
				break;
		}
	}
}