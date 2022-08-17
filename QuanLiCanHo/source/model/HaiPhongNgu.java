package model;

public class HaiPhongNgu extends CanHo{
	//private int gia;
	public HaiPhongNgu(int maCanHo, int dienTich, boolean banCong, int soTang, String loaiCanHo, int gia) {
		super(maCanHo, dienTich, banCong, soTang,"Hai phòng ngủ",gia);
	}
	public int getChenhLech() {
		int tong=2000;
		if (this.isBanCong())
		tong=tong+100;
		if (this.getSoTang()<8) {
		tong=tong+100;
		}else if ((20<this.getSoTang()) && (this.getSoTang()<30))
		{tong=tong+200;}
		return tong;
	}
	
}
