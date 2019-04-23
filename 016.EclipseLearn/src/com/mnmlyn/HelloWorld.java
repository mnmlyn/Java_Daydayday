/*
 * 鸟枪换大炮，开始用Eclipse
 * 一个好的IDE能够节省很多开发的时间，让自己关注主要矛盾
 * 
 * 1. 视窗介绍
 * 首先，所有的视窗都可以通过Window->Show View来找到
 * Package Explorer，树状结构显示项目、源码文件夹、包、类
 * Outline，显示当前源文件的结构
 * Console，程序标准输出及错误输出
 * 保存当前窗体布局为默认，Window->Perspective->Save ...
 * 
 * 2. 编译和运行jdk版本选择
 * Window->Preferences->Java->Compiler
 * Window->Preferences->Java->Installed JREs
 * 
 * 3. 默认的字体大小，看的眼睛要瞎了，如何修改？
 * Window->Preferences->General->Appearance
 *     ->Colors and Fonts->Java->Java Editor Text Font
 * 其他的字体，比如Console的输出，设置里边可以搜索，搜"console font"
 * 
 * 4. 创建class等，会自动生成一些代码，如何修改自动生成的样式？
 * 这是按照模(mu2)板生成代码的，修改一下模板就好了
 * Window->Preferences->Java->Code Style->Code Templates
 * 
 * 5. 行号，打开和关闭？
 * 在代码编辑框的左边白色区，鼠标右键，Show Line Numbers
 * 
 * 6. 悬浮提示的关闭？关闭之后，光标放在相应位置，按F2可以显示
 * Window->Preferences->Java->Editor->Hovers，
 * 将Combined Hovers的勾去掉
 * 
 * -------------------------------------------------------
 * 上边都是基本设置，下边记录常用快捷键
 * 
 * 1. Alt+/，可以代码自动补全
 * 比如，
 * 输入syso，按键，自动补全
 * 输入Scan，按键，自动补全，并且导入依赖的包
 * 这些提示的设置，在Window->Preferences->Java->Editor->Templates
 * 
 * 2. 格式化  ctrl+shift+f
 * 貌似有快捷键冲突，选中代码，Source->Format
 * 
 * 3. 导入包  ctrl+shift+o
 * 删除多余的import语句，补充缺少的import语句
 * 
 * 4. 注释  ctrl+/,ctrl+shift+/,ctrl+shift+\
 * ctrl+/，注释（或取消注释）光标所在行，或选定的多行
 * ctrl+shift+/，选定一块区域，按键将其多行注释
 * ctrl+shift+\，光标在多行注释范围中，按键取消多行注释
 * 
 * 5. 代码上下移动 选中代码alt+上/下箭头
 * 光标所在行，或者选定区域所覆盖的行，代码上下移动
 * 
 * 6. 查看源码  选中类名(F3或者Ctrl+鼠标点击)
 * 相当于代码跳转
 * 
 * 7. 查找具体的类 ctrl + shift + t
 * 可以当做文档来用，全局查找类
 * 
 * 8. 查找具体类的具体方法 ctrl + o
 * 在当前源文件中，找类名，包名或方法名
 * 
 * 9. 给建议 ctrl+1,根据右边生成左边的数据类型,生成方法
 * 这个可以多用一下，有一些好的建议，减少自己低级劳动
 * 
 * 10. 删除代码 ctrl + d
 * 删除光标所在行，或选定范围覆盖的多行
 * 
 * 11. 抽取方法alt + shift + m
 * 选定代码块，按键，可以将一段代码自动提取为一个方法。
 * 按键ctrl+1之后，也有相似的提示可以抽取方法
 * 
 * 12. 改名alt + shift + r
 * 连按两次，可以重命名变量名，方法名
 * 
 * 13. 按键ctrl+m，可以最大化和取消最大化代码编辑区
 * 这个feel不错，在暂时不需要其他区域时，可以这样操作
 * 
 * 14. 快速生成构造函数，getter和setter
 * Alt+Shift+s，这个其实就是快速按菜单栏Source
 * 然后按照有下划线的条目，按那个字母就可以快速选择。
 * 快速生成构造函数的快捷键是，
 * Alt+Shift+s，按键c，生成无参构造
 * Alt+Shift+s，按键o，生成有参构造
 * 快速生成getter和setter方法的快捷键是，
 * Alt+Shift+s，按键r，进入一个选项框，
 * 按键Alt+a快速选择窗体上全选的按键
 * 按键Alt+r生成 
 * 注意，按键Alt，然后按下菜单栏下划线的字母，可以快速选择菜单栏的条目
 * 菜单下拉后，按下划线的字母，可以快速选择条目。
 * 在对话窗体中，按键Alt+下滑线字母，可以快速按键
 * 
 * -------------------------------------------------------
 * jar包的生成和使用
 * 
 * 1. 先创建一个新项目，编写完成源码，在项目上右键Export，搜jar，选择jar file，
 * 选择路径保存。
 * 2. 将生成的jar文件，拖入到现有项目中，选择复制文件。（一般可以放在一个lib文件夹中）
 * 3. 在jar包管理器视窗的jar文件上，右键，Build Path，Add to Build Path。
 * 4. 然后，在当前工程，就可以使用这个jar文件中定义的类。
 * 
 * -------------------------------------------------------
 * Eclipse导入和删除项目
 * 1. 删除项目
 * 包管理器视窗，项目上右键，Delete，注意硬盘删除的勾选框
 * 2. 导入项目
 * 包管理器视窗，右键，Import，找到项目路径，导入即可
 */
package com.mnmlyn;

import com.mnmlyn.helper.Animal;
import com.mnmlyn.helper.Cat;

public class HelloWorld {
	private int c;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Helle World");
		Animal animal = new Cat("Tom",5);
		System.out.println(animal.getName());
	}

}
