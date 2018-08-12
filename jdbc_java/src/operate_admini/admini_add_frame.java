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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class admini_add_frame extends JFrame {

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
					admini_add_frame frame = new admini_add_frame();
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
	public admini_add_frame() {
		
		
		setTitle("\u589E\u52A0\u7BA1\u7406\u4EBA\u5458");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 828, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setBounds(146, 72, 76, 21);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(311, 66, 244, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7F16\u53F7\uFF1A");
		label_1.setBounds(146, 136, 76, 21);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(311, 130, 244, 27);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		

		
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){  
                      
                }else{  
                    e.consume(); 
                }  
            }  
		});
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setBounds(146, 220, 76, 21);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(311, 214, 244, 27);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		JLabel label_3 = new JLabel("\u804C\u4F4D\uFF1A");
		label_3.setBounds(146, 314, 76, 21);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(311, 306, 244, 27);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		JLabel label_4 = new JLabel("\u5DE5\u8D44\uFF1A");
		label_4.setBounds(146, 393, 76, 21);
		contentPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(311, 393, 244, 27);
		textField_4.setColumns(10);
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
		
		JButton button = new JButton("\u786E\u8BA4");
		button.setBounds(311, 524, 69, 29);
		contentPane.add(button);
		
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					Connection con = null;//
					con = DBCon.getCon();
					con.setAutoCommit(true);
					Statement stmt = con.createStatement();
		
					System.out.println("开始插入数据");


					// 创建会话
					try {
						
						PreparedStatement pstmt=con.prepareStatement ("insert into Admini(admini_number,admini_name,admini_sex,admini_position,admini_salary) values(?,?,?,?,?)");
						//use the sql sentence. 
//						 
						//try {
//							 pstmt.setInt(1, Integer.parseInt(textField_1.getText()));
//							
//						} catch (Exception e) {
//							// TODO: handle exception
//							System.out.println("printwrong");
//							textField_1.setText("请重新输入");
//							pstmt.setInt(1, Integer.parseInt(textField_1.getText()));
//							
//							
//						}
						 pstmt.setInt(1, Integer.parseInt(textField_1.getText()));
						 
					     pstmt.setString(2, textField.getText());
					     pstmt.setString(3, textField_2.getText());
					     pstmt.setString(4, textField_3.getText());
					     pstmt.setInt(5, Integer.parseInt(textField_4.getText()));//match the input to each textfield
					     
					     pstmt.executeUpdate(); 
					     pstmt.close();
								
						DBCon.getCon().commit();
						System.out.println("********************");
						System.out.println("添加成功！");
						System.out.println("********************");
						JOptionPane.showMessageDialog(null, "添加管理员成功");//output window shows that you've got the right process.
						DBCon.closeAllMethod(con, stmt, null);
						
						textField.setText("");//reset all the text into null;
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						
						
					} catch (SQLException e) {//in case of die...
						e.printStackTrace();
					}

				} catch (SQLException e) {//same to the die...
					
					e.printStackTrace();
					System.out.println("数据库连接错误");
					System.exit(0);
				}

				
			}
			
		}
		);
		
		
		
	}
}
