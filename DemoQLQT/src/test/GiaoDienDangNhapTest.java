package test;

import static org.junit.Assert.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.io.BufferedReader;
import java.io.FileReader;
import org.junit.Before;
import org.junit.After;
import giaodien.GiaoDienDangNhap;

public class GiaoDienDangNhapTest {

    private GiaoDienDangNhap giaoDienDangNhap;

    @BeforeEach
    public void setUp() throws Exception {
        giaoDienDangNhap = new GiaoDienDangNhap();
        giaoDienDangNhap.setVisible(true);
    }

    @After
    public void tearDown() throws Exception {
        giaoDienDangNhap.dispose();
    }

    @Test
    public void testInitialization() {
        assertNotNull(giaoDienDangNhap);
        assertTrue(giaoDienDangNhap.isVisible());
    }

    @Test
    public void testTextFieldAndPasswordField() {
        assertNotNull(GiaoDienDangNhap.txtTK);
        assertNotNull(GiaoDienDangNhap.txtMK);
    }

    @Test
    public void testButtonDangNhap() {
        // GiaoDienDangNhap.txtTK.setText("NV001");
        // GiaoDienDangNhap.txtMK.setText("1");
        JButton btnDangNhap = findButtonByText(giaoDienDangNhap.getContentPane(), "  Đăng Nhập");
        assertNotNull(btnDangNhap);

        ActionListener[] actionListeners = btnDangNhap.getActionListeners();
        assertEquals(1, actionListeners.length);

        // Test action performed
        actionListeners[0].actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
    }

    private JButton findButtonByText(Container container, String text) {
        for (Component component : container.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                if (button.getText().equals(text)) {
                    return button;
                }
            } else if (component instanceof Container) {
                JButton button = findButtonByText((Container) component, text);
                if (button != null) {
                    return button;
                }
            }
        }
        return null;
    }

    @Test
    public void testButtonThoat() {
        JButton btnThoat = findButtonByText(giaoDienDangNhap.getContentPane(), "   Thoát");
        assertNotNull(btnThoat);
        assertEquals("   Thoát", btnThoat.getText());

        ActionListener[] actionListeners = btnThoat.getActionListeners();
        assertEquals(1, actionListeners.length);

        // Test action performed
        actionListeners[0].actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
    }

    @Test
    public void testLoadTaiKhoan() throws IOException {
        // Tạo file data.txt với nội dung "test"
        File file = new File("data.txt");
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        printWriter.close();

        // Gọi phương thức LoadTaiKhoan để tải dữ liệu từ file
        giaoDienDangNhap.LoadTaiKhoan();

        // Kiểm tra xem txtTK có nội dung đúng không
        assertEquals("", GiaoDienDangNhap.txtTK.getText());

        // Xóa file sau khi kiểm tra
        file.delete();
    }
}
