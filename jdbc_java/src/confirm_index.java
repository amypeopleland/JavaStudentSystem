import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import jdbc_15_4_24.DBCon;

import com.jgoodies.forms.factories.Borders.EmptyBorder;


public class confirm_index extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	ResultSet rs;
	String user,pwd;
	private JTextField textField_1;
	private JPasswordField passwordField;
	//String[] pwd=new String[2];

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					confirm_index frame = new confirm_index();
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
	
	public confirm_index() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
	//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		 
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setBounds(62, 43, 81, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setBounds(62, 94, 81, 21);
		contentPane.add(label_1);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.setBounds(135, 164, 200, 50);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setBounds(135, 26, 188, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
//		textField_1 = new JTextField();
//		textField_1.setBounds(161, 88, 96, 27);
//		contentPane.add(textField_1);
//		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(135, 94, 185, 32);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 428, 245);
		contentPane.add(lblNewLabel);
		
		try {
			Connection con = null;
			con = DBCon.getCon();
			con.setAutoCommit(true);
			Statement stmt = con.createStatement();

			System.out.println("开始查询数据");
			try {

				PreparedStatement pstmt = con
						.prepareStatement("select * from Login");
				rs = pstmt.executeQuery();
				int i = 0;
				  while (rs.next()) {
					    user = rs.getString("user_name");
					    
					    pwd = rs.getString("password").trim();
					   }
				button.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
//							String a;
//							a=textField_1.getText().trim();
//							if(a.equals(pwd.trim())==true){
//								JOptionPane.showMessageDialog(null, "tanchuduihuakuang");
//							}
//							else{
//								JOptionPane.showMessageDialog(null, "xxxuang");
//							}//通过文本框进行输入
							
							
							String b;
							b=String.valueOf (passwordField.getPassword());
							
							String name;
							name=textField.getText().trim();
							
							if(b.equals(pwd)==true && name.equals(user.trim())==true){
//								JOptionPane.showMessageDialog(null, "登陆成功");
								dispose();
								Out da=new Out();
								da.main(null);
								
								
							}
							else{
								JOptionPane.showMessageDialog(null, "登录失败");
							}
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				
				});
				rs.close();
				pstmt.close();
				System.out.println("********************");
				System.out.println("查询成功！");
				System.out.println("********************");
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
}
