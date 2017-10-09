package giaodien;


import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControlGiaoDien;
import control.KetNoiSQL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class GiaoDienThongTinNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoTen;
	private JTextField txtNgaySinh;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JPasswordField txtMatKhau;
	private JTextField txtCMND;
	private JRadioButton rbtnNam, rbtnNu,rbtnKhac;
	GiaoDienDangNhap dn;
	ControlGiaoDien control = new ControlGiaoDien();

	public GiaoDienThongTinNhanVien() throws SQLException {
		setResizable(false);
		setTitle("Thông Tin");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 200, 297, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton(" ");
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setIcon(new ImageIcon(GiaoDienThongTinNhanVien.class.getResource("/ser/edit.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GiaoDienDoiMatKhau().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.setBounds(226, 288, 28, 23);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.decode("#EEEEEE"));
		contentPane.add(btnNewButton);

		txtHoTen = new JTextField();
		txtHoTen.setBounds(76, 139, 195, 20);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);

		JLabel lblHoTen = new JLabel("Họ Tên: ");
		lblHoTen.setBounds(10, 142, 46, 14);
		contentPane.add(lblHoTen);

		JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
		lblNgaySinh.setBounds(10, 192, 65, 14);
		contentPane.add(lblNgaySinh);

		JLabel lblGioiTinh = new JLabel("Giới Tính:");
		lblGioiTinh.setBounds(10, 217, 65, 14);
		contentPane.add(lblGioiTinh);

		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setBounds(10, 242, 46, 14);
		contentPane.add(lblSDT);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setBounds(76, 189, 195, 20);
		contentPane.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);

		txtSDT = new JTextField();
		txtSDT.setBounds(76, 239, 195, 20);
		contentPane.add(txtSDT);
		txtSDT.setColumns(10);

		JLabel lblDiaChi = new JLabel("Địa Chỉ");
		lblDiaChi.setBounds(10, 267, 46, 14);
		contentPane.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(77, 264, 194, 20);
		contentPane.add(txtDiaChi);
		txtDiaChi.setColumns(10);

		JLabel lblMatKhau = new JLabel("Mật Khẩu:");
		lblMatKhau.setBounds(10, 292, 65, 14);
		contentPane.add(lblMatKhau);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(77, 289, 136, 20);
		contentPane.add(txtMatKhau);
		txtMatKhau.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.setIcon(new ImageIcon(GiaoDienThongTinNhanVien.class.getResource("/ser/save.png")));

		btnOk.setBounds(151, 322, 73, 23);
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String diaChiMoi = txtDiaChi.getText()+"";
				String sdtMoi = txtSDT.getText()+"";
				String maNV = dn.txtTK.getText()+"";
				try {
					control.suaDiaChiVaSDT(diaChiMoi, sdtMoi, maNV);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		contentPane.add(btnOk);

		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setBounds(10, 167, 46, 14);
		contentPane.add(lblCMND);

		txtCMND = new JTextField();
		txtCMND.setBounds(76, 164, 195, 20);
		contentPane.add(txtCMND);
		txtCMND.setColumns(10);



		rbtnNam = new JRadioButton("Nam");
		rbtnNam.setBounds(76, 213, 73, 23);
		contentPane.add(rbtnNam);

		rbtnNu = new JRadioButton("Nữ");
		rbtnNu.setBounds(151, 213, 62, 23);
		contentPane.add(rbtnNu);

		rbtnKhac = new JRadioButton("Khác");
		rbtnKhac.setBounds(217, 213, 68, 23);
		contentPane.add(rbtnKhac);


		ButtonGroup gr = new ButtonGroup();
		gr.add(rbtnNam);
		gr.add(rbtnNu);
		gr.add(rbtnKhac);

		txtHoTen.setEditable(false);
		txtCMND.setEditable(false);
		txtDiaChi.setEditable(false);
		txtMatKhau.setEditable(false);
		txtSDT.setEditable(false);
		txtNgaySinh.setEditable(false);
		rbtnKhac.setEnabled(false);
		rbtnNam.setEnabled(false);
		rbtnNu.setEnabled(false);

		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(GiaoDienThongTinNhanVien.class.getResource("/ser/edit.png")));
		btnSua.setBounds(68, 322, 73, 23);
		contentPane.add(btnSua);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GiaoDienThongTinNhanVien.class.getResource("/ser/ava.png")));
		//lblNewLabel.setIcon(new ImageIcon(GiaoDienThongTinNhanVien.class.getResource("/ser/ava.png")));
		lblNewLabel.setBounds(76, 25, 136, 104);
		contentPane.add(lblNewLabel);

		JLabel lblnh = new JLabel("Ảnh");
		lblnh.setBounds(136, 11, 28, 14);
		contentPane.add(lblnh);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtDiaChi.setEditable(true);
				txtSDT.setEditable(true);
			}
		});

		dienDuLieuVaoForm();

	}

	public  void dienDuLieuVaoForm() throws SQLException
	{
		String maNVa = dn.txtTK.getText();
		Connection con =  KetNoiSQL.getInstance().connect();
		try 
		{
			String sql="select * from NhanVien "+"where MaNV=?";
			PreparedStatement pretamt = con.prepareStatement(sql);
			pretamt.setString(1, maNVa);
			ResultSet rs = pretamt.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String gioiTinh= rs.getString(3);
				String ngaySinh = rs.getString(4);
				String sDT = rs.getString(5);
				String diaChi = rs.getString(6);
				String mk = rs.getString(7);
				String cmnd = rs.getString(8);

				txtCMND.setText(cmnd);
				txtNgaySinh.setText(ngaySinh);
				txtSDT.setText(sDT);
				txtMatKhau.setText(mk);
				txtDiaChi.setText(diaChi);
				txtHoTen.setText(ten);
				if (gioiTinh.equals("Nam"))
					rbtnNam.setSelected(true);
				if (gioiTinh.equals("Nữ"))
					rbtnNu.setSelected(true);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			con.close();
		}
	}
}
