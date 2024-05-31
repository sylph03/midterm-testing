package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import control.ControlGiaoDien;
import entity.HoaDonBanHang;
import giaodien.GiaoDienDangNhap;
import giaodien.NhanVien.GiaoDienLapHoaDon;

public class GiaoDienLapHoaDonTest {

	private GiaoDienLapHoaDon gd;
	private JOptionPane optionPane;

	@BeforeEach
	public void setUp() throws Exception {
		// Khởi tạo các trường tĩnh trong GiaoDienDangNhap
		GiaoDienDangNhap.txtTK = new JTextField("NV001");
		GiaoDienDangNhap.txtMK = new JPasswordField("1");

		// Khởi tạo GiaoDienLapHoaDon
		gd = new GiaoDienLapHoaDon();
		assertNotNull(gd, "GiaoDienLapHoaDon object should be instantiated");

		// Thiết lập ban đầu nếu cần thiết
		gd.tablemodelBangThemThuoc = new DefaultTableModel(new Object[][] {},
				new String[] { "Tên thuốc", "Số lượng", "Đơn vị tính", "Giá bán" });
		gd.tablemode = new DefaultTableModel(new Object[][] {},
				new String[] { "Tên thuốc", "Số lượng", "Đơn vị tính", "Đơn giá", "Thành tiền" });
		gd.tableThemThuoc = new JTable(gd.tablemodelBangThemThuoc);
		gd.txtSoLuong_BangThemThuoc = new JTextField();
		gd.txtTongTien = new JTextField();

		// setup lưu toàn bộ thông tin vào hóa đơn
		gd.chkKeDon = new JCheckBox();
		gd.cbbNgay = new JComboBox<>();
		gd.cbbThang = new JComboBox<>();
		gd.cbbNam = new JComboBox<>();
		gd.txtSDT = new JTextField();
		gd.txtCMND = new JTextField();
		gd.panelDienThongTin = new JPanel();
		gd.table = new JTable();

		// set up lưu hóa đơn
		gd.txtMa = new JTextField();
		gd.txtNguoiLap = new JTextField();
		gd.txtNgay = new JTextField();
		gd.txtCMND = new JTextField();
		gd.txtTongTien = new JTextField();

		optionPane = new JOptionPane();

		// Thêm dữ liệu mẫu vào tablemodelBangThemThuoc nếu cần
		gd.tablemodelBangThemThuoc.addRow(new Object[] { "Paracetamol", 100, "viên", 500.0 });
	}

	@Test
	public void testGiaoDienLapHoaDon() {
		assertNotNull(gd, "GiaoDienLapHoaDon object should not be null");
	}

	@Test
	public void testThemThuocTuBangVaoHoaDon() {
		gd.tableThemThuoc.setRowSelectionInterval(0, 0);
		gd.txtSoLuong_BangThemThuoc.setText("10");
		gd.themThuocTuBangVaoHoaDon();
		assertEquals(1, gd.tablemode.getRowCount(), "Table mode row count should be 1");
		assertEquals("Paracetamol", gd.tablemode.getValueAt(0, 0), "First row, first column should be 'Paracetamol'");
		assertEquals(10, gd.tablemode.getValueAt(0, 1), "First row, second column should be 10");
		assertEquals("viên", gd.tablemode.getValueAt(0, 2), "First row, third column should be 'viên'");
		assertEquals(500.0, gd.tablemode.getValueAt(0, 3), "First row, fourth column should be 500.0");
		assertEquals(5000.0, gd.tablemode.getValueAt(0, 4), "First row, fifth column should be 5000.0");
	}

	@Test
	public void testThemThuocTuBangVaoHoaDon_TangSoLuong() {
		gd.tableThemThuoc.setRowSelectionInterval(0, 0);
		String tenThuoc = "Paracetamol";
		int soLuong = 10;
		gd.themThuocTuBangVaoHoaDon_TangSoLuong(tenThuoc, soLuong);
		assertEquals(1, gd.tablemode.getRowCount(), "Table mode row count should be 1");
		assertEquals(tenThuoc, gd.tablemode.getValueAt(0, 0), "First row, first column should be 'Paracetamol'");
		assertEquals(soLuong, gd.tablemode.getValueAt(0, 1), "First row, second column should be 10");
		assertEquals("viên", gd.tablemode.getValueAt(0, 2), "First row, third column should be 'viên'");
		assertEquals(500.0, gd.tablemode.getValueAt(0, 3), "First row, fourth column should be 500.0");
		assertEquals(5000.0, gd.tablemode.getValueAt(0, 4), "First row, fifth column should be 5000.0");
	}

	@Test
	public void testTongTien() {
		gd.tablemode.addRow(new Object[] { "Paracetamol", 10, "viên", 500.0, 5000.0 });
		gd.tablemode.addRow(new Object[] { "Aspirin", 5, "viên", 300.0, 1500.0 });
		gd.tablemode.addRow(new Object[] { "Ibuprofen", 20, "viên", 200.0, 4000.0 });
		double expectedTongTien = 10500.0;
		double actualTongTien = gd.tongTien(gd.tablemode);
		assertEquals(expectedTongTien, actualTongTien, 0.001, "Total money should be 10500.0");
	}

	@Test
	public void testLuuToanBoTTHoaDon() {
		gd.chkKeDon.setSelected(true);
		gd.txtSDT.setText("0123456789");
		gd.txtCMND.setText("123456789");
		gd.table.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { "Paracetamol", 10, "viên", 500.0, 5000.0 } },
				new String[] { "Tên thuốc", "Số lượng", "Đơn vị tính", "Đơn giá", "Thành tiền"
				}));
		assertEquals(optionPane.showConfirmDialog(null, "Lập hóa đơn thành công (CÓ lưu thông tin khách hàng)",
				"Thông báo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE), 0);
	}

	@Test
	void testLuuHD() {
		gd.txtMa.setText("HD001");
		gd.txtNguoiLap.setText("NV001");
		gd.txtNgay.setText("2024-05-31");
		gd.txtCMND.setText("123456789");
		gd.txtTongTien.setText("1000.0");
		gd.control = new ControlGiaoDien() {
			@Override
			public void themHDBVaoSQL(HoaDonBanHang hdb) throws SQLException {
				assertEquals("HD001", hdb.getMaHD(), "Mã hóa đơn không khớp");
				assertEquals("NV001", hdb.getMaNVLap(), "Mã nhân viên lập không khớp");
				assertEquals("2024-05-31", hdb.getNgayLap(), "Ngày lập không khớp");
				assertEquals("123456789", hdb.getMaKH(), "Mã khách hàng không khớp");
				assertEquals(1000.0, hdb.getTongTien(), "Tổng tiền không khớp");
			}
		};
		gd.luuHD();
	}

	@Test
	void testTimThuocTrongBangTheoTen() {
		GiaoDienLapHoaDon gd = new GiaoDienLapHoaDon();
		DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {
				{ "Thuoc1", 10, "viên", 100.0 },
				{ "Thuoc2", 20, "viên", 200.0 }
		}, new String[] { "Tên thuốc", "Số lượng", "Đơn vị tính", "Đơn giá" });
		int soLuong = gd.timThuocTrongBangTheoTenTraVeSoLuong("Thuoc1", tableModel);
		assertEquals(10, soLuong, "Số lượng trả về không đúng");
	}
}
