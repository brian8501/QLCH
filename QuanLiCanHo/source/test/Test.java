package test;

import javax.swing.UIManager;

import model.CanHo;
import model.QLKHmodel;
import view.QLKHview;

public class Test {
	public static void main(String[] args) { 
	try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new QLKHview();
	} catch (Exception ex) {
		ex.printStackTrace();
		
	}
	}
}
