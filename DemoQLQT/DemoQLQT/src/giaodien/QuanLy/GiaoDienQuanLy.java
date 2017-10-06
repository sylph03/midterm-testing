package giaodien.QuanLy;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.ControlGiaoDien;
import control.DanhSachDuLieu;
import entity.CTHoaDonNhap;
import entity.HoaDonBanHang;
import entity.HoaDonNhapHang;
import entity.NhanVien;
import entity.ThongTinThuoc;
import giaodien.GiaoDienDangNhap;
import giaodien.GiaoDienThongTinNhanVien;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridLayout;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Rectangle;
import javax.swing.Icon;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.ComponentOrientation;

public class GiaoDienQuanLy extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableThuocNhap_NhapHang_NhapDon,tableThongtinThuoc_DanhSach,tableDulieuThuoc_NhapHang_NhapDon;
	private JTable tableThongTinNV;
	private DefaultTableModel tableModelThongTinthuoc,tableModelThuocNhap,tableModelDulieuthuoc,tableModelThongTinNV ;
	private DefaultTableModel tableModel_NhapHang_DanhSachDon,tableModel_NhapHang_ChitietDon;
	private JPanel panelNhapHang,panelDanhSach,panelTinhTrang;
	private JTextField txtMaThuoc_DanhSach_DanhSachThuoc;
	private JTextField txtTenThuoc_DanhSach_DanhSachThuoc;
	private JTextField txtSoLuong_DanhSach_DanhSachThuoc;
	private JTextField txtGiaNhap_DanhSach_DanhSachThuoc;
	private JTextField txtGiaBan_DanhSach_DanhSachThuoc;
	private JTextField txtNCC_DanhSach_DanhSachThuoc;
	private JTextField txtTimkiem_DanhSach_DanhSachThuoc;
	private JTextField txtHSD_DanhSach_DanhSachThuoc;
	private JTextField txtLoai_DanhSach_DanhSachThuoc;
	private JToggleButton btnNhapHang,btnDanhSach,btnDaonhThu,btnTinhTrang; 
	private JTextField txtMaDon_NhapHang;
	private JTextField txtNgayLap_NhapHang;
	private JTextField txtTongGia_NhapHang;
	private JScrollPane scrollPane_ThongtinThuoc,scrollPane_TableThuocNhap,scrollPane_TableDulieuThuoc;
	private JTabbedPane tabbedPane_NhapHang;
	private JPanel panel_NhapHang_NhapDon;
	private JButton btnHoanTat_NhapHang_NhapDon;
	private JPanel panel_NhapHang_DanhSach;
	private JPanel panel_NhapHang_ThemThuoc;
	private JButton btnThemVaoDon_NhapHang_NhapDon,btnXoaKhoiDon_NhapHang_NhapDon;
	private JTable tableDanhSachDonHang_NhapHang_DanhSachDon;
	private JTable tableChitietDon_NhapHang_DanhSachDon;
	private JScrollPane scrollPane_NhapHang_DanhSachDon,scrollPane_NhapHang_ChiTietDon ;
	private JLabel lblNewLabel_6,lblNewLabel_7,lblNewLabel_8,lblNewLabel_9,lblNewLabel_DonViTinh;
	private JLabel lblNewLabel_10,lblNewLabel_11,lblNewLabel_12,lblNewLabel_13;
	private JTextField txtmathuoc_NhapHang_Themthuoc;
	private JTextField txtTenThuoc_NhapHang_Themthuoc;
	private JTextField txtLoaiThuoc_NhapHang_Themthuoc;
	private JTextField txtSoluong_NhapHang_Themthuoc;
	private JTextField txtHSD_NhapHang_Themthuoc;
	private JTextField txtGiaNhap_NhapHang_Themthuoc;
	private JTextField txtGiaBan_NhapHang_Themthuoc;
	private JTextField txtNCC_NhapHang_Themthuoc;
	private JTextField txtDonViTinh_NhapHang_Themthuoc;
	private JButton btnThem_NhapHang_Themthuoc;
	private JButton btnHuy_NhapHang_Themthuoc;
	private JLabel lblNewLabel_14;
	private JTextField txtNgay_NhapHang_DanhSachDon;
	private JButton btnTim_NhapHang_DanhSachDon;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JButton btnSua_DanhSach_DanhSachThuoc;
	private JButton btnXoa_DanhSach_DanhSachThuoc;
	private JTextField txtDonViTinh_DanhSach_DanhSachThuoc;
	private JTextField txtNgay_DoanthuvaBaocao;
	private JScrollPane scrollPaneDoanhthu_DoanhThuvaBaoCao,scrollPaneBaoCao_DoanhThuvaBaoCao,scrollPaneTinhTrangThuoc_TinhTrang ;
	private JTable tableDoanhThu_Doanhthu_DoanhThuvaBaoCao,tableBaoCao_DoanhThuvaBaoCao;
	private DefaultTableModel tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao,tableModelBaoCao_Doanhthu_DoanhThuvaBaoCao;
	private JPanel panelDoanhThuvaBaoCao;
	private JPanel panelThuChiDoanhthu_DoanhThuvaBaoCao;
	private JTextField txtSoHang_BaoCao_DoanhThuvaBaoCao;
	private JTextField txtTongGiaHang_BaoCao_DoanhThuvaBaoCao;
	private JTable tableTinhTrangThuoc_TinhTrang;
	private DefaultTableModel tableModelTinhTrangThuoc_TinhTrang;
	private JScrollPane scrollPaneNhanVien;
	private JList listTimKiem_DanhSach_DanhSachThuoc;
	private DefaultListModel<String> listModelTimKiem_DanhSach_DanhSachThuoc;

	ControlGiaoDien control = new ControlGiaoDien();
	DanhSachDuLieu ds = new DanhSachDuLieu();
	private JLabel lblNewLabel_24;
	private JTextField txtMaNV_DanhSach_DanhSachNV;
	private JTextField txtTenNV_DanhSach_DanhSachNV;
	private JTextField txtTimKiem_DanhSach_DanhSachNhanVien;
	private JButton btnTim_DanhSach_DanhSachThuoc;
	private JPanel panelDanhMuc;
	private JButton btnTrangDangNhap;
	private JPanel ThanhToolBar;
	private JLabel lblNewLabel_20;
	private JLabel lblSinThoi;
	private JTextField txtNgaySinh_DanhSach_DanhSachNV;
	private JTextField txtSDT_DanhSach_DanhSachNV;
	private JTextField txtDiaChi_DanhSach_DanhSachNV;
	private JTextField txtCMND_DanhSach_DanhSachNV;
	private ButtonGroup groupDanhMuc,GroupGioiTinh;
	private JButton btnTim_DanhSach_DanhSachNV;
	private JMenuItem itemMnThongTinSanPham;
	private JButton btnNewButton_1;
	private JButton btnSua_NhapHang_DanhSachDon;
	private JButton btnXoa_NhapHang_DanhSachDon;
	private JTextField textField;
	private JLabel lblNewLabel_29;
	private JTextField textField_1;
	private JTextField txtMaThuoc_NhapHang_NhapDon;
	private JTextField txtSoLuong_NhapHang_NhapDon;
	private JTextField txtHSD_NhapHang_NhapDon;
	private JButton btnXacNhan_NhapHang_NhapDon;
	private JRadioButton rdbtnNam_DanhSach_DanhSachNV,rdbtnNu_DanhSach_DanhSachNV;
	public GiaoDienQuanLy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 80, 800, 615);
		setTitle("Quản lý");

		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(false);
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Hệ thống");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);

		JMenu menuTroGiup = new JMenu("Trợ giúp");
		menuBar.add(menuTroGiup);

		itemMnThongTinSanPham = new JMenuItem("Thông tin sản phẩm");
		menuTroGiup.add(itemMnThongTinSanPham);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);

		ThanhToolBar = new JPanel();
		ThanhToolBar.setOpaque(false);
		ThanhToolBar.setBounds(0, 0, 788, 80);
		contentPane.add(ThanhToolBar);
		ThanhToolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));

		JToolBar toolBar = new JToolBar();
		toolBar.setMinimumSize(new Dimension(0, 0));
		ThanhToolBar.add(toolBar);
		toolBar.setVerifyInputWhenFocusTarget(false);

		btnTrangDangNhap = new JButton("Home");
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
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 11));

		btnNewButton_1 = new JButton("Tìm kiếm");
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/search (1).png")));
		btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_1.setPreferredSize(new Dimension(100, 75));
		btnNewButton_1.setMaximumSize(new Dimension(100, 100));
		toolBar.add(btnNewButton_1);



		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDangXuat.setVerticalAlignment(SwingConstants.TOP);
		btnDangXuat.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDangXuat.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/application_exit.png")));
		toolBar.add(btnDangXuat);
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 11));
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

		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/exit (1).png")));
		btnNewButton.setPreferredSize(new Dimension(100, 75));
		btnNewButton.setMaximumSize(new Dimension(100, 100));
		toolBar.add(btnNewButton);


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

		panelDanhMuc = new JPanel();
		panelDanhMuc.setOpaque(false);
		panelDanhMuc.setBounds(0, 90, 178, 470);
		contentPane.add(panelDanhMuc);
		panelDanhMuc.setLayout(new GridLayout(6, 1, 0, 0));



		btnDanhSach = new JToggleButton("    Danh Sách");
		btnDanhSach.setHorizontalAlignment(SwingConstants.LEFT);
		btnDanhSach.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/file_manager.png")));
		panelDanhMuc.add(btnDanhSach);
		btnDanhSach.setFocusPainted(false);
		btnDanhSach.setSelected(true);
		btnDanhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Anpanel();
				panelDanhSach.setVisible(true);
			}
		});



		btnNhapHang = new JToggleButton("Nhập Hàng");	//Tạo nút Nhập hàng
		panelDanhMuc.add(btnNhapHang);
		btnNhapHang.setFocusPainted(false);
		btnNhapHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDanhSach.setVisible(false);
				Anpanel();
				panelNhapHang.setVisible(true);
			}
		});


		btnDaonhThu = new JToggleButton("Doanh thu & Báo cáo");	//Tạo nút DT & Báo cáo
		btnDaonhThu.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/report.png")));
		panelDanhMuc.add(btnDaonhThu);
		btnDaonhThu.setFocusPainted(false);
		btnDaonhThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDanhSach.setVisible(false);
				Anpanel();
				panelDoanhThuvaBaoCao.setVisible(true);
			}
		});


		btnTinhTrang = new JToggleButton("Tình Trạng");		//Tạo nút Tình trạng
		panelDanhMuc.add(btnTinhTrang);
		btnTinhTrang.setFocusPainted(false);
		btnTinhTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDanhSach.setVisible(false);
				Anpanel();
				panelTinhTrang.setVisible(true);
			}
		});

		/*
		 * Cho phép Mục Danh Sách được hiện
		 */
		/*
		 * Cho phép Mục Nhập Hàng được hiện
		 */


		groupDanhMuc=new ButtonGroup();
		groupDanhMuc.add(btnDanhSach);
		groupDanhMuc.add(btnDaonhThu);
		groupDanhMuc.add(btnNhapHang);
		groupDanhMuc.add(btnTinhTrang);


		/*
		 * Khởi tạo layeredPane chứa các panel làm việc của các Button trên
		 * 
		 */

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		layeredPane.setBounds(188, 90, 600, 470);
		contentPane.add(layeredPane);


		////	Tạo bảng trong "Danh sách"
		String[] header = "Mã thuốc;Tên thuốc;Loại thuốc;Nhà cung cấp".split(";");  
		tableModelThongTinthuoc = new DefaultTableModel(header,0);	

		////	Tạo bảng trong "Nhập hàng"
		String[] header_1="Mã thuốc;Tên thuốc;Số lượng;HSD".split(";");
		tableModelThuocNhap = new DefaultTableModel(header_1, 0);
		///		Tạo bảng trong "Nhập hàng"   
		String[] header_2 ="Mã thuôc;Tên thuốc".split(";");
		tableModelDulieuthuoc = new DefaultTableModel(header_2,0);
		/// Bảng danh sách đơn nhập hàng
		String[] header_NhapHang_DanhSachDon="Mã đơn;Ngày lập;Tổng giá".split(";");
		tableModel_NhapHang_DanhSachDon = new DefaultTableModel(header_NhapHang_DanhSachDon,0);
		///Bảng Chi tiết đơn nhập hàng
		String[] header_NhapHang_ChitietDon="Tên thuốc;Số Lượng;HSD".split(";");
		tableModel_NhapHang_ChitietDon= new DefaultTableModel(header_NhapHang_ChitietDon, 0);
		// BẢng doanh thu
		String[] headerDaonhthu="Mã đơn;Mã nhân viên;Tên Nhân viên;Tổng doanh thu".split(";");
		tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao=new DefaultTableModel(headerDaonhthu, 0);
		// Bảng  Báo cáo
		String[] headerBaoCao="Mã thuốc;Tên thuốc;Số lượng bán;đơn vị tính;Tiền lời".split(";");
		tableModelBaoCao_Doanhthu_DoanhThuvaBaoCao=new DefaultTableModel(headerBaoCao, 0);
		/// Bảng Tình Trạng Thuốc
		String[] headerTinhTrang="Mã thuốc;Tên thuốc;Loại thuốc;NCC;Tình trạng".split(";");
		tableModelTinhTrangThuoc_TinhTrang=new DefaultTableModel(headerTinhTrang,0);
		// Bảng thông tin nhân viên
		String[] headerThongTinNV="Mã;Tên;Ngày sinh;Giới tính;Địa chỉ".split(";");
		tableModelThongTinNV =new DefaultTableModel(headerThongTinNV, 0);

		/*
		 *  Panel Nhập hàng Chứa các thành phần giao diên của Button Nhập Hàng
		 *  Các căng chỉnh tọa đọ của các thành phần
		 */

		panelNhapHang = new JPanel();
		layeredPane.setLayer(panelNhapHang, 0);
		panelNhapHang.setOpaque(false);
		panelNhapHang.setBounds(5, 9, 590, 460);
		layeredPane.add(panelNhapHang);
		panelNhapHang.setLayout(null);

		tabbedPane_NhapHang = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_NhapHang.setBounds(0, 0, 600, 460);
		panelNhapHang.add(tabbedPane_NhapHang);

		panel_NhapHang_NhapDon = new JPanel();
		panel_NhapHang_NhapDon.setOpaque(false);
		tabbedPane_NhapHang.addTab("Nhập đơn", (Icon) null, panel_NhapHang_NhapDon, null);
		SpringLayout sl_panel_NhapHang_NhapDon = new SpringLayout();
		panel_NhapHang_NhapDon.setLayout(sl_panel_NhapHang_NhapDon);

		JPanel panelThonTinDonHang = new JPanel();
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.EAST, panelThonTinDonHang, -354, SpringLayout.EAST, panel_NhapHang_NhapDon);
		panelThonTinDonHang.setOpaque(false);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.NORTH, panelThonTinDonHang, 0, SpringLayout.NORTH, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, panelThonTinDonHang, 0, SpringLayout.WEST, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.SOUTH, panelThonTinDonHang, 104, SpringLayout.NORTH, panel_NhapHang_NhapDon);
		panel_NhapHang_NhapDon.add(panelThonTinDonHang);
		panelThonTinDonHang.setBorder(new TitledBorder(null, "Thông tin hóa đơn nhập ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThonTinDonHang.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã đơn hàng");
		lblNewLabel_1.setBounds(10, 25, 75, 14);
		panelThonTinDonHang.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Ngày nhập");
		lblNewLabel_2.setBounds(10, 50, 75, 14);
		panelThonTinDonHang.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Tổng giá");
		lblNewLabel_3.setBounds(10, 75, 75, 14);
		panelThonTinDonHang.add(lblNewLabel_3);

		txtMaDon_NhapHang = new JTextField();
		txtMaDon_NhapHang.setBounds(95, 25, 137, 20);
		panelThonTinDonHang.add(txtMaDon_NhapHang);
		txtMaDon_NhapHang.setColumns(10);

		txtNgayLap_NhapHang = new JTextField();
		txtNgayLap_NhapHang.setColumns(10);
		txtNgayLap_NhapHang.setBounds(95, 50, 137, 20);
		panelThonTinDonHang.add(txtNgayLap_NhapHang);

		txtTongGia_NhapHang = new JTextField();
		txtTongGia_NhapHang.setColumns(10);
		txtTongGia_NhapHang.setBounds(95, 75, 137, 20);
		panelThonTinDonHang.add(txtTongGia_NhapHang);

		panelNhapHang.add(scrollPane_TableThuocNhap=new JScrollPane(tableThuocNhap_NhapHang_NhapDon=new JTable(tableModelThuocNhap)));
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.EAST, scrollPane_TableThuocNhap, -10, SpringLayout.EAST, panel_NhapHang_NhapDon);
		panel_NhapHang_NhapDon.add(scrollPane_TableThuocNhap);


		panelNhapHang.add(scrollPane_TableDulieuThuoc=new JScrollPane(tableDulieuThuoc_NhapHang_NhapDon=new JTable(tableModelDulieuthuoc)));
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, scrollPane_TableDulieuThuoc, 6, SpringLayout.WEST, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.SOUTH, scrollPane_TableDulieuThuoc, -5, SpringLayout.SOUTH, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.EAST, scrollPane_TableDulieuThuoc, -409, SpringLayout.EAST, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.NORTH, scrollPane_TableThuocNhap, 0, SpringLayout.NORTH, scrollPane_TableDulieuThuoc);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.SOUTH, scrollPane_TableThuocNhap, 0, SpringLayout.SOUTH, scrollPane_TableDulieuThuoc);
		panel_NhapHang_NhapDon.add(scrollPane_TableDulieuThuoc);

		btnThemVaoDon_NhapHang_NhapDon = new JButton(">>");
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.NORTH, btnThemVaoDon_NhapHang_NhapDon, 56, SpringLayout.SOUTH, panelThonTinDonHang);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, btnThemVaoDon_NhapHang_NhapDon, 31, SpringLayout.EAST, scrollPane_TableDulieuThuoc);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.EAST, btnThemVaoDon_NhapHang_NhapDon, -29, SpringLayout.WEST, scrollPane_TableThuocNhap);
		btnThemVaoDon_NhapHang_NhapDon.addActionListener(this);
		panel_NhapHang_NhapDon.add(btnThemVaoDon_NhapHang_NhapDon);

		btnXoaKhoiDon_NhapHang_NhapDon = new JButton("<<");
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.SOUTH, btnThemVaoDon_NhapHang_NhapDon, -22, SpringLayout.NORTH, btnXoaKhoiDon_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.NORTH, btnXoaKhoiDon_NhapHang_NhapDon, 221, SpringLayout.NORTH, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, btnXoaKhoiDon_NhapHang_NhapDon, 31, SpringLayout.EAST, scrollPane_TableDulieuThuoc);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.EAST, btnXoaKhoiDon_NhapHang_NhapDon, -29, SpringLayout.WEST, scrollPane_TableThuocNhap);
		btnXoaKhoiDon_NhapHang_NhapDon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=tableThuocNhap_NhapHang_NhapDon.getSelectedRow();
				if(row!=-1)
				{	
					Object[] data= {tableThuocNhap_NhapHang_NhapDon.getValueAt(row, 0),tableThuocNhap_NhapHang_NhapDon.getValueAt(row, 1)};
					tableModelDulieuthuoc.addRow(data);
					tableModelThuocNhap.removeRow(row);
				}
				else
				{
					JOptionPane.showMessageDialog(panel_NhapHang_NhapDon, "Chọn thuốc cần xóa");
				}
			}
		});
		btnXoaKhoiDon_NhapHang_NhapDon.addActionListener(this);
		panel_NhapHang_NhapDon.add(btnXoaKhoiDon_NhapHang_NhapDon);


		btnHoanTat_NhapHang_NhapDon = new JButton("Hoàn tất");
		btnHoanTat_NhapHang_NhapDon.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/done.png")));
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.SOUTH, btnXoaKhoiDon_NhapHang_NhapDon, -94, SpringLayout.NORTH, btnHoanTat_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, scrollPane_TableThuocNhap, 6, SpringLayout.EAST, btnHoanTat_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.NORTH, btnHoanTat_NhapHang_NhapDon, 354, SpringLayout.NORTH, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, btnHoanTat_NhapHang_NhapDon, 6, SpringLayout.EAST, scrollPane_TableDulieuThuoc);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.EAST, btnHoanTat_NhapHang_NhapDon, -292, SpringLayout.EAST, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.SOUTH, btnHoanTat_NhapHang_NhapDon, -10, SpringLayout.SOUTH, panel_NhapHang_NhapDon);
		panel_NhapHang_NhapDon.add(btnHoanTat_NhapHang_NhapDon);
		btnHoanTat_NhapHang_NhapDon.addActionListener(this);


		panel_NhapHang_DanhSach = new JPanel();
		panel_NhapHang_DanhSach.setOpaque(false);
		tabbedPane_NhapHang.addTab("Danh sách đơn", null, panel_NhapHang_DanhSach, null);
		panel_NhapHang_DanhSach.setLayout(null);
		panel_NhapHang_DanhSach.add(scrollPane_NhapHang_DanhSachDon=new JScrollPane(tableDanhSachDonHang_NhapHang_DanhSachDon =new JTable(tableModel_NhapHang_DanhSachDon)));
		scrollPane_NhapHang_DanhSachDon.setSize(234, 329);
		scrollPane_NhapHang_DanhSachDon.setLocation(12, 91);
		panel_NhapHang_DanhSach.add(scrollPane_NhapHang_ChiTietDon=new JScrollPane(tableChitietDon_NhapHang_DanhSachDon=new JTable(tableModel_NhapHang_ChitietDon)));
		scrollPane_NhapHang_ChiTietDon.setSize(315, 329);
		scrollPane_NhapHang_ChiTietDon.setLocation(258, 91);
		tableDanhSachDonHang_NhapHang_DanhSachDon.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = tableDanhSachDonHang_NhapHang_DanhSachDon.getSelectedRow();
				if(row != -1)
				{
					String ma = tableDanhSachDonHang_NhapHang_DanhSachDon.getValueAt(row, 0).toString();
					for(int i=tableModel_NhapHang_ChitietDon.getRowCount()-1;i>=0;i--)
					{
						tableModel_NhapHang_ChitietDon.removeRow(i);
					}
					for (CTHoaDonNhap ctHDN : ds.listThuocNhap)
					{
						if(ma.equalsIgnoreCase(ctHDN.getMaHDN()))
						{
							Object[] row1 = {ctHDN.getMaThuoc(),ctHDN.getSoLuong(),ctHDN.getHsd()};
							tableModel_NhapHang_ChitietDon.addRow(row1);
						}	
					}
				}	
			}
		});


		JLabel lblNewLabel_4 = new JLabel("Danh sách Đơn Hàng");
		lblNewLabel_4.setBounds(12, 63, 127, 16);
		panel_NhapHang_DanhSach.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Chi tiết đơn hàng");
		lblNewLabel_5.setBounds(258, 63, 96, 16);
		panel_NhapHang_DanhSach.add(lblNewLabel_5);

		lblNewLabel_14 = new JLabel("Tìm ngày");
		lblNewLabel_14.setBounds(12, 22, 55, 16);
		panel_NhapHang_DanhSach.add(lblNewLabel_14);

		txtNgay_NhapHang_DanhSachDon = new JTextField();
		txtNgay_NhapHang_DanhSachDon.setBounds(85, 20, 136, 20);
		panel_NhapHang_DanhSach.add(txtNgay_NhapHang_DanhSachDon);
		txtNgay_NhapHang_DanhSachDon.setColumns(10);

		btnTim_NhapHang_DanhSachDon = new JButton("Tìm");
		btnTim_NhapHang_DanhSachDon.setBounds(233, 17, 98, 26);
		panel_NhapHang_DanhSach.add(btnTim_NhapHang_DanhSachDon);

		btnSua_NhapHang_DanhSachDon = new JButton("Sửa");
		btnSua_NhapHang_DanhSachDon.setBounds(341, 19, 89, 23);
		panel_NhapHang_DanhSach.add(btnSua_NhapHang_DanhSachDon);

		btnXoa_NhapHang_DanhSachDon = new JButton("Xóa");
		btnXoa_NhapHang_DanhSachDon.setBounds(440, 19, 89, 23);
		panel_NhapHang_DanhSach.add(btnXoa_NhapHang_DanhSachDon);
		tableThuocNhap_NhapHang_NhapDon.setBounds(new Rectangle(0, 0, 278, 301));
		scrollPane_TableDulieuThuoc.setLocation(10, 140);
		scrollPane_TableDulieuThuoc.setSize(137, 302);

		scrollPane_TableThuocNhap.setLocation(220, 140);
		scrollPane_TableThuocNhap.setSize(278, 302);

		lblNewLabel_15 = new JLabel("Danh sách thuốc");
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.NORTH, lblNewLabel_15, 6, SpringLayout.SOUTH, panelThonTinDonHang);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, lblNewLabel_15, 10, SpringLayout.WEST, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.NORTH, scrollPane_TableDulieuThuoc, 6, SpringLayout.SOUTH, lblNewLabel_15);
		panel_NhapHang_NhapDon.add(lblNewLabel_15);

		lblNewLabel_16 = new JLabel("Thuốc nhập");
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, lblNewLabel_16, 0, SpringLayout.WEST, scrollPane_TableThuocNhap);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.SOUTH, lblNewLabel_16, -6, SpringLayout.NORTH, scrollPane_TableThuocNhap);
		panel_NhapHang_NhapDon.add(lblNewLabel_16);

		JPanel panel_1 = new JPanel();
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, panel_1, 6, SpringLayout.EAST, panelThonTinDonHang);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, panel_NhapHang_NhapDon);
		panel_1.setOpaque(false);
		panel_1.setBorder(new TitledBorder(null, "Thuoc nhap", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.SOUTH, panel_1, 104, SpringLayout.NORTH, panel_NhapHang_NhapDon);
		panel_NhapHang_NhapDon.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_30 = new JLabel("Mã thuốc");
		lblNewLabel_30.setBounds(10, 25, 69, 14);
		panel_1.add(lblNewLabel_30);

		JLabel lblSLngNhp = new JLabel("Số lượng nhập");
		lblSLngNhp.setBounds(10, 50, 90, 14);
		panel_1.add(lblSLngNhp);

		JLabel lblHsd_1 = new JLabel("HSD");
		lblHsd_1.setBounds(10, 75, 69, 14);
		panel_1.add(lblHsd_1);

		txtMaThuoc_NhapHang_NhapDon = new JTextField();
		txtMaThuoc_NhapHang_NhapDon.setColumns(10);
		txtMaThuoc_NhapHang_NhapDon.setBounds(104, 25, 137, 20);
		panel_1.add(txtMaThuoc_NhapHang_NhapDon);

		txtSoLuong_NhapHang_NhapDon = new JTextField();
		txtSoLuong_NhapHang_NhapDon.setColumns(10);
		txtSoLuong_NhapHang_NhapDon.setBounds(104, 50, 137, 20);
		panel_1.add(txtSoLuong_NhapHang_NhapDon);

		txtHSD_NhapHang_NhapDon = new JTextField();
		txtHSD_NhapHang_NhapDon.setColumns(10);
		txtHSD_NhapHang_NhapDon.setBounds(104, 75, 137, 20);
		panel_1.add(txtHSD_NhapHang_NhapDon);

		btnXacNhan_NhapHang_NhapDon = new JButton("Xác nhận");
		btnXacNhan_NhapHang_NhapDon.setToolTipText("");
		btnXacNhan_NhapHang_NhapDon.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXacNhan_NhapHang_NhapDon.setBounds(251, 68, 77, 28);
		panel_1.add(btnXacNhan_NhapHang_NhapDon);

		panel_NhapHang_ThemThuoc = new JPanel();
		panel_NhapHang_ThemThuoc.setOpaque(false);
		tabbedPane_NhapHang.addTab("Thêm thuốc", null, panel_NhapHang_ThemThuoc, null);
		panel_NhapHang_ThemThuoc.setLayout(null);

		lblNewLabel_6 = new JLabel("Mã thuốc");
		lblNewLabel_6.setBounds(12, 30, 55, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Tên Thuốc");
		lblNewLabel_7.setBounds(12, 60, 81, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("Loại thuốc");
		lblNewLabel_8.setBounds(12, 90, 81, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel("Số lượng");
		lblNewLabel_9.setBounds(12, 120, 55, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_9);

		lblNewLabel_10 = new JLabel("HSD");
		lblNewLabel_10.setBounds(12, 150, 55, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_10);

		lblNewLabel_11 = new JLabel("Giá nhập");
		lblNewLabel_11.setBounds(12, 180, 55, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_11);

		lblNewLabel_12 = new JLabel("Giá bán");
		lblNewLabel_12.setBounds(12, 210, 55, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_12);

		lblNewLabel_13 = new JLabel("Nhà cung cấp");
		lblNewLabel_13.setBounds(12, 240, 81, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_13);

		lblNewLabel_DonViTinh = new JLabel("Đơn vị tính");
		lblNewLabel_DonViTinh.setBounds(12, 270, 81, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_DonViTinh);

		txtmathuoc_NhapHang_Themthuoc = new JTextField();
		txtmathuoc_NhapHang_Themthuoc.setBounds(111, 30, 246, 20);
		panel_NhapHang_ThemThuoc.add(txtmathuoc_NhapHang_Themthuoc);
		txtmathuoc_NhapHang_Themthuoc.setColumns(10);

		txtTenThuoc_NhapHang_Themthuoc = new JTextField();
		txtTenThuoc_NhapHang_Themthuoc.setColumns(10);
		txtTenThuoc_NhapHang_Themthuoc.setBounds(111, 60, 246, 20);
		panel_NhapHang_ThemThuoc.add(txtTenThuoc_NhapHang_Themthuoc);

		txtLoaiThuoc_NhapHang_Themthuoc = new JTextField();
		txtLoaiThuoc_NhapHang_Themthuoc.setColumns(10);
		txtLoaiThuoc_NhapHang_Themthuoc.setBounds(111, 90, 246, 20);
		panel_NhapHang_ThemThuoc.add(txtLoaiThuoc_NhapHang_Themthuoc);

		txtSoluong_NhapHang_Themthuoc = new JTextField();
		txtSoluong_NhapHang_Themthuoc.setEditable(false);
		txtSoluong_NhapHang_Themthuoc.setColumns(10);
		txtSoluong_NhapHang_Themthuoc.setBounds(111, 120, 246, 20);
		panel_NhapHang_ThemThuoc.add(txtSoluong_NhapHang_Themthuoc);

		txtHSD_NhapHang_Themthuoc = new JTextField();
		txtHSD_NhapHang_Themthuoc.setEditable(false);
		txtHSD_NhapHang_Themthuoc.setColumns(10);
		txtHSD_NhapHang_Themthuoc.setBounds(111, 150, 246, 20);
		panel_NhapHang_ThemThuoc.add(txtHSD_NhapHang_Themthuoc);

		txtGiaNhap_NhapHang_Themthuoc = new JTextField();
		txtGiaNhap_NhapHang_Themthuoc.setColumns(10);
		txtGiaNhap_NhapHang_Themthuoc.setBounds(111, 180, 246, 20);
		panel_NhapHang_ThemThuoc.add(txtGiaNhap_NhapHang_Themthuoc);

		txtGiaBan_NhapHang_Themthuoc = new JTextField();
		txtGiaBan_NhapHang_Themthuoc.setColumns(10);
		txtGiaBan_NhapHang_Themthuoc.setBounds(111, 210, 246, 20);
		panel_NhapHang_ThemThuoc.add(txtGiaBan_NhapHang_Themthuoc);

		txtNCC_NhapHang_Themthuoc = new JTextField();
		txtNCC_NhapHang_Themthuoc.setColumns(10);
		txtNCC_NhapHang_Themthuoc.setBounds(111, 240, 246, 20);
		panel_NhapHang_ThemThuoc.add(txtNCC_NhapHang_Themthuoc);

		txtDonViTinh_NhapHang_Themthuoc = new JTextField();
		txtDonViTinh_NhapHang_Themthuoc.setColumns(10);
		txtDonViTinh_NhapHang_Themthuoc.setBounds(111, 270, 246, 20);
		panel_NhapHang_ThemThuoc.add(txtDonViTinh_NhapHang_Themthuoc);

		btnThem_NhapHang_Themthuoc = new JButton("Thêm thuốc");
		btnThem_NhapHang_Themthuoc.addActionListener(this);
		btnThem_NhapHang_Themthuoc.setBounds(111, 316, 106, 26);
		panel_NhapHang_ThemThuoc.add(btnThem_NhapHang_Themthuoc);

		btnHuy_NhapHang_Themthuoc = new JButton("Hủy");
		btnHuy_NhapHang_Themthuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane_NhapHang.setSelectedIndex(0);
			}
		});
		btnHuy_NhapHang_Themthuoc.setBounds(259, 316, 98, 26);
		panel_NhapHang_ThemThuoc.add(btnHuy_NhapHang_Themthuoc);

		tableDulieuThuoc_NhapHang_NhapDon.getColumnModel().getColumn(0).setPreferredWidth(19);
		tableThuocNhap_NhapHang_NhapDon.getColumnModel().getColumn(0).setPreferredWidth(60);



		panelDanhSach = new JPanel();
		panelDanhSach.setOpaque(false);
		layeredPane.setLayer(panelDanhSach, 1);

		panelDanhSach.setBounds(5, 9, 590, 455);
		layeredPane.add(panelDanhSach);
		panelDanhSach.setLayout(null);

		JTabbedPane tabbedPane_DanhSach = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_DanhSach.setBounds(0, 0, 590, 460);
		panelDanhSach.add(tabbedPane_DanhSach);

		JPanel panelDanhSachThuoc = new JPanel();
		panelDanhSachThuoc.setOpaque(false);
		tabbedPane_DanhSach.addTab("Danh sách thuốc", null, panelDanhSachThuoc, null);
		panelDanhSachThuoc.setLayout(null);

		JPanel panelThongTinChiTietThuoc = new JPanel();
		panelThongTinChiTietThuoc.setOpaque(false);
		panelThongTinChiTietThuoc.setBorder(new TitledBorder(null, "Thông tin chi tiết", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinChiTietThuoc.setBounds(10, 11, 565, 137);
		panelDanhSachThuoc.add(panelThongTinChiTietThuoc);
		panelThongTinChiTietThuoc.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã thuốc");
		lblNewLabel.setBounds(10, 25, 60, 14);
		panelThongTinChiTietThuoc.add(lblNewLabel);

		JLabel lblTnThuc = new JLabel("Tên thuốc");
		lblTnThuc.setBounds(10, 50, 60, 14);
		panelThongTinChiTietThuoc.add(lblTnThuc);

		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setBounds(10, 75, 60, 14);
		panelThongTinChiTietThuoc.add(lblSLng);

		JLabel lblHsd = new JLabel("HSD");
		lblHsd.setBounds(10, 100, 60, 14);
		panelThongTinChiTietThuoc.add(lblHsd);

		JLabel lblGiNhp = new JLabel("Giá nhập");
		lblGiNhp.setBounds(297, 25, 60, 14);
		panelThongTinChiTietThuoc.add(lblGiNhp);

		JLabel lblGiBn = new JLabel("Giá bán");
		lblGiBn.setBounds(297, 50, 60, 14);
		panelThongTinChiTietThuoc.add(lblGiBn);

		JLabel lblNcc = new JLabel("NCC");
		lblNcc.setBounds(297, 75, 60, 14);
		panelThongTinChiTietThuoc.add(lblNcc);

		txtMaThuoc_DanhSach_DanhSachThuoc = new JTextField();
		txtMaThuoc_DanhSach_DanhSachThuoc.setEditable(false);
		txtMaThuoc_DanhSach_DanhSachThuoc.setColumns(10);
		txtMaThuoc_DanhSach_DanhSachThuoc.setBounds(80, 25, 176, 20);
		panelThongTinChiTietThuoc.add(txtMaThuoc_DanhSach_DanhSachThuoc);

		txtTenThuoc_DanhSach_DanhSachThuoc = new JTextField();
		txtTenThuoc_DanhSach_DanhSachThuoc.setColumns(10);
		txtTenThuoc_DanhSach_DanhSachThuoc.setBounds(80, 50, 176, 20);
		panelThongTinChiTietThuoc.add(txtTenThuoc_DanhSach_DanhSachThuoc);

		txtSoLuong_DanhSach_DanhSachThuoc = new JTextField();
		txtSoLuong_DanhSach_DanhSachThuoc.setColumns(10);
		txtSoLuong_DanhSach_DanhSachThuoc.setBounds(80, 75, 45, 20);
		panelThongTinChiTietThuoc.add(txtSoLuong_DanhSach_DanhSachThuoc);


		txtGiaNhap_DanhSach_DanhSachThuoc = new JTextField();
		txtGiaNhap_DanhSach_DanhSachThuoc.setColumns(10);
		txtGiaNhap_DanhSach_DanhSachThuoc.setBounds(365, 25, 176, 20);
		panelThongTinChiTietThuoc.add(txtGiaNhap_DanhSach_DanhSachThuoc);

		txtGiaBan_DanhSach_DanhSachThuoc = new JTextField();
		txtGiaBan_DanhSach_DanhSachThuoc.setColumns(10);
		txtGiaBan_DanhSach_DanhSachThuoc.setBounds(365, 50, 176, 20);
		panelThongTinChiTietThuoc.add(txtGiaBan_DanhSach_DanhSachThuoc);

		txtNCC_DanhSach_DanhSachThuoc = new JTextField();
		txtNCC_DanhSach_DanhSachThuoc.setColumns(10);
		txtNCC_DanhSach_DanhSachThuoc.setBounds(365, 75, 176, 20);
		panelThongTinChiTietThuoc.add(txtNCC_DanhSach_DanhSachThuoc);

		txtHSD_DanhSach_DanhSachThuoc = new JTextField();
		txtNCC_DanhSach_DanhSachThuoc.setColumns(10);
		txtHSD_DanhSach_DanhSachThuoc.setBounds(80, 100, 176, 20);
		panelThongTinChiTietThuoc.add(txtHSD_DanhSach_DanhSachThuoc);
		txtHSD_DanhSach_DanhSachThuoc.setEditable(false);

		JLabel lblNewLabel_18 = new JLabel("Đơn vị tính");
		lblNewLabel_18.setBounds(130, 75, 70, 16);
		panelThongTinChiTietThuoc.add(lblNewLabel_18);

		txtDonViTinh_DanhSach_DanhSachThuoc = new JTextField();
		txtDonViTinh_DanhSach_DanhSachThuoc.setBounds(193, 75, 60, 20);
		panelThongTinChiTietThuoc.add(txtDonViTinh_DanhSach_DanhSachThuoc);
		txtDonViTinh_DanhSach_DanhSachThuoc.setColumns(10);

		lblNewLabel_24 = new JLabel("Loại thuốc");
		lblNewLabel_24.setBounds(297, 100, 60, 14);
		panelThongTinChiTietThuoc.add(lblNewLabel_24);

		txtLoai_DanhSach_DanhSachThuoc = new JTextField();
		txtLoai_DanhSach_DanhSachThuoc.setBounds(365, 100, 176, 20);
		panelThongTinChiTietThuoc.add(txtLoai_DanhSach_DanhSachThuoc);
		txtLoai_DanhSach_DanhSachThuoc.setColumns(10);

		txtTimkiem_DanhSach_DanhSachThuoc = new JTextField();
		txtTimkiem_DanhSach_DanhSachThuoc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtTimkiem_DanhSach_DanhSachThuoc.getText().length()>0)
				{
					if(!txtTimkiem_DanhSach_DanhSachThuoc.getText().trim().equals(""))
					{
						listModelTimKiem_DanhSach_DanhSachThuoc.removeAllElements();
						try {
							String kq=ds.Timtenthuoc(txtTimkiem_DanhSach_DanhSachThuoc.getText());
							String[] data=kq.split(";");
							if(!kq.equals(""))
							{
								for(int i=0;i<data.length;i++)
								{
									if(i<4)
									listModelTimKiem_DanhSach_DanhSachThuoc.addElement(data[i]);
									else
										break;
								}
								listTimKiem_DanhSach_DanhSachThuoc.setVisible(true);
							}
							else
							{
								listModelTimKiem_DanhSach_DanhSachThuoc.removeAllElements();
								listTimKiem_DanhSach_DanhSachThuoc.setVisible(false);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							txtTimkiem_DanhSach_DanhSachThuoc.setText("");
						}
					}
					else
					{
						listTimKiem_DanhSach_DanhSachThuoc.setVisible(false);
						listModelTimKiem_DanhSach_DanhSachThuoc.removeAllElements();
					}
				}
				else
				{
					listModelTimKiem_DanhSach_DanhSachThuoc.removeAllElements();
					listTimKiem_DanhSach_DanhSachThuoc.setVisible(false);
				}
			}
		});
		txtTimkiem_DanhSach_DanhSachThuoc.setBounds(346, 159, 186, 20);
		panelDanhSachThuoc.add(txtTimkiem_DanhSach_DanhSachThuoc);
		txtTimkiem_DanhSach_DanhSachThuoc.setColumns(10);

		lblNewLabel_17 = new JLabel("Thông tin thuốc");
		lblNewLabel_17.setBounds(10, 183, 89, 16);
		panelDanhSachThuoc.add(lblNewLabel_17);

		btnSua_DanhSach_DanhSachThuoc = new JButton(" ");
		btnSua_DanhSach_DanhSachThuoc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSua_DanhSach_DanhSachThuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/package_editors (1).png")));
		btnSua_DanhSach_DanhSachThuoc.addActionListener(this);
		btnSua_DanhSach_DanhSachThuoc.setBounds(247, 152, 35, 35);
		panelDanhSachThuoc.add(btnSua_DanhSach_DanhSachThuoc);

		btnXoa_DanhSach_DanhSachThuoc = new JButton(" ");
		btnXoa_DanhSach_DanhSachThuoc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXoa_DanhSach_DanhSachThuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/deletered.png")));
		btnXoa_DanhSach_DanhSachThuoc.setBounds(292, 152, 35, 35);
		panelDanhSachThuoc.add(btnXoa_DanhSach_DanhSachThuoc);

		btnTim_DanhSach_DanhSachThuoc = new JButton(" ");
		btnTim_DanhSach_DanhSachThuoc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTim_DanhSach_DanhSachThuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/search.png")));
		btnTim_DanhSach_DanhSachThuoc.setBounds(542, 152, 33, 33);
		panelDanhSachThuoc.add(btnTim_DanhSach_DanhSachThuoc);

		listModelTimKiem_DanhSach_DanhSachThuoc =new DefaultListModel<>();
		listTimKiem_DanhSach_DanhSachThuoc= new JList(listModelTimKiem_DanhSach_DanhSachThuoc);
		listTimKiem_DanhSach_DanhSachThuoc.setSelectionBackground(new Color(0, 120, 215));
		listModelTimKiem_DanhSach_DanhSachThuoc.setSize(3);
		listTimKiem_DanhSach_DanhSachThuoc.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				Object data = listTimKiem_DanhSach_DanhSachThuoc.getSelectedValue();
				if(data!=null)
				{
					txtTimkiem_DanhSach_DanhSachThuoc.setText(listTimKiem_DanhSach_DanhSachThuoc.getSelectedValue()+"");
					listTimKiem_DanhSach_DanhSachThuoc.setVisible(false);
				}
				else
				{
					txtTimKiem_DanhSach_DanhSachNhanVien.setText("");
				}

			}
		});
		listTimKiem_DanhSach_DanhSachThuoc.setVisible(false);
		listTimKiem_DanhSach_DanhSachThuoc.setVisibleRowCount(4);
		listTimKiem_DanhSach_DanhSachThuoc.setBounds(346, 183, 186, 86);
		panelDanhSachThuoc.add(listTimKiem_DanhSach_DanhSachThuoc);
		panelDanhSachThuoc.add(scrollPane_ThongtinThuoc= new JScrollPane(tableThongtinThuoc_DanhSach=new JTable(tableModelThongTinthuoc)));
		scrollPane_ThongtinThuoc.setOpaque(false);
		tableThongtinThuoc_DanhSach.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = tableThongtinThuoc_DanhSach.getSelectedRow();
				// Hàm lấy dữ liệu từ bảng đổ ngược về textFeild
				FillFormThuoc(row);

			}
		});
		scrollPane_ThongtinThuoc.setLocation(10, 200);
		scrollPane_ThongtinThuoc.setSize(575, 220);
		btnXoa_DanhSach_DanhSachThuoc.addActionListener(this);

		JPanel panelDanhSachNhanVien = new JPanel();
		panelDanhSachNhanVien.setOpaque(false);
		panelDanhSachNhanVien.setLayout(null);
		tabbedPane_DanhSach.addTab("Danh Sách nhân viên", null, panelDanhSachNhanVien, null);

		panelDanhSachNhanVien.add(scrollPaneNhanVien =new JScrollPane(tableThongTinNV=new JTable(tableModelThongTinNV)));
		scrollPaneNhanVien.setOpaque(false);
		scrollPaneNhanVien.setBounds(10, 200, 575, 220);
		tableThongTinNV.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				int row = tableThongTinNV.getSelectedRow();
				fillFormNV(row);
			}
		});


		JPanel panelThongTinNV = new JPanel();
		panelThongTinNV.setLayout(null);
		panelThongTinNV.setOpaque(false);
		panelThongTinNV.setBorder(new TitledBorder(null, "Thông tin chi tiết", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinNV.setBounds(10, 11, 565, 137);
		panelDanhSachNhanVien.add(panelThongTinNV);

		JLabel lblTnNv = new JLabel("Mã NV");
		lblTnNv.setBounds(10, 25, 60, 14);
		panelThongTinNV.add(lblTnNv);

		JLabel lblTnNv_1 = new JLabel("Tên NV");
		lblTnNv_1.setBounds(10, 50, 60, 14);
		panelThongTinNV.add(lblTnNv_1);

		txtMaNV_DanhSach_DanhSachNV = new JTextField();
		txtMaNV_DanhSach_DanhSachNV.setEditable(false);
		txtMaNV_DanhSach_DanhSachNV.setColumns(10);
		txtMaNV_DanhSach_DanhSachNV.setBounds(80, 25, 176, 20);
		panelThongTinNV.add(txtMaNV_DanhSach_DanhSachNV);

		txtTenNV_DanhSach_DanhSachNV = new JTextField();
		txtTenNV_DanhSach_DanhSachNV.setColumns(10);
		txtTenNV_DanhSach_DanhSachNV.setBounds(80, 50, 176, 20);
		panelThongTinNV.add(txtTenNV_DanhSach_DanhSachNV);

		lblNewLabel_20 = new JLabel("Ngày Sinh");
		lblNewLabel_20.setBounds(10, 75, 60, 14);
		panelThongTinNV.add(lblNewLabel_20);

		lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setBounds(10, 100, 70, 14);
		panelThongTinNV.add(lblSinThoi);

		txtNgaySinh_DanhSach_DanhSachNV = new JTextField();
		txtNgaySinh_DanhSach_DanhSachNV.setBounds(80, 75, 176, 20);
		panelThongTinNV.add(txtNgaySinh_DanhSach_DanhSachNV);
		txtNgaySinh_DanhSach_DanhSachNV.setColumns(10);

		txtSDT_DanhSach_DanhSachNV = new JTextField();
		txtSDT_DanhSach_DanhSachNV.setColumns(10);
		txtSDT_DanhSach_DanhSachNV.setBounds(80, 100, 176, 20);
		panelThongTinNV.add(txtSDT_DanhSach_DanhSachNV);

		JLabel lblNewLabel_25 = new JLabel("Giới tính");
		lblNewLabel_25.setBounds(315, 25, 46, 14);
		panelThongTinNV.add(lblNewLabel_25);

		rdbtnNam_DanhSach_DanhSachNV = new JRadioButton("Nam",true);
		rdbtnNam_DanhSach_DanhSachNV.setOpaque(false);
		rdbtnNam_DanhSach_DanhSachNV.setBounds(376, 21, 60, 23);
		panelThongTinNV.add(rdbtnNam_DanhSach_DanhSachNV);

		rdbtnNu_DanhSach_DanhSachNV = new JRadioButton("Nữ");
		rdbtnNu_DanhSach_DanhSachNV.setOpaque(false);
		rdbtnNu_DanhSach_DanhSachNV.setBounds(450, 21, 60, 23);
		panelThongTinNV.add(rdbtnNu_DanhSach_DanhSachNV);

		JLabel lblNewLabel_26 = new JLabel("Địa chỉ");
		lblNewLabel_26.setBounds(315, 50, 46, 14);
		panelThongTinNV.add(lblNewLabel_26);

		txtDiaChi_DanhSach_DanhSachNV = new JTextField();
		txtDiaChi_DanhSach_DanhSachNV.setColumns(10);
		txtDiaChi_DanhSach_DanhSachNV.setBounds(376, 47, 180, 20);
		panelThongTinNV.add(txtDiaChi_DanhSach_DanhSachNV);

		JLabel lblNewLabel_27 = new JLabel("CMND");
		lblNewLabel_27.setBounds(315, 75, 46, 14);
		panelThongTinNV.add(lblNewLabel_27);

		txtCMND_DanhSach_DanhSachNV = new JTextField();
		txtCMND_DanhSach_DanhSachNV.setBounds(376, 72, 180, 20);
		panelThongTinNV.add(txtCMND_DanhSach_DanhSachNV);
		txtCMND_DanhSach_DanhSachNV.setColumns(10);

		txtTimKiem_DanhSach_DanhSachNhanVien = new JTextField();
		txtTimKiem_DanhSach_DanhSachNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtTimKiem_DanhSach_DanhSachNhanVien.setColumns(10);
		txtTimKiem_DanhSach_DanhSachNhanVien.setBounds(346, 159, 186, 20);
		panelDanhSachNhanVien.add(txtTimKiem_DanhSach_DanhSachNhanVien);

		JLabel label_9 = new JLabel("Thông tin thuốc");
		label_9.setBounds(10, 183, 89, 16);
		panelDanhSachNhanVien.add(label_9);

		JButton btnSua_DanhSach_DanhSachNhanVien = new JButton(" ");
		btnSua_DanhSach_DanhSachNhanVien.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSua_DanhSach_DanhSachNhanVien.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/package_editors (1).png")));
		btnSua_DanhSach_DanhSachNhanVien.setFocusPainted(false);
		btnSua_DanhSach_DanhSachNhanVien.setBounds(289, 152, 33, 33);
		panelDanhSachNhanVien.add(btnSua_DanhSach_DanhSachNhanVien);

		btnTim_DanhSach_DanhSachNV = new JButton(" ");
		btnTim_DanhSach_DanhSachNV.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTim_DanhSach_DanhSachNV.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/search.png")));
		btnTim_DanhSach_DanhSachNV.setBounds(542, 152, 33, 33);
		panelDanhSachNhanVien.add(btnTim_DanhSach_DanhSachNV);

		GroupGioiTinh = new ButtonGroup();
		GroupGioiTinh.add(rdbtnNam_DanhSach_DanhSachNV);
		GroupGioiTinh.add(rdbtnNu_DanhSach_DanhSachNV);

		panelDoanhThuvaBaoCao = new JPanel();
		layeredPane.setLayer(panelDoanhThuvaBaoCao, 0);
		panelDoanhThuvaBaoCao.setBounds(5, 9, 590, 460);
		layeredPane.add(panelDoanhThuvaBaoCao);
		panelDoanhThuvaBaoCao.setLayout(null);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 570, 89);
		panelDoanhThuvaBaoCao.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_19 = new JLabel("Ngày :");
		lblNewLabel_19.setBounds(10, 30, 73, 14);
		panel.add(lblNewLabel_19);

		txtNgay_DoanthuvaBaocao = new JTextField();
		txtNgay_DoanthuvaBaocao.setBounds(69, 27, 108, 20);
		panel.add(txtNgay_DoanthuvaBaocao);
		txtNgay_DoanthuvaBaocao.setColumns(10);

		JButton btnTim_DoanhthuvaBaoCao = new JButton("Tìm");
		btnTim_DoanhthuvaBaoCao.setBounds(220, 26, 89, 23);
		panel.add(btnTim_DoanhthuvaBaoCao);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 104, 570, 345);
		panelDoanhThuvaBaoCao.add(tabbedPane);

		JPanel panelDoanhThu_DoanhThuvaBaoCao = new JPanel();
		tabbedPane.addTab("Doanh Thu", null, panelDoanhThu_DoanhThuvaBaoCao, null);
		panelDoanhThu_DoanhThuvaBaoCao.setLayout(null);


		tabbedPane.addTab("Doanh thu", null, scrollPaneDoanhthu_DoanhThuvaBaoCao=new JScrollPane(tableDoanhThu_Doanhthu_DoanhThuvaBaoCao=
				new JTable(tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao)), null);
		scrollPaneDoanhthu_DoanhThuvaBaoCao.setBounds(0, 0, 565, 268);
		panelDoanhThu_DoanhThuvaBaoCao.add(scrollPaneDoanhthu_DoanhThuvaBaoCao);

		JLabel lblNewLabel_28 = new JLabel("Tổng doanh thu");
		lblNewLabel_28.setBounds(302, 289, 116, 14);
		panelDoanhThu_DoanhThuvaBaoCao.add(lblNewLabel_28);

		textField = new JTextField();
		textField.setBounds(428, 286, 137, 20);
		panelDoanhThu_DoanhThuvaBaoCao.add(textField);
		textField.setColumns(10);

		JButton btnXemChiTiet_DoanhThuvaBaoCao_DoanhThu = new JButton("Xem chi Tiết");
		btnXemChiTiet_DoanhThuvaBaoCao_DoanhThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GiaoDienChiTietDoanhThu().setVisible(true);
			}
		});
		btnXemChiTiet_DoanhThuvaBaoCao_DoanhThu.setBounds(10, 285, 109, 23);
		panelDoanhThu_DoanhThuvaBaoCao.add(btnXemChiTiet_DoanhThuvaBaoCao_DoanhThu);

		panelThuChiDoanhthu_DoanhThuvaBaoCao = new JPanel();
		panelThuChiDoanhthu_DoanhThuvaBaoCao.setOpaque(false);
		tabbedPane.addTab("Báo cáo thu chi", null, panelThuChiDoanhthu_DoanhThuvaBaoCao, null);
		panelThuChiDoanhthu_DoanhThuvaBaoCao.setLayout(null);

		JLabel lblNewLabel_21 = new JLabel("Số hàng nhập trong ngày");
		lblNewLabel_21.setBounds(10, 11, 160, 14);
		panelThuChiDoanhthu_DoanhThuvaBaoCao.add(lblNewLabel_21);

		txtSoHang_BaoCao_DoanhThuvaBaoCao = new JTextField();
		txtSoHang_BaoCao_DoanhThuvaBaoCao.setEditable(false);
		txtSoHang_BaoCao_DoanhThuvaBaoCao.setBounds(167, 8, 86, 20);
		panelThuChiDoanhthu_DoanhThuvaBaoCao.add(txtSoHang_BaoCao_DoanhThuvaBaoCao);
		txtSoHang_BaoCao_DoanhThuvaBaoCao.setColumns(10);

		JLabel lblNewLabel_22 = new JLabel("Tổng giá trị hàng");
		lblNewLabel_22.setBounds(276, 11, 137, 14);
		panelThuChiDoanhthu_DoanhThuvaBaoCao.add(lblNewLabel_22);

		txtTongGiaHang_BaoCao_DoanhThuvaBaoCao = new JTextField();
		txtTongGiaHang_BaoCao_DoanhThuvaBaoCao.setEditable(false);
		txtTongGiaHang_BaoCao_DoanhThuvaBaoCao.setBounds(377, 8, 162, 20);
		panelThuChiDoanhthu_DoanhThuvaBaoCao.add(txtTongGiaHang_BaoCao_DoanhThuvaBaoCao);
		txtTongGiaHang_BaoCao_DoanhThuvaBaoCao.setColumns(10);


		panelThuChiDoanhthu_DoanhThuvaBaoCao.add(scrollPaneBaoCao_DoanhThuvaBaoCao = new JScrollPane(tableBaoCao_DoanhThuvaBaoCao=
				new JTable(tableModelBaoCao_Doanhthu_DoanhThuvaBaoCao)));
		scrollPaneBaoCao_DoanhThuvaBaoCao.setBounds(10, 67, 545, 190);

		JLabel lblNewLabel_23 = new JLabel("Danh sách thuốc bán trong ngày");
		lblNewLabel_23.setBounds(10, 42, 230, 14);
		panelThuChiDoanhthu_DoanhThuvaBaoCao.add(lblNewLabel_23);

		lblNewLabel_29 = new JLabel("Tổng tiền lời");
		lblNewLabel_29.setBounds(377, 281, 82, 14);
		panelThuChiDoanhthu_DoanhThuvaBaoCao.add(lblNewLabel_29);

		textField_1 = new JTextField();
		textField_1.setBounds(469, 278, 86, 20);
		panelThuChiDoanhthu_DoanhThuvaBaoCao.add(textField_1);
		textField_1.setColumns(10);


		panelTinhTrang = new JPanel();
		panelTinhTrang.setOpaque(false);
		panelTinhTrang.setBounds(5, 9, 590, 460);
		layeredPane.add(panelTinhTrang);
		panelTinhTrang.setLayout(null);

		panelTinhTrang.add(scrollPaneTinhTrangThuoc_TinhTrang=new JScrollPane(tableTinhTrangThuoc_TinhTrang=
				new JTable(tableModelTinhTrangThuoc_TinhTrang)));
		scrollPaneTinhTrangThuoc_TinhTrang.setBounds(10, 26, 570, 423);


		/*
		 * Các hàm cần chạy ngay sau khi đã load Giao diện hoàn tất
		 */
		duaDuLieuTuListVaoTable();
		Anpanel();
		textField.setText(control.tongDoanhThu(tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao)+"");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnThemVaoDon_NhapHang_NhapDon)
		{
			//Bấm nút ">>" trong thẻ Nhập đơn của mục nhập hàng
			int row=tableDulieuThuoc_NhapHang_NhapDon.getSelectedRow();
			if(row!=-1)
			{
				Object[] data= {tableDulieuThuoc_NhapHang_NhapDon.getValueAt(row, 0),tableDulieuThuoc_NhapHang_NhapDon.getValueAt(row, 1),
						TimThuocTheoMa(tableDulieuThuoc_NhapHang_NhapDon.getValueAt(row, 0).toString()).getSoLuong()+"",
						TimThuocTheoMa(tableDulieuThuoc_NhapHang_NhapDon.getValueAt(row, 0)+"").getHsd()+""};
				tableModelDulieuthuoc.removeRow(row);
				tableModelThuocNhap.addRow(data);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Chọn thuốc cần nhập");
			}
		}
		else if(e.getSource()==btnSua_DanhSach_DanhSachThuoc)
		{
			//Bấm nút Sửa trong thẻ Danh sách thuốc mục Danh Sách
			int selection =JOptionPane.showConfirmDialog(panelDanhSach, "Bạn chắc chắn sửa ?","Sửa dữ liệu",JOptionPane.YES_NO_OPTION);
			ThongTinThuoc thuocSua = new ThongTinThuoc();

			thuocSua.setMaThuoc(txtMaThuoc_DanhSach_DanhSachThuoc.getText());
			thuocSua.setTenThuoc(txtTenThuoc_DanhSach_DanhSachThuoc.getText());
			thuocSua.setSoLuong(Integer.parseInt(txtSoLuong_DanhSach_DanhSachThuoc.getText()));
			thuocSua.setGiaBan(Double.parseDouble(txtGiaBan_DanhSach_DanhSachThuoc.getText()));
			thuocSua.setGiaNhap(Double.parseDouble(txtGiaNhap_DanhSach_DanhSachThuoc.getText()));
			thuocSua.setNcc(txtNCC_DanhSach_DanhSachThuoc.getText());
			thuocSua.setDonViTinh(txtDonViTinh_DanhSach_DanhSachThuoc.getText());
			thuocSua.setHsd(txtHSD_DanhSach_DanhSachThuoc.getText());
			thuocSua.setSoLuong(Integer.parseInt(txtSoLuong_DanhSach_DanhSachThuoc.getText()));
			thuocSua.setLoai(txtLoai_DanhSach_DanhSachThuoc.getText());

			try {
				if(control.SuaDuLieuThuocTrongSQL(thuocSua))
				{
					if(selection==JOptionPane.YES_OPTION)
						xoaRowtrongTable();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			duaDuLieuTuListVaoTable();
		}
		else if(e.getSource() ==btnXoa_DanhSach_DanhSachThuoc)
		{
			//Bấm nút Xóa trong thẻ Danh sách thuốc mục danh sách
			int selection =JOptionPane.showConfirmDialog(panelDanhSach, "Bạn chắc chắn xóa ?","Xóa",JOptionPane.YES_NO_OPTION);
			int row = tableThongtinThuoc_DanhSach.getSelectedRow();
			String maThuocXoa = (tableThongtinThuoc_DanhSach.getValueAt(row, 0)+"");
			try {
				if(control.xoaThuocTrongSQL(maThuocXoa))
				{
					if(selection==JOptionPane.YES_OPTION)
						xoaRowtrongTable();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			duaDuLieuTuListVaoTable();

		}
		else if(e.getSource() == btnThem_NhapHang_Themthuoc)
		{
			ThongTinThuoc thuoc = new ThongTinThuoc();
			thuoc.setMaThuoc(txtmathuoc_NhapHang_Themthuoc.getText());
			thuoc.setTenThuoc(txtTenThuoc_NhapHang_Themthuoc.getText());
			thuoc.setLoai(txtLoaiThuoc_NhapHang_Themthuoc.getText());
			thuoc.setSoLuong(0);
			thuoc.setHsd("2017/01/01");
			thuoc.setGiaNhap(Double.parseDouble(txtGiaNhap_NhapHang_Themthuoc.getText()));
			thuoc.setGiaBan(Double.parseDouble(txtGiaBan_NhapHang_Themthuoc.getText()));
			thuoc.setNcc(txtNCC_NhapHang_Themthuoc.getText());
			thuoc.setDonViTinh(txtDonViTinh_NhapHang_Themthuoc.getText());
			try {
				control.themThuocVaoSQL(thuoc);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			xoaRowtrongTable();
			for(int i=tableModelThuocNhap.getRowCount()-1;i>=0;i--)
			{
				tableModelThuocNhap.removeRow(i);
			}
			duaDuLieuTuListVaoTable();

			txtmathuoc_NhapHang_Themthuoc.setText("");
			txtTenThuoc_NhapHang_Themthuoc.setText("");
			txtLoaiThuoc_NhapHang_Themthuoc.setText("");
			txtGiaNhap_NhapHang_Themthuoc.setText("");
			txtGiaBan_NhapHang_Themthuoc.setText("");
			txtNCC_NhapHang_Themthuoc.setText("");
			txtDonViTinh_NhapHang_Themthuoc.setText("");
		}
		else if(e.getSource() == btnHoanTat_NhapHang_NhapDon)
		{
			HoaDonNhapHang hdn = new HoaDonNhapHang();
			hdn.setMaHDN(txtMaDon_NhapHang.getText());
			hdn.setNgayNhap(txtNgayLap_NhapHang.getText().toString());
			hdn.setTongGiaNhap(Double.parseDouble(txtTongGia_NhapHang.getText()));
			try {
				control.themHDNVaoSQL(hdn);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			for(int i=tableModelThuocNhap.getRowCount()-1;i>=0;i--)
			{
				CTHoaDonNhap ctHDN = new CTHoaDonNhap();
				ctHDN.setMaHDN(txtMaDon_NhapHang.getText());
				ctHDN.setMaThuoc(tableThuocNhap_NhapHang_NhapDon.getValueAt(i, 0)+"");
				ctHDN.setSoLuong(Integer.parseInt(tableThuocNhap_NhapHang_NhapDon.getValueAt(i, 2)+""));
				ctHDN.setHsd(tableThuocNhap_NhapHang_NhapDon.getValueAt(i, 3)+"");
				try {
					control.themCTHoaDonNhapVaoSQL(ctHDN);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			for(int i=tableThuocNhap_NhapHang_NhapDon.getRowCount()-1;i>=0;i--)
			{
				tableModelThuocNhap.removeRow(i);
			}
			xoaRowtrongTable();
			duaDuLieuTuListVaoTable();
			
		}
	}

	void duaDuLieuTuListVaoTable()
	{
		try {
			ds.docThuoc();
			ds.docBangHDN();
			ds.docBangCTHoaDonNhap();
			ds.docNV();
			ds.docBangHDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (ThongTinThuoc thuoc : ds.listThuoc) 
		{
			Object[] row = {thuoc.getMaThuoc(),thuoc.getTenThuoc(),thuoc.getLoai(),thuoc.getNcc()};
			tableModelThongTinthuoc.addRow(row);
			Object[] row2 = {thuoc.getMaThuoc(),thuoc.getTenThuoc()};
			tableModelDulieuthuoc.addRow(row2);

		}
		for (HoaDonNhapHang hdn : ds.listHDN)
		{
			Object[] row = {hdn.getMaHDN(),hdn.getNgayNhap(),hdn.getTongGiaNhap()};
			tableModel_NhapHang_DanhSachDon.addRow(row);
		}
		
		for(NhanVien nv : ds.listNV)
		{
			Object[] row = {nv.getMaNv(),nv.getHoTenNV(),nv.getNgaySinh(),nv.getGioiTinh(),nv.getDiaChi()};
			tableModelThongTinNV.addRow(row);
		}
		
		for(HoaDonBanHang hdb : ds.listHDB)
		{
			Object[] row = {hdb.getMaHD(),hdb.getMaNVLap(),(TimNVTheoMa(hdb.getMaNVLap())).getHoTenNV(),hdb.getTongTien()};
			tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao.addRow(row);
		}
	}

	/*
	 * Ẩn tất cả các khung làm việc trong các mục
	 */
	void Anpanel()
	{
		panelNhapHang.setVisible(false);
		panelDoanhThuvaBaoCao.setVisible(false);
		panelTinhTrang.setVisible(false);
	}
	public void FillFormThuoc(int row)
	{
		if(row!=-1)
		{
			txtMaThuoc_DanhSach_DanhSachThuoc.setText(tableThongtinThuoc_DanhSach.getValueAt(row, 0)+"");
			txtTenThuoc_DanhSach_DanhSachThuoc.setText(tableThongtinThuoc_DanhSach.getValueAt(row, 1)+"");
			txtNCC_DanhSach_DanhSachThuoc.setText(tableThongtinThuoc_DanhSach.getValueAt(row, 3)+"");
			txtSoLuong_DanhSach_DanhSachThuoc.setText(TimThuocTheoMa(tableThongtinThuoc_DanhSach.getValueAt(row, 0).toString()).getSoLuong()+"");
			txtGiaBan_DanhSach_DanhSachThuoc.setText(TimThuocTheoMa(tableThongtinThuoc_DanhSach.getValueAt(row, 0)+"").getGiaBan()+"");
			txtGiaNhap_DanhSach_DanhSachThuoc.setText(TimThuocTheoMa(tableThongtinThuoc_DanhSach.getValueAt(row, 0)+"").getGiaNhap()+"");
			txtHSD_DanhSach_DanhSachThuoc.setText(TimThuocTheoMa(tableThongtinThuoc_DanhSach.getValueAt(row, 0)+"").getHsd()+"");
			txtDonViTinh_DanhSach_DanhSachThuoc.setText(TimThuocTheoMa(tableThongtinThuoc_DanhSach.getValueAt(row, 0)+"").getDonViTinh()+"");
			txtLoai_DanhSach_DanhSachThuoc.setText(tableThongtinThuoc_DanhSach.getValueAt(row, 2)+"");
		}
	}
	
	public void fillFormNV(int row)
	{
		if(row!=-1)
		{
			txtMaNV_DanhSach_DanhSachNV.setText(tableThongTinNV.getValueAt(row, 0)+"");
			txtTenNV_DanhSach_DanhSachNV.setText(tableThongTinNV.getValueAt(row, 1)+"");
			txtNgaySinh_DanhSach_DanhSachNV.setText(tableThongTinNV.getValueAt(row, 2)+"");
			txtDiaChi_DanhSach_DanhSachNV.setText(tableThongTinNV.getValueAt(row, 4)+"");
			txtCMND_DanhSach_DanhSachNV.setText(TimNVTheoMa(tableThongTinNV.getValueAt(row, 0)+"").getCmnd());
			if((tableThongTinNV.getValueAt(row, 3)+"").equalsIgnoreCase("Nam"))
			{
				rdbtnNam_DanhSach_DanhSachNV.setSelected(true);
			}
			else
				rdbtnNu_DanhSach_DanhSachNV.setSelected(true);
			txtSDT_DanhSach_DanhSachNV.setText(TimNVTheoMa(tableThongTinNV.getValueAt(row, 0)+"").getSdt());
		}
	}
	public ThongTinThuoc TimThuocTheoMa(String ma)
	{
		for (ThongTinThuoc thuoc : ds.listThuoc)
			if(thuoc.getMaThuoc().equalsIgnoreCase(ma))
				return thuoc;
		return null;

	}
	public NhanVien TimNVTheoMa(String ma)
	{
		for (NhanVien nv: ds.listNV)
			if(nv.getMaNv().equalsIgnoreCase(ma))
				return nv;
		return null;
	
	}
	

	public void xoaRowtrongTable()
	{
		for(int i=tableModelThongTinthuoc.getRowCount()-1;i>=0;i--)
		{
			tableModelThongTinthuoc.removeRow(i);	
		}
		for(int i=tableModelDulieuthuoc.getRowCount()-1;i>=0;i--)
		{
			tableModelDulieuthuoc.removeRow(i);
		}
		for(int i=tableModel_NhapHang_DanhSachDon.getRowCount()-1;i>=0;i--)
		{
			tableModel_NhapHang_DanhSachDon.removeRow(i);
		}
		for(int i=tableModelThongTinNV.getRowCount()-1;i>=0;i--)
		{
			tableModelThongTinNV.removeRow(i);
		}
		for(int i=tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao.getRowCount()-1;i>=0;i--)
		{
			tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao.removeRow(i);
		}

	}
}
