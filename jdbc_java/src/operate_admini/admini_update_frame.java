package operate_admini;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
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

public class admini_update_frame extends JFrame {

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
					admini_update_frame frame = new admini_update_frame();
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
	public admini_update_frame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 799, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7F16\u53F7\uFF1A");
		label.setBounds(166, 65, 81, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setBounds(166, 129, 81, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setBounds(166, 190, 81, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u804C\u4F4D\uFF1A");
		label_3.setBounds(166, 258, 81, 21);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u5DE5\u8D44\uFF1A");
		label_4.setBounds(166, 308, 81, 21);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(251, 59, 277, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){  
                      
                }else{  
                    e.consume(); 
                }  
            }  
		});
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(253, 129, 275, 27);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(251, 190, 277, 27);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(253, 252, 275, 27);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(251, 308, 277, 27);
		contentPane.add(textField_4);
		
		textField_4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){  
                      
                }else{  
                    e.consume(); 
                }  
            }  
		});
		
		JButton button_1 = new JButton("\u786E\u5B9A");
		button_1.setBounds(312, 397, 123, 29);
		contentPane.add(button_1);
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = null;
					con = DBCon.getCon();
					con.setAutoCommit(true);
					Statement stmt = con.createStatement();
		
					System.out.println("开始更新数据");


					// 创建会话
					try {
						
						 PreparedStatement pstmt=con.prepareStatement(" update Admini set admini_name=?,admini_sex=?,admini_position=?,admini_salary=? where admini_number=?");
					     pstmt.setString(1, textField_1.getText());
					     pstmt.setString(2, textField_2.getText());
					     pstmt.setString(3, textField_3.getText());
					     pstmt.setInt(4, Integer.parseInt(textField_4.getText()));
					     pstmt.setString(5, textField.getText());
					     
						
					     pstmt.executeUpdate(); 
					     pstmt.close();
					    
								
						DBCon.getCon().commit();
						JOptionPane.showMessageDialog(null, "修改管理员成功");
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
