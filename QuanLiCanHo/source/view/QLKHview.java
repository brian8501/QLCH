package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BaPhongNgu;
import model.CanHo;
import model.HaiPhongNgu;
import model.KhachHang;
import model.PenHouse;
import model.QLCHmodel;
import model.QLKHmodel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TabableView;

import controller.QLCHcontroller;
import controller.QLKHcontroller;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;

public class QLKHview<E> extends JFrame {

	private JPanel contentPane;
	public QLKHmodel model;
	public QLCHmodel model1;
	public JTextField textField_maKHtim;
	public JTable table;
	public JTable table1;
	public JTable table2;
	public JTextField textField_maKhachHang;
	public JTextField textField_hoVaTen;
	public JTextField textField_email;
	public JTextField textField_soDienThoai;
	public JTextField textField_canHo;
	public JTextField textField_maCanHoCanTim;
	public JTextField textField_maCanHo;
	public JTextField textField_dienTich;
	public JTextField textField_soTang;
	public JTextField textField_giaTien;
	public JComboBox comboBox_loaiCanHo;
	public ButtonGroup btn_banCong;
	public ButtonGroup btn_banCong1;
	public JRadioButton rdbtn_co;
	public JRadioButton rdbtn_khong;
	public JTextField textField_SoTangKhachChon;
	public JTextField textField_dienTichKhachChon;
	public JComboBox comboBox_loaiCanHoKhachChon;
	public ButtonGroup btn_banCongKhachChon;
	public JRadioButton rdbtn_coKhachChon;
	public JRadioButton rdbtn_khongKhachChon;
	private JTextField textField;
	private JLabel label_soTang_SoTangKhachChon;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLKHview frame = new QLKHview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLKHview() {
		this.model= new QLKHmodel();
		this.model1=new QLCHmodel();
		this.model1.insertCH();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 649);
		
		Action action = new QLKHcontroller(this);
		Action actione_canHo=new QLCHcontroller(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuFile.add(menuSave);
		
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuFile.add(menuExit);
	
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAbout.add(menuAboutMe);
		menuAboutMe.addActionListener(action);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 643, 600);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Quản lí khác hàng", null, panel, null);
		panel.setLayout(null);
		
		JLabel label_MaKhachHang = new JLabel("Mã Khách Hàng");
		label_MaKhachHang.setBounds(24, 10, 110, 26);
		panel.add(label_MaKhachHang);
		
		textField_maKHtim = new JTextField();
		textField_maKHtim.setColumns(10);
		textField_maKHtim.setBounds(118, 14, 145, 26);
		panel.add(textField_maKHtim);
		
		JButton btn_Tim = new JButton("Tìm");
		btn_Tim.addActionListener(action);
		btn_Tim.setBounds(327, 16, 85, 21);
		panel.add(btn_Tim);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(24, 64, 575, 2);
		panel.add(separator_1);
		
		JLabel label_danhSachKhachHang = new JLabel("Danh sách khách hàng");
		label_danhSachKhachHang.setBounds(24, 76, 110, 26);
		panel.add(label_danhSachKhachHang);
		       
		
	    table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Mã khách hàng", "Họ và tên", "Email", "Số điện thoại", "Căn hộ cần mua"
			}
		));
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 112, 623, 160);
		panel.add(scrollPane);
		
		JLabel label_KhachHang = new JLabel("Khách hàng");
		label_KhachHang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_KhachHang.setBounds(10, 281, 110, 26);
		panel.add(label_KhachHang);
		
		JLabel label_MaKhachHang_1 = new JLabel("Mã Khách Hàng");
		label_MaKhachHang_1.setBounds(10, 311, 110, 26);
		panel.add(label_MaKhachHang_1);
		
		textField_maKhachHang = new JTextField();
		textField_maKhachHang.setColumns(10);
		textField_maKhachHang.setBounds(104, 315, 145, 26);
		panel.add(textField_maKhachHang);
		
		JLabel label_hoVaTen = new JLabel("Họ và tên");
		label_hoVaTen.setBounds(10, 351, 110, 26);
		panel.add(label_hoVaTen);
		
		textField_hoVaTen = new JTextField();
		textField_hoVaTen.setColumns(10);
		textField_hoVaTen.setBounds(104, 355, 145, 26);
		panel.add(textField_hoVaTen);
		
		JLabel label_email = new JLabel("Email");
		label_email.setBounds(10, 391, 110, 26);
		panel.add(label_email);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(104, 395, 145, 26);
		panel.add(textField_email);
		
		JLabel label_soDienThoai = new JLabel("Số điện thoại");
		label_soDienThoai.setBounds(327, 311, 110, 26);
		panel.add(label_soDienThoai);
		
		textField_soDienThoai = new JTextField();
		textField_soDienThoai.setColumns(10);
		textField_soDienThoai.setBounds(421, 315, 145, 26);
		panel.add(textField_soDienThoai);
		
		JLabel lblCnHCn = new JLabel("Mã căn hộ cần mua");
		lblCnHCn.setBounds(327, 351, 110, 26);
		panel.add(lblCnHCn);
		
		textField_canHo = new JTextField();
		textField_canHo.setColumns(10);
		textField_canHo.setBounds(421, 355, 145, 26);
		panel.add(textField_canHo);
		
		JButton btn_sapXep = new JButton("Sắp xếp");
		btn_sapXep.addActionListener(action);
		btn_sapXep.setBounds(24, 453, 85, 21);
		panel.add(btn_sapXep);
		
		JButton btn_them = new JButton("Thêm");
		btn_them.addActionListener(action);
		btn_them.setBounds(134, 453, 85, 21);
		panel.add(btn_them);
		
		JButton btn_xoa = new JButton("Xóa");
		btn_xoa.addActionListener(action);
		btn_xoa.setBounds(412, 528, 85, 21);
		panel.add(btn_xoa);
		
		JButton btn_luu = new JButton("Lưu");
		btn_luu.addActionListener(action);
		btn_luu.setBounds(532, 528, 85, 21);
		panel.add(btn_luu);
		
		JButton btn_capnhat = new JButton("Cập nhật");
		btn_capnhat.addActionListener(action);
		btn_capnhat.setBounds(305, 528, 85, 21);
		panel.add(btn_capnhat);
		
		JLabel label_loaiCanHoKhachChon = new JLabel("Loại căn hộ");
		label_loaiCanHoKhachChon.setBounds(356, 393, 66, 26);
		panel.add(label_loaiCanHoKhachChon);
		
		JLabel label_banCongKhachChon = new JLabel("Ban công");
		label_banCongKhachChon.setBounds(356, 425, 56, 26);
		panel.add(label_banCongKhachChon);
		String loaiCanHo[]= {"Hai phòng ngủ","Ba phòng ngủ","Penhouse"};
		comboBox_loaiCanHoKhachChon = new JComboBox(loaiCanHo);
		comboBox_loaiCanHoKhachChon.setBounds(432, 396, 134, 21);
		panel.add(comboBox_loaiCanHoKhachChon);
		
		rdbtn_coKhachChon = new JRadioButton("Có");
		rdbtn_coKhachChon.setBounds(432, 428, 56, 21);
		panel.add(rdbtn_coKhachChon);
		
		rdbtn_khongKhachChon = new JRadioButton("Không");
		rdbtn_khongKhachChon.setBounds(496, 428, 56, 21);
		panel.add(rdbtn_khongKhachChon);
		
		JLabel label_dienTich_1 = new JLabel("Diện tích");
		label_dienTich_1.setBounds(356, 461, 74, 26);
		panel.add(label_dienTich_1);
		
		textField_dienTichKhachChon = new JTextField();
		textField_dienTichKhachChon.setColumns(10);
		textField_dienTichKhachChon.setBounds(404, 462, 125, 21);
		panel.add(textField_dienTichKhachChon);
		
		label_soTang_SoTangKhachChon = new JLabel("Vị trí( tầng): ");
		label_soTang_SoTangKhachChon.setBounds(341, 497, 74, 21);
		panel.add(label_soTang_SoTangKhachChon);
		
		textField_SoTangKhachChon = new JTextField();
		textField_SoTangKhachChon.setColumns(10);
		textField_SoTangKhachChon.setBounds(404, 497, 125, 21);
		panel.add(textField_SoTangKhachChon);;
		
		
		String loai[]= {"Hai phòng ngủ","Ba phòng ngủ","Penhouse"};
		
		 
		btn_banCong=new ButtonGroup();
		
		btn_banCong1=new ButtonGroup();
		btn_banCong1.add(rdbtn_khongKhachChon);
		btn_banCong1.add(rdbtn_coKhachChon);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(404, 497, 125, 21);
		panel.add(textField);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Quản lí căn hộ", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_maCanHo = new JLabel("Mã căn hộ");
		label_maCanHo.setBounds(72, 10, 110, 26);
		panel_1.add(label_maCanHo);
		
		textField_maCanHoCanTim = new JTextField();
		textField_maCanHoCanTim.setColumns(10);
		textField_maCanHoCanTim.setBounds(148, 11, 145, 26);
		panel_1.add(textField_maCanHoCanTim);
		
		JButton btn_TimCanHo = new JButton("Tìm CH");
		btn_TimCanHo.addActionListener(actione_canHo);
		btn_TimCanHo.setBounds(401, 10, 85, 21);
		panel_1.add(btn_TimCanHo);
		
		JLabel label_MaCanHo = new JLabel("Mã căn hộ");
		label_MaCanHo.setBounds(22, 305, 110, 26);
		panel_1.add(label_MaCanHo);
		
		textField_maCanHo = new JTextField();
		textField_maCanHo.setColumns(10);
		textField_maCanHo.setBounds(116, 309, 145, 26);
		panel_1.add(textField_maCanHo);
		
		JLabel label_dienTich = new JLabel("Diện tích");
		label_dienTich.setBounds(22, 345, 110, 26);
		panel_1.add(label_dienTich);
		
		textField_dienTich = new JTextField();
		textField_dienTich.setColumns(10);
		textField_dienTich.setBounds(116, 349, 145, 26);
		panel_1.add(textField_dienTich);
		
		JLabel label_soTang = new JLabel("Vị trí( tầng):");
		label_soTang.setBounds(22, 385, 110, 26);
		panel_1.add(label_soTang);
		
		textField_soTang = new JTextField();
		textField_soTang.setColumns(10);
		textField_soTang.setBounds(116, 389, 145, 26);
		panel_1.add(textField_soTang);
		
		JLabel label_loaiCanHo = new JLabel("Loại căn hộ");
		label_loaiCanHo.setBounds(339, 305, 110, 26);
		panel_1.add(label_loaiCanHo);
		
		JLabel label_banCong = new JLabel("Ban công");
		label_banCong.setBounds(339, 345, 110, 26);
		panel_1.add(label_banCong);
		
		JLabel label_giaTien = new JLabel("Giá tiền");
		label_giaTien.setBounds(339, 385, 110, 26);
		panel_1.add(label_giaTien);
		
		textField_giaTien = new JTextField();
		textField_giaTien.setColumns(10);
		textField_giaTien.setBounds(433, 389, 145, 26);
		panel_1.add(textField_giaTien);
		
		JButton btn_sapXep_canHo = new JButton("Sắp xếp căn hộ");
		btn_sapXep_canHo.addActionListener(actione_canHo);
		btn_sapXep_canHo.setBounds(22, 447, 126, 21);
		panel_1.add(btn_sapXep_canHo);
		
		JButton btn_xoa_canHo = new JButton("Xóa CH");
		btn_xoa_canHo.addActionListener(actione_canHo);
		btn_xoa_canHo.setBounds(433, 435, 85, 21);
		panel_1.add(btn_xoa_canHo);
		
		JButton btn_luu_canHo = new JButton("Lưu CH");
		btn_luu_canHo.addActionListener(actione_canHo);
		btn_luu_canHo.setBounds(536, 435, 85, 21);
		panel_1.add(btn_luu_canHo);
		
		JButton btn_capnhat_canHo = new JButton("Cập nhật CH");
		btn_capnhat_canHo.addActionListener(actione_canHo);
		btn_capnhat_canHo.setBounds(322, 435, 89, 21);
		panel_1.add(btn_capnhat_canHo);
		comboBox_loaiCanHo = new JComboBox(loai);
		comboBox_loaiCanHo.setBounds(433, 308, 134, 21);
		panel_1.add(comboBox_loaiCanHo);
		
		rdbtn_co = new JRadioButton("Có");
		rdbtn_co.setBounds(433, 348, 56, 21);
		panel_1.add(rdbtn_co);
		
		rdbtn_khong = new JRadioButton("Không");
		rdbtn_khong.setBounds(526, 348, 56, 21);
		panel_1.add(rdbtn_khong);
		btn_banCong.add(rdbtn_khong);
		btn_banCong.add(rdbtn_co);
		
		    table1 = new JTable();
		    table1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		    table1.setModel(new DefaultTableModel(
		    	new Object[][] {
		    	},
		    	new String[] {
		    		"M\u00E3 c\u0103n h\u1ED9", "Di\u1EC7n t\u00EDch", "Ban c\u00F4ng", "T\u1EA7ng s\u1ED1", "lo\u1EA1i c\u0103n h\u1ED9", "Gi\u00E1 ti\u1EC1n"
		    	}
		    ));
		    table1.setRowHeight(25);
		    
		    JScrollPane scrollPane_1 = new JScrollPane(table1);
		    scrollPane_1.setBounds(10, 71, 611, 203);
		    panel_1.add(scrollPane_1);
		    
		    JLabel lblDanhSchCn = new JLabel("Danh sách căn hộ ");
		    lblDanhSchCn.setBounds(10, 35, 172, 26);
		    panel_1.add(lblDanhSchCn);
		    
		    JButton btn_danhSachCanHoConLai = new JButton("Thống kê căn hộ còn lại");
		    btn_danhSachCanHoConLai.addActionListener(actione_canHo);
		    btn_danhSachCanHoConLai.setBounds(6, 482, 158, 21);
		    panel_1.add(btn_danhSachCanHoConLai);
		    
		    JButton btn_danhSachCanHoDaCoChu = new JButton("Thống kê căn hộ đã có chủ");
		    btn_danhSachCanHoDaCoChu.addActionListener(actione_canHo);
		    btn_danhSachCanHoDaCoChu.setBounds(6, 525, 158, 21);
		    panel_1.add(btn_danhSachCanHoDaCoChu);
		    
		    table_1 = new JTable();
		    table_1.setModel(new DefaultTableModel(
		    	new Object[][] {
		    		{null, null, null, null},
		    	},
		    	new String[] {
		    		"Hai phòng ngủ", "Ba phòng ngủ", "PenHouse"
		    	}
		    ));
		    table_1.setRowHeight(25);
		    table_1.setBounds(256, 539, 355, -36);
		    JScrollPane scrollPane2 = new JScrollPane(table_1);
			scrollPane2.setBounds(270, 479, 358, 52);
			panel_1.add(scrollPane2);
		  //  panel_1.add(table_1);
		    
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Hóa đơn", null, panel_2, null);
		panel_2.setLayout(null);
		table2 = new JTable();
	    table2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    table2.setModel(new DefaultTableModel(
	    	new Object[][] {
	    	},
	    	new String[] {
	    		"Mã khách hàng", "M\u00E3 c\u0103n h\u1ED9", "Gi\u00E1 ti\u1EC1n"
	    	}
	    ));
	    table2.setRowHeight(25);
	    
	    JScrollPane scrollPane_2 = new JScrollPane(table2);
	    scrollPane_2.setBounds(59, 22, 465, 127);
	    panel_2.add(scrollPane_2);

		this.setVisible(true);
	}
	
	public void xoaForm() {
			textField_maKhachHang.setText("");
			textField_hoVaTen.setText("");
			textField_email.setText("");
			textField_soDienThoai.setText("");
			textField_canHo.setText("");
		
	}
	public void xoaFormCanHo() {
		textField_maCanHo.setText("");
		textField_dienTich.setText("");
		textField_soTang.setText("");
		comboBox_loaiCanHo.setSelectedIndex(-1);
		btn_banCong.clearSelection();
		textField_giaTien.setText("");
	
}
	public void themHoacCapNhatKhachHang(KhachHang kh, CanHo ch) {
		DefaultTableModel table_model = (DefaultTableModel) table.getModel();
		DefaultTableModel table_model2 = (DefaultTableModel) table2.getModel();
		DefaultTableModel table_model1 = (DefaultTableModel) table1.getModel();
		if (this.model.getLuaChon().equals("Cập nhật") && this.model.kiemTraTonTai(kh)) {
			for (KhachHang tam : this.model.getDsKhachHang()) {
				if (tam.getMaKhachHang()==kh.getMaKhachHang()) {
					this.model.xoaItemKhachHang(tam);
					break;
				}
			}
		//	System.out.println(kh);
			this.model.update(kh);
			int soLuongDong = table_model.getRowCount();
			for (int i=0; i< soLuongDong;i++) {
				String id=table_model.getValueAt(i, 0)+"";
				if (id.equals(kh.getMaKhachHang()+"")) {
					table_model.setValueAt(kh.getMaKhachHang()+"",i,0);
					table_model.setValueAt(kh.getHoVaTen()+"",i,1);
					table_model.setValueAt(kh.getMail()+"",i,2);
					table_model.setValueAt(kh.getSoDienThoai()+"",i,3);
					table_model.setValueAt(kh.getCanHoCanMua()+"",i,4);
				}
			}
		//	this.kiemTraAnNutCapNhat();
			
		}else 
		//if (!this.model.kiemTraTonTai(kh)) {
		{
			//if (this.model1.kiemTraTonTaiCanHoHayKhong(ch))
			//{
				this.model.insertKH(kh);
				table_model.addRow(new Object[]{kh.getMaKhachHang()+"", kh.getHoVaTen(), kh.getMail(),kh.getSoDienThoai(),kh.getCanHoCanMua()});
				//table_model1.addRow(new Object[]{ch.getMaCanHo()+"", ch.getDienTich(), ch.isBanCong(), ch.getSoTang(), ch.getLoaiCanHo(), ch.getGia()});
				table_model2.addRow(new Object[]{kh.getMaKhachHang()+"", kh.getCanHoCanMua()+"",ch.getGia()});
				thucHienLoadLaiDuLieuCanHo();
			//}else System.out.println("Can ho da co chu");
		}
//		if (this.model.getLuaChon().equals("Cập nhật")) {
//			for (KhachHang tam : this.model.getDsKhachHang()) {
//				if (tam.getMaKhachHang()==kh.getMaKhachHang()) {
//					this.model.xoaItemKhachHang(tam);
//					break;
//				}
//			}
//		//	System.out.println(kh);
//			this.model.update(kh);
//			int soLuongDong = table_model.getRowCount();
//			for (int i=0; i< soLuongDong;i++) {
//				String id=table_model.getValueAt(i, 0)+"";
//				if (id.equals(kh.getMaKhachHang()+"")) {
//					table_model.setValueAt(kh.getMaKhachHang()+"",i,0);
//					table_model.setValueAt(kh.getHoVaTen()+"",i,1);
//					table_model.setValueAt(kh.getMail()+"",i,2);
//					table_model.setValueAt(kh.getSoDienThoai()+"",i,3);
//					table_model.setValueAt(kh.getCanHoCanMua()+"",i,4);
//				}
//			}
//		//	this.kiemTraAnNutCapNhat();
//			
//		}
	}
	public KhachHang getKhachHangDangChon() {
		DefaultTableModel table_model = (DefaultTableModel) table.getModel();
		int i_row= table.getSelectedRow();
		
		int maKhachHang=Integer.valueOf(table_model.getValueAt(i_row, 0)+"");
		String hoVaTen=table_model.getValueAt(i_row, 1)+"";			
		String mail=table_model.getValueAt(i_row, 2)+"";
		String soDienThoai=table_model.getValueAt(i_row, 3)+"";
		int canHoCanMua=Integer.valueOf(table_model.getValueAt(i_row, 4)+"");
		KhachHang kh=new KhachHang(maKhachHang, hoVaTen, mail, soDienThoai, canHoCanMua);
		return kh;
	}
	public CanHo getCanHoDaChon() {
		DefaultTableModel table_model1 = (DefaultTableModel) table1.getModel();
		int i_row= table1.getSelectedRow();
		
		int maCanHo=Integer.valueOf(table_model1.getValueAt(i_row, 0)+"");
		//System.out.println(maCanHo);
		int dienTich=Integer.valueOf(table_model1.getValueAt(i_row, 1)+"");		
		String textBanCong=table_model1.getValueAt(i_row, 2)+"";
		boolean banCong=textBanCong.equals("Có");
		int soTang=Integer.valueOf(table_model1.getValueAt(i_row, 3)+"");	
		String loaiCanHo=table_model1.getValueAt(i_row, 4)+"";
		int gia=Integer.valueOf(table_model1.getValueAt(i_row, 5)+"");	
		CanHo ch=new CanHo(maCanHo, dienTich, banCong, soTang, loaiCanHo, gia);
		return ch;
	}
	public void hienThiThongTinKhachHangDaChon() {
		KhachHang kh=getKhachHangDangChon();
		//CanHo ch=getCanHoDaChon();
		this.textField_maKhachHang.setText(kh.getMaKhachHang()+"");
		this.textField_hoVaTen.setText(kh.getHoVaTen());
		this.textField_email.setText(kh.getMail());
		this.textField_soDienThoai.setText(kh.getSoDienThoai());
		this.textField_canHo.setText(kh.getCanHoCanMua()+"");
		DefaultTableModel table_model2 = (DefaultTableModel) table2.getModel();
//		table_model2.addRow(new Object[]{kh.getMaKhachHang()+"", 
//										 kh.getCanHoCanMua()+"",
//									///	 ch.getGia(),
//		});
		
	}
	public void hienThiThongTinCanHoDaChon() {
		CanHo ch=getCanHoDaChon();
	//	System.out.println(ch.getLoaiCanHo());
		this.textField_maCanHo.setText(ch.getMaCanHo()+"");
		this.textField_dienTich.setText(ch.getDienTich()+"");
		this.textField_soTang.setText(ch.getSoTang()+"");
		if (ch.getLoaiCanHo().equals("Hai phòng ngủ")) {
			this.comboBox_loaiCanHo.setSelectedIndex(0);;;
		}else if (ch.getLoaiCanHo().equals("Ba phòng ngủ")) {
			this.comboBox_loaiCanHo.setSelectedIndex(1);
		}else {
			this.comboBox_loaiCanHo.setSelectedIndex(2);
		}
		if (ch.isBanCong()) {
			rdbtn_co.setSelected(true);
		}else {
			rdbtn_khong.setSelected(true);
		}
		
	}
	public void thucHienXoa() {
		DefaultTableModel table_model = (DefaultTableModel) table.getModel();
		int i_row= table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa khách hàng");
		if (luaChon==JOptionPane.YES_OPTION)
		{
					KhachHang kh=getKhachHangDangChon();
					this.model.deleteKH(kh);
					table_model.removeRow(i_row);
					//System.out.println(kh);
		}
		
	}

	public void thucHienTimKhachHang(int maKh) {
		while (true) {
			DefaultTableModel table_model = (DefaultTableModel) table.getModel();
			int soLuongDong=table_model.getRowCount();
			if (soLuongDong==0)
				break;
			else 
				table_model.removeRow(0);
		}
		DefaultTableModel table_model = (DefaultTableModel) table.getModel();
		for (KhachHang kh:this.model.getDsKhachHang()) {
			{
				if (maKh==kh.getMaKhachHang()) {
					table_model.addRow(new Object[]{kh.getMaKhachHang()+"", kh.getHoVaTen(), kh.getMail(),kh.getSoDienThoai(),kh.getCanHoCanMua()});
					break;
				}
			}
		}		
	}
	public void thucHienTimCanHo(int maCh) {
		while (true) {
			DefaultTableModel table_model1 = (DefaultTableModel) table1.getModel();
			int soLuongDong=table_model1.getRowCount();
			if (soLuongDong==0)
				break;
			else 
				table_model1.removeRow(0);
		}
		DefaultTableModel table_model1 = (DefaultTableModel) table1.getModel();
		for (CanHo ch:this.model1.getDsCanHo()) {
			{
				if (maCh==ch.getMaCanHo()) {
					table_model1.addRow(new Object[]{ch.getMaCanHo()+"", 
							 ch.getDienTich(),
							 (ch.isBanCong()?"Có":"Không"), 
							 ch.getSoTang(),
							 ch.getLoaiCanHo(),
							 ch.getGia(),
			});
					break;
				}
			}
		}		
	}
	public void thucHienSapXep() {
//		DefaultTableModel table_model = (DefaultTableModel) table.getModel();	
//		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
//		table.setRowSorter(sorter);
//
//		List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
//		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
//		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
//		sorter.setSortKeys(sortKeys);
		this.model.sapXepKhachHang();
		this.thucHienLoadLaiDuLieuKhachHang();
		
	}

	public void thucHienSapXepCanHo() {
//		DefaultTableModel table_model1 = (DefaultTableModel) table1.getModel();
//		
//		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table1.getModel());
//		table1.setRowSorter(sorter);
//
//		List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
//		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
//		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
//		sorter.setSortKeys(sortKeys);
		this.model1.sapXepCanHo();
		this.thucHienLoadLaiDuLieuCanHo();
		System.out.println(this.model1.getDsCanHo());
	}
	public void thucHienXoaCanHo() {
		DefaultTableModel table_model1 = (DefaultTableModel) table1.getModel();
		int i_row= table1.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa căn hộ");
		if (luaChon==JOptionPane.YES_OPTION)
		{
					CanHo ch = getCanHoDaChon();
					for (CanHo tam : this.model1.getDsCanHo()) {
						if (tam.getMaCanHo()==ch.getMaCanHo()) {
							tam.setDienTich(0);
							tam.setBanCong(false);
							tam.setLoaiCanHo("");
							tam.setSoTang(0);
							tam.setGia(0);
							for (KhachHang kh:this.model.getDsKhachHang()) {
								if (kh.getCanHoCanMua()==tam.getMaCanHo())
								{
									this.model.deleteKH(kh);
									this.thucHienLoadLaiDuLieuKhachHang();
									break;
								}
							}
							this.thucHienLoadLaiDuLieuCanHo();
							//this.model1.xoaItemCanHoKhoiDanhSachNguoiMua(tam);
							break;
						}
					}
			//		this.model1.xoaItemCanHo(ch);
				//	table_model1.removeRow(i_row);
					//System.out.println(ch);
		}
		
	}
	//public void them
	public void themHoacCapCanHo(HaiPhongNgu ch) {
		DefaultTableModel table_model1 = (DefaultTableModel) table1.getModel();
		if (!this.model1.kiemTraTonTaiCanHo(ch)) {
		//System.out.println(ch.getMaCanHo());	
	//	this.model1.insertCH(ch);
	//	System.out.println(this.model1.getDsCanHo());
		table_model1.addRow(new Object[]{ch.getMaCanHo()+"", 
										 ch.getDienTich(),
										 (ch.isBanCong()?"Có":"Không"), 
										 ch.getSoTang(),
										 ch.getLoaiCanHo(),
										 ch.getGia(),
		});
		
		}else {
			for (CanHo tam : this.model1.getDsCanHo()) {
				if (tam.getMaCanHo()==ch.getMaCanHo()) {
					this.model1.xoaItemCanHo(tam);
					break;
				}
			}
			//System.out.println(ch);
			this.model1.update(ch);
			int soLuongDong = table_model1.getRowCount();
			for (int i=0; i< soLuongDong;i++) {
				String id=table_model1.getValueAt(i, 0)+"";
				if (id.equals(ch.getMaCanHo()+"")) {
					table_model1.setValueAt(ch.getMaCanHo()+"",i,0);
					table_model1.setValueAt(ch.getDienTich()+"",i,1);
					table_model1.setValueAt((ch.isBanCong()?"Có":"Không"),i,2);
					table_model1.setValueAt(ch.getSoTang()+"",i,3);
					table_model1.setValueAt(ch.getLoaiCanHo()+"",i,4);
					table_model1.setValueAt(ch.getGia()+"",i,5);
				}
			}
		}
		
	}
	public void themHoacCapCanHo(BaPhongNgu ch) {
		DefaultTableModel table_model1 = (DefaultTableModel) table1.getModel();
		if (!this.model1.kiemTraTonTaiCanHo(ch)) {
	//	System.out.println(ch.getMaCanHo());	
		//this.model1.insertCH(ch);
		table_model1.addRow(new Object[]{ch.getMaCanHo()+"", 
										 ch.getDienTich(),
										 (ch.isBanCong()?"Có":"Không"), 
										 ch.getSoTang(),
										 ch.getLoaiCanHo(),
										 ch.getGia(),
		});
		
		}else {
			for (CanHo tam : this.model1.getDsCanHo()) {
				if (tam.getMaCanHo()==ch.getMaCanHo()) {
					this.model1.xoaItemCanHo(tam);
					break;
				}
			}
		//	System.out.println(ch);
			this.model1.update(ch);
			int soLuongDong = table_model1.getRowCount();
			for (int i=0; i< soLuongDong;i++) {
				String id=table_model1.getValueAt(i, 0)+"";
				if (id.equals(ch.getMaCanHo()+"")) {
					table_model1.setValueAt(ch.getMaCanHo()+"",i,0);
					table_model1.setValueAt(ch.getDienTich()+"",i,1);
					table_model1.setValueAt((ch.isBanCong()?"Có":"Không"),i,2);
					table_model1.setValueAt(ch.getSoTang()+"",i,3);
					table_model1.setValueAt(ch.getLoaiCanHo()+"",i,4);
					table_model1.setValueAt(ch.getGia()+"",i,5);
				}
			}
		}
		
	}
	public void themHoacCapCanHo(PenHouse ch) {
		DefaultTableModel table_model1 = (DefaultTableModel) table1.getModel();
		if (!this.model1.kiemTraTonTaiCanHo(ch)) {
		//System.out.println(ch.getMaCanHo());	
		//this.model1.insertCH(ch);
		table_model1.addRow(new Object[]{ch.getMaCanHo()+"", 
										 ch.getDienTich(),
										 (ch.isBanCong()?"Có":"Không"), 
										 ch.getSoTang(),
										 ch.getLoaiCanHo(),
										 ch.getGia(),
		});
		
		}else {
			for (CanHo tam : this.model1.getDsCanHo()) {
				if (tam.getMaCanHo()==ch.getMaCanHo()) {
					this.model1.xoaItemCanHo(tam);
					break;
				}
			}
			//System.out.println(ch);
			this.model1.update(ch);
			int soLuongDong = table_model1.getRowCount();
			for (int i=0; i< soLuongDong;i++) {
				String id=table_model1.getValueAt(i, 0)+"";
				if (id.equals(ch.getMaCanHo()+"")) {
					table_model1.setValueAt(ch.getMaCanHo()+"",i,0);
					table_model1.setValueAt(ch.getDienTich()+"",i,1);
					table_model1.setValueAt((ch.isBanCong()?"Có":"Không"),i,2);
					table_model1.setValueAt(ch.getSoTang()+"",i,3);
					table_model1.setValueAt(ch.getLoaiCanHo()+"",i,4);
					table_model1.setValueAt(ch.getGia()+"",i,5);
				}
			}
		}
		
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this,"Phần mềm quản lí căn hộ chung cư");
		
	}

	public void thoatKhoiChuongTrinh() {
		
		
	}
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			ArrayList<Object> list = new ArrayList<>();
			for (KhachHang kh : this.model.getDsKhachHang()) {
				list.add(kh);
				//oos.writeObject(kh);
			}
			for (CanHo ch: this.model1.getDsCanHo()) {
				list.add(ch);
				//oos1.writeObject(ch);
			}
			oos.writeObject(list);
			//System.out.println(this.model1.getDsCanHo());
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void openFile(File file) {
		ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
		ArrayList<CanHo> dsch = new ArrayList<CanHo>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Object> input=(ArrayList<Object>) ois.readObject();
			ArrayList<Object> checkList = new ArrayList<>();
			for (Object l : input) {
                checkList.add(l.getClass().getSimpleName());
                if (l instanceof KhachHang) {
                    KhachHang app = (KhachHang) l;
                    ds.add(app);
                    System.out.println(app.getMaKhachHang());
                    System.out.println(app.getHoVaTen());
                }
                if (l instanceof CanHo) {
                    CanHo app = (CanHo) l;
                    System.out.println(app.getMaCanHo());
                    System.out.println(app.getDienTich());
                    dsch.add(app);
                }
            }
			System.out.println(checkList);
			//FileInputStream fis1 = new FileInputStream(file);
//			ObjectInputStream ois1 = new ObjectInputStream(fis);
//			System.out.println((ch = (CanHo) ois1.readObject())!=null);
//			while ((ch = (CanHo) ois1.readObject())!=null) {
//				System.out.println(dsch);
//			}
			ois.close();
			//ois1.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsKhachHang(ds);
		
		this.model1.setDsCanHo(dsch);
	}
	public void thucHienSaveFile() {
		if (this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal==JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
		
	}

	

	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal==JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienLoadLaiDuLieuKhachHang();
			thucHienLoadLaiDuLieuCanHo();
			//System.out.println(this.model1.getDsCanHo());
		}
	}
	public void thucHienLoadLaiDuLieuKhachHang() {
		while (true) {
			DefaultTableModel table_model = (DefaultTableModel) table.getModel();
			int soLuongDong=table_model.getRowCount();
			if (soLuongDong==0)
				break;
			else 
				table_model.removeRow(0);
		}
		for (KhachHang kh:this.model.getDsKhachHang()) {
			this.themKhachHangVaoTable(kh);
		}
		
	}
	public void thucHienLoadLaiDuLieuCanHo() {
		while (true) {
			DefaultTableModel table_model1 = (DefaultTableModel) table1.getModel();
			int soLuongDong=table_model1.getRowCount();
			if (soLuongDong==0)
				break;
			else 
				table_model1.removeRow(0);
		}
		for (CanHo ch:this.model1.getDsCanHo()) {
			this.themCanHoVaoTableCanHo(ch);
		}
	}
	private void themCanHoVaoTableCanHo(CanHo ch) {
		DefaultTableModel table_model1 = (DefaultTableModel) table1.getModel();
		table_model1.addRow(new Object[]{ch.getMaCanHo()+"", 
				 ch.getDienTich(),
				 (ch.isBanCong()?"Có":"Không"), 
				 ch.getSoTang(),
				 ch.getLoaiCanHo(),
				 ch.getGia(),
});
	}

	private void themKhachHangVaoTable(KhachHang kh) {
		DefaultTableModel table_model = (DefaultTableModel) table.getModel();
		table_model.addRow(new Object[]{kh.getMaKhachHang()+"", kh.getHoVaTen(), kh.getMail(),kh.getSoDienThoai(),kh.getCanHoCanMua()});
	}
	public void xoaBangCanHo() {
		while (true) {
			DefaultTableModel table_model1 = (DefaultTableModel) table1.getModel();
			int soLuongDong=table_model1.getRowCount();
			if (soLuongDong==0)
				break;
			else 
				table_model1.removeRow(0);
		}
	}
	public void thongKeCanHoConLai() {
		this.xoaBangCanHo();
		int countHaiPhongNgu=0;
		int countBaPhongNgu=0;
		int countPenHouse=0;
		this.xoaBangThongKe();
		DefaultTableModel table_model1 = (DefaultTableModel) table1.getModel();
		DefaultTableModel table_model_1 = (DefaultTableModel) table_1.getModel();
		for (CanHo ch:this.model1.getDsCanHo()) {
			if (ch.getDienTich()==0) {
				table_model1.addRow(new Object[]{ch.getMaCanHo()+"", 
						 ch.getDienTich(),
						 (ch.isBanCong()?"Có":"Không"), 
						 ch.getSoTang(),
						 ch.getLoaiCanHo(),
						 ch.getGia(),
		});
			}else {
				if (ch.getLoaiCanHo().equals("Hai phòng ngủ")) {
					countHaiPhongNgu+=1;
				}
				if (ch.getLoaiCanHo().equals("Ba phòng ngủ")) {
					countBaPhongNgu+=1;
				}if (ch.getLoaiCanHo().equals("Penhouse")) {
					countPenHouse+=1;
				}	
			}
		}
		table_model_1.addRow(new Object[] {500-countHaiPhongNgu,300-countBaPhongNgu,12-countPenHouse});
		
	}
	public void xoaBangThongKe() {
		while (true) {
			DefaultTableModel table_model_1 = (DefaultTableModel) table_1.getModel();
			int soLuongDong=table_model_1.getRowCount();
			if (soLuongDong==0)
				break;
			else 
				table_model_1.removeRow(0);
		}
	}
	public void thongKeCanHoDaCoChu() {
		this.xoaBangCanHo();
		DefaultTableModel table_model1 = (DefaultTableModel) table1.getModel();
		DefaultTableModel table_model_1 = (DefaultTableModel) table_1.getModel();
		int countHaiPhongNgu=0;
		int countBaPhongNgu=0;
		int countPenHouse=0;
		this.xoaBangThongKe();
		for (CanHo ch:this.model1.getDsCanHo()) {
			if (ch.getDienTich()!=0) {
				System.out.println(ch.getLoaiCanHo());
				if (ch.getLoaiCanHo().equals("Hai phòng ngủ")) {
					countHaiPhongNgu+=1;
				}
				if (ch.getLoaiCanHo().equals("Ba phòng ngủ")) {
					countBaPhongNgu+=1;
				}if (ch.getLoaiCanHo().equals("Penhouse")) {
					countPenHouse+=1;
				}	
				table_model1.addRow(new Object[]{ch.getMaCanHo()+"", 
						 ch.getDienTich(),
						 (ch.isBanCong()?"Có":"Không"), 
						 ch.getSoTang(),
						 ch.getLoaiCanHo(),
						 ch.getGia(),
		});
			}
		}
		table_model_1.addRow(new Object[] {countHaiPhongNgu,countBaPhongNgu,countPenHouse});
	}

	
}
