/*
 * 1. Java��������
 * ��������[] ������ = new ��������[���鳤��];
 * ���磺int[] arr = new int[5];
 * 
 * ����������һ�ַ�ʽ
 * int[] arr2 = new int[]{11,22,33,44,55};
 * int[] arr3 = {11,22,33,44,55};
 *
 * ����д��1����д�ĳ�ʼ���б�ֻ�������븳ֵ��ͬһ��
 * int[] arr4;
 * arr4 = {11,22,33,44,55};
 * ����д��2��new��ߵ�������д���˴�С���Ͳ���ͬʱ����ֵ
 * int[] arr5 = new int[5]{11,22,33,44};
 * 
 * 2. Ĭ�ϳ�ʼ��ֵ��
 * �������ͣ�byte,short,int,longĬ��ֵ����0
 * �������ͣ�float,doubleĬ��ֵ����0.0
 * �������ͣ�booleanĬ�ϳ�ʼֵfalse
 * �ַ����ͣ�charĬ�ϳ�ʼֵ'\u0000'��
 * ע��Java��charռ���ֽڣ�Unicode����
 *
 * 3. ��ӡ������arr���õ�[I@15db9742
 * ���У�[����һά���飬I�������Σ�@�ǹ̶���ǣ�����ǵ�ַ
 *
 * 4. int[] arrֻ��һ���������ã����԰�һ���������ø�����һ��
 * int[] arr1 = arr;
 *
 * 5. ����ĳ��ȣ�������arr.length�����
 *
 * 6. �������Σ���������
 * ���Կ����ں����е��޸�ֱ�Ӹ���ԭ���飬
 * ˵�����������ã��ҿ��޸�
 *
 * 7. ��ά����
 * int[][] arr6 = new int[3][2];
 * �Լ���������д����
 * int arr7[][] = new int[3][2];
 * int[] arr8[] = new int[3][2];
 * ���У�int[] x,y[];��x��һά���飬y�Ƕ�ά����
 *
 * 8. ��ά���飬����ֻд��һά��ά����Ҳ����ÿ��λ�ö���null
 * Ȼ���ٳ�ʼ����һά��ÿ��λ�ã�ÿ���ڶ�ά���Բ�һ����
 * int arr9[][] = new int[2][];
 * arr9[0] = new int[3];
 * arr9[1] = new int[4];
 *
 * 9. ��ά���飬����ֱ�Ӵ����ų�ʼ��
 * int[][] arr10 = {{1,2},{3,4,5,6},{7,8,9}};
*/
public class Array {
	public static void main(String[] args) {
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = i + 1;
		}
		for (int i = 0; i < 5; ++i) {
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
		
		printIntArray(arr);
		printIntArray(arr);
		System.out.println(arr);//[I@15db9742
		int[] arr1 = arr;
		System.out.println(arr1);
		arr1=null;
		System.out.println(arr1);
		//System.out.println(arr1[0]);//java.lang.NullPointerException
		twoDimArrayTest();
	}
	
	public static void printIntArray(int[] arr) {
		System.out.println("--------------");
		for (int i = 0; i < arr.length; ++i) {
			System.out.println(arr[i]);
		}
		System.out.println("--------------");
		arr[0]++;
	}
	
	public static void twoDimArrayTest() {
		int[][] arr1 = new int[3][2];//��һ��д��
		printTwoDimArray(arr1);
		
		int[] arr2[] = new int[3][2];//�ڶ���д��
		printTwoDimArray(arr2);
		
		int arr3[][] = new int[3][2];//������д��
		printTwoDimArray(arr3);
		
		System.out.println(arr3);//[[I@6d06d69c
		System.out.println(arr3[0]);//[I@7852e922
		System.out.println(arr3[1]);//[I@4e25154f
		System.out.println(arr3[2]);//[I@70dea4e
		//���Կ�������ά�����е�ÿһ��һά���飬
		//���ǲ�ͬ��λ�ã�������������
		
		//������ʼ��ÿ��ά��
		int arr4[][] = new int[2][];
		arr4[0] = new int[3];
		arr4[1] = new int[4];
		printTwoDimArray(arr4);
		
		//�����ų�ʼ��
		int[][] arr5 = {{1,2},{3,4,5,6},{7,8,9}};
		printTwoDimArray(arr5);
	}
	
	public static void printTwoDimArray(int[][] arr) {
		for(int i=0;i<arr.length;++i) {
			for(int j=0;j<arr[i].length;++j) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}
}