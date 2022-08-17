package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;
import javax.swing.text.html.HTMLDocument.Iterator;

public class QLKHmodel {
	private ArrayList<KhachHang> dsKhachHang;
	private String luaChon;
	private String tenFile;
	public QLKHmodel() {
		this.dsKhachHang = new ArrayList<KhachHang>();
		this.luaChon="";
		this.tenFile="";
	}
	
	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}
	
	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public QLKHmodel(ArrayList<KhachHang> dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
	}

	public ArrayList<KhachHang> getDsKhachHang() {
		return dsKhachHang;
	}

	public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
	}
	public void insertKH(KhachHang khachHang) {
		this.dsKhachHang.add(khachHang);
	}
	public void deleteKH(KhachHang khacHang) {
		this.dsKhachHang.remove(khacHang);
	}
	public void update(KhachHang khachHang) {
		this.dsKhachHang.add(khachHang);
	}
	public boolean kiemTraTonTai(KhachHang kh) {
		for (KhachHang khachHang:dsKhachHang) {
			if (khachHang.getMaKhachHang() == kh.getMaKhachHang())
				return true;
		}
		return false;
	}
	public void xoaItemKhachHang(KhachHang tam) {
		this.dsKhachHang.remove(tam);	
	}
	
	public void sapXepKhachHang() {
		Collections.sort(dsKhachHang,Comparator.comparing(KhachHang::getMaKhachHang));
//		for (KhachHang khachHang : dsKhachHang) {
//			System.out.println(khachHang);
//		}
	}

	
}
