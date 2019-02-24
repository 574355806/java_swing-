package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import table.Loginuser;

import dao.Login_sql;

public class Changepassword extends JInternalFrame implements ActionListener{
	Box con, con1, con2, con3, con4;
	JButton b1, b2;
	JTextField j1 = new JTextField(10);
	JPasswordField j2 = new JPasswordField(10);
	JPasswordField j3 = new JPasswordField(10);
	
	JPanel jPanel=new JPanel();
	Login_sql login=new Login_sql();
	Changepassword() {
		super("修改密码",true,true,true,true);
		this.setSize(600, 360);
		JLabel j = new JLabel("修改密码");
		jPanel.add(j,BorderLayout.CENTER);
		ImageIcon bg=new ImageIcon("image/t01a77d262d6dc4c74a.jpg");
	    JLabel label=new JLabel(bg);
	    label.setBounds(0, 0, 600,150);
	    jPanel.add(label,BorderLayout.NORTH);
      
		Container content = this.getContentPane();
		
		content.add(jPanel, BorderLayout.NORTH);
		
		con1 = Box.createVerticalBox();
		con1.add(new JLabel("用户名："));
		con1.add(Box.createVerticalStrut(5));
		con1.add(new JLabel("原始密码："));
		con1.add(Box.createVerticalStrut(5));
		con1.add(new JLabel("重设密码："));
		
		con2 = Box.createVerticalBox();
		con2.add(j1);
		con2.add(Box.createVerticalStrut(5));
		con2.add(j2);
		con2.add(Box.createVerticalStrut(5));
		con2.add(j3);

		b1 = new JButton("确定修改");
		b2 = new JButton("取消");
		con3 = Box.createHorizontalBox();
		con3.add(b1);
		con3.add(Box.createHorizontalStrut(5));
		con3.add(b2);
		con3.add(Box.createHorizontalStrut(5));
		
		con4 = Box.createVerticalBox();
		con4.add(con3);
		JPanel jj=new JPanel();
		jj.add(con1,BorderLayout.CENTER);
		jj.add(con2);
		/*con = Box.createHorizontalBox();
		con.add(con1);
		con.add(Box.createHorizontalStrut(5));
		con.add(con2);*/

		content.add(jj,BorderLayout.CENTER);
		content.add(con4, BorderLayout.SOUTH);
		content.validate();
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String name=null,ps=null;
		if(e.getSource()==b1)
			name=j1.getText();
	     ps=j2.getText();
	     Loginuser u=new Loginuser(name,ps);    
	 if(login.login(u))
	 { 
		 login.delete(u);
		 u.setPassword(j3.getText());
		 login.insert(u);
		 JOptionPane.showMessageDialog(null, "修改成功", "成功登录", 1);
		
		 this.dispose();
		 } 
	 else {JOptionPane.showMessageDialog(null, "用户信息错误", "修改密码", 2);
		}
	}

}
