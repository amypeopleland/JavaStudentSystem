package operate_admini;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

public class admini_delete_frame extends JFrame {

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
					admini_delete_frame frame = new admini_delete_frame();
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
	public admini_delete_frame() {
		setTitle("\u5220\u9664\u7BA1\u7406\u5458");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 746, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblH = new JLabel("\u5220\u9664\u7F16\u53F7\uFF1A");
		lblH.setBounds(73, 50, 185, 32);
		contentPane.add(lblH);
		
		JLabel label = new JLabel("\u5220\u9664\u59D3\u540D\uFF1A");
		label.setBounds(73, 132, 109, 21);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(208, 55, 269, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){  
                      
                }else{  
                    e.consume(); //关键，屏蔽掉非法输入。
                }  
            }  
		});

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(208, 132, 269, 27);
		contentPane.add(textField_1);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(565, 53, 123, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u786E\u5B9A");
		button_1.setBounds(565, 132, 123, 29);
		contentPane.add(button_1);
		
		
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
						
						PreparedStatement pstmt=con.prepareStatement(" delete Admini where admini_number=?");
						
						pstmt.setInt(1, Integer.parseInt(textField.getText()));
					     
					     pstmt.executeUpdate(); 
					     pstmt.close();
								
						DBCon.getCon().commit();
						JOptionPane.showMessageDialog(null, "删除管理员成功");
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
						
						PreparedStatement pstmt=con.prepareStatement(" delete Admini where admini_name=?");
						pstmt.setString(1, textField_1.getText());	
						
					     
						
					     pstmt.executeUpdate(); 
					     pstmt.close();
					     
//					     pstmt1.executeUpdate(); 
//					     pstmt1.close(); 
								
						DBCon.getCon().commit();
						JOptionPane.showMessageDialog(null, "删除管理员成功");
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
