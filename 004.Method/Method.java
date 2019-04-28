/*
 * 1. �����Ķ��壺
 * ���η� ����ֵ���� ������(�β�����1 �β���1,...) {
	 ������;
	 return ����ֵ;
 * }
 * ���η�����public static�������η���������C++û����
 * 
 * 2. �ɱ�����ķ�������
 * func(int ... arr)
 * ע�⣬
 * �ɱ����arr�ڷ����ڱ��������飬�������Ϊ����ķ�����ͻ
 * �ɱ����������ڲ���������һ�����������֮������в���
 * �ɱ���������Դ���0���������޸�����
*/
public class Method {
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 3;
		int result = twoSum(num1, num2);
		System.out.println(result);
		
		//ʹ�ÿɱ�����ĺ���sum
		System.out.println(sum(1, 2, 3, 4, 5));
	}
	
	public static int twoSum(int a, int b) {
		return a + b;
	}
	
	//����ɱ�����ĺ���
	public static int sum(int ... arr) {
		int ret = 0;
		for (int i = 0; i < arr.length; ++i) {
			ret += arr[i];
		}
		return ret;
	}
	
	//�����޷���Method��ͬʱ����sum(int[])��sum(int...)
	//public static int sum(int[] arr) {
	//	return 0;
	//}
}