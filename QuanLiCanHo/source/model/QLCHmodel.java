package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class QLCHmodel {
	private ArrayList<CanHo> dsCanHo;
	
	public QLCHmodel() {
		this.dsCanHo=new ArrayList<>();
	}

	public QLCHmodel(ArrayList<CanHo> dsCanHo) {
		this.dsCanHo = dsCanHo;
	}

	public ArrayList<CanHo> getDsCanHo() {
		return dsCanHo;
	}
	public void setDsCanHo(ArrayList<CanHo> dsCanHo) { 
		this.dsCanHo = dsCanHo;
	}
	public void insertCH() {
		for (int i=0;i<812;i++) {
			CanHo canHo=new CanHo(i, 0, false, 0, "", 0);
			this.dsCanHo.add(canHo);
		}
	}
	public void deleteCH(CanHo canHo) {
		this.dsCanHo.remove(canHo);
	}
	public void update(CanHo canHo) {
		this.dsCanHo.add(canHo);
	}
	public boolean kiemTraTonTaiCanHo(CanHo ch) {
		for (CanHo canHo : dsCanHo) {
			if (canHo.getMaCanHo() == ch.getMaCanHo())
				return true;
		}
			
		return false;
	}
	public void sapXepCanHo() {
		Collections.sort(dsCanHo,Comparator.comparing(CanHo::getMaCanHo));
//		for (CanHo canHo : dsCanHo) {
//			//System.out.println(canHo);
//		}
	}
	public void xoaItemCanHo(CanHo tam) {
		this.dsCanHo.remove(tam);
		
	}

	public boolean kiemTraTonTaiCanHoHayKhong(CanHo ch) {
		System.out.println(dsCanHo);
		for (CanHo canHo : dsCanHo) {
			if ((canHo.getMaCanHo()==ch.getMaCanHo()) && (ch.getDienTich() == 0))
				{
				return true;
				}
		}
				return false;
			
	}

	public void xoaItemCanHoKhoiDanhSachNguoiMua(CanHo tam) {
		tam.setDienTich(0);
		tam.setBanCong(false);
		tam.setLoaiCanHo("");
		tam.setSoTang(0);
		tam.setGia(0);
	}
}
