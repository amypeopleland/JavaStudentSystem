import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import operate_admini.admini_add_frame;
import operate_admini.admini_delete_frame;
import operate_admini.admini_select_frame;
import operate_admini.admini_update_frame;
import operate_student.student_add_frame;
import operate_student.student_delete_frame;
import operate_student.student_select_frame;
import operate_student.student_update_frame;
import operate_teacher.teacher_add_frame;
import operate_teacher.teacher_delete_frame;
import operate_teacher.teacher_select_frame;
import operate_teacher.teacher_update_frame;


public class Out implements ActionListener{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Out window = new Out();
					window.frame.setVisible(true);//show the frame
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Out() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u6559\u52A1\u7CFB\u7EDF");
		frame.setBounds(100, 100, 707, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JMenuBar menuBar_2 = new JMenuBar();
		frame.getContentPane().add(menuBar_2);
		
		JMenu menu_2 = new JMenu("\u7BA1\u7406\u5458");
		menuBar_2.add(menu_2);
		
		JMenuItem menuItem_8 = new JMenuItem("\u7BA1\u7406\u5458\u589E\u52A0");
		menu_2.add(menuItem_8);
		menuItem_8.addActionListener(this);
		
		JMenuItem menuItem_9 = new JMenuItem("\u7BA1\u7406\u5458\u5220\u9664");
		menu_2.add(menuItem_9);
		menuItem_9.addActionListener(this);
		
		JMenuItem menuItem_10 = new JMenuItem("\u7BA1\u7406\u5458\u4FEE\u6539");
		menu_2.add(menuItem_10);
		menuItem_10.addActionListener(this);
		
		JMenuItem menuItem_11 = new JMenuItem("\u7BA1\u7406\u5458\u67E5\u770B");
		menu_2.add(menuItem_11);
		menuItem_11.addActionListener(this);
		
		JMenuBar menuBar_1 = new JMenuBar();
		frame.getContentPane().add(menuBar_1);
		
		JMenu menu_1 = new JMenu("\u6559\u5E08\u7BA1\u7406");
		menuBar_1.add(menu_1);
		
		
		JMenuItem menuItem_4 = new JMenuItem("\u6559\u5E08\u589E\u52A0");
		menu_1.add(menuItem_4);
		menuItem_4.addActionListener(this);
		
		JMenuItem menuItem_5 = new JMenuItem("\u6559\u5E08\u5220\u9664");
		menu_1.add(menuItem_5);
		menuItem_5.addActionListener(this);
		
		JMenuItem menuItem_6 = new JMenuItem("\u6559\u5E08\u4FEE\u6539");
		menu_1.add(menuItem_6);
		menuItem_6.addActionListener(this);
		
		JMenuItem menuItem_7 = new JMenuItem("\u6559\u5E08\u67E5\u770B");
		menu_1.add(menuItem_7);
		menuItem_7.addActionListener(this);
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar);
		//JMenu mnNewMenu = new JMenu("ѧ������");
		
		JMenu menu = new JMenu("\u5B66\u751F\u7BA1\u7406");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u5B66\u751F\u589E\u52A0");
		menu.add(menuItem);
		menuItem.addActionListener(this);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5B66\u751F\u5220\u9664");
		menu.add(menuItem_1);
		menuItem_1.addActionListener(this);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5B66\u751F\u4FEE\u6539");
		menu.add(menuItem_2);
		menuItem_2.addActionListener(this);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5B66\u751F\u67E5\u770B");
		menu.add(menuItem_3);
		menuItem_3.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent arg0) {//add click action and find the match to each item,plus transmit to the 
												  //other files of java.
		// TODO Auto-generated method stub
		if (arg0.getActionCommand()=="ѧ������")
		{
			student_add_frame da=new student_add_frame();
			da.setVisible(true);
		}else 		if (arg0.getActionCommand()=="ѧ��ɾ��")
		{
			student_delete_frame da=new student_delete_frame();
			da.setVisible(true);
		}else 		if (arg0.getActionCommand()=="ѧ���鿴")
		{
			student_select_frame da=new student_select_frame();
			da.setVisible(true);
		}else 		if (arg0.getActionCommand()=="ѧ���޸�")
		{
			student_update_frame da=new student_update_frame();
			da.setVisible(true);
		}
		
		else if (arg0.getActionCommand()=="��ʦ����")
		{
			teacher_add_frame da=new teacher_add_frame();
			da.setVisible(true);
		}else 		if (arg0.getActionCommand()=="��ʦɾ��")
		{
			teacher_delete_frame da=new teacher_delete_frame();
			da.setVisible(true);
		}else 		if (arg0.getActionCommand()=="��ʦ�鿴")
		{
			teacher_select_frame da=new teacher_select_frame();
			da.setVisible(true);
		}else 		if (arg0.getActionCommand()=="��ʦ�޸�")
		{
			teacher_update_frame da=new teacher_update_frame();
			da.setVisible(true);
		}
		
		else if (arg0.getActionCommand()=="����Ա����")
		{
			admini_add_frame da=new admini_add_frame();
			da.setVisible(true);
		}else 		if (arg0.getActionCommand()=="����Աɾ��")
		{
			admini_delete_frame da=new admini_delete_frame();
			da.setVisible(true);
		}else 		if (arg0.getActionCommand()=="����Ա�鿴")
		{
			admini_select_frame da=new admini_select_frame();
			da.setVisible(true);
		}else 		if (arg0.getActionCommand()=="����Ա�޸�")
		{
			admini_update_frame da=new admini_update_frame();
			da.setVisible(true);
		}
	}

}
