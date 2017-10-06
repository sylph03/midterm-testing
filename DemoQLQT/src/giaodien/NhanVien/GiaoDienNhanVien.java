package giaodien.NhanVien;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.ControlGiaoDien;
import control.DanhSachDuLieu;
import entity.HoaDonBanHang;
import entity.ThongTinThuoc;
import giaodien.GiaoDienDangNhap;
import giaodien.GiaoDienThongTinNhanVien;
import giaodien.QuanLy.GiaoDienQuanLy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.ScrollPane;
import java.awt.Panel;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.Label;

public class GiaoDienNhanVien extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPaneDanhSachThuoc,scrollPaneDanhSachDon,scrollPaneCTHD,scrollPaneDoanhThu;
	private DefaultTableModel tablemodel,tablemodel2,tableModel3,tablemodel4;
	JTable tableDanhSachThuoc,tableDanhSachDon,tableCTHD,tableDoanhThu ;
	ControlGiaoDien control = new ControlGiaoDien();
	DanhSachDuLieu ds = new DanhSachDuLieu();
	GiaoDienDangNhap dn;
	public String IDNhanVien=dn.txtTK.getText();
	private JTextField txtMaHD;
	private JTextField txtNgayLAp_timkiem;
	private JTextField txtNguoiLap_timkiem;
	private JTextField txtTongTien_timkiem;
	private JTextField textField;

	public GiaoDienNhanVien() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("aaaa.jpg"));

		setTitle("Nhân Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBounds(0, 0, 794, 21);
		contentPane.add(menuBar);
		menuBar.setOpaque(false);

		JMenu mnNewMenu = new JMenu("Hệ thống");
		menuBar.add(mnNewMenu);

		JMenuItem mntmngXut = new JMenuItem("Đăng xuất");
		mntmngXut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					new GiaoDienDangNhap().setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmngXut);

		JMenuItem mntmNewMenuItem = new JMenuItem("Thoát");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		JMenu menuTroGiup = new JMenu("Trợ giúp");
		menuBar.add(menuTroGiup);

		JMenuItem itemMnThongTinSanPham = new JMenuItem("Thông tin sản phẩm");
		menuTroGiup.add(itemMnThongTinSanPham);

		JMenuItem mntmHngDnS = new JMenuItem("Hướng dẫn sử dụng");
		menuTroGiup.add(mntmHngDnS);


		JPanel ThanhToolBar = new JPanel();
		ThanhToolBar.setOpaque(false);
		ThanhToolBar.setBounds(0, 24, 794, 80);
		contentPane.add(ThanhToolBar);
		ThanhToolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));

		JToolBar toolBar = new JToolBar();
		toolBar.setMinimumSize(new Dimension(0, 0));
		ThanhToolBar.add(toolBar);
		toolBar.setVerifyInputWhenFocusTarget(false);

		JButton btnTrangDangNhap = new JButton("Trang chủ");
		btnTrangDangNhap.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTrangDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTrangDangNhap.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTrangDangNhap.setVerticalAlignment(SwingConstants.TOP);
		btnTrangDangNhap.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTrangDangNhap.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/home.png")));
		btnTrangDangNhap.setPreferredSize(new Dimension(100, 75));
		btnTrangDangNhap.setMaximumSize(new Dimension(100, 100));
		toolBar.add(btnTrangDangNhap);

		JButton btnNhanVien = new JButton("Thông Tin");
		btnNhanVien.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNhanVien.setVerticalAlignment(SwingConstants.TOP);
		btnNhanVien.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNhanVien.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/preferences_desktop_user.png")));
		btnNhanVien.setPreferredSize(new Dimension(100, 75));
		btnNhanVien.setMaximumSize(new Dimension(100, 100));
		toolBar.add(btnNhanVien);
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 11));

		JButton btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLapHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GiaoDienLapHoaDon().setVisible(true);
			}
		});
		toolBar.add(btnLapHoaDon);
		btnLapHoaDon.setIcon(new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/bill.png")));
		btnLapHoaDon.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLapHoaDon.setVerticalAlignment(SwingConstants.TOP);
		btnLapHoaDon.setPreferredSize(new Dimension(100, 75));
		btnLapHoaDon.setMaximumSize(new Dimension(100, 100));
		btnLapHoaDon.setHorizontalTextPosition(SwingConstants.CENTER);



		JButton btnDangXuat = new JButton("Đăng xuất");
		toolBar.add(btnDangXuat);
		btnDangXuat.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDangXuat.setVerticalAlignment(SwingConstants.TOP);
		btnDangXuat.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDangXuat.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/application_exit.png")));
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dispose();
					new GiaoDienDangNhap().setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDangXuat.setPreferredSize(new Dimension(100, 75));
		btnDangXuat.setMaximumSize(new Dimension(100, 100));

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 11));
		toolBar.add(btnThoat);
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnThoat.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnThoat.setVerticalAlignment(SwingConstants.TOP);
		btnThoat.setHorizontalTextPosition(SwingConstants.CENTER);
		btnThoat.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/exit (1).png")));
		btnThoat.setPreferredSize(new Dimension(100, 75));
		btnThoat.setMaximumSize(new Dimension(100, 100));


		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new GiaoDienThongTinNhanVien().setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});				

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setVerifyInputWhenFocusTarget(false);
		tabbedPane.setBounds(10, 131, 774, 404);
		contentPane.add(tabbedPane);

		String[] header="Mã thuốc;Tên thuốc;Loại thuốc;Nhà cung cấp".split(";");
		tablemodel = new DefaultTableModel(header,0);

		String[] header2="Mã đơn;Ngày lập;Người Lập;Tổng tiền".split(";");
		tablemodel2 = new DefaultTableModel(header2,0);
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh sách thuốc", null, scrollPaneDanhSachThuoc=new JScrollPane(tableDanhSachThuoc=new JTable(tablemodel)), null);
		scrollPaneDanhSachThuoc.setWheelScrollingEnabled(false);
		
		JPanel panelDSHD = new JPanel(); 
		tabbedPane.addTab("Danh sách hóa đơn", null, panelDSHD, null);
		panelDSHD.setLayout(null);
		tabbedPane.addTab("Danh sách hóa đơn", null, scrollPaneDanhSachDon = new JScrollPane(tableDanhSachDon = new JTable(tablemodel2)));
		scrollPaneDanhSachDon.setBounds(52, 49, 690, 249);
		panelDSHD.add(scrollPaneDanhSachDon);
		
		JLabel lblNgayLap_timkiem = new JLabel("Ngày lập: ");
		lblNgayLap_timkiem.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNgayLap_timkiem.setBounds(158, 21, 67, 14);
		panelDSHD.add(lblNgayLap_timkiem);
		
		JComboBox cbbNgay = new JComboBox();
		cbbNgay.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbbNgay.setBounds(235, 18, 52, 20);
		panelDSHD.add(cbbNgay);
		
		JComboBox cbbThang = new JComboBox();
		cbbThang.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cbbThang.setBounds(297, 18, 52, 20);
		panelDSHD.add(cbbThang);
		
		JComboBox cbbNam = new JComboBox();
		cbbNam.setModel(new DefaultComboBoxModel(new String[] {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2017", "2018"}));
		cbbNam.setBounds(359, 18, 61, 20);
		panelDSHD.add(cbbNam);
		
		JButton btnTim_DSHoaDon = new JButton("Tìm");
		btnTim_DSHoaDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTim_DSHoaDon.setIcon(new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/search.png")));
		btnTim_DSHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim_DSHoaDon.setBounds(438, 18, 85, 20);
		panelDSHD.add(btnTim_DSHoaDon);
		
		JButton btnNewButton = new JButton("Xem chi tiết");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnNewButton.setIcon(new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/view_details.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(335, 318, 141, 45);
		panelDSHD.add(btnNewButton);
		
		JPanel panelCTHD = new JPanel();
		tabbedPane.addTab("Chi tiết hóa đơn", new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/more_01.png")), panelCTHD, null);
		panelCTHD.setLayout(null);
		panelCTHD.setEnabled(false);
		
		JLabel lblMa = new JLabel("Mã hóa đơn:");
		lblMa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMa.setBounds(85, 20, 77, 14);
		panelCTHD.add(lblMa);
		
		txtMaHD = new JTextField();
		txtMaHD.setEditable(false);
		txtMaHD.setEnabled(false);
		txtMaHD.setBounds(172, 17, 86, 20);
		panelCTHD.add(txtMaHD);
		txtMaHD.setColumns(10);
		
		JLabel lblNgay = new JLabel("Ngày lập:");
		lblNgay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNgay.setBounds(297, 20, 62, 14);
		panelCTHD.add(lblNgay);
		
		txtNgayLAp_timkiem = new JTextField();
		txtNgayLAp_timkiem.setEnabled(false);
		txtNgayLAp_timkiem.setEditable(false);
		txtNgayLAp_timkiem.setBounds(366, 17, 108, 20);
		panelCTHD.add(txtNgayLAp_timkiem);
		txtNgayLAp_timkiem.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Người lập:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(511, 20, 67, 14);
		panelCTHD.add(lblNewLabel_3);
		
		txtNguoiLap_timkiem = new JTextField();
		txtNguoiLap_timkiem.setText(IDNhanVien);
		txtNguoiLap_timkiem.setEditable(false);
		txtNguoiLap_timkiem.setEnabled(false);
		txtNguoiLap_timkiem.setBounds(588, 17, 86, 20);
		panelCTHD.add(txtNguoiLap_timkiem);
		txtNguoiLap_timkiem.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tổng tiền:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(478, 336, 62, 14);
		panelCTHD.add(lblNewLabel);
		
		txtTongTien_timkiem = new JTextField();
		txtTongTien_timkiem.setEditable(false);
		txtTongTien_timkiem.setEnabled(false);
		txtTongTien_timkiem.setBounds(550, 333, 140, 20);
		panelCTHD.add(txtTongTien_timkiem);
		txtTongTien_timkiem.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Danh sách thuốc bán:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(70, 66, 136, 14);
		panelCTHD.add(lblNewLabel_2);
		String[] headerCTHD="Tên thuốc;Số lượng;Đơn vị tính;Đơn giá".split(";");
		tableModel3 = new DefaultTableModel(headerCTHD,30);

		panelCTHD.add(scrollPaneCTHD =  new JScrollPane(tableCTHD = new JTable(tableModel3)));
		scrollPaneCTHD.setBounds(70, 81, 620, 241);

		JPanel panelDoanhThu = new JPanel();
		tabbedPane.addTab("Xem tổng doanh thu", null, panelDoanhThu, null);
		panelDoanhThu.setLayout(null);

		JLabel lblChon = new JLabel("Chọn mốc thời gian:");
		lblChon.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChon.setBounds(10, 11, 125, 48);
		panelDoanhThu.add(lblChon);

		JComboBox comboBoxNgay_DoanhThu = new JComboBox();
		comboBoxNgay_DoanhThu.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxNgay_DoanhThu.setBounds(123, 64, 58, 26);
		panelDoanhThu.add(comboBoxNgay_DoanhThu);

		JComboBox comboBoxThang_DoanhThu = new JComboBox();
		comboBoxThang_DoanhThu.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxThang_DoanhThu.setBounds(236, 64, 58, 26);
		panelDoanhThu.add(comboBoxThang_DoanhThu);

		JComboBox comboBoxNam_DoanhThu = new JComboBox();
		comboBoxNam_DoanhThu.setModel(new DefaultComboBoxModel(new String[] {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2017", "2018"}));
		comboBoxNam_DoanhThu.setBounds(345, 64, 58, 26);
		comboBoxNam_DoanhThu.setMaximumRowCount(1);
		panelDoanhThu.add(comboBoxNam_DoanhThu);

		JLabel lblNewLabel_1 = new JLabel("Ngày:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(83, 70, 52, 14);
		panelDoanhThu.add(lblNewLabel_1);

		JLabel lblThng = new JLabel("Tháng:");
		lblThng.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblThng.setBounds(191, 70, 46, 14);
		panelDoanhThu.add(lblThng);

		JLabel lblNm = new JLabel("Năm:");
		lblNm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNm.setBounds(304, 70, 46, 14);
		panelDoanhThu.add(lblNm);
		
	
		String[] headerDoanhThu="Mã hóa đơn;Người lập;Ngày lập;Tổng tiền".split(";");
		tablemodel4 = new DefaultTableModel(headerDoanhThu,10);
		panelDoanhThu.add(scrollPaneDoanhThu =  new JScrollPane(tableDoanhThu = new JTable(tablemodel4)));
		
		JLabel lblNewLabel_4 = new JLabel("Tổng doanh thu:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(35, 334, 115, 14);
		panelDoanhThu.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(160, 334, 378, 20);
		panelDoanhThu.add(textField);
		textField.setColumns(10);
		
		JButton btntimDoanhThu = new JButton("Xem");
		btntimDoanhThu.setIcon(new ImageIcon(GiaoDienNhanVien.class.getResource("/ser/search.png")));
		btntimDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btntimDoanhThu.setBounds(413, 64, 89, 26);
		panelDoanhThu.add(btntimDoanhThu);
		
		JLabel lblBG = new JLabel("Bỏ gì ở đây bây?");
		lblBG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBG.setBounds(562, 28, 185, 324);
		panelDoanhThu.add(lblBG);
		scrollPaneDoanhThu.setBounds(35, 110, 503, 213);
		


		JLabel lblbanquyen = new JLabel("Made by cCc ");
		lblbanquyen.setForeground(Color.LIGHT_GRAY);
		lblbanquyen.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblbanquyen.setBounds(696, 546, 88, 14);
		contentPane.add(lblbanquyen);


		duaDuLieuTuListVaoTable();
	}

	void duaDuLieuTuListVaoTable()
	{
		try {
			ds.docThuoc();
			ds.docBangHDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (ThongTinThuoc thuoc : ds.listThuoc) 
		{
			Object[] row = {thuoc.getMaThuoc(),thuoc.getTenThuoc(),thuoc.getLoai(),thuoc.getNcc()};
			tablemodel.addRow(row);
		}
		for (HoaDonBanHang hd : ds.listHDB)
		{
			Object[] row = {hd.getMaHD(),hd.getNgayLap(),hd.getMaNVLap(),""};
			tablemodel2.addRow(row);
		}
	}
}
