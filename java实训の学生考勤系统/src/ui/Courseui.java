package ui;

import handle.Handlecourse;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import table.Course;

public class Courseui extends JInternalFrame implements ActionListener {
	JScrollPane jScrollPane=null;
	JButton b1,b2,b3,b4;//增加  删除  修改   查询
	Box box,box0,box1,box2,box3,box4 ;
	JTextField teachertext,coursenametext,coursenumtext,timetext;  //各个文本域
	JLabel j1,j2,j3,j4,j5;     //每个标签
		
		

	Handlecourse handlecourse=new Handlecourse();
	JTable table = new JTable();
	public Courseui() {
		 super("课程管理", true, true, true, true);
		     DefaultTableModel dtm = handlecourse.showTable();
		     table.setModel(dtm);
			 jScrollPane=new JScrollPane(table);
			 add(new JScrollPane(jScrollPane),BorderLayout.CENTER);	
			    box0=Box.createVerticalBox();
			    //提示标签，放入一个盒子中
			    j1=new JLabel("课程编号");
			    j2=new JLabel("课程名称");
			    j3=new JLabel("授课教师");
			    j4=new JLabel("学时");
			    box0.add(j1);
			    box0.add(Box.createVerticalStrut(5));
			    box0.add(j2);
			    box0.add(Box.createVerticalStrut(5));
			    box0.add(j3);
			    box0.add(Box.createVerticalStrut(5));
			    box0.add(j4);
			    //各个文本域，放入另一个盒子中，
			    coursenumtext=new JTextField(1);
			    coursenametext=new JTextField(1);
			    teachertext=new JTextField(1);
			    timetext=new JTextField(1);
				   
			    box2=Box.createVerticalBox();
			    box2.add(coursenumtext);
			    box2.add(Box.createVerticalStrut(1));
			    box2.add(coursenametext);
			    box2.add(Box.createVerticalStrut(1));
				box2.add(teachertext);
				box2.add(Box.createVerticalStrut(1));
				box2.add(timetext);
			     box3=Box.createHorizontalBox();
			   box3.add(box0);
			   box3.add(Box.createHorizontalStrut(15));
			   box3.add(box2);
			    box = Box.createVerticalBox();
			    box.add(Box.createVerticalStrut(30));
			    box.add(box3);
			    box.add(Box.createVerticalStrut(30));
	  //定义各个操作按钮
			    
			    b1 = new JButton("查询");
	    b1.addActionListener(this);
	    b2 = new JButton("删除");
	    b2.addActionListener(this);
	    b3 = new JButton("增加");
	    b3.addActionListener(this);
	    b4 = new JButton("修改");
	    b4.addActionListener(this);
	    //将按钮填入盒子
	   box1 =  Box.createHorizontalBox();
	    box1.add(b1);
	    box1.add(Box.createHorizontalStrut(15));
	    box1.add(b2);
	    box1.add(Box.createHorizontalStrut(15));
	    box1.add(b3);
	    box1.add(Box.createHorizontalStrut(15));
	    box1.add(b4);
	    box.add(box1);
	   //将整个盒子放到大的jpanel里
	  JPanel jPanel=new JPanel();
	  jPanel.add(box,BorderLayout.CENTER);
	   this.add(jPanel,BorderLayout.SOUTH);
	   setVisible(true);
		setSize(500,500);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	   }
	@Override
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()== b1){//查询
		 String nameString=coursenametext.getText();//获得填写的课程，教师，课程编号
		 String teacherString=teachertext.getText();
		 String numberstring=coursenumtext.getText();
		 if(nameString.equals("")&&teacherString.equals("")) {   //若未填写课程，教师，显示所有数据
				DefaultTableModel dtm = handlecourse.showTable();
				table.setModel(dtm);
				}
		 else if(nameString.equals("")){//若课程栏为空，按照教师查找
			 Course xPresent=handlecourse.findbyteacher(teacherString);
				if(xPresent!=null)
				{   
					DefaultTableModel dtm = handlecourse.findresultbyteacher(teacherString);
					table.setModel(dtm);
				}
				else JOptionPane.showMessageDialog(null, "查无此课程", "查询", 1);
				 
		 }
		 else if(teacherString.equals(""))            //若学号栏空，按照班及查找
		 {
			 Course xPresent=handlecourse.findbyname(nameString);
				if(xPresent!=null)
				{   
					DefaultTableModel dtm = handlecourse.findresultbyname(nameString);
					table.setModel(dtm);
				}
				else JOptionPane.showMessageDialog(null, "查无此课程", "查询", 1);
			
		 }
		 else{             //若都填写，按具体信息查找
			 Course p=new Course( numberstring, nameString,teacherString, 0);
			 Course xPresent=handlecourse.findzonghe(p);
				if(xPresent!=null)
				{   
					DefaultTableModel dtm = handlecourse.findresultbyzonghe(xPresent);
					table.setModel(dtm);
				}
				else JOptionPane.showMessageDialog(null, "查无此课程", "查询", 1);
				
		 }
	      }
			if(e.getSource()== b2){//删除
			       String nameString=coursenametext.getText();
		  		    String coursenum=coursenumtext.getText();
					String teacher=teachertext.getText();
					  
					  Course a=new Course(coursenum, nameString, teacher, 0);
					 	 
					 if(nameString.equals("")||teacher.equals("")||coursenum.equals(""))
						  JOptionPane.showMessageDialog(null, "请输入条件", "删除失败", 1);    //若有未填写的地方，提示
						
					  else if(handlecourse.findzonghe(a)!=null)            //查找删除
				    {
				    int x= JOptionPane.showInternalConfirmDialog(this,"确定删除？","取消" ,JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
				    if(x==0){
					 handlecourse.deletezonghe(a);
					 JOptionPane.showMessageDialog(null, "删除成功", "删除成功", 1);
					 DefaultTableModel dtm = handlecourse.showTable();
				     table.setModel(dtm);
				     }
					 }
					  else JOptionPane.showMessageDialog(null, "查无此课程", "删除失败", 1);
			}
			
		if(e.getSource() == b3){//增加
			//请输入课程所有信息，不能有空
			if((coursenametext.getText().equals(""))||(coursenumtext.getText().equals(""))||(teachertext.getText().equals(""))||(timetext.getText().equals("")))
			{ 
			JOptionPane.showMessageDialog(table, "课程信息不完善", "添加失败", 1);
			}
			else {//查找添加是否重复，重复给出错误提示
			Course p=new Course(coursenumtext.getText(), coursenametext.getText(),
			teachertext.getText(), Integer.parseInt(timetext.getText()));
				if(handlecourse.findzonghe(p)==null)
				{
				if(handlecourse.add(p)==true)
			       JOptionPane.showMessageDialog(null, "添加成功", "添加成功", 1);
				DefaultTableModel dtm = handlecourse.showTable();
			    table.setModel(dtm);
				}
			else {JOptionPane.showMessageDialog(null, "已有此课程", "添加失败", 1);
				}
			}
		}
		if(e.getSource()==b4){         //在表格里修改数据，点击修改按钮，修改
			  	int row=table.getSelectedRow();   //获得改动的前数据
				    String coursenum = (String) table.getValueAt(row,0);
					String coursename = (String) table.getValueAt(row,1);
					String teacher = (String) table.getValueAt(row,2);
					int time = Integer.parseInt( table.getValueAt(row,3).toString());
					Course beforec=new Course(coursenum, coursename, teacher, time);
					int a = table.getEditingRow();
					 int c = table.getEditingColumn();//获得改动后的数据
					 table.getCellEditor(a,c).stopCellEditing();
					 coursenum = (String) table.getValueAt(row,0);
					 coursename = (String) table.getValueAt(row,1);
					 teacher = (String) table.getValueAt(row,2);
					 time = Integer.parseInt((String) table.getValueAt(row,3));
					 Course nowc=new Course(coursenum, coursename, teacher, time);
				     int x= JOptionPane.showInternalConfirmDialog(table,"确定修改？","取消" ,JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
				    if(x==0){
			    		handlecourse.deletezonghe(beforec);//删除之前的数据，添加修改后的数据
						handlecourse.add(nowc);
				JOptionPane.showMessageDialog(null, "修改成功", "成功", 1);
			   }
			    	 else  JOptionPane.showMessageDialog(null, "修改失败", "失败", 1);
				}
		
	}

}
