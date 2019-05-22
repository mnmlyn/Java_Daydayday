/*
 * ѧϰjdbc�Ļ���ʹ��
 * 
 * �����ļ�config.passwordд����
<ip>
<username>
<password>
ip=<ip>
user=<username>
password=<password>
 */
package com.mnmlyn;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class JdbcTest {

	public static void main(String[] args) throws Exception {
		// �����д����ע��������ʽ������
		// Demo1();
		// Demo2();
		// Demo3();
		Demo4();
		
		// ���������ļ�������һ�ַ�ʽ�������ļ�Ҫд��xxx.properties������srcĿ¼�£����ز�д��׺
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String ip = rb.getString("ip");
		System.out.println(ip);
	}

	private static void Demo4() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
		// ����Ԥ�����Statement������PreparedStatement
		Properties prop = new Properties();
		prop.load(new FileInputStream("config.password"));
		// 1 .ע������
		Class.forName("com.mysql.jdbc.Driver");
		// 2. �������
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("ip")
				+ ":3306/java_jdbc?useSSL=false", prop);
		// 3. ����Ԥ����stmt
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM student WHERE name=?");
		// 4. Ԥ����stmt��ռλ���ĸ�ֵ
		stmt.setString(1, "zhao");
		// 5. ִ��
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt("id") + "\t");
			System.out.print(rs.getString("name") + "\t");
			System.out.println(rs.getInt("age"));
		}
		rs.close();
		// �ٴθ�ֵ��ִ��
		System.out.println("----------------");
		stmt.setString(1, "min");
		rs = stmt.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt("id") + "\t");
			System.out.print(rs.getString("name") + "\t");
			System.out.println(rs.getInt("age"));
		}
		// 6. �ͷ���Դ
		rs.close();
		stmt.close();
		conn.close();
	}

	private static void Demo3() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
		// ������һ�飬��ArrayList������������������е�ÿ�������������һ��Bean(һ��������Ķ���)����ʾ
		// ��ȡ����
		Properties prop = new Properties();
		prop.load(new FileInputStream("config.password"));
		// 1. ��������
		Class.forName("com.mysql.jdbc.Driver");
		// 2. ��ȡ����
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("ip") 
				+ ":3306/java_jdbc?useSSL=false&user=" + prop.getProperty("user") 
				+ "&password=" + prop.getProperty("password"));
		// 3. ����stmt
		Statement stmt = conn.createStatement();
		// 4. ִ�в�ѯ
		ResultSet rs = stmt.executeQuery("SELECT * FROM student");
		// 5. ���������������ArrayList
		List<Student> list = new ArrayList<>();
		while(rs.next()) {
			Student stu = new Student();
			stu.setId(rs.getInt("id"));
			stu.setName(rs.getString("name"));
			stu.setAge(rs.getInt("age"));
			list.add(stu);
		}
		
		// �ƶ����α�ķ���
		// �����ƶ�һ��
		rs.previous();
		System.out.println(rs.getString("name"));
		// �ƶ�����һ��֮ǰ��Ҳ���Ǳ�ͷ����ʱ�򣬲���ȡ�����ݣ�Ҫ����next����һ�У�����ȡ����
		rs.beforeFirst();
		// �ƶ�����һ��
		rs.next();
		System.out.println(rs.getString("name"));
		// �ƶ������һ��֮��
		rs.afterLast();
		rs.previous();
		System.out.println(rs.getString("name"));
		// �ƶ���ָ���У���1��ʼ
		rs.absolute(2);
		System.out.println(rs.getString("name"));
		
		// 6. �ر���Դ
		rs.close();
		stmt.close();
		conn.close();
		
		// ���������
		System.out.println("----------------");
		for (Student student : list) {
			System.out.println(student);
		}
	}

	private static void Demo2() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
		// ������һ�飬��Properties����������
		Properties prop = new Properties();
		prop.load(new FileInputStream("config.password"));
		
		// 1. ��������
		Class.forName("com.mysql.jdbc.Driver");
		// 2. ��ȡ���ӣ������mysql���ĵ���ֻ��Ҫprop�д���user��password����key������ȷ����
		// ���ߣ�ֻ��һ�������ķ�����user��password��?user=root&pasword=1234Ҳ����
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("ip") + ":3306/java_jdbc?useSSL=false", prop);
		// 3. �����Ӵ���stmt����
		Statement stmt = conn.createStatement();
		
		// 4. ����һ�¸���
		stmt.executeUpdate("DELETE FROM student WHERE id=3");
		stmt.executeUpdate("INSERT INTO student(id,name,age) VALUES(3,'Tom',14)");
		stmt.executeUpdate("UPDATE student SET name='Jerry',age=15 WHERE id=3");
		
		// 4. ʹ��stmt����ִ��sql
		ResultSet rs = stmt.executeQuery("SELECT * FROM student");
		// 5. ���������
		while(rs.next()) {
			System.out.print(rs.getObject(1) + "\t");
			System.out.print(rs.getObject(2) + "\t");
			// Ҳ����ͨ������ȡ�������һ�е�ĳһ��
			System.out.print("age:" + rs.getObject("age") + "\t");
			System.out.println(rs.getObject(3));
		}
		// 6. �ر���Դ
		rs.close();
		stmt.close();
		conn.close();
	}

	private static void Demo1() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		// �������ļ��ж�ȡ��ip���û���������
		BufferedReader br = new BufferedReader(new FileReader("config.password"));
		String ip = br.readLine();
		String user = br.readLine();
		String pw = br.readLine();
		br.close();

		/*
		 * ���ݿ�����java_jdbc
		 * ����
		 * CREATE TABLE student(
		 *     id INT primary key auto_increment,
		 *     name VARCHAR(10) NOT NULL,
		 *     age INT NOT NULL
		 * );
		 */
		// 1. ע������
		// ��ʹ�����ַ�ʽ
		// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// ʹ���±����ַ�ʽ����������
		Class.forName("com.mysql.jdbc.Driver");
		// 2. ��ȡ����
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/java_jdbc?useSSL=false", user, pw);
		// 3. �����Ӵ���stat����
		Statement stmt = conn.createStatement();
		// 4. ��stat����ִ��sql��䣬�õ������
		ResultSet rs = stmt.executeQuery("SELECT * FROM student;");
		// 5. ��������
		while(rs.next()) {
			System.out.print(rs.getObject(1) + "\t");
			System.out.print(rs.getObject(2) + "\t");
			System.out.println(rs.getObject(3));
		}
		// 6. �ر���Դ
		rs.close();
		stmt.close();
		conn.close();
	}

}
