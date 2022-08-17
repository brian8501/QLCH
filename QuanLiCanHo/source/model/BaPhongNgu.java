package model;

public class BaPhongNgu extends CanHo{
	private int gia;
	public BaPhongNgu(int maCanHo, int dienTich, boolean banCong, int soTang, String loaiCanHo, int gia) {
		super(maCanHo, dienTich, banCong, soTang,"Ba phòng ngủ", gia);
	}
	public int getChenhLech() {
		int tong=3000;
		if (this.isBanCong())
			tong=tong+100;
			if (this.getSoTang()<8) {
			tong=tong+100;
			}else if ((20<this.getSoTang()) && (this.getSoTang()<30))
			tong=tong+200;
		return tong;
	}
	
//	public int getGia() {
//		return gia;
//	}
//	public void setGia(int gia) {
//		this.gia = gia;
//	}
//	public int hoaDon() {
//		if (this.isBanCong())
//		tong=3000+100;
//		if (this.getSoTang()<8)
//		tong=tong+100;
//		if ((20<this.getSoTang()) && (this.getSoTang()<30))
//		tong=tong+200;
//		return tong;
//	}
}
