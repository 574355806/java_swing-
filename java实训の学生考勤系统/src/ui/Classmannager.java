package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;


import handle.Handleclass;

public class Classmannager extends JInternalFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable jtable;
	JButton fin1,del2,add3,upd4;
	JTextField classnum,classname,classcount;
	@SuppressWarnings("rawtypes")
	JComboBox classdept;
	JPanel jPanel;
	JLabel jLabel1,jLabel2,jLabel3,jLabel4;
	JScrollPane jScrollPane;
	Box box1,box2,box3,box4,box5;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Classmannager() {//构造方法
		
		super("班级管理",true,true,true,true);
		setSize(500,500);
		Handleclass handleclass = new Handleclass();
		
		jtable = new JTable();
		DefaultTableModel dtm = handleclass.showAlldata();
		jtable.setModel(dtm);           
		jScrollPane = new JScrollPane(jtable);
		this.add(jScrollPane,BorderLayout.CENTER);//将表列在center
		String[] depts = new String[5];       //下拉列表数据
		depts[0] = new String("机电工程学院");
		depts[1] = new String("经济管理学院");
		depts[2] = new String("计算机学院");
		depts[3] = new String("材料工程学院");
		depts[4] = new String("文法系");
		classdept = new JComboBox(depts);    //创建下拉列表
		classdept.setEnabled(true);
		
		
		classnum = new JTextField(20);
		classname = new JTextField(20);
		classcount = new JTextField(20);
		jLabel1 = new JLabel("班级编号");
		jLabel2 = new JLabel("班级名称");
		jLabel3 = new JLabel("系别");
		jLabel4 = new JLabel("总人数");
		
	//fin1,del2,add3,upd4;
		fin1 = new JButton("查找");
		fin1.addActionListener(this);
		del2 = new JButton("删除");
		del2.addActionListener(this);
		add3 = new JButton("添加");
		add3.addActionListener(this);
		upd4 = new JButton("修改");
		upd4.addActionListener(this);
	    
		box1 = Box.createVerticalBox();
		box1.add(jLabel1);
		box1.add(Box.createVerticalStrut(5));
		box1.add(jLabel2);
		box1.add(Box.createVerticalStrut(5));
		box1.add(jLabel3);
		box1.add(Box.createVerticalStrut(5));
		box1.add(jLabel4);
		
		box2 = Box.createVerticalBox();
		box2.add(Box.createVerticalStrut(5));
		box2.add(classnum);
		box2.add(Box.createVerticalStrut(5));
		box2.add(classname);
		box2.add(Box.createVerticalStrut(5));
		box2.add(classdept);
		box2.add(Box.createVerticalStrut(5));
		box2.add(classcount);
		
	
		box3 = Box.createHorizontalBox();
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(box2);
		
		box4 = Box.createHorizontalBox();
		box4.add(fin1);
		box4.add(Box.createHorizontalStrut(5));
		box4.add(del2);
		box4.add(Box.createHorizontalStrut(5));
		box4.add(add3);
		box4.add(Box.createHorizontalStrut(5));
		box4.add(upd4);
		
		box5 = Box.createVerticalBox();
		box5.add(box3);
		box5.add(Box.createVerticalStrut(20));
		box5.add(box4);
		
		jPanel = new JPanel();         //这样能使下面那部分居中美观
		jPanel.add(box5,BorderLayout.CENTER);
		this.add(jPanel, BorderLayout.SOUTH);
		setVisible(true);
		//setBounds(0,0,1000,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		    String name = classname.getText();
			String num = classnum.getText();
			String dept = classdept.getSelectedItem().toString();
			String count = classcount.getText();
			
		    Handleclass handleclass = new Handleclass();
		if(e.getSource() == fin1){    //查找
			
			if((!name.equals(""))&&(!num.equals(""))){
				DefaultTableModel dtm = handleclass.findresultbyzonghe(num, name);
				//DefaultTableModel dtm = handleclass.showTablectn(num, name);
				jtable.setModel(dtm);
				validate();
			}
			else if((!name.equals(""))&&(num.equals(""))){   //名称不空，为空
				DefaultTableModel dtm = handleclass.findresultbyname(name);
				jtable.setModel(dtm);           
				validate();               
			}
			else if(!num.equals("")){
				DefaultTableModel dtm = handleclass.findresultbynum(num);
				jtable.setModel(dtm);           
				validate(); 
			}
			else{
				
				DefaultTableModel dtm = handleclass.findresultbydept(dept);
				jtable.setModel(dtm);           
				validate(); 
			}
		}
		else if(e.getSource()==del2) {
			if(!name.equals("")&&!name.equals(""))//名称编号都填的时候，删除
			{
				DefaultTableModel dtm = handleclass.deleteDataall(num, name);
				jtable.setModel(dtm);
				validate();
			}
			else if(!name.equals("")){
				DefaultTableModel dtm = handleclass.deleteDatacname(name);
				 	jtable.setModel(dtm);
				 	jtable.validate();
			}
			else if(!num.equals("")){
				DefaultTableModel dtm = handleclass.deleteDatacnum(num);
			 	jtable.setModel(dtm);
			 	jtable.validate();
			}
		}
		
		if(e.getSource() == add3){          //添加
			if(!count.equals("")&&!num.equals("")&&!name.equals("")&&!dept.equals(""))
			 {//int count1 = Integer.parseInt(count);
			 
			 handleclass.addClassAll(num, name, dept, count);
			 DefaultTableModel dtm=handleclass.showAlldata();
			 jtable.setModel(dtm);}
			else {
				JOptionPane.showMessageDialog(null, "请将信息添加完整", "添加失败", 1);
				
			}
			
		}
		
		if(e.getSource() == upd4){         // 修改
			DefaultTableModel dtm = handleclass.updataAll(jtable);
			jtable.setModel(dtm);
			jtable.validate();
		}
	}

}
