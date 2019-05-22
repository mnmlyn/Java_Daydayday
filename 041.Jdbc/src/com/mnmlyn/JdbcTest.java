/*
 * 学习jdbc的基本使用
 * 
 * 配置文件config.password写法：
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
		// 最基本写法，注册驱动方式不建议
		// Demo1();
		// Demo2();
		// Demo3();
		Demo4();
		
		// 加载配置文件，还有一种方式，配置文件要写成xxx.properties，放在src目录下，加载不写后缀
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String ip = rb.getString("ip");
		System.out.println(ip);
	}

	private static void Demo4() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
		// 改用预编译的Statement，叫做PreparedStatement
		Properties prop = new Properties();
		prop.load(new FileInputStream("config.password"));
		// 1 .注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2. 获得连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("ip")
				+ ":3306/java_jdbc?useSSL=false", prop);
		// 3. 创建预编译stmt
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM student WHERE name=?");
		// 4. 预编译stmt中占位符的赋值
		stmt.setString(1, "zhao");
		// 5. 执行
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt("id") + "\t");
			System.out.print(rs.getString("name") + "\t");
			System.out.println(rs.getInt("age"));
		}
		rs.close();
		// 再次赋值与执行
		System.out.println("----------------");
		stmt.setString(1, "min");
		rs = stmt.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt("id") + "\t");
			System.out.print(rs.getString("name") + "\t");
			System.out.println(rs.getInt("age"));
		}
		// 6. 释放资源
		rs.close();
		stmt.close();
		conn.close();
	}

	private static void Demo3() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
		// 再来敲一遍，用ArrayList来保存结果集，结果集中的每个结果，可以用一个Bean(一个定制类的对象)来表示
		// 读取配置
		Properties prop = new Properties();
		prop.load(new FileInputStream("config.password"));
		// 1. 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2. 获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("ip") 
				+ ":3306/java_jdbc?useSSL=false&user=" + prop.getProperty("user") 
				+ "&password=" + prop.getProperty("password"));
		// 3. 创建stmt
		Statement stmt = conn.createStatement();
		// 4. 执行查询
		ResultSet rs = stmt.executeQuery("SELECT * FROM student");
		// 5. 遍历结果集，放入ArrayList
		List<Student> list = new ArrayList<>();
		while(rs.next()) {
			Student stu = new Student();
			stu.setId(rs.getInt("id"));
			stu.setName(rs.getString("name"));
			stu.setAge(rs.getInt("age"));
			list.add(stu);
		}
		
		// 移动行游标的方法
		// 向上移动一行
		rs.previous();
		System.out.println(rs.getString("name"));
		// 移动到第一行之前，也就是表头，这时候，不能取得数据，要调用next到第一行，才能取数据
		rs.beforeFirst();
		// 移动到下一行
		rs.next();
		System.out.println(rs.getString("name"));
		// 移动到最后一行之后
		rs.afterLast();
		rs.previous();
		System.out.println(rs.getString("name"));
		// 移动到指定行，从1开始
		rs.absolute(2);
		System.out.println(rs.getString("name"));
		
		// 6. 关闭资源
		rs.close();
		stmt.close();
		conn.close();
		
		// 遍历结果集
		System.out.println("----------------");
		for (Student student : list) {
			System.out.println(student);
		}
	}

	private static void Demo2() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
		// 再来敲一遍，用Properties来加载配置
		Properties prop = new Properties();
		prop.load(new FileInputStream("config.password"));
		
		// 1. 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2. 获取连接，这里，由mysql的文档，只需要prop中带有user和password两个key即可正确连接
		// 或者，只有一个参数的方法将user和password用?user=root&pasword=1234也可以
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("ip") + ":3306/java_jdbc?useSSL=false", prop);
		// 3. 用连接创建stmt对象
		Statement stmt = conn.createStatement();
		
		// 4. 尝试一下更新
		stmt.executeUpdate("DELETE FROM student WHERE id=3");
		stmt.executeUpdate("INSERT INTO student(id,name,age) VALUES(3,'Tom',14)");
		stmt.executeUpdate("UPDATE student SET name='Jerry',age=15 WHERE id=3");
		
		// 4. 使用stmt对象执行sql
		ResultSet rs = stmt.executeQuery("SELECT * FROM student");
		// 5. 遍历结果集
		while(rs.next()) {
			System.out.print(rs.getObject(1) + "\t");
			System.out.print(rs.getObject(2) + "\t");
			// 也可以通过列名取结果集中一行的某一列
			System.out.print("age:" + rs.getObject("age") + "\t");
			System.out.println(rs.getObject(3));
		}
		// 6. 关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}

	private static void Demo1() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
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
		// 不使用这种方式
		// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// 使用下边这种方式，加载驱动
		Class.forName("com.mysql.jdbc.Driver");
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
