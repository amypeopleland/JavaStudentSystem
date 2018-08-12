package operate_student;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javax.swing.JInternalFrame;
import java.awt.Panel;
import java.beans.PropertyVetoException;

import javax.swing.JTextPane;

public class student_add_frame extends JFrame {

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
					student_add_frame frame = new student_add_frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public student_add_frame() {
		setTitle("\u589E\u52A0\u5B66\u751F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 694, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setBounds(128, 35, 81, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5B66\u53F7\uFF1A");
		label_1.setBounds(128, 106, 81, 21);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel.setBounds(128, 157, 81, 21);
		contentPane.add(lblNewLabel);
		
		JLabel label_2 = new JLabel("\u5B66\u79D1\uFF1A");
		label_2.setBounds(128, 221, 81, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u6210\u7EE9\uFF1A");
		label_3.setBounds(128, 280, 81, 21);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(241, 29, 232, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(241, 106, 232, 27);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(241, 151, 232, 27);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(241, 215, 232, 27);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(241, 274, 232, 27);
		contentPane.add(textField_4);
		
		JButton button = new JButton("\u786E\u8BA4");
		
		
		
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					Connection con = null;
					con = DBCon.getCon();
					con.setAutoCommit(true);
					Statement stmt = con.createStatement();
		
					System.out.println("开始插入数据");


					// 创建会话
					try {
						
						PreparedStatement pstmt=con.prepareStatement ("insert into Student(stu_number,stu_name,stu_sex,stu_subject,stu_score) values(?,?,?,?,?)");
						 
						 pstmt.setInt(1, Integer.parseInt(textField_1.getText()));
					     pstmt.setString(2, textField.getText());
					     pstmt.setString(3, textField_2.getText());
					     pstmt.setString(4, textField_3.getText());
					     pstmt.setInt(5, Integer.parseInt(textField_4.getText()));
					     
					     pstmt.executeUpdate(); 
					     pstmt.close();
								
						DBCon.getCon().commit();
						DBCon.closeAllMethod(con, stmt, null);
						
//						Confirm_add add_frame=new Confirm_add();
//						add_frame.setVisible(true);
						JOptionPane.showMessageDialog(null, "添加学生成功！");
						
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						
						
					} catch (SQLException e) {
						e.printStackTrace();
					}

				} catch (SQLException e) {
					
					e.printStackTrace();
					System.out.println("数据库连接错误");
					System.exit(0);
				}

				
			}
			
		}
		);
		button.setBounds(253, 358, 123, 29);
		contentPane.add(button);
	}
}
