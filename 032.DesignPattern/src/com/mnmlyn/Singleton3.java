package com.mnmlyn;

//����ģʽ3��ֱ�ӱ�¶�������ã���final���η�ֹ���޸�
public class Singleton3 {
	private Singleton3() {
	}

	public static final Singleton3 instance = new Singleton3();
}
