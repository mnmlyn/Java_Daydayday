/* �����������������
 * ��֧�ṹ����C++û̫������ע���ж���������ֱ����int����
*/
import java.util.Scanner;

public class BasicIOTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ��������");
		int a = sc.nextInt();
		System.out.println("��������ǣ�" + a);
		
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
	}
}