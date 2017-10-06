package giaodien;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControlGiaoDien;
import entity.NhanVien;
import giaodien.NhanVien.GiaoDienNhanVien;
import giaodien.QuanLy.GiaoDienQuanLy;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;


public class GiaoDienDangNhap extends JFrame {

	private JPanel contentPane;
	public static  JTextField txtTK;
	public static JPasswordField txtMK;
	private JButton btnDangNhap;
	ControlGiaoDien control = new ControlGiaoDien();
	public GiaoDienDangNhap() throws SQLException {
		setForeground(new Color(255, 255, 255));
		setResizable(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 800, 562);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTieuDe = new JLabel("HỆ THỐNG QUẢN LÝ QUẦY THUỐC");
		lblTieuDe.setForeground(new Color(139, 0, 0));
		lblTieuDe.setBackground(Color.WHITE);
		lblTieuDe.setToolTipText("");
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTieuDe.setBounds(10, 23, 627, 85);
		contentPane.add(lblTieuDe);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(76, 304, 425, 193);
		contentPane.add(tabbedPane);

		JPanel plDangNhap = new JPanel();
		plDangNhap.setOpaque(false);
		tabbedPane.addTab("Đăng nhập: ", null, plDangNhap, null);
		plDangNhap.setLayout(null);

		JLabel lblTaiKhoan = new JLabel("Tài Khoản: ");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTaiKhoan.setBounds(26, 27, 86, 24);
		plDangNhap.add(lblTaiKhoan);

		txtTK = new JTextField();
		txtTK.setBounds(122, 27, 238, 24);
		plDangNhap.add(txtTK);
		txtTK.setColumns(10);

		JLabel lblMatKhau = new JLabel("Mật Khẩu: ");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatKhau.setBounds(26, 62, 86, 24);
		plDangNhap.add(lblMatKhau);

		txtMK = new JPasswordField();
		txtMK.setBounds(122, 62, 238, 24);
		plDangNhap.add(txtMK);
		txtMK.setColumns(10);


		JCheckBox chkLuu = new JCheckBox("Duy trì đăng nhập");
		chkLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chkLuu.isSelected())
				{
				}
			}
		});
		chkLuu.setOpaque(false);
		chkLuu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkLuu.setBounds(132, 89, 139, 29);
		plDangNhap.add(chkLuu);


		btnDangNhap = new JButton("  Đăng Nhập");
		btnDangNhap.setHorizontalAlignment(SwingConstants.LEFT);
		btnDangNhap.setIcon(new ImageIcon(GiaoDienDangNhap.class.getResource("/ser/log_in.png")));
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDangNhap.setBounds(83, 125, 130, 30);
		plDangNhap.add(btnDangNhap);

		JButton btnThoat = new JButton("   Thoát");
		btnThoat.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnThoat.setHorizontalAlignment(SwingConstants.LEFT);
		btnThoat.setIcon(new ImageIcon(GiaoDienDangNhap.class.getResource("/ser/exit.png")));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnThoat.setBounds(245, 126, 130, 30);
		plDangNhap.add(btnThoat);

		btnDangNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Id=txtTK.getText();
				char[] pass =txtMK.getPassword();
				String mk=new String(pass);
				try {
					NhanVien nv = control.docDuLieuNhanVien(Id);
					if(nv!=null)
					{
						if(nv.getPass().equals(mk))
						{
							if(control.PhanQuyenNV(nv)==true)
							{
								new GiaoDienQuanLy().setVisible(true);
								dispose();
							}
							else
							{
								new GiaoDienNhanVien().setVisible(true);
								dispose();

							}
						}
						else
							JOptionPane.showMessageDialog(plDangNhap,"Tài khoản hoặc mật khẩu sai");
					}
					else
						JOptionPane.showMessageDialog(plDangNhap,"Tài khoản hoặc mật khẩu sai");
				} 
				catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JTextArea txtAGioiThieu = new JTextArea();
		txtAGioiThieu.setOpaque(false);
		txtAGioiThieu.setSelectionColor(Color.WHITE);
		txtAGioiThieu.setBackground(Color.WHITE);
		txtAGioiThieu.setEditable(false);
		txtAGioiThieu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAGioiThieu.setForeground(new Color(0, 0, 0));
		txtAGioiThieu.setText("NHÓM 09: HỆ THỐNG QUẢN LÝ QUẦY THUỐC CỦA BỆNH VIỆN\r\n  "
				+ "Các thành viên thực hiện:\r\n\t- Trần Đình Chiến \t\t15091761\r\n\t- "
				+ "Nguyễn Văn Mạnh Cường\t\t15051431\r\n\t- "
				+ "Trần Hùng Cường\t\t15056921\r\n "
				+ "Đồ án môn: Phát triển ứng dụng (Có đồ án)\r\n "
				+ "GV: Võ Thị Thanh Vân\r\n Lớp DHKTPM11A - Khoa CNTT Đại học Công Nghiệp TPHCM");
		tabbedPane.addTab("Thông tin:", null, txtAGioiThieu, null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(GiaoDienDangNhap.class.getResource("/ser/logobv.png")));
		lblLogo.setBounds(28, 87, 200, 154);
		contentPane.add(lblLogo);

		JLabel lblSDT = new JLabel("Điện thoại: (028) 9234675");
		lblSDT.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSDT.setBounds(38, 252, 132, 20);
		contentPane.add(lblSDT);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(GiaoDienDangNhap.class.getResource("/ser/logo_iuh.png")));
		lblNewLabel_1.setBounds(679, 466, 105, 44);
		contentPane.add(lblNewLabel_1);

		JLabel lblbanquyen = new JLabel("Made by cCc ");
		lblbanquyen.setForeground(Color.LIGHT_GRAY);
		lblbanquyen.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblbanquyen.setBounds(693, 509, 91, 26);
		contentPane.add(lblbanquyen);

		JLabel lblDiachi = new JLabel("766 Võ Văn Kiệt, Phường 1, Quận 5, TP. HCM");
		lblDiachi.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblDiachi.setBounds(10, 228, 232, 26);
		contentPane.add(lblDiachi);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GiaoDienDangNhap.class.getResource("/ser/20160929154306.jpg")));
		lblNewLabel.setBounds(0, 0, 800, 535);
		contentPane.add(lblNewLabel);
		//
		LoadTaiKhoan();
	}

	public void LoadTaiKhoan()
	{
		String filename="data.txt";
		BufferedReader br =null;
		try
		{
			if(new File(filename).exists())
			{
				br = new BufferedReader(new FileReader(filename));
				br.readLine();
				while(br.ready())
				{
					String line = br.readLine();
					if(line !=null && !line.equals("") )
					{
						String[] c = line.split(";");
						txtTK.setText(c[0]);
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
