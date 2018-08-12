package operate_teacher;

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
import java.awt.GridLayout;
import javax.swing.SpringLayout;

public class teacher_add_frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teacher_add_frame frame = new teacher_add_frame();
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
	public teacher_add_frame() {
		setTitle("\u589E\u52A0\u6559\u5E08");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 897, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		label.setBounds(10, 11, 285, 51);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(300, 11, 285, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		label_5 = new JLabel("");
		label_5.setBounds(590, 11, 285, 100);
		contentPane.add(label_5);
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u7F16\u53F7\uFF1A");
		label_1.setBounds(10, 116, 285, 51);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(300, 116, 285, 46);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		label_6 = new JLabel("");
		label_6.setBounds(590, 116, 285, 100);
		contentPane.add(label_6);
		
		JLabel label_2 = new JLabel("\u6559\u5E08\u6027\u522B\uFF1A");
		label_2.setBounds(10, 221, 285, 51);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(300, 221, 285, 51);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		label_7 = new JLabel("");
		label_7.setBounds(590, 221, 285, 100);
		contentPane.add(label_7);
		
		JLabel label_3 = new JLabel("\u6559\u5E08\u5B66\u79D1\uFF1A");
		label_3.setBounds(10, 326, 285, 46);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(300, 326, 285, 51);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		label_8 = new JLabel("");
		label_8.setBounds(590, 326, 285, 100);
		contentPane.add(label_8);
		
		JLabel label_4 = new JLabel("\u6559\u5E08\u5DE5\u8D44\uFF1A");
		label_4.setBounds(10, 431, 285, 51);
		contentPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(300, 431, 285, 51);
		textField_4.setColumns(10);
		contentPane.add(textField_4);
		
		label_9 = new JLabel("");
		label_9.setBounds(590, 431, 285, 100);
		contentPane.add(label_9);
		
		label_10 = new JLabel("");
		label_10.setBounds(10, 536, 285, 100);
		contentPane.add(label_10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(300, 536, 285, 51);
		contentPane.add(button);
		
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
						
						PreparedStatement pstmt=con.prepareStatement ("insert into Teacher(tea_number,tea_name,tea_sex,tea_subject,tea_salary) values(?,?,?,?,?)");
						 
						 pstmt.setInt(1, Integer.parseInt(textField_1.getText()));
					     pstmt.setString(2, textField.getText());
					     pstmt.setString(3, textField_2.getText());
					     pstmt.setString(4, textField_3.getText());
					     pstmt.setInt(5, Integer.parseInt(textField_4.getText()));
					     
					     pstmt.executeUpdate(); 
					     pstmt.close();
								
						DBCon.getCon().commit();
						JOptionPane.showMessageDialog(null, "添加教师成功");
						DBCon.closeAllMethod(con, stmt, null);
						
						
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
		
		label_11 = new JLabel("");
		label_11.setBounds(590, 536, 285, 100);
		contentPane.add(label_11);
	}
}
