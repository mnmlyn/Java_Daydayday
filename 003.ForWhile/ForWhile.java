/*
 * ѭ����ʹ��
 * 1. ��ӡ100-999������ˮ�ɻ���
 * 2. ��ӡ������
 * #
 * ##
 * ###
 * 3. ��ӡ99�˷���
 * 1*1=1
 * 1*2=2 2*2=4
 * ...
 * 4. ��ţ�������break����ָ����ѭ��
 * 5. ѧ������ͼ���֮��forѭ���µ�д��
 * for(int x:arr){}
 * for(String str:list){}
*/
import java.util.ArrayList;

public class ForWhile {
	public static void main(String[] args) {
		//ˮ�ɻ���
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
		
		//������
		for (int i = 1; i <= 3; ++i) {
			for (int j = 0; j < i; ++j) {
				System.out.print("#");
			}
			System.out.println("");
		}
		
		//�˷���
		for (int i = 1; i <= 9; ++i) {
			for (int j = 1; j <= i; ++j) {
				System.out.print(j + "x" + i + "=" + i*j + '\t');
			}
			System.out.println("");
		}
		
		//��ţ�����ָ��ѭ��
		int sum = 0;
		outer: for (int i=0; i < 10; ++i) {
			inner: for (int j = 0; j < 10; ++j) {
				++sum;
				if (j == 1)break outer;
			}
		}
		System.out.println("sum=" + sum);
		
		//ѧ������ͼ���֮��forѭ���µ�д��
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