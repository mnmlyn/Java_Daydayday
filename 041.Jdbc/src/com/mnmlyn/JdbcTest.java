/*
 * 学习jdbc的基本使用
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
		// 从配置文件中读取：ip，用户名，密码
		BufferedReader br = new BufferedReader(new FileReader("config.password"));
		String ip = br.readLine();
		String user = br.readLine();
		String pw = br.readLine();
		br.close();

		/*
		 * 数据库名称java_jdbc
		 * 表创建
		 * CREATE TABLE student(
		 *     id INT primary key auto_increment,
		 *     name VARCHAR(10) NOT NULL,
		 *     age INT NOT NULL
		 * );
		 */
		// 1. 注册驱动
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// 2. 获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/java_jdbc?useSSL=false", user, pw);
		// 3. 用连接创建stat对象
		Statement stmt = conn.createStatement();
		// 4. 用stat对象执行sql语句，得到结果集
		ResultSet rs = stmt.executeQuery("SELECT * FROM student;");
		// 5. 处理结果集
		while(rs.next()) {
			System.out.print(rs.getObject(1) + "\t");
			System.out.print(rs.getObject(2) + "\t");
			System.out.println(rs.getObject(3));
		}
		// 6. 关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}

}
