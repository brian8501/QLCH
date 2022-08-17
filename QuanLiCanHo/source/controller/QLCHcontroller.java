package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import model.BaPhongNgu;
import model.CanHo;
import model.HaiPhongNgu;
import model.KhachHang;
import model.PenHouse;
import view.QLKHview;

public class QLCHcontroller implements Action {

	public QLKHview view;
	
	public QLCHcontroller(QLKHview view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cm1=e.getActionCommand();
		//JOptionPane.showMessageDialog(view, "Ban vua nhan vao"+cm1);
		if (cm1.equals("Sắp xếp căn hộ")){
			//!
			this.view.thucHienSapXepCanHo();
		}
		else if (cm1.equals("Thêm CH")){
			this.view.xoaFormCanHo();
		}
		else if (cm1.equals("Lưu CH")){
			
			try {
				int maCanHo = Integer.valueOf(this.view.textField_maCanHo.getText());
				int dienTich = Integer.valueOf(this.view.textField_dienTich.getText());
				String loaiCanHo = this.view.comboBox_loaiCanHo.getSelectedIndex()+"";
				boolean banCong=true;
				int chenhLech1=0;
				if (this.view.rdbtn_co.isSelected())
				{
					banCong=true;
					chenhLech1=100;
					//System.out.println("yes");
				}else {
					banCong=false;
				}
				int soTang=Integer.valueOf(this.view.textField_soTang.getText());
				if (soTang<8) {
					int chenhLech2=100;
				}else if ((20<soTang) && (soTang<30)) {
					int chenhLech2=200;
				}
				if (loaiCanHo.equals("0")){
					HaiPhongNgu haiPhong1= new HaiPhongNgu(maCanHo, dienTich, banCong, soTang,"Hai phòng ngủ",2000);
					int chenhLech=haiPhong1.getChenhLech();
					HaiPhongNgu haiPhong = new HaiPhongNgu(maCanHo, dienTich, banCong, soTang, loaiCanHo, chenhLech);
					this.view.themHoacCapCanHo(haiPhong);
				}else if (loaiCanHo.equals("1")) {
					BaPhongNgu baPhong1 = new BaPhongNgu(maCanHo, dienTich, banCong, soTang, "Ba phòng ngủ", 3000);
					int chenhLech=baPhong1.getChenhLech();
					BaPhongNgu baPhong = new BaPhongNgu(maCanHo, dienTich, banCong, soTang, loaiCanHo, chenhLech);
					this.view.themHoacCapCanHo(baPhong);
				}else if (loaiCanHo.equals("2")) {
					PenHouse penHouse1 = new PenHouse(maCanHo, dienTich, banCong, soTang, "PenHouse", 6000);
					int chenhLech=penHouse1.getChenhLech();
					PenHouse penHouse = new PenHouse(maCanHo, dienTich, banCong, soTang, loaiCanHo, chenhLech);
					this.view.themHoacCapCanHo(penHouse);
				}
				//System.out.println(this.view.model1.getDsCanHo());
			} catch (Exception e2) {
			}
		}
		else if (cm1.equals("Cập nhật CH")){
			this.view.hienThiThongTinCanHoDaChon();;
		}
		else if (cm1.equals("Xóa CH")){
			this.view.thucHienXoaCanHo();
			System.out.println(this.view.model1.getDsCanHo());
		}else if (cm1.equals("Thống kê căn hộ còn lại")){
			this.view.thongKeCanHoConLai();
			//System.out.println(11111);
		}else if (cm1.equals("Thống kê căn hộ đã có chủ")){
			this.view.thongKeCanHoDaCoChu();
		}else if (cm1.equals("Tìm CH")){
			int maCanHoTimKiem=Integer.valueOf(this.view.textField_maCanHoCanTim.getText());
			this.view.thucHienTimCanHo(maCanHoTimKiem);
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
