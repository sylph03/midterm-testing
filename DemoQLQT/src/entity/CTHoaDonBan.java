package entity;

public class CTHoaDonBan {
	String MaHD;
	String MaThuoc;
	int SoLuong;
	double DonGia;
	public String getMaHD() {
		return MaHD;
	}
	public void setMaHD(String maHD) {
		MaHD = maHD; 
	}
	public String getMaThuoc() {
		return MaThuoc;
	}
	public void setMaThuoc(String maThuoc) {
		MaThuoc = maThuoc;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public double getDonGia() {
		return DonGia;
	}
	public void setDonGia(double donGia) {
		DonGia = donGia;
	}
	public CTHoaDonBan(String maHD, String maThuoc, int soLuong, double donGia) {
		super();
		MaHD = maHD;
		MaThuoc = maThuoc;
		SoLuong = soLuong;
		DonGia = donGia;
	}
	public CTHoaDonBan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
