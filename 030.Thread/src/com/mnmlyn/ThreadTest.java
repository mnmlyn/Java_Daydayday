/*
 * ���߳�
 * 
 * 1. ʹ�ö��̵߳ĵ�һ�ַ���
 * �̳�Thread�࣬��дrun()���������߳���Ҫִ�еĴ��룬����start()���������߳�
 * 
 * 2. ʹ�ö��̵߳ĵڶ��ַ���
 * ʵ��Runnable�ӿڣ�������ΪThread�๹�캯���Ĳ���������Thread���󣬵���Thread�����start����
 * 
 * ���ַ�����Javaֻ�ܵ��̳У������и��࣬�������ʵ��Runnable�ӿڵķ����� 
 * 
 * 3. �����߳����ƣ���ȡ�߳����Ƶķ���
 * ���ã�
 * Thread�Ĺ��죬setName()����
 * ��ȡ��
 * getName()����
 * 
 * 4. ��ȡ��ǰ�̵߳�����
 * Thread.currentThread()��static����
 * 
 * 5. �߳�����
 * Thread.sleep()��static����
 * 
 * 6. ����Ϊ�ػ��߳�
 * �̶߳������setDaemon(true)������������Ϊ�ػ��̣߳��������߳��˳�ʱ�����߳�Ҳ��֮�˳�
 * 
 * 7. join()
 * ��ǰ�߳���ͣ���ȴ�ָ���߳̽����󣬵�ǰ�߳��ټ���
 * 
 * 8. ��ǰ�߳��ó�cpu
 * yeild()����
 * 
 * 9. �����߳����ȼ�
 * setPrority()���������ȼ���1~10�����ķ�Χ
 * Thread.MIN_PRIORITY��Thread.MAX_PRIORITY��������ȷ����Χ
 * 
 * 10. ͬ�������synchronized(obj){}
 * ���������obj��Ϊͬ��������
 * 
 * 11. ͬ��������ֱ���ڷ����ϼ����η�synchronized�����ɱ�Ϊͬ������
 * �Ǿ�̬��ͬ��������ͬ���������ǵ�ǰ���󣬼�thisָ��
 * ��̬������ͬ���������ǵ�ǰ����ֽ��룬������.class
 * 
 */
package com.mnmlyn;

public class ThreadTest {

	public static void main(String[] args) {
		// Test1();
		// Test2();
		// Test3();
		// Test4();
		// Test5();
		// Test6();
		// Test7();
		// Test8();
		// Test9();
	}

	private static void Test9() {
		// ��̬������ʹ���ֽ���������ͬ��
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					Printer.print7();
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					Printer.print8();
				}
			}
		}.start();
	}

	private static void Test8() {
		// �Ǿ�̬ͬ��������ʹ�ö����thisָ����Ϊͬ��������
		Printer p = new Printer();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					p.print5();
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					p.print6();
				}
			}
		}.start();
	}

	private static void Test7() {
		// �����߳��У������ٽ���Դ��׼����Ĵ��룬��ͬ�������synchronized����֤ͬ��
		Printer p = new Printer();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					p.print3();
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					p.print4();
				}
			}
		}.start();
	}

	private static void Test6() {
		// ����ͬ�������ʱ��������ʾ��������Ϊ��׼������ٽ���Դ�������̻߳�����
		Printer p = new Printer();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					p.print1();
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					p.print2();
				}
			}
		}.start();
	}

	private static void Test5() {
		// �����߳����ƣ���ȡ�߳����ơ�
		// �߳�����
		new Thread("MyThread-1") {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(this.getName());
				this.setName("�½��߳�1");
				System.out.println(this.getName());
			}
		}.start();

		// ��ȡ��ǰ�̵߳�����
		System.out.println(Thread.currentThread().getName());
		new Thread(new Runnable() {
			@Override
			public void run() {
				// �±�������this��Runnable�ӿڵ�ʵ�ֵĶ��󣬲�����Thread����
				// System.out.println(this.getName());
				// Ҫ��ȡ�̣߳��������»�ȡ��ǰ�߳�����
				System.out.println(Thread.currentThread().getName());
			}
		}).start();
	}

	private static void Test4() {
		// ���̵߳ڶ��ַ�����ʹ�������ڲ���ʵ��Runnable�ӿڲ�ʵ�������󣬴���Thread���󣬵���start����
		// ��Ȼ�����԰�ThreadҲдΪ�����ڲ���
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					System.out.println("ttttttttttt");
				}
			}
		});
		t3.start();
		for (int i = 0; i < 1000; ++i) {
			System.out.println("mmmmmmmm");
		}
	}

	private static void Test3() {
		// ���̵߳ڶ��ַ�����ʵ��Runnable�ӿڣ���дrun������
		// ��ʵ�ֵĶ��󴫸�Thread�๹��Thread���󣬵�����start����
		MyRunnable mr = new MyRunnable();
		Thread t2 = new Thread(mr);
		t2.start();
		for (int i = 0; i < 1000; ++i) {
			System.out.println("mmmmmmmm");
		}
	}

	private static void Test2() {
		// ���̵߳�һ�ַ������̳�Thread�࣬���������ڲ���
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					System.out.println("ttttttttttt");
				}
			}
		}.start();
		for (int i = 0; i < 1000; ++i) {
			System.out.println("mmmmmmmm");
		}
	}

	private static void Test1() {
		// ���̵߳�һ�ַ������̳�Thread��
		MyThread t1 = new MyThread();
		t1.start();
		for (int i = 0; i < 1000; ++i) {
			System.out.println("mmmmmmmm");
		}
	}

}
