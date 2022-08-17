package model;

public class PenHouse extends CanHo{
	private int gia;
	public PenHouse(int maCanHo, int dienTich, boolean banCong, int soTang, String loaiCanHo, int gia) {
		super(maCanHo, dienTich, banCong, soTang,"PenHouse",gia);
		int tong=6000;
		if ((this.isBanCong()) || (this.getSoTang()>8))
			tong=tong+5000;
		this.gia=tong;
	}
	public int getChenhLech() {
		int tong=6000;
		if ((this.isBanCong()) || (this.getSoTang()>8))
			tong=tong+5000;
		return tong;
	}
	
//	public int getGia() {
//		return gia;
//	}
//	public void setGia(int gia) {
//		this.gia = gia;
//	}
//	
//	public int hoaDon() {
//		if ((this.isBanCong()) || (this.getSoTang()>8))
//		tong=6000+5000;
//		return tong;
//	}
}
