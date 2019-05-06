/*
 * Math�����࣬Random�࣬System�����࣬BigInteger�࣬BigDecimal�࣬���������
 * 
 * 1. Math������
 * Math.PI
 * Math.abs()
 * Math.ceil(),Math.floor(),Math.round()
 * Math.max(),Math.min()
 * Math.pow()�η�,Math.sqrt()��ƽ��
 * Math.random()������0.0��1.0��doubleֵ
 * 
 * 2. Random�����������
 * Ĭ���޲ι��죬�õ�������ʱ�������ӣ�ֱ���þ���
 * Random r = new Random();
 * r.nextInt()
 * 
 * 3. System��
 * System.gc()��������������ա��������ջ���ö����finalize()������
 * System.exit()����exit()����
 * System.currentTimeMillis()����ϵͳ��ǰʱ��ĺ���ֵ��long����
 * System.arraycopy()��Լ��memcpy()�ķ�װ
 * 
 * 4. BigInteger��
 * ���Դ��ַ�������
 * �Ӽ��˳��ֱ���add(),subtract(),multiply(),divide()
 * �����õ��̺�������divideAndRemainder()
 * 
 * 5. BigDecimal��
 * ���ھ�ȷ����С��
 * 
 * 6. Date��
 * ���ڣ�ʱ���
 * + Date�Ĺ����setTime()������ǰʱ���(ms)��ָ��ʱ���(ms)��ת��ΪDate����
 * + getTime()����ȡDate����ʱ���ʱ���
 * 
 * 7. SimpleDataFormat��
 * �����ڽ��и�ʽ�������췽����ָ����ʽpattern
 * + format()����Date���󣬸�ʽ��Ϊ����ʱpatternָ���ĸ�ʽ
 * + parse()����pattern��ʽ���ַ�����ת��ΪDate����
 * 
 * 8. Calendar��
 * ���������ֶε���ȡ���޸�
 * �����࣬��Calendar.getInstance()��ȡ�������зŵ��ǵ�ǰ���ڡ�
 * һ���ȹ��죬Ȼ��set��Ҫ��������ڣ�Ȼ��add��get
 * get()����ȡָ���ֶε�ֵ
 * add()�������ֶμ���
 * set()�������ֶ�����
 * 
 * 9. Runtime��
 * ����ģʽ���࣬��������ִ��ϵͳcmd����
 * Runtime.getRuntime();��ȡ����ʱ����
 * exec()��������ִ���������execϵͳ���ã������������һ���µĽ�����ִ����������ǵ�ǰ����
 */
package com.mnmlyn;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class SomeOtherObject {
	public static void main(String[] args) throws ParseException, IOException {
		long starttime = System.currentTimeMillis();

		// Math��
		System.out.println(Math.PI);
		float a = 1.56f;
		System.out.println(Math.abs(a));
		System.out.println(Math.ceil(a));
		System.out.println(Math.floor(a));
		System.out.println(Math.max(10, 12));
		System.out.println(Math.min(10.123, 12.1));
		System.out.println(Math.pow(2.0, 3.0));
		System.out.println(Math.sqrt(9.0));
		System.out.println(Math.round(12.45));
		System.out.println(Math.random());

		// Random��
		Random r = new Random();
		System.out.println(r.nextInt());
		System.out.println(r.nextInt(10));

		// System��
		// System.exit(0);
		// System.out.println("not exit");
		System.gc();
		int[] src = { 1, 2, 3, 4, 5 };
		int[] dst = new int[10];
		for (int x : src)
			System.out.print(x + " ");
		System.out.println();
		System.arraycopy(src, 0, dst, 0, src.length);
		for (int x : dst)
			System.out.print(x + " ");
		System.out.println();

		// BigInteger��
		BigInteger bi1 = new BigInteger("1234567890987654321");
		BigInteger bi2 = new BigInteger("10");
		System.out.println(bi1.add(bi2));
		System.out.println(bi1.subtract(bi2));
		System.out.println(bi1.multiply(bi2));
		System.out.println(bi1.divide(bi2));
		BigInteger[] biarr = bi1.divideAndRemainder(bi2);
		for (int i = 0; i < biarr.length; i++) {
			System.out.print(biarr[i] + " ");
		}
		System.out.println();

		// BigDecimal��
		BigDecimal bd1 = new BigDecimal("1.0");
		BigDecimal bd2 = new BigDecimal("0.9");
		System.out.println(bd1.subtract(bd2));
		System.out.println(1.0 - 0.9);// ��������double����ֱ�����㣬����ȷ�����������

		// Date��
		Date d1 = new Date();
		long timestamp1 = d1.getTime();// ����Date��������ʱ�̵ĺ���ʱ���
		System.out.println(timestamp1);
		// ʱ���ת��Ϊ��ǰʱ����ʱ��
		Date d2 = new Date(0);// ʱ���������Date����
		System.out.println(d2.toString());// �᷵��1970.1.1��ҹ���+��ǰʱ��
		d2.setTime(timestamp1);// ʱ���ת��ΪDate
		System.out.println(d2);

		// SimpleDataFormat��
		// DateFormat��һ�������࣬����ʵ������getDateInstance()���Եõ�����ʵ��
		DateFormat df = DateFormat.getDateInstance();
		System.out.println(df.format(d1));

		// ��Date�����ʽ��Ϊ�ַ���
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();// ����д�Ǹ�ʽ��ΪĬ��pattern
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		String date_str = sdf.format(d);
		System.out.println(date_str);
		System.out.println(sdf1.format(d));

		// ���ַ�������ʽ����ΪDate����
		String str = "3085/06/12 23:12:16";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date d3 = sdf2.parse(str);// �쳣����ctrl+1��ʱ�Զ����
		System.out.println(sdf1.format(d3));

		// Calendar��
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -5);
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 15);
		System.out.println(cal.get(Calendar.YEAR));// ��ȡ�ֶ�
		System.out.println(cal.get(Calendar.MONTH));// Month�Ǵ�0��ʼ��ŵ�
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));// �����ǵ�1��

		// Runtime��
		Runtime rt = Runtime.getRuntime();
		rt.exec("shutdown -s -t 300");
		rt.exec("shutdown -a");

		long endtime = System.currentTimeMillis();
		System.out.println("��������ʱ�䣺" + (endtime - starttime) + "ms");
	}
}