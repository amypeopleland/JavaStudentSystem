package operate_admini;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc_15_4_24.DBCon;

public class admini_select_frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admini_select_frame frame = new admini_select_frame();
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
	public admini_select_frame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 865, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 535, 611);
		contentPane.add(panel);

		try {
			Connection con = null;
			con = DBCon.getCon();
			con.setAutoCommit(true);
			Statement stmt = con.createStatement();

			System.out.println("开始查询数据");
			try {

				PreparedStatement pstmt = con
						.prepareStatement("select * from Admini");
				ResultSet rs = pstmt.executeQuery();
				int i = 0;
				while (rs.next()) {
					JLabel jl = new JLabel();
					jl.setLocation(100, i * 30);
					String admini_number = rs.getString("admini_number");
					String admini_name = rs.getString("admini_name");
					String admini_sex = rs.getString("admini_sex");
					String admini_position = rs.getString("admini_position");
					String admini_salary = rs.getString("admini_salary");

					jl.setText("number：" + admini_number+ "name："
							+ admini_name + "sex：" + admini_sex + "position："
							+ admini_position + "salary:：" + admini_salary);
					jl.setSize(500, 30);
					panel.add(jl);
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
