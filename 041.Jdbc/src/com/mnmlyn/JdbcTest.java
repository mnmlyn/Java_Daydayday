/*
 * ѧϰjdbc�Ļ���ʹ��
 * 
 */
package com.mnmlyn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) throws Exception {
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
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
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
