package operate_student;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc_15_4_24.DBCon;

public class student_select_frame extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=-25,10
	 */
	private final Panel panel = new Panel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_select_frame frame = new student_select_frame();
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
	public student_select_frame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 753, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(10, 0, 508, 592);
		contentPane.add(panel_1);
		panel.setLayout(null);
		
		try {
			Connection con = null;
			con = DBCon.getCon();
			con.setAutoCommit(true);
			Statement stmt = con.createStatement();

			System.out.println("开始查询数据");


			// 创建会话
			try {
				
				PreparedStatement pstmt=con.prepareStatement("select * from Student");
				ResultSet rs=pstmt.executeQuery();
				int i=0;
			     while(rs.next()){
			    	 JLabel jl=new JLabel();
			    	 jl.setLocation(100, i*30);
			    	 String stu_number=rs.getString("stu_number");
			    	 String stu_name=rs.getString("stu_name");
			    	 String stu_sex=rs.getString("stu_sex");
			    	 String stu_subject=rs.getString("stu_subject");
			    	 String stu_score=rs.getString("stu_score");
			    	 
			    	 
			    	 jl.setText("编号："+stu_number+"name："+stu_name+"sex："+stu_sex+"subject："+stu_subject+"医院编号："+stu_score);
			    	 jl.setSize(500,30);
			    	 panel_1.add(jl);
			    	 i++;
			    }
			     
				
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


