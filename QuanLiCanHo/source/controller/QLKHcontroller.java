package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import model.CanHo;
import model.KhachHang;
import view.QLKHview;

public class QLKHcontroller implements Action {
	public QLKHview view;
	boolean capNhat=false;
	public QLKHcontroller(QLKHview view) {
		this.view = view;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cm=e.getActionCommand();
	//	JOptionPane.showMessageDialog(view, "Ban vua nhan vao"+cm);
		if (cm.equals("Thêm")) {
			this.view.xoaForm();	
			this.view.model.setLuaChon("Thêm");
			System.out.println(this.view.model.getLuaChon());
		}else if (cm.equals("Lưu")){
				try {
					int maKhachHang=Integer.valueOf(this.view.textField_maKhachHang.getText());
					String hoVaTen=this.view.textField_hoVaTen.getText();			
					String mail=this.view.textField_email.getText();
					String soDienThoai=this.view.textField_soDienThoai.getText();
					int canHoCanMua=Integer.valueOf(this.view.textField_canHo.getText());
					KhachHang kh=new KhachHang(maKhachHang, hoVaTen, mail, soDienThoai, canHoCanMua);
					boolean ktra=true;
					for (KhachHang kkh:this.view.model.getDsKhachHang()) {
						if (kkh.getCanHoCanMua()==canHoCanMua)
						{
							ktra=false;
							break;
						}
					}
					if (ktra) {
						
						for (CanHo canHO : this.view.model1.getDsCanHo()) {
							if (kh.getCanHoCanMua() == canHO.getMaCanHo()) {
								canHO.setDienTich(Integer.valueOf(this.view.textField_dienTichKhachChon.getText()+""));
								boolean banCong=true;
								int chenhLech1=0;
								if (this.view.rdbtn_coKhachChon.isSelected())
								{
									System.out.println(1);
									banCong=true;
									chenhLech1=100;
									//System.out.println("yes");
								}else {
									banCong=false;
								}
								int soTang=Integer.valueOf(this.view.textField_SoTangKhachChon.getText());
								int chenhlech2=0;
								if (soTang<8) {
									int chenhLech2=100;
								}else if ((20<soTang) && (soTang<30)) {
									int chenhLech2=200;
								}
								canHO.setBanCong(banCong);
								String loaiCanHo=this.view.comboBox_loaiCanHoKhachChon.getSelectedItem()+"";
								canHO.setLoaiCanHo(loaiCanHo);
								canHO.setSoTang(soTang);
								if (loaiCanHo.equals("Hai phòng ngủ"))
									canHO.setGia(2000+chenhLech1+chenhlech2);
								if (loaiCanHo.equals("Ba phòng ngủ"))
									canHO.setGia(3000+chenhLech1+chenhlech2);
								if (loaiCanHo.equals("Penhouse")){
									if ((banCong) ||(soTang>8)) {
										canHO.setGia(6000+5000);
									}else {
										canHO.setGia(6000);
									}
									
								}
								this.view.themHoacCapNhatKhachHang(kh, canHO);
								break;
							}//else JOptionPane.showMessageDialog(view, "Khong co can ho");
						}
					}else {JOptionPane.showMessageDialog(view, "Căn hộ đã có chủ");}
				} catch (Exception e2) {
					e2.printStackTrace();
}
		}else if (cm.equals("Cập nhật")){
			this.view.hienThiThongTinKhachHangDaChon();
			this.view.model.setLuaChon("Cập nhật");
		}else if (cm.equals("Xóa")){
			this.view.thucHienXoa();
			}
		else if (cm.equals("Tìm")){
			int maKhachHangTimKiem=Integer.valueOf(this.view.textField_maKHtim.getText());
			this.view.thucHienTimKhachHang(maKhachHangTimKiem);
		}else if (cm.equals("Sắp xếp")){
			this.view.thucHienSapXep();
		}else if (cm.equals("About Me")){
			this.view.hienThiAbout();	
			//System.out.println(this.view.model.getDsKhachHang());
		}else if (cm.equals("Exit")){
			this.view.thoatKhoiChuongTrinh();
		}else if (cm.equals("Save")){
			this.view.thucHienSaveFile();
		}else if (cm.equals("Open")){
			this.view.thucHienOpenFile();
		}
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}
