/*
 * ѭ����ʹ��
 * ��ӡ100-999������ˮ�ɻ���
*/
public class ForWhile {
	public static void main(String[] args) {
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
	}
}