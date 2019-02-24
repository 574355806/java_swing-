package ui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import table.Loginuser;

import dao.Login_sql;

class Login_user extends JFrame implements ActionListener{
	Box con, con1, con2, con3, con4;
	JButton  b2;
	JTextField j1 = new JTextField(5);
	JPasswordField j2 = new JPasswordField(5);
	JPanel jPanel=new JPanel();
	Login_sql login=new Login_sql();
	Login_user() {
		super("登录");
		this.setSize(300, 230);
		//插入logo
		ImageIcon bg=new ImageIcon("D://新建文件夹/java实训の学生考勤系统/image/登录副本.jpg"); 
		JLabel label=new JLabel(bg);
	    jPanel.add(label,BorderLayout.NORTH); 
	   
		Container content = this.getContentPane();
		content.setBackground(Color.lightGray);
		content.add(jPanel, "North");
		//插入标签和文本框密码框
	    con1 = Box.createVerticalBox();
		con1.add(new JLabel("用户名："));
		con1.add(Box.createVerticalStrut(5));
		con1.add(new JLabel("密码："));
		con2 = Box.createVerticalBox();
		con2.add(j1);
		con2.add(Box.createVerticalStrut(5));
		con2.add(j2);

		b2 = new JButton("登录");
		//盒子布局
		con3 = Box.createHorizontalBox();
		con3.add(b2);
		con3.add(Box.createHorizontalStrut(5));
		con4 = Box.createVerticalBox();
		con4.add(con3, "Center");
		con = Box.createHorizontalBox();
		con.add(con1);
		con.add(Box.createHorizontalStrut(10));
		con.add(con2, "Center");
		content.add(con);
		content.add(con4, "South");
		content.validate();
		
		
		b2.addActionListener(this);
			
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	    new Maininterface();
	/*	String name = null;
		String ps=null;
		if(e.getSource()==b2)
		{ name=j1.getText();
		     ps=j2.getText();
		     Loginuser u=new Loginuser(name,ps);  
		     //用户名，密码正确，进入系统，错误给出提示
		 if(!login.findlogin(u))
		  {JOptionPane.showMessageDialog(null, "用户信息错误", "成功登录", 2);
			}
		 else {this.dispose();
		    new Maininterface();}
		}
		*/
	}
}
