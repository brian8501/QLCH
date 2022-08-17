package model;

import java.io.Serializable;
import java.util.Objects;
public class KhachHang implements Comparable,Serializable{
	private int maKhachHang;
	private String hoVaTen;
	private String mail;
	private String soDienThoai;
	private int canHoCanMua;
	public KhachHang(int maKhachHang, String hoVaTen, String mail, String soDienThoai, int canHoCanMua) {
		this.maKhachHang = maKhachHang;
		this.hoVaTen = hoVaTen;
		this.mail = mail;
		this.soDienThoai = soDienThoai;
		this.canHoCanMua = canHoCanMua;
	}
	public int getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public int getCanHoCanMua() {
		return canHoCanMua;
	}
	public void setCanHoCanMua(int canHoCanMua) {
		this.canHoCanMua = canHoCanMua;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(canHoCanMua, hoVaTen, maKhachHang, mail, soDienThoai);
	}
//	public int compareTo(KhachHang comparestu) {
//	        int compareage=((KhachHang)comparestu).getMaKhachHang();
//	        /* For Ascending order*/
//	        return this.maKhachHang-compareage;
//	 }
	        /* For Descending order do like this */
	        //return compareage-this.studentage;
	 @Override
		public String toString() {
			return "KhachHang [maKhachHang=" + maKhachHang + ", hoVaTen=" + hoVaTen + ", mail=" + mail + ", soDienThoai="
					+ soDienThoai + ", canHoCanMua=" + canHoCanMua + "]";
		}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(canHoCanMua, other.canHoCanMua) && Objects.equals(hoVaTen, other.hoVaTen)
				&& maKhachHang == other.maKhachHang && Objects.equals(mail, other.mail)
				&& Objects.equals(soDienThoai, other.soDienThoai);
	}
			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
	
	
}
