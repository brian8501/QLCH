package model;

import java.io.Serializable;
import java.util.Objects;

public class CanHo implements Serializable,Comparable {
	protected int maCanHo;
	protected int dienTich;
	protected boolean banCong;
	protected int soTang;
	protected String loaiCanHo;
	protected int gia;
	public CanHo() {
	}
	public CanHo(int maCanHo, int dienTich, boolean banCong, int soTang, String loaiCanHo, int gia) {
		this.maCanHo = maCanHo;
		this.dienTich = dienTich;
		this.banCong = banCong;
		this.soTang = soTang;
		this.loaiCanHo=loaiCanHo;
		this.gia=gia;
	}
	public int getMaCanHo() {
		return maCanHo;
	}
	public void setMaCanHo(int maCanHo) {
		this.maCanHo = maCanHo;
	}
	public int getDienTich() {
		return dienTich;
	}
	public void setDienTich(int dienTich) {
		this.dienTich = dienTich;
	}
	public boolean isBanCong() {
		return banCong;
	}
	public void setBanCong(boolean banCong) {
		this.banCong = banCong;
	}
	public int getSoTang() {
		return soTang;
	}
	public void setSoTang(int soTang) {
		this.soTang = soTang;
	}
	public String getLoaiCanHo() {
		return loaiCanHo;
	}
	public void setLoaiCanHo(String loaiCanHo) {
		this.loaiCanHo = loaiCanHo;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	@Override
	public String toString() {
		return "CanHo [maCanHo=" + maCanHo + ", dienTich=" + dienTich + ", banCong=" + banCong + ", soTang=" + soTang
				+ ", loaiCanHo=" + loaiCanHo + ", gia=" + gia + "]";
	}
	@Override
	
	public int hashCode() {
		return Objects.hash(banCong, dienTich, gia, loaiCanHo, maCanHo, soTang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CanHo other = (CanHo) obj;
		return banCong == other.banCong && dienTich == other.dienTich && gia == other.gia
				&& Objects.equals(loaiCanHo, other.loaiCanHo) && maCanHo == other.maCanHo && soTang == other.soTang;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
}
