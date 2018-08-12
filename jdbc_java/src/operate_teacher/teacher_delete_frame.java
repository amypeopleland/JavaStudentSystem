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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class teacher_delete_frame extends JFrame {

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
					teacher_delete_frame frame = new teacher_delete_frame();
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
	public teacher_delete_frame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 592, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5220\u9664\u7F16\u53F7\uFF1A");
		label.setBounds(39, 77, 98, 21);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(184, 71, 137, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(364, 69, 123, 29);
		contentPane.add(button);
		
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = null;
					con = DBCon.getCon();
					con.setAutoCommit(true);
					Statement stmt = con.createStatement();
		
					System.out.println("开始删除数据");


					// 创建会话
					try {
						
						PreparedStatement pstmt=con.prepareStatement(" delete Teacher where tea_number=?");
						
						pstmt.setInt(1, Integer.parseInt(textField.getText()));
							
						
							
//						PreparedStatement pstmt1=con.prepareStatement(" delete Student where stu_name=?");
//							pstmt.setString(1, textField_1.getText());
					     
						
					     pstmt.executeUpdate(); 
					     pstmt.close();
					     
//					     pstmt1.executeUpdate(); 
//					     pstmt1.close();
								
						DBCon.getCon().commit();
						JOptionPane.showMessageDialog(null, "删除教师成功！");
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
		
		JLabel label_1 = new JLabel("\u5220\u9664\u59D3\u540D\uFF1A");
		label_1.setBounds(39, 143, 98, 21);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 137, 137, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("\u786E\u5B9A");
		button_1.setBounds(364, 135, 123, 29);
		contentPane.add(button_1);
		
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = null;
					con = DBCon.getCon();
					con.setAutoCommit(true);
					Statement stmt = con.createStatement();
		
					System.out.println("开始插入数据");


					// 创建会话
					try {
						
						PreparedStatement pstmt=con.prepareStatement(" delete Teacher where tea_name=?");
						pstmt.setString(1, textField_1.getText());	
						
					     
						
					     pstmt.executeUpdate(); 
					     pstmt.close();
					     
//					     pstmt1.executeUpdate(); 
//					     pstmt1.close(); 
								
						DBCon.getCon().commit();
						JOptionPane.showMessageDialog(null, "删除教师成功！");
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
