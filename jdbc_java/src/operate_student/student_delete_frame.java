package operate_student;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import jdbc_15_4_24.DBCon;

public class student_delete_frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_delete_frame frame = new student_delete_frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public student_delete_frame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1004, 799);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5220\u9664\u7F16\u53F7\uFF1A");
		label.setBounds(144, 56, 154, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5220\u9664\u59D3\u540D\uFF1A");
		label_1.setBounds(144, 130, 154, 21);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(310, 56, 265, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(310, 124, 265, 27);
		contentPane.add(textField_1);
		
		JButton button1 = new JButton("\u786E\u5B9A");
		button1.setBounds(708, 66, 123, 29);
		contentPane.add(button1);
		
		JButton button2 = new JButton("\u786E\u5B9A");
		button2.setBounds(708, 124, 123, 29);
		contentPane.add(button2);
		
		
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = null;
					con = DBCon.getCon();
					con.setAutoCommit(true);
					Statement stmt = con.createStatement();
		
					System.out.println("开始插入数据");


					// 创建会话
					try {
						
						PreparedStatement pstmt=con.prepareStatement(" delete Student where stu_number=?");
						
						pstmt.setInt(1, Integer.parseInt(textField.getText()));
							
						
							
//						PreparedStatement pstmt1=con.prepareStatement(" delete Student where stu_name=?");
//							pstmt.setString(1, textField_1.getText());
					     
						
					     pstmt.executeUpdate(); 
					     pstmt.close();
					     
//					     pstmt1.executeUpdate(); 
//					     pstmt1.close();
								
						DBCon.getCon().commit();
						JOptionPane.showMessageDialog(null, "删除学生成功！");
						DBCon.closeAllMethod(con, stmt, null);
					} catch (SQLException e) {
						e.printStackTrace();
					}

				} catch (SQLException e) {
					
					e.printStackTrace();
					System.out.println("数据库连接错误");
					System.exit(0);
				}
			}
			
		});
		
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = null;
					con = DBCon.getCon();
					con.setAutoCommit(true);
					Statement stmt = con.createStatement();
		
					System.out.println("开始插入数据");


					// 创建会话
					try {
						
						PreparedStatement pstmt=con.prepareStatement(" delete Student where stu_name=?");
						pstmt.setString(1, textField_1.getText());	
						
					     
						
					     pstmt.executeUpdate(); 
					     pstmt.close();
					     
//					     pstmt1.executeUpdate(); 
//					     pstmt1.close(); 
								
						DBCon.getCon().commit();
						JOptionPane.showMessageDialog(null, "删除学生成功！");
						DBCon.closeAllMethod(con, stmt, null);
					} catch (SQLException e) {
						e.printStackTrace();
					}

				} catch (SQLException e) {
					
					e.printStackTrace();
					System.out.println("数据库连接错误");
					System.exit(0);
				}
			}
			
		});

	}
}
