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
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;


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

		JLabel lblTaiKhoan = new JLabel("Tài Khoản: ");
		lblTaiKhoan.setBounds(137, 301, 75, 24);
		contentPane.add(lblTaiKhoan);
		lblTaiKhoan.setRequestFocusEnabled(false);
		lblTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtTK = new JTextField();
		txtTK.setBounds(222, 303, 211, 24);
		contentPane.add(txtTK);
		txtTK.requestFocus();
		txtTK.setColumns(10);

		JLabel lblMatKhau = new JLabel("Mật Khẩu: ");
		lblMatKhau.setBounds(136, 349, 75, 24);
		contentPane.add(lblMatKhau);
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtMK = new JPasswordField();
		txtMK.setBounds(222, 351, 211, 24);
		contentPane.add(txtMK);
		txtMK.setColumns(10);


		btnDangNhap = new JButton("  Đăng Nhập");
		btnDangNhap.setToolTipText("Enter");
		btnDangNhap.setBounds(128, 398, 140, 30);
		contentPane.add(btnDangNhap);
		btnDangNhap.setActionCommand("DangNhap");
		btnDangNhap.setHorizontalAlignment(SwingConstants.LEFT);
		btnDangNhap.setIcon(new ImageIcon(GiaoDienDangNhap.class.getResource("/ser/log_in.png")));
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnThoat = new JButton("   Thoát");
		btnThoat.setToolTipText("Esc");
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThoat.setBounds(278, 398, 143, 30);
		contentPane.add(btnThoat);
		btnThoat.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnThoat.setHorizontalAlignment(SwingConstants.LEFT);
		btnThoat.setIcon(new ImageIcon(GiaoDienDangNhap.class.getResource("/ser/exit.png")));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GiaoDienDangNhap.class.getResource("/ser/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 794, 535);
		contentPane.add(lblNewLabel);
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		btnDangNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Id=txtTK.getText();
				char[] pass =txtMK.getPassword();
				String mk=new String(pass);
				try {
					NhanVien nv = control.docDuLieuNhanVien(Id);
					Component plDangNhap=null;
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
		//
		LoadTaiKhoan();
		//--------------------phím tắt-------------
		txtTK.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					btnDangNhap.doClick();
				}
			}
		});
		txtMK.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					btnDangNhap.doClick();
				}
			}
		});
		txtMK.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
				{
					btnThoat.doClick();
				}
			}
		});
		txtTK.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
				{
					btnThoat.doClick();
				}
			}
		});
		//-----------------------------------------

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
