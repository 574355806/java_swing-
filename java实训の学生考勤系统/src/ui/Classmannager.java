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
	public Classmannager() {//���췽��
		
		super("�༶����",true,true,true,true);
		setSize(500,500);
		Handleclass handleclass = new Handleclass();
		
		jtable = new JTable();
		DefaultTableModel dtm = handleclass.showAlldata();
		jtable.setModel(dtm);           
		jScrollPane = new JScrollPane(jtable);
		this.add(jScrollPane,BorderLayout.CENTER);//��������center
		String[] depts = new String[5];       //�����б�����
		depts[0] = new String("���繤��ѧԺ");
		depts[1] = new String("���ù���ѧԺ");
		depts[2] = new String("�����ѧԺ");
		depts[3] = new String("���Ϲ���ѧԺ");
		depts[4] = new String("�ķ�ϵ");
		classdept = new JComboBox(depts);    //���������б�
		classdept.setEnabled(true);
		
		
		classnum = new JTextField(20);
		classname = new JTextField(20);
		classcount = new JTextField(20);
		jLabel1 = new JLabel("�༶���");
		jLabel2 = new JLabel("�༶����");
		jLabel3 = new JLabel("ϵ��");
		jLabel4 = new JLabel("������");
		
	//fin1,del2,add3,upd4;
		fin1 = new JButton("����");
		fin1.addActionListener(this);
		del2 = new JButton("ɾ��");
		del2.addActionListener(this);
		add3 = new JButton("���");
		add3.addActionListener(this);
		upd4 = new JButton("�޸�");
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
		
		jPanel = new JPanel();         //������ʹ�����ǲ��־�������
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
		if(e.getSource() == fin1){    //����
			
			if((!name.equals(""))&&(!num.equals(""))){
				DefaultTableModel dtm = handleclass.findresultbyzonghe(num, name);
				//DefaultTableModel dtm = handleclass.showTablectn(num, name);
				jtable.setModel(dtm);
				validate();
			}
			else if((!name.equals(""))&&(num.equals(""))){   //���Ʋ��գ�Ϊ��
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
			if(!name.equals("")&&!name.equals(""))//���Ʊ�Ŷ����ʱ��ɾ��
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
		
		if(e.getSource() == add3){          //���
			if(!count.equals("")&&!num.equals("")&&!name.equals("")&&!dept.equals(""))
			 {//int count1 = Integer.parseInt(count);
			 
			 handleclass.addClassAll(num, name, dept, count);
			 DefaultTableModel dtm=handleclass.showAlldata();
			 jtable.setModel(dtm);}
			else {
				JOptionPane.showMessageDialog(null, "�뽫��Ϣ�������", "���ʧ��", 1);
				
			}
			
		}
		
		if(e.getSource() == upd4){         // �޸�
			DefaultTableModel dtm = handleclass.updataAll(jtable);
			jtable.setModel(dtm);
			jtable.validate();
		}
	}

}
