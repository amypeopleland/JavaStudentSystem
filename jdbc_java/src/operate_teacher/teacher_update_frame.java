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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

public class teacher_update_frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teacher_update_frame frame = new teacher_update_frame();
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
	public teacher_update_frame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 879, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("152px"),
				ColumnSpec.decode("118px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("271px"),
				ColumnSpec.decode("89px"),
				ColumnSpec.decode("123px"),},
			new RowSpec[] {
				RowSpec.decode("59px"),
				RowSpec.decode("35px"),
				RowSpec.decode("32px"),
				RowSpec.decode("27px"),
				RowSpec.decode("47px"),
				RowSpec.decode("27px"),
				RowSpec.decode("49px"),
				RowSpec.decode("27px"),
				RowSpec.decode("28px"),
				RowSpec.decode("34px"),
				RowSpec.decode("142px"),
				RowSpec.decode("29px"),}));
		
		JLabel label = new JLabel("\u6559\u5E08\u7F16\u53F7\uFF1A");
		contentPane.add(label, "2, 2, fill, center");
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		contentPane.add(label_1, "2, 4, left, bottom");
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		contentPane.add(label_2, "2, 6, left, top");
		
		JLabel label_3 = new JLabel("\u5B66\u79D1\uFF1A");
		contentPane.add(label_3, "2, 8, left, bottom");
		
		JLabel label_4 = new JLabel("\u5DE5\u8D44\uFF1A");
		contentPane.add(label_4, "2, 10, left, top");
		
		textField = new JTextField();
		contentPane.add(textField, "4, 2, fill, bottom");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		contentPane.add(textField_1, "4, 4, fill, top");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		contentPane.add(textField_2, "4, 6, fill, top");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		contentPane.add(textField_3, "4, 8, fill, top");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		contentPane.add(textField_4, "4, 10, fill, bottom");
		
		button = new JButton("\u786E\u5B9A");
		contentPane.add(button, "4, 12, center, top");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = null;
					con = DBCon.getCon();
					con.setAutoCommit(true);
					Statement stmt = con.createStatement();
		
					System.out.println("开始更新数据");


					// 创建会话
					try {
						
						 PreparedStatement pstmt=con.prepareStatement(" update Teacher set tea_name=?,tea_sex=?,tea_subject=?,tea_salary=? where tea_number=?");
					     pstmt.setString(1, textField_1.getText());
					     pstmt.setString(2, textField_2.getText());
					     pstmt.setString(3, textField_3.getText());
					     pstmt.setInt(4, Integer.parseInt(textField_4.getText()));
					     pstmt.setString(5, textField.getText());
					     
						
					     pstmt.executeUpdate(); 
					     pstmt.close();
					    
								
						DBCon.getCon().commit();
						JOptionPane.showMessageDialog(null, "更新教师成功！");
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
