package giaodien.QuanLy;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import control.ControlGiaoDien;
import control.DanhSachDuLieu;
import entity.CTHoaDonBan;
import entity.CTHoaDonNhap;
import entity.HoaDonBanHang;
import entity.HoaDonNhapHang;
import entity.NhanVien;
import entity.ThongTinThuoc;
import giaodien.GiaoDienDangNhap;
import giaodien.GiaoDienThongTinNhanVien;
import main.Run;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import java.awt.GridLayout;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Rectangle;
import java.awt.SystemColor;

import javax.swing.Icon;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JViewport;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ListSelectionModel;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;

import java.awt.Toolkit;
import com.toedter.calendar.JDateChooser;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.ComponentOrientation;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.util.Locale;

public class GiaoDienQuanLy extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private JPanel contentPane;
	////*********************Phần Khai báo thanh menu**************
	private JMenuItem itemMnThongTinSanPham;
	private JRadioButtonMenuItem chude1,chude2,chude3,chude4,chude5,chude6,chude7,chude8,chude9,chude10;

	///**********************Phần khai báo thanh ToolBar***********
	private JPanel ThanhToolBar;
	private JToggleButton btnNhapHang,btnDanhSach,btnDaonhThu,btnTinhTrang,btnTrangChu; 

	///**********************Phần khai báo Khu vực làm việc
	private JPanel panelNhapHang,panelDanhSach,panelTinhTrang,panelTrangChu;
	//1-Trang Chủ

	//2-Danh Sách

	private JTextField txtMaThuoc_DanhSach_DanhSachThuoc;
	private JTextField txtTenThuoc_DanhSach_DanhSachThuoc;
	private JTextField txtSoLuong_DanhSach_DanhSachThuoc;
	private JTextField txtGiaNhap_DanhSach_DanhSachThuoc;
	private JTextField txtGiaBan_DanhSach_DanhSachThuoc;
	private JTextField txtNCC_DanhSach_DanhSachThuoc;
	private JTextField txtTimkiem_DanhSach_DanhSachThuoc;
	private JTextField txtHSD_DanhSach_DanhSachThuoc;
	private JTextField txtLoai_DanhSach_DanhSachThuoc;
	private JTextField txtDonViTinh_DanhSach_DanhSachThuoc;
	private JTextField txtMaNV_DanhSach_DanhSachNV;
	private JTextField txtTenNV_DanhSach_DanhSachNV;
	private JTextField txtTimKiem_DanhSach_DanhSachNhanVien;
	private JTextField txtSDT_DanhSach_DanhSachNV;
	private JTextField txtDiaChi_DanhSach_DanhSachNV;
	private JTextField txtCMND_DanhSach_DanhSachNV;
	private JButton btnLuu_DanhSach_DanhSachThuoc;
	private JButton btnXoa_DanhSach_DanhSachThuoc;
	private JButton btnTim_DanhSach_DanhSachThuoc;	
	private JButton btnTim_DanhSach_DanhSachNV;
	private JButton btnChinhSua_DanhSach_DanhSachThuoc ;
	private JButton btnLuu_DanhSach_DanhSachNhanVien;
	private JRadioButton rdbtnNam_DanhSach_DanhSachNV,rdbtnNu_DanhSach_DanhSachNV;
	private JTable tableThongTinNV,tableThongtinThuoc_DanhSach;
	private DefaultTableModel tableModelThongTinthuoc,tableModelThongTinNV ;
	private JScrollPane scrollPane_ThongtinThuoc,scrollPaneNhanVien;
	private JList<String> listTimKiem_DanhSach_DanhSachThuoc;
	private DefaultListModel<String> listModelTimKiem_DanhSach_DanhSachThuoc;	
	//3-Nhập hàng

	private JTabbedPane tabbedPane_NhapHang;
	private JPanel panel_NhapHang_NhapDon;
	private JPanel panel_NhapHang_DanhSach;
	private JPanel panel_NhapHang_ThemThuoc;
	private JLabel lbkiemtrama_Themthuoc,lbKiemtraten_Themthuoc,lbKiemtraLoai_Themthuoc,lbKiemtraGiaBan_Themthuoc;
	private JLabel lbkiemtraNCC_Themthuoc,lbKiemtraDonViTinh_Themthuoc,lbkiemtraGiaNhap_Themthuoc;
	private JTextField txtMaDon_NhapHang;
	private JTextField txtTongGia_NhapHang;
	private JTextField txtmathuoc_NhapHang_Themthuoc;
	private JTextField txtTenThuoc_NhapHang_Themthuoc;
	private JComboBox cbLoaiThuoc_NhapHang_Themthuoc;
	private JTextField txtSoluong_NhapHang_Themthuoc;
	private JTextField txtHSD_NhapHang_Themthuoc;
	private JTextField txtGiaNhap_NhapHang_Themthuoc;
	private JTextField txtGiaBan_NhapHang_Themthuoc;
	private JComboBox cbNCC_NhapHang_Themthuoc;
	private JComboBox cbDonViTinh_NhapHang_Themthuoc;
	private JTextField txtMaThuoc_NhapHang_NhapDon;
	private JTextField txtSoLuong_NhapHang_NhapDon;
	private JButton btnThem_NhapHang_Themthuoc;
	private JButton btnHuy_NhapHang_Themthuoc;
	private JButton btnTim_NhapHang_DanhSachDon;
	private JButton btnHoanTat_NhapHang_NhapDon;
	private JButton btnThemVaoDon_NhapHang_NhapDon,btnXoaKhoiDon_NhapHang_NhapDon;
	private JButton btnXoa_NhapHang_DanhSachDon;	
	private DefaultTableModel tableModelThuocNhap,tableModelDulieuthuoc;
	private DefaultTableModel tableModel_NhapHang_DanhSachDon,tableModel_NhapHang_ChitietDon;
	private JTable tableThuocNhap_NhapHang_NhapDon,tableDulieuThuoc_NhapHang_NhapDon;
	private JTable tableDanhSachDonHang_NhapHang_DanhSachDon,tableChitietDon_NhapHang_DanhSachDon;
	private JScrollPane scrollPane_NhapHang_DanhSachDon,scrollPane_NhapHang_ChiTietDon ;
	private JScrollPane scrollPane_TableThuocNhap,scrollPane_TableDulieuThuoc;
	private JDateChooser dateChooserHSD_NhapHang_NhapDon,datechooserNgayLap_NhapHang,dateChoosertNgay_NhapHang_DanhSachDon;
	private JRadioButton rdbtnTimChinhXac_NhapHang_DanhSachDon,rdbtnTimTheoThang_NhapHang_DanhSachDon,rdbtnTimTheoNam_NhapHang_DanhSachDon;
	private JRadioButton rdbtnHienTatCa_NhapHang_DanhSachDon;
	private DefaultComboBoxModel<String> CBModelLoai_NhapHang_ThemThuoc,CBModelNCC_NhapHang_ThemThuoc,CBModelDonViTinh_NhapHang_ThemThuoc;
	private JDateChooser datechooserNgaySinh_DanhSach_DanhSachNV;
	//4-Doanh thu và báo cáo

	private JPanel panelDoanhThuvaBaoCao;
	private JPanel panelThuChiDoanhthu_DoanhThuvaBaoCao;
	private JButton btnTim_DoanhthuvaBaoCao;
	public JTable tableDoanhThu_Doanhthu_DoanhThuvaBaoCao,tableBaoCao_DoanhThuvaBaoCao;
	public DefaultTableModel tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao,tableModelBaoCao_Doanhthu_DoanhThuvaBaoCao;
	private JScrollPane scrollPaneDoanhthu_DoanhThuvaBaoCao,scrollPaneBaoCao_DoanhThuvaBaoCao,scrollPaneTinhTrangThuoc_TinhTrang ;
	private JDateChooser datechooserNgay_DoanthuvaBaocao;
	private JRadioButton rdbtnHientatca_Doanhthu,rdbtnTimTheoNgay_Doanhthu,rdbtnTimtheoThang_Doanhthu,rdbtnTimTheoNam_Doanhthu;
	//5-Tình Trạng thuốc
	private JTable tableTinhTrangThuoc_TinhTrang;
	private DefaultTableModel tableModelTinhTrangThuoc_TinhTrang;

	///*********************Các class bổ trợ và Component hỗ trợ ************************
	private DateFormat dateformat =new SimpleDateFormat("yyyy-MM-dd");
	private ButtonGroup groupDanhMuc,GroupGioiTinh,GroupChuDe,GroupTimkiem,GroupDoanhthu;
	private MaskFormatter formattext;
	private JScrollPane jsclist;
	private ControlGiaoDien control = new ControlGiaoDien();
	private DanhSachDuLieu ds = new DanhSachDuLieu();
	private JButton btnSua_DanhSach_DanhSachNhanVien;
	private JTextField txtMaNV_BaoCaovaDoanhThu;

	public GiaoDienQuanLy() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GiaoDienQuanLy.class.getResource("/ser/pill.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 80, 800, 615);
		setTitle("Quản lý");

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Hệ thống");
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Đổi giao diện");
		mnNewMenu.add(mnNewMenu_1);

		chude1 = new JRadioButtonMenuItem("McWin",true);
		chude1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doiGiaoDien("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			}
		});
		mnNewMenu_1.add(chude1);

		chude2 = new JRadioButtonMenuItem("Luna");
		chude2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.luna.LunaLookAndFeel");
			}
		});
		mnNewMenu_1.add(chude2);

		chude3 = new JRadioButtonMenuItem("Areo");
		chude3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.aero.AeroLookAndFeel");
			}
		});
		mnNewMenu_1.add(chude3);

		chude4 = new JRadioButtonMenuItem("Texture");
		chude4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.texture.TextureLookAndFeel");
			}
		});
		mnNewMenu_1.add(chude4);

		chude5 = new JRadioButtonMenuItem("aluminium");
		chude5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
			}
		});
		mnNewMenu_1.add(chude5);

		chude6 = new JRadioButtonMenuItem("NimBus");
		chude6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			}
		});
		mnNewMenu_1.add(chude6);

		chude7 = new JRadioButtonMenuItem("Bernstein");
		chude7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
			}
		});
		mnNewMenu_1.add(chude7);

		chude8 = new JRadioButtonMenuItem("Fast");
		chude8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.fast.FastLookAndFeel");
			}
		});
		mnNewMenu_1.add(chude8);

		chude9 = new JRadioButtonMenuItem("Graphite");
		chude9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
			}
		});
		mnNewMenu_1.add(chude9);

		chude10 = new JRadioButtonMenuItem("Mint");
		chude10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiGiaoDien("com.jtattoo.plaf.mint.MintLookAndFeel");
			}
		});
		mnNewMenu_1.add(chude10);

		JMenu menuTroGiup = new JMenu("Trợ giúp");
		menuBar.add(menuTroGiup);

		GroupChuDe =new ButtonGroup();
		GroupChuDe.add(chude1);
		GroupChuDe.add(chude2);
		GroupChuDe.add(chude3);
		GroupChuDe.add(chude4);
		GroupChuDe.add(chude5);
		GroupChuDe.add(chude6);
		GroupChuDe.add(chude7);
		GroupChuDe.add(chude8);
		GroupChuDe.add(chude9);
		GroupChuDe.add(chude10);
		try {
			formattext = new MaskFormatter("####-##-##");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		itemMnThongTinSanPham = new JMenuItem("Thông tin sản phẩm");
		menuTroGiup.add(itemMnThongTinSanPham);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);

		groupDanhMuc=new ButtonGroup();

		ThanhToolBar = new JPanel();
		ThanhToolBar.setBounds(0, 0, 795, 80);
		contentPane.add(ThanhToolBar);
		ThanhToolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));

		JToolBar toolBar = new JToolBar();
		toolBar.setMinimumSize(new Dimension(0, 0));
		ThanhToolBar.add(toolBar);
		toolBar.setVerifyInputWhenFocusTarget(false);

		btnTrangChu = new JToggleButton("Home");
		btnTrangChu.setMnemonic('1');
		btnTrangChu.setSelected(true);
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Anpanel();
				panelTrangChu.setVisible(true);
			}
		});
		groupDanhMuc.add(btnTrangChu);
		btnTrangChu.setMinimumSize(new Dimension(53, 23));
		btnTrangChu.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTrangChu.setVerticalAlignment(SwingConstants.TOP);
		btnTrangChu.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTrangChu.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/home.png")));
		btnTrangChu.setPreferredSize(new Dimension(80, 75));
		btnTrangChu.setMaximumSize(new Dimension(100, 100));
		toolBar.add(btnTrangChu);

		JButton btnNhanVien = new JButton("Thông Tin");
		btnNhanVien.setMnemonic('2');
		GiaoDienThongTinNhanVien tt =new GiaoDienThongTinNhanVien();
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tt.setVisible(true);
			}
		});
		btnNhanVien.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNhanVien.setVerticalAlignment(SwingConstants.TOP);
		btnNhanVien.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNhanVien.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/preferences_desktop_user.png")));
		btnNhanVien.setPreferredSize(new Dimension(80, 75));
		btnNhanVien.setMaximumSize(new Dimension(100, 100));
		toolBar.add(btnNhanVien);
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnThmThuc = new JButton("Thêm Thuốc");
		btnThmThuc.setMnemonic('3');
		btnThmThuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNhapHang.doClick();
				tabbedPane_NhapHang.setSelectedIndex(2);
				txtmathuoc_NhapHang_Themthuoc.requestFocus();
			}
		});
		btnThmThuc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/drug_basket.png")));
		btnThmThuc.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnThmThuc.setVerticalAlignment(SwingConstants.TOP);
		btnThmThuc.setPreferredSize(new Dimension(80, 75));
		btnThmThuc.setMaximumSize(new Dimension(100, 100));
		btnThmThuc.setHorizontalTextPosition(SwingConstants.CENTER);
		toolBar.add(btnThmThuc);



		btnDanhSach = new JToggleButton("Danh Sách");
		btnDanhSach.setMnemonic('4');
		btnDanhSach.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDanhSach.setMaximumSize(new Dimension(75, 75));
		btnDanhSach.setPreferredSize(new Dimension(80, 75));
		toolBar.add(btnDanhSach);
		btnDanhSach.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDanhSach.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/file_manager.png")));
		btnDanhSach.setFocusPainted(false);
		btnDanhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Anpanel();
				panelDanhSach.setVisible(true);
				panelTrangChu.setVisible(false);
			}
		});
		groupDanhMuc.add(btnDanhSach);



		btnNhapHang = new JToggleButton("Nhập Hàng");
		btnNhapHang.setMnemonic('5');
		btnNhapHang.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNhapHang.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNhapHang.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/truck.png")));
		btnNhapHang.setMaximumSize(new Dimension(75, 75));
		btnNhapHang.setPreferredSize(new Dimension(80, 75));
		toolBar.add(btnNhapHang);
		btnNhapHang.setFocusPainted(false);
		btnNhapHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Anpanel();
				panelNhapHang.setVisible(true);
				panelTrangChu.setVisible(false);
				KhoiTaoCBBoxNhapHang();
			}
		});
		groupDanhMuc.add(btnNhapHang);


		btnDaonhThu = new JToggleButton("Doanh Thu");	//Tạo nút DT & Báo cáo
		btnDaonhThu.setMnemonic('6');
		btnDaonhThu.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/report.png")));
		btnDaonhThu.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDaonhThu.setPreferredSize(new Dimension(80, 75));
		btnDaonhThu.setMaximumSize(new Dimension(75, 75));
		toolBar.add(btnDaonhThu);
		btnDaonhThu.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDaonhThu.setFocusPainted(false);
		btnDaonhThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDanhSach.setVisible(false);
				Anpanel();
				panelDoanhThuvaBaoCao.setVisible(true);
				panelTrangChu.setVisible(false);
			}
		});
		groupDanhMuc.add(btnDaonhThu);


		btnTinhTrang = new JToggleButton("Tình Trạng");
		btnTinhTrang.setMnemonic('7');
		btnTinhTrang.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTinhTrang.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTinhTrang.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/properties.png")));
		btnTinhTrang.setPreferredSize(new Dimension(80, 75));
		btnTinhTrang.setMinimumSize(new Dimension(75, 75));
		btnTinhTrang.setMaximumSize(new Dimension(75, 75));
		btnTinhTrang.setSize(new Dimension(75, 75));
		toolBar.add(btnTinhTrang);
		btnTinhTrang.setFocusPainted(false);
		btnTinhTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDanhSach.setVisible(false);
				Anpanel();
				panelTinhTrang.setVisible(true);
				panelTrangChu.setVisible(false);
			}
		});
		groupDanhMuc.add(btnTinhTrang);



		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setMnemonic('8');
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
		btnDangXuat.setPreferredSize(new Dimension(80, 75));
		btnDangXuat.setMaximumSize(new Dimension(100, 100));

		JButton btnThoatChuongTrinh = new JButton("Thoát");
		btnThoatChuongTrinh.setMnemonic('9');
		btnThoatChuongTrinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnThoatChuongTrinh.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnThoatChuongTrinh.setVerticalAlignment(SwingConstants.TOP);
		btnThoatChuongTrinh.setHorizontalTextPosition(SwingConstants.CENTER);
		btnThoatChuongTrinh.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/exit (1).png")));
		btnThoatChuongTrinh.setPreferredSize(new Dimension(80, 75));
		btnThoatChuongTrinh.setMaximumSize(new Dimension(100, 100));
		toolBar.add(btnThoatChuongTrinh);




		/*
		 * Khởi tạo layeredPane chứa các panel làm việc của các Button trên
		 * 
		 */

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(true);
		layeredPane.setBorder(null);
		layeredPane.setBounds(0, 80, 796, 484);
		contentPane.add(layeredPane);


		////	Tạo bảng trong "Danh sách"
		String[] header = "Mã thuốc;Tên thuốc;Loại thuốc;Nhà cung cấp".split(";");  
		tableModelThongTinthuoc = new DefaultTableModel(header,0){ 
			@Override//Override lại phương thức isCellEditable 
			public boolean isCellEditable(int row, int column) { 
				return false;//Trả về false không cho edit. 
			} 
		}; 	

		////	Tạo bảng trong "Nhập hàng"
		String[] header_1="Mã thuốc;Tên thuốc;Số lượng;HSD".split(";");
		tableModelThuocNhap = new DefaultTableModel(header_1, 0){ 
			@Override//Override lại phương thức isCellEditable 
			public boolean isCellEditable(int row, int column) { 
				return false;//Trả về false không cho edit. 
			} 
		}; 
		///		Tạo bảng trong "Nhập hàng"   
		String[] header_2 ="Mã thuôc;Tên thuốc".split(";");
		tableModelDulieuthuoc = new DefaultTableModel(header_2,0){ 
			@Override//Override lại phương thức isCellEditable 
			public boolean isCellEditable(int row, int column) { 
				return false;//Trả về false không cho edit. 
			} 
		}; 
		/// Bảng danh sách đơn nhập hàng
		String[] header_NhapHang_DanhSachDon="Mã đơn;Ngày lập;Tổng giá".split(";");
		tableModel_NhapHang_DanhSachDon = new DefaultTableModel(header_NhapHang_DanhSachDon,0){ 
			@Override//Override lại phương thức isCellEditable 
			public boolean isCellEditable(int row, int column) { 
				return false;//Trả về false không cho edit. 
			} 
		}; 
		///Bảng Chi tiết đơn nhập hàng
		String[] header_NhapHang_ChitietDon="Tên thuốc;Số Lượng;HSD;Tình trạng".split(";");
		tableModel_NhapHang_ChitietDon= new DefaultTableModel(header_NhapHang_ChitietDon, 0){ 
			@Override//Override lại phương thức isCellEditable 
			public boolean isCellEditable(int row, int column) { 
				return false;//Trả về false không cho edit. 
			} 
		}; 
		// BẢng doanh thu
		String[] headerDaonhthu="Mã nhân viên;Tên Nhân viên;Ngày làm;Tổng doanh thu".split(";");
		tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao=new DefaultTableModel(headerDaonhthu, 0){ 
			@Override//Override lại phương thức isCellEditable 
			public boolean isCellEditable(int row, int column) { 
				return false;//Trả về false không cho edit. 
			} 
		}; 
		// Bảng  Báo cáo
		String[] headerBaoCao="Mã thuốc;Tên thuốc;Số lượng bán;đơn vị tính;Tiền lời".split(";");
		tableModelBaoCao_Doanhthu_DoanhThuvaBaoCao=new DefaultTableModel(headerBaoCao, 0){ 
			@Override//Override lại phương thức isCellEditable 
			public boolean isCellEditable(int row, int column) { 
				return false;//Trả về false không cho edit. 
			} 
		}; 
		/// Bảng Tình Trạng Thuốc
		String[] headerTinhTrang="Mã thuốc;Tên thuốc;Loại thuốc;NCC;HSD;Số Lượng;Đơn vị tính;Tình trạng".split(";");
		tableModelTinhTrangThuoc_TinhTrang=new DefaultTableModel(headerTinhTrang,0){ 
			@Override//Override lại phương thức isCellEditable 
			public boolean isCellEditable(int row, int column) { 
				return false;//Trả về false không cho edit. 
			} 
		}; 
		// Bảng thông tin nhân viên
		String[] headerThongTinNV="Mã;Tên;Ngày sinh;Giới tính;Địa chỉ".split(";");
		tableModelThongTinNV =new DefaultTableModel(headerThongTinNV, 0){ 
			@Override//Override lại phương thức isCellEditable 
			public boolean isCellEditable(int row, int column) { 
				return false;//Trả về false không cho edit. 
			} 
		}; 

		/*
		 *  Panel Nhập hàng Chứa các thành phần giao diên của Button Nhập Hàng
		 *  Các căng chỉnh tọa đọ của các thành phần
		 */

		panelDoanhThuvaBaoCao = new JPanel();
		layeredPane.setLayer(panelDoanhThuvaBaoCao, 0);
		panelDoanhThuvaBaoCao.setBounds(0, 0, 795, 484);
		layeredPane.add(panelDoanhThuvaBaoCao);
		panelDoanhThuvaBaoCao.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 770, 98);
		panelDoanhThuvaBaoCao.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_19 = new JLabel("Ngày :");
		lblNewLabel_19.setBounds(10, 17, 73, 14);
		panel.add(lblNewLabel_19);

		btnTim_DoanhthuvaBaoCao = new JButton("Tìm");
		btnTim_DoanhthuvaBaoCao.setBounds(562, 12, 89, 23);
		panel.add(btnTim_DoanhthuvaBaoCao);
		btnTim_DoanhthuvaBaoCao.addActionListener(this);

		datechooserNgay_DoanthuvaBaocao = new JDateChooser();
		datechooserNgay_DoanthuvaBaocao.setDateFormatString("dd / MM /yyyy");
		datechooserNgay_DoanthuvaBaocao.setLocale(new Locale("vi", "VN"));
		datechooserNgay_DoanthuvaBaocao.setBounds(58, 15, 173, 20);
		panel.add(datechooserNgay_DoanthuvaBaocao);

		JLabel lblNewLabel_22 = new JLabel("Mã nhân viên :");
		lblNewLabel_22.setBounds(264, 17, 94, 14);
		panel.add(lblNewLabel_22);

		txtMaNV_BaoCaovaDoanhThu = new JTextField();
		txtMaNV_BaoCaovaDoanhThu.setText("Nhập mã nv nếu muốn");
		txtMaNV_BaoCaovaDoanhThu.setForeground(Color.gray);
		txtMaNV_BaoCaovaDoanhThu.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtMaNV_BaoCaovaDoanhThu.setText("");
				txtMaNV_BaoCaovaDoanhThu.setForeground(Color.BLACK);
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(txtMaNV_BaoCaovaDoanhThu.getText().equals(""))
				{
					txtMaNV_BaoCaovaDoanhThu.setText("Nhập mã nv nếu muốn");
					txtMaNV_BaoCaovaDoanhThu.setForeground(Color.gray);
				}
			}
		});
		txtMaNV_BaoCaovaDoanhThu.setBounds(364, 15, 139, 20);
		panel.add(txtMaNV_BaoCaovaDoanhThu);
		txtMaNV_BaoCaovaDoanhThu.setColumns(10);

		JLabel lblNewLabel_31 = new JLabel("");
		lblNewLabel_31.setToolTipText("Tìm doanh thu cả nv theo thời gian chỉ định . Để trống để tìm hết các nhân viên");
		lblNewLabel_31.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/get_info.png")));
		lblNewLabel_31.setBounds(509, 18, 20, 17);
		panel.add(lblNewLabel_31);

		GroupDoanhthu= new ButtonGroup();
		rdbtnHientatca_Doanhthu = new JRadioButton("Hiện tất cả");
		rdbtnHientatca_Doanhthu.setSelected(true);
		rdbtnHientatca_Doanhthu.setBounds(6, 38, 109, 23);
		panel.add(rdbtnHientatca_Doanhthu);
		GroupDoanhthu.add(rdbtnHientatca_Doanhthu);

		rdbtnTimTheoNgay_Doanhthu = new JRadioButton("Tìm theo chính xác");
		rdbtnTimTheoNgay_Doanhthu.setBounds(146, 38, 139, 23);
		panel.add(rdbtnTimTheoNgay_Doanhthu);
		GroupDoanhthu.add(rdbtnTimTheoNgay_Doanhthu);

		rdbtnTimtheoThang_Doanhthu = new JRadioButton("Tìm theo tháng");
		rdbtnTimtheoThang_Doanhthu.setBounds(6, 64, 120, 23);
		panel.add(rdbtnTimtheoThang_Doanhthu);
		GroupDoanhthu.add(rdbtnTimtheoThang_Doanhthu);

		rdbtnTimTheoNam_Doanhthu = new JRadioButton("Tìm theo năm");
		rdbtnTimTheoNam_Doanhthu.setBounds(146, 64, 139, 23);
		panel.add(rdbtnTimTheoNam_Doanhthu);
		GroupDoanhthu.add(rdbtnTimTheoNam_Doanhthu);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 110, 785, 363);
		panelDoanhThuvaBaoCao.add(tabbedPane);

		JPanel panelDoanhThu_DoanhThuvaBaoCao = new JPanel();
		tabbedPane.addTab("Doanh Thu", null, panelDoanhThu_DoanhThuvaBaoCao, null);
		panelDoanhThu_DoanhThuvaBaoCao.setLayout(null);


		tabbedPane.addTab("Doanh thu", null, scrollPaneDoanhthu_DoanhThuvaBaoCao=new JScrollPane(tableDoanhThu_Doanhthu_DoanhThuvaBaoCao=
				new JTable(tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao)), null);
		scrollPaneDoanhthu_DoanhThuvaBaoCao.setBounds(0, 0, 780, 272);
		panelDoanhThu_DoanhThuvaBaoCao.add(scrollPaneDoanhthu_DoanhThuvaBaoCao);

		JLabel lblNewLabel_28 = new JLabel("Tổng doanh thu");
		lblNewLabel_28.setBounds(525, 305, 116, 14);
		panelDoanhThu_DoanhThuvaBaoCao.add(lblNewLabel_28);

		JTextField TongDoanhThu_DoanhThu_DoanhThu = new JTextField();
		TongDoanhThu_DoanhThu_DoanhThu.setEditable(false);
		TongDoanhThu_DoanhThu_DoanhThu.setEnabled(false);
		TongDoanhThu_DoanhThu_DoanhThu.setBounds(643, 302, 137, 20);
		panelDoanhThu_DoanhThuvaBaoCao.add(TongDoanhThu_DoanhThu_DoanhThu);
		TongDoanhThu_DoanhThu_DoanhThu.setColumns(10);

		JButton btnXemChiTiet_DoanhThuvaBaoCao_DoanhThu = new JButton("Xem chi Tiết");
		btnXemChiTiet_DoanhThuvaBaoCao_DoanhThu.setBounds(10, 301, 109, 23);
		panelDoanhThu_DoanhThuvaBaoCao.add(btnXemChiTiet_DoanhThuvaBaoCao_DoanhThu);

		panelThuChiDoanhthu_DoanhThuvaBaoCao = new JPanel();
		tabbedPane.addTab("Báo cáo thu chi", null, panelThuChiDoanhthu_DoanhThuvaBaoCao, null);
		panelThuChiDoanhthu_DoanhThuvaBaoCao.setLayout(null);


		panelThuChiDoanhthu_DoanhThuvaBaoCao.add(scrollPaneBaoCao_DoanhThuvaBaoCao = new JScrollPane(tableBaoCao_DoanhThuvaBaoCao=
				new JTable(tableModelBaoCao_Doanhthu_DoanhThuvaBaoCao)));
		scrollPaneBaoCao_DoanhThuvaBaoCao.setBounds(10, 36, 758, 221);

		JLabel lblNewLabel_23 = new JLabel("Danh sách thuốc bán trong ngày");
		lblNewLabel_23.setBounds(10, 11, 230, 14);
		panelThuChiDoanhthu_DoanhThuvaBaoCao.add(lblNewLabel_23);

		JLabel lblNewLabel_29 = new JLabel("Tổng tiền lời");
		lblNewLabel_29.setBounds(540, 294, 82, 14);
		panelThuChiDoanhthu_DoanhThuvaBaoCao.add(lblNewLabel_29);

		JTextField TongTienLoi_DoanhThu_BaoCao = new JTextField();
		TongTienLoi_DoanhThu_BaoCao.setEnabled(false);
		TongTienLoi_DoanhThu_BaoCao.setEditable(false);
		TongTienLoi_DoanhThu_BaoCao.setBounds(632, 291, 136, 20);
		panelThuChiDoanhthu_DoanhThuvaBaoCao.add(TongTienLoi_DoanhThu_BaoCao);
		TongTienLoi_DoanhThu_BaoCao.setColumns(10);

		btnXemChiTiet_DoanhThuvaBaoCao_DoanhThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = tableDoanhThu_Doanhthu_DoanhThuvaBaoCao.getSelectedRow();
				if(row!=-1){
					String maHD = tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao.getValueAt(row, 0)+"";
					String maNV = tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao.getValueAt(row, 1)+"";
					String tenNV = tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao.getValueAt(row, 2)+"";
					double tongTien = Double.parseDouble(tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao.getValueAt(row, 3)+"");
					new GiaoDienChiTietDoanhThu(maHD,maNV,tenNV,tongTien).setVisible(true);
				}
			}
		});

		JButton btnXuatBaoCao_DoanhThu_BaoCao = new JButton("Xuất báo cáo");
		btnXuatBaoCao_DoanhThu_BaoCao.addActionListener(new ActionListener() {

			JFileChooser chooser = new JFileChooser();
			public void actionPerformed(ActionEvent e) {
				chooser.setSize(200,300);
				chooser.addChoosableFileFilter(new FileNameExtensionFilter("*.xlsx", ".xlsx"));
				int value =chooser .showSaveDialog(panelThuChiDoanhthu_DoanhThuvaBaoCao);
				if(value==JFileChooser.APPROVE_OPTION)
				{
					File file = chooser.getSelectedFile();
					if(new File(file+"").exists()==false)
					{
						String chuoi="";
						for(int row=0;row<=tableBaoCao_DoanhThuvaBaoCao.getRowCount()-1;row++)
						{
							for(int column=0;column<=4;column++)
							{
								chuoi+=tableBaoCao_DoanhThuvaBaoCao.getValueAt(row, column)+";";
							}

						}
						///Hàm Xuất EXCEL
						control.GhiEXECL(file+".xlsx",chuoi);
					}
					else
					{
						JOptionPane.showMessageDialog(panelThuChiDoanhthu_DoanhThuvaBaoCao,"Tên này đã tồn tại","Thông báo",JOptionPane.CLOSED_OPTION);
						btnXuatBaoCao_DoanhThu_BaoCao.doClick();
					}

				}
				else if(value==JFileChooser.CANCEL_OPTION)
				{
					chooser.cancelSelection();
				}
			}
		});
		btnXuatBaoCao_DoanhThu_BaoCao.setBounds(10, 290, 141, 23);
		panelThuChiDoanhthu_DoanhThuvaBaoCao.add(btnXuatBaoCao_DoanhThu_BaoCao);


		panelNhapHang = new JPanel();
		layeredPane.setLayer(panelNhapHang, 0);
		panelNhapHang.setBounds(0, 0, 795, 484);
		layeredPane.add(panelNhapHang);
		panelNhapHang.setLayout(null);

		tabbedPane_NhapHang = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_NhapHang.setBounds(0, 0, 795, 484);
		panelNhapHang.add(tabbedPane_NhapHang);

		panel_NhapHang_NhapDon = new JPanel();
		tabbedPane_NhapHang.addTab("Nhập đơn", (Icon) null, panel_NhapHang_NhapDon, null);
		SpringLayout sl_panel_NhapHang_NhapDon = new SpringLayout();
		panel_NhapHang_NhapDon.setLayout(sl_panel_NhapHang_NhapDon);

		JPanel panelThonTinDonHang = new JPanel();
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.EAST, panelThonTinDonHang, -504, SpringLayout.EAST, panel_NhapHang_NhapDon);
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
		txtMaDon_NhapHang.setBounds(95, 25, 171, 20);
		panelThonTinDonHang.add(txtMaDon_NhapHang);
		txtMaDon_NhapHang.setColumns(10);

		txtTongGia_NhapHang = new JTextField();
		txtTongGia_NhapHang.setColumns(10);
		txtTongGia_NhapHang.setBounds(95, 75, 171, 20);
		panelThonTinDonHang.add(txtTongGia_NhapHang);

		panelNhapHang.add(scrollPane_TableThuocNhap=new JScrollPane(tableThuocNhap_NhapHang_NhapDon=new JTable(tableModelThuocNhap)));
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.SOUTH, scrollPane_TableThuocNhap, -5, SpringLayout.SOUTH, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.EAST, scrollPane_TableThuocNhap, -10, SpringLayout.EAST, panel_NhapHang_NhapDon);
		panel_NhapHang_NhapDon.add(scrollPane_TableThuocNhap);

		panelNhapHang.add(scrollPane_TableDulieuThuoc=new JScrollPane(tableDulieuThuoc_NhapHang_NhapDon=new JTable(tableModelDulieuthuoc)));
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.NORTH, scrollPane_TableThuocNhap, 0, SpringLayout.NORTH, scrollPane_TableDulieuThuoc);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, scrollPane_TableDulieuThuoc, 6, SpringLayout.WEST, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.SOUTH, scrollPane_TableDulieuThuoc, -5, SpringLayout.SOUTH, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.EAST, scrollPane_TableDulieuThuoc, -507, SpringLayout.EAST, panel_NhapHang_NhapDon);
		panel_NhapHang_NhapDon.add(scrollPane_TableDulieuThuoc);

		btnThemVaoDon_NhapHang_NhapDon = new JButton("");
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.NORTH, btnThemVaoDon_NhapHang_NhapDon, 163, SpringLayout.NORTH, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, btnThemVaoDon_NhapHang_NhapDon, 20, SpringLayout.EAST, scrollPane_TableDulieuThuoc);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.EAST, btnThemVaoDon_NhapHang_NhapDon, -15, SpringLayout.WEST, scrollPane_TableThuocNhap);
		btnThemVaoDon_NhapHang_NhapDon.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/forward.png")));
		btnThemVaoDon_NhapHang_NhapDon.addActionListener(this);
		panel_NhapHang_NhapDon.add(btnThemVaoDon_NhapHang_NhapDon);

		btnXoaKhoiDon_NhapHang_NhapDon = new JButton("");
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.NORTH, btnXoaKhoiDon_NhapHang_NhapDon, 224, SpringLayout.NORTH, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, btnXoaKhoiDon_NhapHang_NhapDon, 20, SpringLayout.EAST, scrollPane_TableDulieuThuoc);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.EAST, btnXoaKhoiDon_NhapHang_NhapDon, -15, SpringLayout.WEST, scrollPane_TableThuocNhap);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.SOUTH, btnThemVaoDon_NhapHang_NhapDon, -11, SpringLayout.NORTH, btnXoaKhoiDon_NhapHang_NhapDon);
		btnXoaKhoiDon_NhapHang_NhapDon.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/back1.png")));
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
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.SOUTH, btnXoaKhoiDon_NhapHang_NhapDon, -80, SpringLayout.NORTH, btnHoanTat_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, scrollPane_TableThuocNhap, 6, SpringLayout.EAST, btnHoanTat_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.NORTH, btnHoanTat_NhapHang_NhapDon, 354, SpringLayout.NORTH, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, btnHoanTat_NhapHang_NhapDon, 6, SpringLayout.EAST, scrollPane_TableDulieuThuoc);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.SOUTH, btnHoanTat_NhapHang_NhapDon, -10, SpringLayout.SOUTH, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.EAST, btnHoanTat_NhapHang_NhapDon, -390, SpringLayout.EAST, panel_NhapHang_NhapDon);
		btnHoanTat_NhapHang_NhapDon.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/done.png")));
		panel_NhapHang_NhapDon.add(btnHoanTat_NhapHang_NhapDon);
		btnHoanTat_NhapHang_NhapDon.addActionListener(this);

		panel_NhapHang_DanhSach = new JPanel();
		tabbedPane_NhapHang.addTab("Danh sách đơn", null, panel_NhapHang_DanhSach, null);
		panel_NhapHang_DanhSach.setLayout(null);
		panel_NhapHang_DanhSach.add(scrollPane_NhapHang_DanhSachDon=new JScrollPane(tableDanhSachDonHang_NhapHang_DanhSachDon =new JTable(tableModel_NhapHang_DanhSachDon)));
		scrollPane_NhapHang_DanhSachDon.setSize(234, 311);
		scrollPane_NhapHang_DanhSachDon.setLocation(12, 134);
		panel_NhapHang_DanhSach.add(scrollPane_NhapHang_ChiTietDon=new JScrollPane(tableChitietDon_NhapHang_DanhSachDon=new JTable(tableModel_NhapHang_ChitietDon)));
		scrollPane_NhapHang_ChiTietDon.setSize(522, 311);
		scrollPane_NhapHang_ChiTietDon.setLocation(258, 134);
		tableChitietDon_NhapHang_DanhSachDon.setEnabled(false);
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
							String tinhtrang=ctHDN.getTinhTrang() !=1 ? "Đã update":"Chưa update";
							Object[] row1 = {ctHDN.getMaThuoc(),ctHDN.getSoLuong(),ctHDN.getHsd(),tinhtrang};
							tableModel_NhapHang_ChitietDon.addRow(row1);
						}	
					}
				}	
			}
		});


		JLabel lblNewLabel_4 = new JLabel("Danh sách Đơn Hàng");
		lblNewLabel_4.setBounds(12, 107, 127, 16);
		panel_NhapHang_DanhSach.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Chi tiết đơn hàng");
		lblNewLabel_5.setBounds(260, 107, 109, 16);
		panel_NhapHang_DanhSach.add(lblNewLabel_5);

		JLabel lblNewLabel_14 = new JLabel("Thời gian :");
		lblNewLabel_14.setBounds(12, 20, 98, 16);
		panel_NhapHang_DanhSach.add(lblNewLabel_14);

		btnTim_NhapHang_DanhSachDon = new JButton("Tìm");
		btnTim_NhapHang_DanhSachDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=tableModel_NhapHang_DanhSachDon.getRowCount()-1;i>=0;i--)
				{
					tableModel_NhapHang_DanhSachDon.removeRow(i);
				}
				for(int i=tableModel_NhapHang_ChitietDon.getRowCount()-1;i>=0;i--)
				{
					tableModel_NhapHang_ChitietDon.removeRow(i);
				}
				if(rdbtnTimChinhXac_NhapHang_DanhSachDon.isSelected())
				{
					for (HoaDonNhapHang hdn : ds.listHDN)
					{
						if(dateformat.format(dateChoosertNgay_NhapHang_DanhSachDon.getDate()).equals(hdn.getNgayNhap()))
						{
							Object[] row = {hdn.getMaHDN(),hdn.getNgayNhap(),hdn.getTongGiaNhap()};
							tableModel_NhapHang_DanhSachDon.addRow(row);
						}	
					}
				}
				else if(rdbtnTimTheoThang_NhapHang_DanhSachDon.isSelected())
				{
					ArrayList<HoaDonNhapHang> ds = control.TimHDNHangTheoThang(dateChoosertNgay_NhapHang_DanhSachDon.getDate().getMonth()+1,
							dateChoosertNgay_NhapHang_DanhSachDon.getDate().getYear()+1900);
					for(HoaDonNhapHang hd : ds)
					{
						Object[] row = {hd.getMaHDN(),hd.getNgayNhap(),hd.getTongGiaNhap()};
						tableModel_NhapHang_DanhSachDon.addRow(row);;
					}
				}
				else if(rdbtnTimTheoNam_NhapHang_DanhSachDon.isSelected())
				{
					ArrayList<HoaDonNhapHang> ds = control.TimHDNHangTheoNam(dateChoosertNgay_NhapHang_DanhSachDon.getDate().getYear()+1900);
					for(HoaDonNhapHang hd : ds)
					{
						Object[] row = {hd.getMaHDN(),hd.getNgayNhap(),hd.getTongGiaNhap()};
						tableModel_NhapHang_DanhSachDon.addRow(row);;
					}	
				}
				else if(rdbtnHienTatCa_NhapHang_DanhSachDon.isSelected())
				{
					for (HoaDonNhapHang hdn : ds.listHDN)
					{
						Object[] row = {hdn.getMaHDN(),hdn.getNgayNhap(),hdn.getTongGiaNhap()};
						tableModel_NhapHang_DanhSachDon.addRow(row);
					}
				}
			}
		});
		btnTim_NhapHang_DanhSachDon.setBounds(588, 15, 98, 26);
		panel_NhapHang_DanhSach.add(btnTim_NhapHang_DanhSachDon);

		btnXoa_NhapHang_DanhSachDon = new JButton("Xóa đơn hàng");
		btnXoa_NhapHang_DanhSachDon.setBounds(588, 52, 98, 26);
		panel_NhapHang_DanhSach.add(btnXoa_NhapHang_DanhSachDon);

		dateChoosertNgay_NhapHang_DanhSachDon = new JDateChooser();
		dateChoosertNgay_NhapHang_DanhSachDon.setDateFormatString("dd / MM / yyyy");
		dateChoosertNgay_NhapHang_DanhSachDon.setLocale(new Locale("vi", "VN"));
		dateChoosertNgay_NhapHang_DanhSachDon.setBounds(98, 20, 158, 20);
		panel_NhapHang_DanhSach.add(dateChoosertNgay_NhapHang_DanhSachDon);

		GroupTimkiem = new ButtonGroup();		
		rdbtnTimChinhXac_NhapHang_DanhSachDon = new JRadioButton("Tìm chính xác");
		rdbtnTimChinhXac_NhapHang_DanhSachDon.setBounds(417, 15, 117, 23);
		panel_NhapHang_DanhSach.add(rdbtnTimChinhXac_NhapHang_DanhSachDon);
		GroupTimkiem.add(rdbtnTimChinhXac_NhapHang_DanhSachDon);

		rdbtnTimTheoThang_NhapHang_DanhSachDon = new JRadioButton("Tìm theo tháng");
		rdbtnTimTheoThang_NhapHang_DanhSachDon.setBounds(275, 54, 130, 23);
		panel_NhapHang_DanhSach.add(rdbtnTimTheoThang_NhapHang_DanhSachDon);
		GroupTimkiem.add(rdbtnTimTheoThang_NhapHang_DanhSachDon);

		rdbtnTimTheoNam_NhapHang_DanhSachDon = new JRadioButton("Tìm theo năm");
		rdbtnTimTheoNam_NhapHang_DanhSachDon.setBounds(417, 52, 109, 23);
		panel_NhapHang_DanhSach.add(rdbtnTimTheoNam_NhapHang_DanhSachDon);
		GroupTimkiem.add(rdbtnTimTheoNam_NhapHang_DanhSachDon);

		rdbtnHienTatCa_NhapHang_DanhSachDon = new JRadioButton("Hiện tất cả đơn",true);
		rdbtnHienTatCa_NhapHang_DanhSachDon.setBounds(275, 17, 130, 23);
		panel_NhapHang_DanhSach.add(rdbtnHienTatCa_NhapHang_DanhSachDon);
		GroupTimkiem.add(rdbtnHienTatCa_NhapHang_DanhSachDon);

		btnXoa_NhapHang_DanhSachDon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row = tableDanhSachDonHang_NhapHang_DanhSachDon.getSelectedRow();
				String ma = tableModel_NhapHang_DanhSachDon.getValueAt(row, 0)+"";
				try {
					control.xoaCTHoaDonNhaptrongSQL(ma);
					control.xoaHDNtrongSQL(ma);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				xoaRowtrongTable();
				duaDuLieuTuListVaoTable();
			}
		});
		tableThuocNhap_NhapHang_NhapDon.setBounds(new Rectangle(0, 0, 278, 301));
		scrollPane_TableDulieuThuoc.setLocation(10, 140);
		scrollPane_TableDulieuThuoc.setSize(137, 302);

		scrollPane_TableThuocNhap.setLocation(220, 140);
		scrollPane_TableThuocNhap.setSize(278, 302);

		JLabel lblNewLabel_15 = new JLabel("Danh sách thuốc");
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.NORTH, lblNewLabel_15, 6, SpringLayout.SOUTH, panelThonTinDonHang);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, lblNewLabel_15, 10, SpringLayout.WEST, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.NORTH, scrollPane_TableDulieuThuoc, 6, SpringLayout.SOUTH, lblNewLabel_15);
		panel_NhapHang_NhapDon.add(lblNewLabel_15);

		JLabel lblNewLabel_16 = new JLabel("Thuốc nhập");
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.NORTH, lblNewLabel_16, 0, SpringLayout.NORTH, lblNewLabel_15);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, lblNewLabel_16, 314, SpringLayout.EAST, lblNewLabel_15);
		panel_NhapHang_NhapDon.add(lblNewLabel_16);

		JPanel panel_1 = new JPanel();
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, panelThonTinDonHang);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.WEST, panel_1, 133, SpringLayout.EAST, panelThonTinDonHang);

		datechooserNgayLap_NhapHang = new JDateChooser();
		datechooserNgayLap_NhapHang.getSpinner().setIgnoreRepaint(true);
		datechooserNgayLap_NhapHang.setDateFormatString("dd / MM / yyyy");
		datechooserNgayLap_NhapHang.setLocale(new Locale("vi", "VN"));
		datechooserNgayLap_NhapHang.setBounds(94, 50, 172, 20);
		panelThonTinDonHang.add(datechooserNgayLap_NhapHang);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.SOUTH, panel_1, 104, SpringLayout.NORTH, panel_NhapHang_NhapDon);
		sl_panel_NhapHang_NhapDon.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, panel_NhapHang_NhapDon);
		panel_1.setBorder(new TitledBorder(null, "Thuoc nhap", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		txtMaThuoc_NhapHang_NhapDon.setEditable(false);
		txtMaThuoc_NhapHang_NhapDon.setColumns(10);
		txtMaThuoc_NhapHang_NhapDon.setBounds(104, 25, 247, 20);
		panel_1.add(txtMaThuoc_NhapHang_NhapDon);

		txtSoLuong_NhapHang_NhapDon = new JTextField();
		txtSoLuong_NhapHang_NhapDon.setColumns(10);
		txtSoLuong_NhapHang_NhapDon.setBounds(104, 50, 247, 20);
		panel_1.add(txtSoLuong_NhapHang_NhapDon);

		dateChooserHSD_NhapHang_NhapDon = new JDateChooser();
		dateChooserHSD_NhapHang_NhapDon.setDateFormatString("dd / MM / yyyy");
		dateChooserHSD_NhapHang_NhapDon.setLocale(new Locale("vi", "VN"));
		dateChooserHSD_NhapHang_NhapDon.setBounds(104, 75, 247, 20);
		panel_1.add(dateChooserHSD_NhapHang_NhapDon);

		panel_NhapHang_ThemThuoc = new JPanel();
		tabbedPane_NhapHang.addTab("Thêm thuốc", null, panel_NhapHang_ThemThuoc, null);
		panel_NhapHang_ThemThuoc.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Mã thuốc");
		lblNewLabel_6.setBounds(12, 30, 55, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Tên Thuốc");
		lblNewLabel_7.setBounds(12, 60, 81, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Loại thuốc");
		lblNewLabel_8.setBounds(12, 90, 81, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Số lượng");
		lblNewLabel_9.setBounds(12, 120, 55, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("HSD");
		lblNewLabel_10.setBounds(12, 150, 55, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Giá nhập");
		lblNewLabel_11.setBounds(12, 180, 55, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("Giá bán");
		lblNewLabel_12.setBounds(12, 210, 55, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Nhà cung cấp");
		lblNewLabel_13.setBounds(12, 240, 81, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_13);

		JLabel lblNewLabel_DonViTinh = new JLabel("Đơn vị tính");
		lblNewLabel_DonViTinh.setBounds(12, 270, 81, 16);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_DonViTinh);

		lbkiemtrama_Themthuoc = new JLabel("");
		lbkiemtrama_Themthuoc.setHorizontalTextPosition(SwingConstants.RIGHT);
		lbkiemtrama_Themthuoc.setHorizontalAlignment(SwingConstants.LEFT);
		lbkiemtrama_Themthuoc.setVisible(false);
		lbkiemtrama_Themthuoc.setBounds(367, 31, 150, 16);
		panel_NhapHang_ThemThuoc.add(lbkiemtrama_Themthuoc);

		lbKiemtraten_Themthuoc = new JLabel("");
		lbKiemtraten_Themthuoc.setHorizontalTextPosition(SwingConstants.RIGHT);
		lbKiemtraten_Themthuoc.setHorizontalAlignment(SwingConstants.LEFT);
		lbKiemtraten_Themthuoc.setVisible(false);
		lbKiemtraten_Themthuoc.setBounds(367, 61, 150, 16);
		panel_NhapHang_ThemThuoc.add(lbKiemtraten_Themthuoc);

		lbKiemtraLoai_Themthuoc = new JLabel("");
		lbKiemtraLoai_Themthuoc.setHorizontalTextPosition(SwingConstants.RIGHT);
		lbKiemtraLoai_Themthuoc.setHorizontalAlignment(SwingConstants.LEFT);
		lbKiemtraLoai_Themthuoc.setVisible(false);
		lbKiemtraLoai_Themthuoc.setBounds(367, 91, 150, 16);
		panel_NhapHang_ThemThuoc.add(lbKiemtraLoai_Themthuoc);

		lbkiemtraGiaNhap_Themthuoc = new JLabel("");
		lbkiemtraGiaNhap_Themthuoc.setHorizontalTextPosition(SwingConstants.RIGHT);
		lbkiemtraGiaNhap_Themthuoc.setHorizontalAlignment(SwingConstants.LEFT);
		lbkiemtraGiaNhap_Themthuoc.setVisible(false);
		lbkiemtraGiaNhap_Themthuoc.setBounds(367, 181, 150, 16);
		panel_NhapHang_ThemThuoc.add(lbkiemtraGiaNhap_Themthuoc);

		lbKiemtraGiaBan_Themthuoc = new JLabel("");
		lbKiemtraGiaBan_Themthuoc.setHorizontalTextPosition(SwingConstants.RIGHT);
		lbKiemtraGiaBan_Themthuoc.setHorizontalAlignment(SwingConstants.LEFT);
		lbKiemtraGiaBan_Themthuoc.setVisible(false);
		lbKiemtraGiaBan_Themthuoc.setBounds(367, 211, 150, 16);
		panel_NhapHang_ThemThuoc.add(lbKiemtraGiaBan_Themthuoc);

		lbkiemtraNCC_Themthuoc = new JLabel("");
		lbkiemtraNCC_Themthuoc.setHorizontalTextPosition(SwingConstants.RIGHT);
		lbkiemtraNCC_Themthuoc.setHorizontalAlignment(SwingConstants.LEFT);
		lbkiemtraNCC_Themthuoc.setVisible(false);
		lbkiemtraNCC_Themthuoc.setBounds(367, 241, 150, 16);
		panel_NhapHang_ThemThuoc.add(lbkiemtraNCC_Themthuoc);

		lbKiemtraDonViTinh_Themthuoc = new JLabel("");
		lbKiemtraDonViTinh_Themthuoc.setHorizontalTextPosition(SwingConstants.RIGHT);
		lbKiemtraDonViTinh_Themthuoc.setHorizontalAlignment(SwingConstants.LEFT);
		lbKiemtraDonViTinh_Themthuoc.setVisible(false);
		lbKiemtraDonViTinh_Themthuoc.setBounds(367, 271, 150, 16);
		panel_NhapHang_ThemThuoc.add(lbKiemtraDonViTinh_Themthuoc);

		txtmathuoc_NhapHang_Themthuoc = new JTextField();
		txtmathuoc_NhapHang_Themthuoc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtmathuoc_NhapHang_Themthuoc.getText().trim().equals(""))
				{
					if(ds.TimThuocTheoMa(txtmathuoc_NhapHang_Themthuoc.getText())==null)
					{
						lbkiemtrama_Themthuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/check.png")));
						lbkiemtrama_Themthuoc.setVisible(true);
						lbkiemtrama_Themthuoc.setText("");
					}
					else
					{
						lbkiemtrama_Themthuoc.setVisible(true);
						lbkiemtrama_Themthuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/stop.png")));
						lbkiemtrama_Themthuoc.setText("Trùng mã");
						lbkiemtrama_Themthuoc.setForeground(Color.RED);
					}
				}
				else
				{
					lbkiemtrama_Themthuoc.setVisible(true);
					lbkiemtrama_Themthuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/stop.png")));
					lbkiemtrama_Themthuoc.setText("Không được trống");
					lbkiemtrama_Themthuoc.setForeground(Color.RED);

				}
			}
		});

		txtmathuoc_NhapHang_Themthuoc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
					txtTenThuoc_NhapHang_Themthuoc.requestFocus();
			}
		});

		txtmathuoc_NhapHang_Themthuoc.setBounds(111, 30, 246, 20);
		panel_NhapHang_ThemThuoc.add(txtmathuoc_NhapHang_Themthuoc);
		txtmathuoc_NhapHang_Themthuoc.setColumns(10);

		txtTenThuoc_NhapHang_Themthuoc = new JTextField();
		txtTenThuoc_NhapHang_Themthuoc.setColumns(10);
		txtTenThuoc_NhapHang_Themthuoc.setBounds(111, 60, 246, 20);
		panel_NhapHang_ThemThuoc.add(txtTenThuoc_NhapHang_Themthuoc);
		txtTenThuoc_NhapHang_Themthuoc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtTenThuoc_NhapHang_Themthuoc.getText().trim().equals(""))
				{
					lbKiemtraten_Themthuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/check.png")));
					lbKiemtraten_Themthuoc.setVisible(true);
					lbKiemtraten_Themthuoc.setText("");
				}
				else
				{
					lbKiemtraten_Themthuoc.setVisible(true);
					lbKiemtraten_Themthuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/stop.png")));
					lbKiemtraten_Themthuoc.setText("Không được trống");
					lbKiemtraten_Themthuoc.setForeground(Color.RED);
				}
			}
		});
		txtTenThuoc_NhapHang_Themthuoc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
					cbLoaiThuoc_NhapHang_Themthuoc.requestFocus();
				else if(arg0.getKeyCode()==KeyEvent.VK_UP)
					txtmathuoc_NhapHang_Themthuoc.requestFocus();
			}
		});
		CBModelLoai_NhapHang_ThemThuoc =new DefaultComboBoxModel<String>();
		CBModelNCC_NhapHang_ThemThuoc=new DefaultComboBoxModel<String>();
		cbLoaiThuoc_NhapHang_Themthuoc = new JComboBox();
		cbLoaiThuoc_NhapHang_Themthuoc.setModel(CBModelLoai_NhapHang_ThemThuoc);
		cbLoaiThuoc_NhapHang_Themthuoc.setEditable(true);
		cbLoaiThuoc_NhapHang_Themthuoc.setBounds(111, 90, 246, 20);
		panel_NhapHang_ThemThuoc.add(cbLoaiThuoc_NhapHang_Themthuoc);

		txtSoluong_NhapHang_Themthuoc = new JTextField();
		txtSoluong_NhapHang_Themthuoc.setEnabled(false);
		txtSoluong_NhapHang_Themthuoc.setEditable(false);
		txtSoluong_NhapHang_Themthuoc.setColumns(10);
		txtSoluong_NhapHang_Themthuoc.setBounds(111, 120, 246, 20);
		panel_NhapHang_ThemThuoc.add(txtSoluong_NhapHang_Themthuoc);

		txtHSD_NhapHang_Themthuoc = new JTextField();
		txtHSD_NhapHang_Themthuoc.setEnabled(false);
		txtHSD_NhapHang_Themthuoc.setEditable(false);
		txtHSD_NhapHang_Themthuoc.setColumns(10);
		txtHSD_NhapHang_Themthuoc.setBounds(111, 150, 246, 20);
		panel_NhapHang_ThemThuoc.add(txtHSD_NhapHang_Themthuoc);

		txtGiaNhap_NhapHang_Themthuoc = new JTextField();
		txtGiaNhap_NhapHang_Themthuoc.setColumns(10);
		txtGiaNhap_NhapHang_Themthuoc.setBounds(111, 180, 246, 20);
		panel_NhapHang_ThemThuoc.add(txtGiaNhap_NhapHang_Themthuoc);
		txtGiaNhap_NhapHang_Themthuoc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtGiaNhap_NhapHang_Themthuoc.getText().trim().equals(""))
				{
					try {
						int i = Integer.parseInt(txtGiaNhap_NhapHang_Themthuoc.getText());
						if(i<0)
						{
							lbkiemtraGiaNhap_Themthuoc.setVisible(true);
							lbkiemtraGiaNhap_Themthuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/stop.png")));
							lbkiemtraGiaNhap_Themthuoc.setText("Giá không được âm");
							lbkiemtraGiaNhap_Themthuoc.setForeground(Color.RED);
						}
						else
						{
							lbkiemtraGiaNhap_Themthuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/check.png")));
							lbkiemtraGiaNhap_Themthuoc.setVisible(true);
							lbkiemtraGiaNhap_Themthuoc.setText("");
						}
					}
					catch(Exception e)
					{
						// TODO: handle finally clause
						lbkiemtraGiaNhap_Themthuoc.setVisible(true);
						lbkiemtraGiaNhap_Themthuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/stop.png")));
						lbkiemtraGiaNhap_Themthuoc.setText("Vui lòng nhập số");
						lbkiemtraGiaNhap_Themthuoc.setForeground(Color.RED);
					}
				}
				else
				{
					lbkiemtraGiaNhap_Themthuoc.setVisible(true);
					lbkiemtraGiaNhap_Themthuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/stop.png")));
					lbkiemtraGiaNhap_Themthuoc.setText("Không được trống");
					lbkiemtraGiaNhap_Themthuoc.setForeground(Color.RED);
				}
			}
		});
		txtGiaNhap_NhapHang_Themthuoc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
					txtGiaBan_NhapHang_Themthuoc.requestFocus();
				else if(arg0.getKeyCode()==KeyEvent.VK_UP)
					cbLoaiThuoc_NhapHang_Themthuoc.requestFocus();
			}
		});

		txtGiaBan_NhapHang_Themthuoc = new JTextField();
		txtGiaBan_NhapHang_Themthuoc.setColumns(10);
		txtGiaBan_NhapHang_Themthuoc.setBounds(111, 210, 246, 20);
		panel_NhapHang_ThemThuoc.add(txtGiaBan_NhapHang_Themthuoc);
		txtGiaBan_NhapHang_Themthuoc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!txtGiaBan_NhapHang_Themthuoc.getText().trim().equals(""))
				{
					try {
						int i = Integer.parseInt(txtGiaBan_NhapHang_Themthuoc.getText());
						if(i<0)
						{
							lbKiemtraGiaBan_Themthuoc.setVisible(true);
							lbKiemtraGiaBan_Themthuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/stop.png")));
							lbKiemtraGiaBan_Themthuoc.setText("Giá không được âm");
							lbKiemtraGiaBan_Themthuoc.setForeground(Color.RED);
						}
						else
						{
							lbKiemtraGiaBan_Themthuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/check.png")));
							lbKiemtraGiaBan_Themthuoc.setVisible(true);
							lbKiemtraGiaBan_Themthuoc.setText("");
						}
					}
					catch(Exception e)
					{
						// TODO: handle finally clause
						lbKiemtraGiaBan_Themthuoc.setVisible(true);
						lbKiemtraGiaBan_Themthuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/stop.png")));
						lbKiemtraGiaBan_Themthuoc.setText("Vui lòng nhập số");
						lbKiemtraGiaBan_Themthuoc.setForeground(Color.RED);
					}
				}
				else
				{
					lbKiemtraGiaBan_Themthuoc.setVisible(true);
					lbKiemtraGiaBan_Themthuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/stop.png")));
					lbKiemtraGiaBan_Themthuoc.setText("Không được trống");
					lbKiemtraGiaBan_Themthuoc.setForeground(Color.RED);
				}
			}
		});
		txtGiaBan_NhapHang_Themthuoc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
					cbNCC_NhapHang_Themthuoc.requestFocus();
				else if(arg0.getKeyCode()==KeyEvent.VK_UP)
					txtGiaNhap_NhapHang_Themthuoc.requestFocus();
			}
		});
		cbNCC_NhapHang_Themthuoc = new JComboBox();
		cbNCC_NhapHang_Themthuoc.setModel(CBModelNCC_NhapHang_ThemThuoc);
		cbNCC_NhapHang_Themthuoc.setEditable(true);
		cbNCC_NhapHang_Themthuoc.setBounds(111, 240, 246, 20);
		panel_NhapHang_ThemThuoc.add(cbNCC_NhapHang_Themthuoc);
		CBModelDonViTinh_NhapHang_ThemThuoc = new DefaultComboBoxModel<String>();
		cbDonViTinh_NhapHang_Themthuoc = new JComboBox();
		cbDonViTinh_NhapHang_Themthuoc.setModel(CBModelDonViTinh_NhapHang_ThemThuoc);
		cbDonViTinh_NhapHang_Themthuoc.setEditable(true);
		cbDonViTinh_NhapHang_Themthuoc.setBounds(111, 270, 246, 20);
		panel_NhapHang_ThemThuoc.add(cbDonViTinh_NhapHang_Themthuoc);

		btnThem_NhapHang_Themthuoc = new JButton("Thêm thuốc");
		btnThem_NhapHang_Themthuoc.addActionListener(this);
		btnThem_NhapHang_Themthuoc.setBounds(111, 301, 106, 26);
		panel_NhapHang_ThemThuoc.add(btnThem_NhapHang_Themthuoc);

		btnHuy_NhapHang_Themthuoc = new JButton("Hủy");
		btnHuy_NhapHang_Themthuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane_NhapHang.setSelectedIndex(0);
			}
		});
		btnHuy_NhapHang_Themthuoc.setBounds(259, 301, 98, 26);
		panel_NhapHang_ThemThuoc.add(btnHuy_NhapHang_Themthuoc);

		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/get_info.png")));
		lblNewLabel_21.setToolTipText("Số lượng sẽ được cập nhật khi thuốc được nhâp về");
		lblNewLabel_21.setBounds(367, 121, 21, 19);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_21);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/get_info.png")));
		label.setToolTipText("HSD sẽ được cập nhật khi thuốc được nhâp về");
		label.setBounds(367, 151, 21, 19);
		panel_NhapHang_ThemThuoc.add(label);

		JLabel lblNewLabel_32 = new JLabel("");
		lblNewLabel_32.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/20160929154306.jpg")));
		lblNewLabel_32.setBounds(0, 0, 790, 456);
		panel_NhapHang_ThemThuoc.add(lblNewLabel_32);

		tableDulieuThuoc_NhapHang_NhapDon.getColumnModel().getColumn(0).setPreferredWidth(19);
		tableThuocNhap_NhapHang_NhapDon.getColumnModel().getColumn(0).setPreferredWidth(60);

		tableDulieuThuoc_NhapHang_NhapDon.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				int row = tableDulieuThuoc_NhapHang_NhapDon.getSelectedRow();
				if(row!=-1)
				{
					txtMaThuoc_NhapHang_NhapDon.setText(tableModelDulieuthuoc.getValueAt(row, 0)+"");
				}

			}
		});



		panelDanhSach = new JPanel();
		layeredPane.setLayer(panelDanhSach, 0);

		panelDanhSach.setBounds(0, 0, 795, 484);
		layeredPane.add(panelDanhSach);
		panelDanhSach.setLayout(null);

		JTabbedPane tabbedPane_DanhSach = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_DanhSach.setBounds(0, 0, 795, 460);
		panelDanhSach.add(tabbedPane_DanhSach);

		JPanel panelDanhSachThuoc = new JPanel();
		tabbedPane_DanhSach.addTab("Danh sách thuốc", null, panelDanhSachThuoc, null);
		panelDanhSachThuoc.setLayout(null);

		JPanel panelThongTinChiTietThuoc = new JPanel();
		panelThongTinChiTietThuoc.setBorder(new TitledBorder(null, "Thông tin chi tiết", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinChiTietThuoc.setBounds(10, 11, 535, 137);
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
		txtSoLuong_DanhSach_DanhSachThuoc.setEditable(false);
		txtSoLuong_DanhSach_DanhSachThuoc.setColumns(10);
		txtSoLuong_DanhSach_DanhSachThuoc.setBounds(80, 75, 45, 20);
		panelThongTinChiTietThuoc.add(txtSoLuong_DanhSach_DanhSachThuoc);


		txtGiaNhap_DanhSach_DanhSachThuoc = new JTextField();
		txtGiaNhap_DanhSach_DanhSachThuoc.setColumns(10);
		txtGiaNhap_DanhSach_DanhSachThuoc.setBounds(365, 25, 160, 20);
		panelThongTinChiTietThuoc.add(txtGiaNhap_DanhSach_DanhSachThuoc);

		txtGiaBan_DanhSach_DanhSachThuoc = new JTextField();
		txtGiaBan_DanhSach_DanhSachThuoc.setColumns(10);
		txtGiaBan_DanhSach_DanhSachThuoc.setBounds(365, 50, 160, 20);
		panelThongTinChiTietThuoc.add(txtGiaBan_DanhSach_DanhSachThuoc);

		txtNCC_DanhSach_DanhSachThuoc = new JTextField();
		txtNCC_DanhSach_DanhSachThuoc.setColumns(10);
		txtNCC_DanhSach_DanhSachThuoc.setBounds(365, 75, 160, 20);
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
		txtDonViTinh_DanhSach_DanhSachThuoc.setEditable(false);
		txtDonViTinh_DanhSach_DanhSachThuoc.setBounds(193, 75, 60, 20);
		panelThongTinChiTietThuoc.add(txtDonViTinh_DanhSach_DanhSachThuoc);
		txtDonViTinh_DanhSach_DanhSachThuoc.setColumns(10);

		JLabel lblNewLabel_24 = new JLabel("Loại thuốc");
		lblNewLabel_24.setBounds(297, 100, 60, 14);
		panelThongTinChiTietThuoc.add(lblNewLabel_24);

		txtLoai_DanhSach_DanhSachThuoc = new JTextField();
		txtLoai_DanhSach_DanhSachThuoc.setBounds(365, 100, 160, 20);
		panelThongTinChiTietThuoc.add(txtLoai_DanhSach_DanhSachThuoc);
		txtLoai_DanhSach_DanhSachThuoc.setColumns(10);

		txtTimkiem_DanhSach_DanhSachThuoc = new JTextField("Tên thuốc....");
		txtTimkiem_DanhSach_DanhSachThuoc.setForeground(Color.GRAY);
		txtTimkiem_DanhSach_DanhSachThuoc.setBounds(551, 18, 186, 20);
		panelDanhSachThuoc.add(txtTimkiem_DanhSach_DanhSachThuoc);
		txtTimkiem_DanhSach_DanhSachThuoc.setColumns(10);

		txtTimkiem_DanhSach_DanhSachThuoc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtTimkiem_DanhSach_DanhSachThuoc.setText("");
				txtTimkiem_DanhSach_DanhSachThuoc.setForeground(Color.BLACK);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(!txtTimkiem_DanhSach_DanhSachThuoc.getText().trim().equals(""))
				{
					//Không làm gì cả
				}
				else
				{
					txtTimkiem_DanhSach_DanhSachThuoc.setForeground(Color.GRAY);
					txtTimkiem_DanhSach_DanhSachThuoc.setText("Tên thuốc....");
					jsclist.setVisible(false);
				}
			}
		});

		//Phần bắt các ký tự nhập vào
		txtTimkiem_DanhSach_DanhSachThuoc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_DOWN)
				{
					listTimKiem_DanhSach_DanhSachThuoc.requestFocus();
					listTimKiem_DanhSach_DanhSachThuoc.setVisible(true);
					listTimKiem_DanhSach_DanhSachThuoc.setSelectedIndex(0);
				}
				else if(e.getKeyCode()==KeyEvent.VK_UP)
				{
					listTimKiem_DanhSach_DanhSachThuoc.requestFocus();
					listTimKiem_DanhSach_DanhSachThuoc.setVisible(true);
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// Phần xử lý và tìm kiếm dữ liệu nhập
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
									listModelTimKiem_DanhSach_DanhSachThuoc.addElement(data[i]);
								}
								jsclist.setVisible(true);
							}
							else
							{
								listModelTimKiem_DanhSach_DanhSachThuoc.removeAllElements();
								jsclist.setVisible(false);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							txtTimkiem_DanhSach_DanhSachThuoc.setText("");
						}
					}
					else
					{
						jsclist.setVisible(false);
						listModelTimKiem_DanhSach_DanhSachThuoc.removeAllElements();
					}
				}
				else
				{
					listModelTimKiem_DanhSach_DanhSachThuoc.removeAllElements();
					jsclist.setVisible(false);
				}
			}
		});


		JLabel lblNewLabel_17 = new JLabel("Thông tin thuốc");
		lblNewLabel_17.setBounds(10, 159, 89, 16);
		panelDanhSachThuoc.add(lblNewLabel_17);

		btnLuu_DanhSach_DanhSachThuoc = new JButton(" ");
		btnLuu_DanhSach_DanhSachThuoc.setEnabled(false);
		btnLuu_DanhSach_DanhSachThuoc.setToolTipText("Lưu thông tin thuốc");
		btnLuu_DanhSach_DanhSachThuoc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLuu_DanhSach_DanhSachThuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/save.png")));
		btnLuu_DanhSach_DanhSachThuoc.addActionListener(this);
		btnLuu_DanhSach_DanhSachThuoc.setBounds(747, 178, 35, 35);
		panelDanhSachThuoc.add(btnLuu_DanhSach_DanhSachThuoc);

		btnXoa_DanhSach_DanhSachThuoc = new JButton(" ");
		btnXoa_DanhSach_DanhSachThuoc.setToolTipText("Xóa dữ liệu");
		btnXoa_DanhSach_DanhSachThuoc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnXoa_DanhSach_DanhSachThuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/deletered.png")));
		btnXoa_DanhSach_DanhSachThuoc.setBounds(747, 224, 35, 35);
		panelDanhSachThuoc.add(btnXoa_DanhSach_DanhSachThuoc);

		btnTim_DanhSach_DanhSachThuoc = new JButton(" ");
		btnTim_DanhSach_DanhSachThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tenthuoc=txtTimkiem_DanhSach_DanhSachThuoc.getText();
				int vitri =ds.TimVitrithuocTrongbang(tenthuoc);
				if(vitri!=-1)
				{
					tableThongtinThuoc_DanhSach.getSelectionModel().setSelectionInterval(vitri,vitri);
					tableThongtinThuoc_DanhSach.scrollRectToVisible(tableThongtinThuoc_DanhSach.getCellRect(vitri, vitri, true));
					jsclist.setVisible(false);
				}
				else
				{
					jsclist.setVisible(false);
					JOptionPane.showMessageDialog(panelDanhSachThuoc,"Không tìm thấy thuốc");

				}
			}
		});
		btnTim_DanhSach_DanhSachThuoc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTim_DanhSach_DanhSachThuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/search.png")));
		btnTim_DanhSach_DanhSachThuoc.setBounds(747, 11, 33, 33);
		panelDanhSachThuoc.add(btnTim_DanhSach_DanhSachThuoc);
		listModelTimKiem_DanhSach_DanhSachThuoc =new DefaultListModel<String>();
		listTimKiem_DanhSach_DanhSachThuoc= new JList<String>(listModelTimKiem_DanhSach_DanhSachThuoc);
		jsclist = new JScrollPane(listTimKiem_DanhSach_DanhSachThuoc);
		listTimKiem_DanhSach_DanhSachThuoc.setSelectionBackground(Color.WHITE);


		listTimKiem_DanhSach_DanhSachThuoc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					txtTimkiem_DanhSach_DanhSachThuoc.setText(listTimKiem_DanhSach_DanhSachThuoc.getSelectedValue()+"");
					btnTim_DanhSach_DanhSachThuoc.doClick();
				}
			}
		});
		jsclist = new JScrollPane(listTimKiem_DanhSach_DanhSachThuoc);
		listTimKiem_DanhSach_DanhSachThuoc.setSelectionBackground(Color.WHITE);
		listTimKiem_DanhSach_DanhSachThuoc.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				Object data = listTimKiem_DanhSach_DanhSachThuoc.getSelectedValue();
				if(data!=null)
				{
					txtTimkiem_DanhSach_DanhSachThuoc.setText(listTimKiem_DanhSach_DanhSachThuoc.getSelectedValue()+"");
				}
			}
		});

		jsclist.setVisible(false);
		listTimKiem_DanhSach_DanhSachThuoc.setVisibleRowCount(4);
		jsclist.setBounds(551, 42, 186, 66);
		panelDanhSachThuoc.add(jsclist);
		jsclist.setVisible(false);
		listTimKiem_DanhSach_DanhSachThuoc.setVisibleRowCount(4);
		jsclist.setBounds(551, 42, 186, 66);
		panelDanhSachThuoc.add(jsclist);
		panelDanhSachThuoc.add(scrollPane_ThongtinThuoc= new JScrollPane(tableThongtinThuoc_DanhSach=new JTable(tableModelThongTinthuoc)));

		btnChinhSua_DanhSach_DanhSachThuoc = new JButton(" ");
		btnChinhSua_DanhSach_DanhSachThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row =tableThongtinThuoc_DanhSach.getSelectedRow();
				if(row!=-1)
				{
					MoKhoaTextFeilDanhSachThuoc(true);
					btnXoa_DanhSach_DanhSachThuoc.setEnabled(false);
					btnChinhSua_DanhSach_DanhSachThuoc.setEnabled(false);
					tableThongtinThuoc_DanhSach.setEnabled(false);
					btnLuu_DanhSach_DanhSachThuoc.setEnabled(true);
				}
				else
					JOptionPane.showMessageDialog(panelDanhSachThuoc,"Vui lòng chọn thuốc cần sửa");
			}
		});
		btnChinhSua_DanhSach_DanhSachThuoc.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/package_editors (1).png")));
		btnChinhSua_DanhSach_DanhSachThuoc.setToolTipText("Chỉnh sửa thuốc");
		btnChinhSua_DanhSach_DanhSachThuoc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnChinhSua_DanhSach_DanhSachThuoc.setBounds(747, 270, 35, 35);
		panelDanhSachThuoc.add(btnChinhSua_DanhSach_DanhSachThuoc);
		tableThongtinThuoc_DanhSach.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row = tableThongtinThuoc_DanhSach.getSelectedRow();
				// Hàm lấy dữ liệu từ bảng đổ ngược về textFeild
				FillFormThuoc(row);

			}
		});
		scrollPane_ThongtinThuoc.setLocation(10, 178);
		scrollPane_ThongtinThuoc.setSize(732, 242);
		btnXoa_DanhSach_DanhSachThuoc.addActionListener(this);

		JPanel panelDanhSachNhanVien = new JPanel();
		panelDanhSachNhanVien.setLayout(null);
		tabbedPane_DanhSach.addTab("Danh Sách nhân viên", null, panelDanhSachNhanVien, null);

		panelDanhSachNhanVien.add(scrollPaneNhanVien =new JScrollPane(tableThongTinNV=new JTable(tableModelThongTinNV)));
		scrollPaneNhanVien.setBounds(10, 175, 727, 245);
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

		JLabel lblNewLabel_20 = new JLabel("Ngày Sinh");
		lblNewLabel_20.setBounds(10, 75, 60, 14);
		panelThongTinNV.add(lblNewLabel_20);

		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setBounds(10, 100, 70, 14);
		panelThongTinNV.add(lblSinThoi);

		txtSDT_DanhSach_DanhSachNV = new JTextField();
		txtSDT_DanhSach_DanhSachNV.setColumns(10);
		txtSDT_DanhSach_DanhSachNV.setBounds(80, 100, 176, 20);
		panelThongTinNV.add(txtSDT_DanhSach_DanhSachNV);

		JLabel lblNewLabel_25 = new JLabel("Giới tính");
		lblNewLabel_25.setBounds(315, 25, 60, 14);
		panelThongTinNV.add(lblNewLabel_25);

		rdbtnNam_DanhSach_DanhSachNV = new JRadioButton("Nam",true);
		rdbtnNam_DanhSach_DanhSachNV.setBounds(376, 21, 60, 23);
		panelThongTinNV.add(rdbtnNam_DanhSach_DanhSachNV);

		rdbtnNu_DanhSach_DanhSachNV = new JRadioButton("Nữ");
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
		txtTimKiem_DanhSach_DanhSachNhanVien.setBounds(582, 18, 155, 20);
		panelDanhSachNhanVien.add(txtTimKiem_DanhSach_DanhSachNhanVien);

		JLabel label_9 = new JLabel("Thông tin thuốc");
		label_9.setBounds(10, 155, 89, 16);
		panelDanhSachNhanVien.add(label_9);

		btnLuu_DanhSach_DanhSachNhanVien = new JButton(" ");
		btnLuu_DanhSach_DanhSachNhanVien.setEnabled(false);
		btnLuu_DanhSach_DanhSachNhanVien.setToolTipText("Lưu thông tin lại");
		btnLuu_DanhSach_DanhSachNhanVien.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLuu_DanhSach_DanhSachNhanVien.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/save.png")));
		btnLuu_DanhSach_DanhSachNhanVien.setBounds(747, 175, 33, 33);
		panelDanhSachNhanVien.add(btnLuu_DanhSach_DanhSachNhanVien);
		btnLuu_DanhSach_DanhSachNhanVien.addActionListener(this);

		btnTim_DanhSach_DanhSachNV = new JButton(" ");
		btnTim_DanhSach_DanhSachNV.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTim_DanhSach_DanhSachNV.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/search.png")));
		btnTim_DanhSach_DanhSachNV.setBounds(747, 11, 33, 33);
		panelDanhSachNhanVien.add(btnTim_DanhSach_DanhSachNV);
		GroupGioiTinh = new ButtonGroup();
		GroupGioiTinh.add(rdbtnNam_DanhSach_DanhSachNV);
		GroupGioiTinh.add(rdbtnNu_DanhSach_DanhSachNV);

		datechooserNgaySinh_DanhSach_DanhSachNV = new JDateChooser();
		datechooserNgaySinh_DanhSach_DanhSachNV.setDateFormatString("dd / MM / yyyy");
		datechooserNgaySinh_DanhSach_DanhSachNV.setLocale(new Locale("vi", "VN"));
		datechooserNgaySinh_DanhSach_DanhSachNV.setBounds(80, 75, 176, 20);
		panelThongTinNV.add(datechooserNgaySinh_DanhSach_DanhSachNV);

		btnSua_DanhSach_DanhSachNhanVien = new JButton(" ");
		btnSua_DanhSach_DanhSachNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableThongTinNV.getSelectedRow();
				if(row!=-1)
				{
					MoKhoaTextFeilDanhSachNV(true);
					tableThongTinNV.setEnabled(false);
					btnSua_DanhSach_DanhSachNhanVien.setEnabled(false);
					btnLuu_DanhSach_DanhSachNhanVien.setEnabled(true);
				}
				else
					JOptionPane.showMessageDialog(panelThongTinNV,"Chọn nhân viên cần sửa");
			}
		});
		btnSua_DanhSach_DanhSachNhanVien.setIcon(new ImageIcon(GiaoDienQuanLy.class.getResource("/ser/package_editors (1).png")));
		btnSua_DanhSach_DanhSachNhanVien.setToolTipText("Sửa thông tinh nhân viên");
		btnSua_DanhSach_DanhSachNhanVien.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSua_DanhSach_DanhSachNhanVien.setBounds(747, 219, 33, 33);
		panelDanhSachNhanVien.add(btnSua_DanhSach_DanhSachNhanVien);

		btnTim_DanhSach_DanhSachThuoc = new JButton(" ");
		btnTim_DanhSach_DanhSachThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tenthuoc=txtTimkiem_DanhSach_DanhSachThuoc.getText();
				int vitri =ds.TimVitrithuocTrongbang(tenthuoc);
				if(vitri!=-1)
				{
					tableThongtinThuoc_DanhSach.getSelectionModel().setSelectionInterval(vitri,vitri);
					tableThongtinThuoc_DanhSach.scrollRectToVisible(tableThongtinThuoc_DanhSach.getCellRect(vitri, vitri, true));
					jsclist.setVisible(false);
				}
				else
				{
					jsclist.setVisible(false);
					JOptionPane.showMessageDialog(panelDanhSachThuoc,"Không tìm thấy thuốc");

				}
			}
		});

		panelTrangChu = new JPanel();
		layeredPane.setLayer(panelTrangChu, 0);
		panelTrangChu.setBounds(0, 0, 795, 484);
		layeredPane.add(panelTrangChu);

		panelTinhTrang = new JPanel();
		panelTinhTrang.setBounds(0, 0, 795, 484);
		layeredPane.add(panelTinhTrang);
		panelTinhTrang.setLayout(null);

		panelTinhTrang.add(scrollPaneTinhTrangThuoc_TinhTrang=new JScrollPane(tableTinhTrangThuoc_TinhTrang=
				new JTable(tableModelTinhTrangThuoc_TinhTrang)));
		scrollPaneTinhTrangThuoc_TinhTrang.setBounds(5, 26, 795, 423);


		/*
		 * Các hàm cần chạy ngay sau khi đã load Giao diện hoàn tất
		 */
		duaDuLieuTuListVaoTable();
		Anpanel();
		TaiTinhTrangThuoc();
		MoKhoaTextFeilDanhSachThuoc(false);
		MoKhoaTextFeilDanhSachNV(false);
		TongDoanhThu_DoanhThu_DoanhThu.setText(control.tongDoanhThu(tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao,3)+"");
		TongTienLoi_DoanhThu_BaoCao.setText(control.tongDoanhThu(tableModelBaoCao_Doanhthu_DoanhThuvaBaoCao, 4)+"");
		for(int i = tableTinhTrangThuoc_TinhTrang.getRowCount()-1;i>=0;i--)
		{
			ThongTinThuoc thuoc = new ThongTinThuoc();
			thuoc = ds.TimThuocTheoMa(tableModelTinhTrangThuoc_TinhTrang.getValueAt(i, 0)+"");
			try {
				control.autoCapNhatThuocHetHan(thuoc, panelTinhTrang);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		TaiTinhTrangThuoc();
	}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnThemVaoDon_NhapHang_NhapDon)
		{
			//Bấm nút ">>" trong thẻ Nhập đơn của mục nhập hàng
			int row=tableDulieuThuoc_NhapHang_NhapDon.getSelectedRow();
			if(row!=-1)
			{
				if(!txtSoLuong_NhapHang_NhapDon.getText().equals(""))
				{
					int soLuong = Integer.parseInt(txtSoLuong_NhapHang_NhapDon.getText());
					if(soLuong >0)
					{
						Object[] data= {tableDulieuThuoc_NhapHang_NhapDon.getValueAt(row, 0),tableDulieuThuoc_NhapHang_NhapDon.getValueAt(row, 1),
								txtSoLuong_NhapHang_NhapDon.getText()+"",
								dateformat.format(dateChooserHSD_NhapHang_NhapDon.getDate())};
						tableModelDulieuthuoc.removeRow(row);
						tableModelThuocNhap.addRow(data);
						txtMaThuoc_NhapHang_NhapDon.setText("");
						txtSoLuong_NhapHang_NhapDon.setText("");
					}
					else
						JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập số lượng >0!");

				}
				else
					JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập số lượng và hạn sử dụng!");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Chọn thuốc cần nhập");
			}
		}
		else if(e.getSource()==btnLuu_DanhSach_DanhSachThuoc)
		{
			//Bấm nút Sửa trong thẻ Danh sách thuốc mục Danh Sách
			ThongTinThuoc thuocSua = new ThongTinThuoc();
			thuocSua.setMaThuoc(txtMaThuoc_DanhSach_DanhSachThuoc.getText());
			thuocSua.setTenThuoc(txtTenThuoc_DanhSach_DanhSachThuoc.getText());
			thuocSua.setNcc(txtNCC_DanhSach_DanhSachThuoc.getText());
			thuocSua.setDonViTinh(txtDonViTinh_DanhSach_DanhSachThuoc.getText());
			thuocSua.setHsd(txtHSD_DanhSach_DanhSachThuoc.getText());
			thuocSua.setSoLuong(Integer.parseInt(txtSoLuong_DanhSach_DanhSachThuoc.getText()));
			thuocSua.setLoai(txtLoai_DanhSach_DanhSachThuoc.getText());
			try {
				if(!control.kiemTraDuLieuSo(txtGiaBan_DanhSach_DanhSachThuoc.getText()) || !control.kiemTraDuLieuSo(txtGiaNhap_DanhSach_DanhSachThuoc.getText()))
				{
					JOptionPane.showMessageDialog(panelDanhSach,"Giá nhập, Giá Bán phải là số");
				}
				else if(Double.parseDouble(txtGiaBan_DanhSach_DanhSachThuoc.getText())<0 || Double.parseDouble(txtGiaNhap_DanhSach_DanhSachThuoc.getText())<0)
				{
					JOptionPane.showMessageDialog(panelDanhSach,"Giá nhập, Giá Bán không được âm");
				}
				else
				{
					int selection =JOptionPane.showConfirmDialog(panelDanhSach, "Bạn chắc chắn sửa ?","Sửa dữ liệu",JOptionPane.YES_NO_CANCEL_OPTION);
					thuocSua.setGiaBan(Double.parseDouble(txtGiaBan_DanhSach_DanhSachThuoc.getText()));
					thuocSua.setGiaNhap(Double.parseDouble(txtGiaNhap_DanhSach_DanhSachThuoc.getText()));
					if(selection==JOptionPane.YES_OPTION)
					{

						if(control.SuaDuLieuThuocTrongSQL(thuocSua))
						{
							tableThongtinThuoc_DanhSach.setEnabled(true);
							btnXoa_DanhSach_DanhSachThuoc.setEnabled(true);
							btnChinhSua_DanhSach_DanhSachThuoc.setEnabled(true);
							btnLuu_DanhSach_DanhSachThuoc.setEnabled(false);
							MoKhoaTextFeilDanhSachThuoc(false);
							xoaRowtrongTable();
							duaDuLieuTuListVaoTable();
						}
					}
					else if(selection==JOptionPane.NO_OPTION)
					{
						tableThongtinThuoc_DanhSach.setEnabled(true);
						btnXoa_DanhSach_DanhSachThuoc.setEnabled(true);
						btnChinhSua_DanhSach_DanhSachThuoc.setEnabled(true);
						btnLuu_DanhSach_DanhSachThuoc.setEnabled(false);
						MoKhoaTextFeilDanhSachThuoc(false);
					}
				}
				FillFormThuoc(tableThongtinThuoc_DanhSach.getSelectedRow());
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			catch (Exception e2)
			{
				JOptionPane.showMessageDialog(panelDanhSach, "Kiểm tra giá nhập, Giá bán phải là số");
			}
		}
		else if(e.getSource() ==btnXoa_DanhSach_DanhSachThuoc)
		{
			//Bấm nút Xóa trong thẻ Danh sách thuốc mục danh sách
			int row = tableThongtinThuoc_DanhSach.getSelectedRow();
			if(row!=-1)
			{
				String maThuocXoa = (tableThongtinThuoc_DanhSach.getValueAt(row, 0)+"");
				int selection =JOptionPane.showConfirmDialog(panelDanhSach, "Bạn chắc chắn xóa ?","Xóa",JOptionPane.YES_NO_OPTION);
				try {

					if(selection==JOptionPane.YES_OPTION)
					{	
						if(control.xoaThuocTrongSQL(maThuocXoa))
						{
							xoaRowtrongTable();
							duaDuLieuTuListVaoTable();
						}
						else
							JOptionPane.showMessageDialog(panelDanhSach,"Không được xóa! Thuốc này đã nằm trong danh sách bán hàng");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(panelDanhSach,"Thuốc không thể xóa!");
				}
			}
			else
				JOptionPane.showMessageDialog(panelDanhSach, "Vui lòng chọn thuốc cần xóa");

		}
		else if(e.getSource() == btnThem_NhapHang_Themthuoc)
		{

			try {
				if(Double.parseDouble(txtGiaNhap_NhapHang_Themthuoc.getText())>0 && Double.parseDouble(txtGiaBan_NhapHang_Themthuoc.getText()) >0)
				{
					ThongTinThuoc thuoc = new ThongTinThuoc();
					thuoc.setMaThuoc(txtmathuoc_NhapHang_Themthuoc.getText());
					thuoc.setTenThuoc(txtTenThuoc_NhapHang_Themthuoc.getText());
					thuoc.setLoai(cbLoaiThuoc_NhapHang_Themthuoc.getSelectedItem()+"");
					thuoc.setSoLuong(0);
					thuoc.setHsd("2017/01/01");
					thuoc.setGiaNhap(Double.parseDouble(txtGiaNhap_NhapHang_Themthuoc.getText()));
					thuoc.setGiaBan(Double.parseDouble(txtGiaBan_NhapHang_Themthuoc.getText()));
					thuoc.setNcc(cbNCC_NhapHang_Themthuoc.getSelectedItem()+"");
					thuoc.setDonViTinh(cbDonViTinh_NhapHang_Themthuoc.getSelectedItem()+"");
					if(control.themThuocVaoSQL(thuoc))
					{
						xoaRowtrongTable();
						for(int i=tableModelThuocNhap.getRowCount()-1;i>=0;i--)
						{
							tableModelThuocNhap.removeRow(i);
						}
						duaDuLieuTuListVaoTable();

						txtmathuoc_NhapHang_Themthuoc.setText("");
						txtTenThuoc_NhapHang_Themthuoc.setText("");
						cbLoaiThuoc_NhapHang_Themthuoc.setSelectedItem(0);
						txtGiaNhap_NhapHang_Themthuoc.setText("");
						txtGiaBan_NhapHang_Themthuoc.setText("");
						cbNCC_NhapHang_Themthuoc.setSelectedItem(0);
						cbDonViTinh_NhapHang_Themthuoc.setSelectedItem(0);
						KhoiTaoCBBoxNhapHang();
					}
					else
					{
						JOptionPane.showMessageDialog(panel_NhapHang_ThemThuoc,"Lỗi!Kiểm tra lại thông tin nhập vào");
					}
				}
				else
					JOptionPane.showMessageDialog(panel_NhapHang_ThemThuoc,"Giá phải lớn hơn 0");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(panel_NhapHang_ThemThuoc, "Khong the them");
			}
		}
		else if(e.getSource() == btnHoanTat_NhapHang_NhapDon)
		{
			HoaDonNhapHang hdn = new HoaDonNhapHang();
			hdn.setMaHDN(txtMaDon_NhapHang.getText());
			hdn.setNgayNhap(dateformat.format(datechooserNgayLap_NhapHang.getDate()));
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
				ctHDN.setTinhTrang(1);
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
			txtMaDon_NhapHang.setText("");
			txtTongGia_NhapHang.setText("");
		}
		else if(e.getSource()==btnTim_DoanhthuvaBaoCao)
		{
			xoaRowtrongTable();
			String mnv ="";
			ArrayList<HoaDonBanHang> hoadon=null;
			if(!txtMaNV_BaoCaovaDoanhThu.getText().equals("Nhập mã nv nếu muốn"))
			{
				mnv=txtMaNV_BaoCaovaDoanhThu.getText();
			}
			if(rdbtnHientatca_Doanhthu.isSelected())
			{
				hoadon=ds.listHDB;
			}
			else if(rdbtnTimTheoNgay_Doanhthu.isSelected())
			{
				String ngay = dateformat.format(datechooserNgay_DoanthuvaBaocao.getDate());
				hoadon=control.TimHDNBanTheoNgay(ngay);
			}
			else if(rdbtnTimtheoThang_Doanhthu.isSelected())
			{
				int thang = datechooserNgay_DoanthuvaBaocao.getDate().getMonth()+1;
				hoadon=control.TimHDNBanTheoThang(thang);
			}
			else if(rdbtnTimTheoNam_Doanhthu.isSelected())
			{
				int nam = datechooserNgay_DoanthuvaBaocao.getDate().getYear()+1900;
				hoadon=control.TimHDNBanTheoNam(nam);
			}
			for(HoaDonBanHang hd : hoadon)
			{
				if(mnv.equals(""))
				{
					Object[] row = {hd.getMaNVLap(),ds.TimNVTheoMa(hd.getMaNVLap()).getHoTenNV(),hd.getNgayLap(),hd.getTongTien()};
					tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao.addRow(row);
				}
				else
				{
					if(hd.getMaNVLap().equalsIgnoreCase(mnv))
					{
						Object[] row = {hd.getMaNVLap(),ds.TimNVTheoMa(hd.getMaNVLap()).getHoTenNV(),hd.getNgayLap(),hd.getTongTien()};
						tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao.addRow(row);
					}
				}
			}
		}	
		else if(e.getSource()==btnLuu_DanhSach_DanhSachNhanVien)
		{
			String maNV = txtMaNV_DanhSach_DanhSachNV.getText();
			String ngaySinh =dateformat.format(datechooserNgaySinh_DanhSach_DanhSachNV.getDate());
			String sdt =txtSDT_DanhSach_DanhSachNV.getText();
			String diaChi = txtDiaChi_DanhSach_DanhSachNV.getText();
			String CMND =txtCMND_DanhSach_DanhSachNV.getText();
			String gioiTinh = rdbtnNam_DanhSach_DanhSachNV.isSelected() ? "Nam" : "Nữ";
			try
			{
				if(control.kiemTraDuLieuSo(CMND) && control.kiemTraDuLieuSo(sdt))
				{
					if(Long.parseLong(CMND)>0 && Long.parseLong(sdt)>0)
					{
						try {
							int selection = JOptionPane.showConfirmDialog(panelDanhSach, "Bạn có muốn lưu","Chú ý",JOptionPane.YES_NO_CANCEL_OPTION);
							if(selection==JOptionPane.YES_OPTION)
							{
								control.suaDuLieuNVTrongSQL(maNV, ngaySinh, sdt, diaChi, CMND, gioiTinh);
								MoKhoaTextFeilDanhSachNV(false);
								tableThongTinNV.setEnabled(true);
								btnSua_DanhSach_DanhSachNhanVien.setEnabled(true);
								btnLuu_DanhSach_DanhSachNhanVien.setEnabled(false);
								xoaRowtrongTable();
								duaDuLieuTuListVaoTable();
							}
							else if(selection==JOptionPane.NO_OPTION)
							{
								MoKhoaTextFeilDanhSachNV(false);
								tableThongTinNV.setEnabled(true);
								btnSua_DanhSach_DanhSachNhanVien.setEnabled(true);
								btnLuu_DanhSach_DanhSachNhanVien.setEnabled(false);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else
						JOptionPane.showMessageDialog(panelDanhSach, "SDDT và CMND không được chứa ký tự đặt biệt");
				}
				else
					JOptionPane.showMessageDialog(panelDanhSach, "SĐT và CMND phải là số");

			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(panelDanhSach,"Giá trị bạn nhập vào :"+ex.getMessage()+" không có nghĩa");
			}
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
			ds.docBangCTHoaDonBan();
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
			Object[] row = {hdb.getMaNVLap(),ds.TimNVTheoMa(hdb.getMaNVLap()).getHoTenNV(),hdb.getNgayLap(),hdb.getTongTien()};
			tableModelDoanhThu_Doanhthu_DoanhThuvaBaoCao.addRow(row);
		}
		for(CTHoaDonBan ctHDB : ds.listThuocBan)
		{
			String maHD = ctHDB.getMaHD();
			try {
				if((control.timHDBtheoMa(maHD).getNgayLap()).equals(control.layNgayHeThong()))
				{
					Object[] row = {ctHDB.getMaThuoc(),ctHDB.getTenThuoc(),ctHDB.getSoLuong(),ds.TimThuocTheoMa(ctHDB.getMaThuoc()).getDonViTinh(),(control.tinhTienLoi(ctHDB.getMaThuoc(), ctHDB.getSoLuong()))+""};
					tableModelBaoCao_Doanhthu_DoanhThuvaBaoCao.addRow(row);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(panelThuChiDoanhthu_DoanhThuvaBaoCao, "Chưa có thuốc nào được bán trong hôm nay!");
			}
		}
	}

	/*
	 * Ẩn tất cả các khung làm việc trong các mục
	 */
	void Anpanel()
	{
		panelDanhSach.setVisible(false);
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
			txtSoLuong_DanhSach_DanhSachThuoc.setText(ds.TimThuocTheoMa(tableThongtinThuoc_DanhSach.getValueAt(row, 0).toString()).getSoLuong()+"");
			txtGiaBan_DanhSach_DanhSachThuoc.setText(ds.TimThuocTheoMa(tableThongtinThuoc_DanhSach.getValueAt(row, 0)+"").getGiaBan()+"");
			txtGiaNhap_DanhSach_DanhSachThuoc.setText(ds.TimThuocTheoMa(tableThongtinThuoc_DanhSach.getValueAt(row, 0)+"").getGiaNhap()+"");
			txtHSD_DanhSach_DanhSachThuoc.setText(ds.TimThuocTheoMa(tableThongtinThuoc_DanhSach.getValueAt(row, 0)+"").getHsd()+"");
			txtDonViTinh_DanhSach_DanhSachThuoc.setText(ds.TimThuocTheoMa(tableThongtinThuoc_DanhSach.getValueAt(row, 0)+"").getDonViTinh()+"");
			txtLoai_DanhSach_DanhSachThuoc.setText(tableThongtinThuoc_DanhSach.getValueAt(row, 2)+"");
		}
	}

	public void fillFormNV(int row)
	{
		if(row!=-1)
		{
			Date date = null;
			txtMaNV_DanhSach_DanhSachNV.setText(tableThongTinNV.getValueAt(row, 0)+"");
			txtTenNV_DanhSach_DanhSachNV.setText(tableThongTinNV.getValueAt(row, 1)+"");
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(tableThongTinNV.getValueAt(row, 2)+"");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			datechooserNgaySinh_DanhSach_DanhSachNV.setDate(date);
			txtDiaChi_DanhSach_DanhSachNV.setText(tableThongTinNV.getValueAt(row, 4)+"");
			txtCMND_DanhSach_DanhSachNV.setText(ds.timNVTheoMa(tableThongTinNV.getValueAt(row, 0)+"").getCmnd());
			if((tableThongTinNV.getValueAt(row, 3)+"").equalsIgnoreCase("Nam"))
			{
				rdbtnNam_DanhSach_DanhSachNV.setSelected(true);
			}
			else
				rdbtnNu_DanhSach_DanhSachNV.setSelected(true);
			txtSDT_DanhSach_DanhSachNV.setText(ds.timNVTheoMa(tableThongTinNV.getValueAt(row, 0)+"").getSdt());
		}
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
		for(int i=tableModel_NhapHang_ChitietDon.getRowCount()-1;i>=0;i--)
		{
			tableModel_NhapHang_ChitietDon.removeRow(i);
		}
		for(int i=tableModelBaoCao_Doanhthu_DoanhThuvaBaoCao.getRowCount()-1;i>=0;i--)
		{
			tableModelBaoCao_Doanhthu_DoanhThuvaBaoCao.removeRow(i);
		}

	}
	public void doiGiaoDien(String chude)
	{
		try
		{
			UIManager.setLookAndFeel(chude);
			SwingUtilities.updateComponentTreeUI(GiaoDienQuanLy.this);
			control.LuuChuDe(chude);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void TaiTinhTrangThuoc()
	{
		String tinhtrang ="";
		for(int i=tableModelTinhTrangThuoc_TinhTrang.getRowCount()-1;i>=0;i--)
			tableModelTinhTrangThuoc_TinhTrang.removeRow(i);
		for (ThongTinThuoc thuoc : ds.listThuoc) 
		{
			int i=control.KiemTraTinhTrang(thuoc);
			if(i==1)
			{
				tinhtrang="Hết hạn sử dụng";
			}
			else if(i==2)
			{
				tinhtrang="Hết số lượng";
			}
			if(i>0)
			{
				Object[] row = {thuoc.getMaThuoc(),thuoc.getTenThuoc(),thuoc.getLoai(),thuoc.getNcc(),thuoc.getHsd(),thuoc.getSoLuong(),thuoc.getDonViTinh(),tinhtrang};
				tableModelTinhTrangThuoc_TinhTrang.addRow(row);
			}
		}
	}
	public void MoKhoaTextFeilDanhSachThuoc(Boolean b)
	{
		txtTenThuoc_DanhSach_DanhSachThuoc.setEditable(b);
		txtGiaBan_DanhSach_DanhSachThuoc.setEditable(b);
		txtGiaNhap_DanhSach_DanhSachThuoc.setEditable(b);
		txtLoai_DanhSach_DanhSachThuoc.setEditable(b);
		txtNCC_DanhSach_DanhSachThuoc.setEditable(b);
	}
	public void MoKhoaTextFeilDanhSachNV(Boolean b)
	{
		txtTenNV_DanhSach_DanhSachNV.setEditable(b);
		txtSDT_DanhSach_DanhSachNV.setEditable(b);
		rdbtnNam_DanhSach_DanhSachNV.setEnabled(b);
		rdbtnNu_DanhSach_DanhSachNV.setEnabled(b);
		datechooserNgaySinh_DanhSach_DanhSachNV.getSpinner().setEnabled(b);
		txtDiaChi_DanhSach_DanhSachNV.setEditable(b);
		txtCMND_DanhSach_DanhSachNV.setEditable(b);
	}
	public void KhoiTaoCBBoxNhapHang()
	{

		String[] loai =control.DSLoaithuoc().split(";");
		String[] NCC =control.DSNCC().split(";");
		String[] DVT =control.DSDonViTinh().split(";");
		CBModelLoai_NhapHang_ThemThuoc.removeAllElements();
		CBModelNCC_NhapHang_ThemThuoc.removeAllElements();
		CBModelDonViTinh_NhapHang_ThemThuoc.removeAllElements();
		for(int i=0;i<loai.length;i++)
		{
			CBModelLoai_NhapHang_ThemThuoc.addElement(loai[i]);
		}

		for(int i=0;i<NCC.length;i++)
		{
			CBModelNCC_NhapHang_ThemThuoc.addElement(NCC[i]);
		}

		for(int i=0;i<DVT.length;i++)
		{
			CBModelDonViTinh_NhapHang_ThemThuoc.addElement(DVT[i]);
		}
	}

}
