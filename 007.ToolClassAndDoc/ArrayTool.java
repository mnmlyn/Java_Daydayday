/**
�����������ʾ���дһ�������࣬��ʹ��javadoc��������˵����
���ɷ����ǣ�ִ�У�docdirΪָ��·���������Լ�ָ����
javadoc -d docdir -version -author ArrayTool.java
@author mnmlyn@153.com
@version v0.1
*/
public class ArrayTool {//����ʹ��public��������
	private ArrayTool(){}//������ʵ���������࣬
						 //ֱ��ʹ������.������
	
	/**
	��ӡ����
	@param arr ����һ����������
	*/
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	/**
	��ȡ�������ֵ
	@param arr ����һ����������
	@return �������Ԫ�ص�ֵ
	*/
	public static int getMax(int[] arr) {
		//�����ǿ�����
		int imax = arr[0];
		for (int i = 1; i < arr.length; ++i) {
			if (arr[i] > imax)
				imax = arr[i];
		}
		return imax;
	}
}