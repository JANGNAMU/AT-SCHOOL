import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class mainfclass extends JFrame implements ActionListener{
	
	JMenu MENU = new JMenu("메뉴");
	JMenuItem order = new JMenuItem("주문");
	JMenuItem clist = new JMenuItem("고객관리");
	JMenuItem manage = new JMenuItem("메뉴관리");
	JPanelChange win = new JPanelChange();
	
	public mainfclass() {
		
		
		
		win.setTitle("");
		win.jpanel01 = new JPanel01(win);
		win.jpanel02 = new JPanel02(win);
		win.jpanel03 = new JPanel03(win);
		win.add(win.jpanel01);
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		win.setSize(getMaximumSize());
		
		win.setLocationRelativeTo(null);
		JMenuBar mb = new JMenuBar();
		win.setJMenuBar(mb);
		
		
		MENU.setFont(new Font("나눔글꼴", Font.BOLD, 30));
		order.setFont(new Font("나눔글꼴", Font.BOLD, 20));
		clist.setFont(new Font("나눔글꼴", Font.BOLD, 20));
		manage.setFont(new Font("나눔글꼴", Font.BOLD, 20));
		mb.add(MENU);
		MENU.add(order);
		MENU.add(clist);
		MENU.add(manage);
		mb.setBackground(Color.gray);
		MENU.setForeground(Color.white);
		order.addActionListener(this);
		clist.addActionListener(this);
		manage.addActionListener(this);
		win.setVisible(true);
	}
	public static void main(String[] args) {
		
		mainfclass mf = new mainfclass();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == order) {
			win.change("panel01");
			MENU.setText("주문");
		}else if(obj == clist) {
			win.change("panel02");
			MENU.setText("고객관리");
		}else if(obj == manage) {
			win.change("panel03");
			MENU.setText("메뉴관리");
		}
		
	}
	
}
