package test;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import giaodien.GiaoDienDangNhap;
import giaodien.QuanLy.GiaoDienQuanLy;

class GiaoDienQuanLyTest {

	private GiaoDienQuanLy giaoDienQuanLy;

	@BeforeEach
	public void setUp() throws Exception {
		// Khởi tạo các trường tĩnh trong GiaoDienDangNhap
		GiaoDienDangNhap.txtTK = new JTextField("QL001");
		GiaoDienDangNhap.txtMK = new JPasswordField("1");
		// Tạo đối tượng GiaoDienQuanLy
		giaoDienQuanLy = new GiaoDienQuanLy();
		// Khởi tạo panelJcalender
		giaoDienQuanLy.panelJcalender = new JPanel();
		// Khởi tạo panelTimkiemDoanhthu
		giaoDienQuanLy.panelTimkiemDoanhthu = new JPanel();
	}

	@Test
	void testGiaoDienQuanLy() {
		// Tạo đối tượng GiaoDienQuanLy
		GiaoDienQuanLy giaoDienQuanLy = new GiaoDienQuanLy();

		// Kiểm tra xem giao diện đã được khởi tạo thành công không
		assertNotNull(giaoDienQuanLy);
	}

	@Test
	void testFillFormThuoc() {
		// Tạo đối tượng GiaoDienQuanLy
		GiaoDienQuanLy giaoDienQuanLy = new GiaoDienQuanLy();

		// Kiểm tra sự tồn tại của các thành phần giao diện trước khi truy cập
		assertNotNull(giaoDienQuanLy.txtMaThuoc_DanhSach_DanhSachThuoc);
		assertNotNull(giaoDienQuanLy.txtTenThuoc_DanhSach_DanhSachThuoc);
		assertNotNull(giaoDienQuanLy.txtNCC_DanhSach_DanhSachThuoc);

		// Khai báo giá trị mong đợi
		int expectedRow = 0;

		// Gọi phương thức FillFormThuoc với một hàng cụ thể trong bảng dữ liệu
		giaoDienQuanLy.FillFormThuoc(expectedRow);

		// Kiểm tra xem các trường văn bản đã được điền đúng giá trị hay không
		assertEquals("A001", giaoDienQuanLy.txtMaThuoc_DanhSach_DanhSachThuoc.getText());
		assertEquals("COTRIM STADA FORTE", giaoDienQuanLy.txtTenThuoc_DanhSach_DanhSachThuoc.getText());
		assertEquals("cCc", giaoDienQuanLy.txtNCC_DanhSach_DanhSachThuoc.getText());
		// Thêm các kiểm tra khác tùy thuộc vào dữ liệu và giao diện của bạn
	}

	@Test
	void testMoKhoaTextFeilDanhSachThuoc() {
		// Tạo đối tượng GiaoDienQuanLy
		GiaoDienQuanLy giaoDienQuanLy = new GiaoDienQuanLy();

		// Gọi phương thức MoKhoaTextFeilDanhSachThuoc với đối số là true
		giaoDienQuanLy.MoKhoaTextFeilDanhSachThuoc(true);

		// Kiểm tra xem các trường văn bản đã được mở khóa chưa
		assertTrue(giaoDienQuanLy.txtTenThuoc_DanhSach_DanhSachThuoc.isEditable());
		assertTrue(giaoDienQuanLy.txtGiaBan_DanhSach_DanhSachThuoc.isEditable());
		assertTrue(giaoDienQuanLy.txtGiaNhap_DanhSach_DanhSachThuoc.isEditable());
		assertTrue(giaoDienQuanLy.txtLoai_DanhSach_DanhSachThuoc.isEditable());
		assertTrue(giaoDienQuanLy.txtNCC_DanhSach_DanhSachThuoc.isEditable());

		// Gọi phương thức MoKhoaTextFeilDanhSachThuoc với đối số là false
		giaoDienQuanLy.MoKhoaTextFeilDanhSachThuoc(false);

		// Kiểm tra xem các trường văn bản đã bị khóa chưa
		assertFalse(giaoDienQuanLy.txtTenThuoc_DanhSach_DanhSachThuoc.isEditable());
		assertFalse(giaoDienQuanLy.txtGiaBan_DanhSach_DanhSachThuoc.isEditable());
		assertFalse(giaoDienQuanLy.txtGiaNhap_DanhSach_DanhSachThuoc.isEditable());
		assertFalse(giaoDienQuanLy.txtLoai_DanhSach_DanhSachThuoc.isEditable());
		assertFalse(giaoDienQuanLy.txtNCC_DanhSach_DanhSachThuoc.isEditable());
	}

	@Test
	void testLoadJCalender() {
		// Gọi phương thức LoadJCalender với tham số a là true
		giaoDienQuanLy.LoadJCalender(true, false, false, false);

		// Kiểm tra panelJcalender chứa một JLabel
		assertEquals(1, giaoDienQuanLy.panelJcalender.getComponentCount());
		assertTrue(giaoDienQuanLy.panelJcalender.getComponent(0) instanceof JLabel);
	}

	@Test
	void testLoadJCalender_Doanhthu() {
		// Gọi phương thức LoadJCalender_Doanhthu với tham số a là true
		giaoDienQuanLy.LoadJCalender_Doanhthu(true, false, false, false);

		// Kiểm tra panelTimkiemDoanhthu chứa một JLabel
		assertEquals(1, giaoDienQuanLy.panelTimkiemDoanhthu.getComponentCount());
		assertTrue(giaoDienQuanLy.panelTimkiemDoanhthu.getComponent(0) instanceof JLabel);
	}

}
