package operate_student;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import jdbc_15_4_24.DBCon;

public class student_update_frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_update_frame frame = new student_update_frame();
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
	public student_update_frame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 938, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5B66\u53F7\uFF1A");
		label.setBounds(137, 27, 171, 40);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setBounds(136, 73, 127, 30);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setBounds(137, 134, 127, 30);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5B66\u79D1\uFF1A");
		label_3.setBounds(137, 184, 127, 30);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u6210\u7EE9\uFF1A");
		label_4.setBounds(137, 247, 81, 21);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(239, 27, 343, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(239, 73, 343, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(239, 134, 343, 30);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(239, 184, 343, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(239, 238, 343, 30);
		contentPane.add(textField_4);
		
		JButton button = new JButton("\u66F4\u65B0");
		button.setBounds(328, 355, 123, 29);
		contentPane.add(button);
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = null;
					con = DBCon.getCon();
					con.setAutoCommit(true);
					Statement stmt = con.createStatement();
		
					System.out.println("开始插入数据");


					// 创建会话
					try {
						
						 PreparedStatement pstmt=con.prepareStatement(" update Student set stu_name=?,stu_sex=?,stu_subject=?,stu_score=? where stu_number=?");
					     pstmt.setString(1, textField_1.getText());
					     pstmt.setString(2, textField_2.getText());
					     pstmt.setString(3, textField_3.getText());
					     pstmt.setInt(4, Integer.parseInt(textField_4.getText()));
					     pstmt.setString(5, textField.getText());
					     
						
					     pstmt.executeUpdate(); 
					     pstmt.close();
					    
								
						DBCon.getCon().commit();
						JOptionPane.showMessageDialog(null, "更新成功！");
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
