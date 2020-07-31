import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

import javax.security.auth.Refreshable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import oracle.jdbc.driver.DMSFactory;

public class JPanel01 extends JPanel implements ActionListener {
	private JPanel p1, p2, p3, p4, p5, p6, p7, p8;
	private JTextField tf1, tf2, tf3, tf4,tf4_1,tf4_2, tf5, tf6;
	private RoundedButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17;
	private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10,lb11;
	private JButton jbutton1;
	private JScrollPane jscrollpane1;
	private JTextArea jtextarea1;
	private JPanelChange win;
	private DBConnect dc;
	private int[] menunm = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private Vector v;
	private String custnum = null;
	private String[][] menuinfo;
	private String quantity, total;
	private boolean checkphone=false;
	Vector cols;
	DefaultTableModel model;
	JTable jTable;
	JScrollPane pane;
	Font ft = new Font("나눔글꼴", Font.BOLD, 15);
	Font fb = new Font("나눔글꼴", Font.BOLD, 15);

	public JPanel01(JPanelChange win) {
		DBConnect dc = new DBConnect();
		menuinfo = new String[12][3];
		menuload();
		
		setLayout(null);
		this.win = win;
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p8 = new JPanel();
		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.fill = GridBagConstraints.BOTH;
		add(p1, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weighty = 2;
		add(p2, gc);
		gc.gridx = 1;
		gc.gridy = 0;
		gc.weighty = 1;
		add(p3, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weighty = 2;
		add(p4, gc);

		lb1 = new JLabel("주문번호 : ");
		lb2 = new JLabel("주문날짜 : ");
		lb3 = new JLabel("고객 이름 : ");
		lb4 = new JLabel("연락처 : ");
		lb5 = new JLabel("고객 주소 : ");
		lb10 = new JLabel("-");
		lb11 = new JLabel("-");
		lb1.setFont(ft);
		lb2.setFont(ft);
		lb3.setFont(ft);
		lb4.setFont(ft);
		lb5.setFont(ft);
		lb10.setFont(ft);
		lb11.setFont(ft);
		
		gc.fill = GridBagConstraints.NONE;
		p1.setLayout(null);
		lb1.setBounds(30, 0, 100, 100);
		lb4.setBounds(30, 40, 100, 100);
		lb3.setBounds(30, 80, 100, 100);
		lb2.setBounds(30, 120, 100, 100);
		lb5.setBounds(30, 160, 100, 100);
		lb10.setBounds(250, 40, 100, 100);
		lb11.setBounds(360, 40, 100, 100);
		p1.add(lb1, gc);
		p1.add(lb2, gc);
		p1.add(lb3, gc);
		p1.add(lb4, gc);
		p1.add(lb5, gc);
		p1.add(lb10, gc);
		p1.add(lb11, gc);

		tf1 = new JTextField(10);
		tf2 = new JTextField(10);
		

		

		tf3 = new JTextField(10);
		tf4 = new JTextField(10);
		tf4_1 = new JTextField(10);
		tf4_2 = new JTextField(10);
		tf5 = new JTextField(10);
		tf6 = new JTextField(10);
		tf1.setEditable(false);
		tf2.setEditable(false);
		tf1.setFont(ft);
		tf2.setFont(ft);
		tf3.setFont(ft);
		tf4.setFont(ft);
		tf4_1.setFont(ft);
		tf4_2.setFont(ft);
		tf5.setFont(ft);
		tf6.setFont(ft);
		tf1.setBounds(160, 40, 300, 30);
		tf4.setBounds(160, 80, 80, 30);
		tf4_1.setBounds(270, 80, 80, 30);
		tf4_2.setBounds(380, 80, 80, 30);
		tf3.setBounds(160, 120, 300, 30);
		tf2.setBounds(160, 160, 300, 30);
		tf5.setBounds(160, 200, 300, 30);
		tf1.setText(dc.findorderid());
		p1.add(tf1);

		p1.add(tf2);
		dayload();
		p1.add(tf3);
		p1.add(tf4);
		p1.add(tf4_1);
		p1.add(tf4_2);
		p1.add(tf5);
		b14 = new RoundedButton("검색");
		b14.setFont(ft);
		b14.setBounds(500, 80, 100, 30);
		p1.add(b14);
		b14.addActionListener(this);

		GridLayout gl = new GridLayout(3, 4);
		p2.setLayout(gl);
		gl.setVgap(17);
		gl.setHgap(17);

		b1 = new RoundedButton(menuinfo[0][1]);
		b2 = new RoundedButton(menuinfo[1][1]);
		b3 = new RoundedButton(menuinfo[2][1]);
		b4 = new RoundedButton(menuinfo[3][1]);
		b5 = new RoundedButton(menuinfo[4][1]);
		b6 = new RoundedButton(menuinfo[5][1]);
		b7 = new RoundedButton(menuinfo[6][1]);
		b8 = new RoundedButton(menuinfo[7][1]);
		b9 = new RoundedButton(menuinfo[8][1]);
		b10 = new RoundedButton(menuinfo[9][1]);
		b11 = new RoundedButton(menuinfo[10][1]);
		b12 = new RoundedButton(menuinfo[11][1]);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(b7);
		p2.add(b8);
		p2.add(b9);
		p2.add(b10);
		p2.add(b11);
		p2.add(b12);
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p3.setLayout(new GridLayout(1, 3));
		p3.add(p5);
		p3.add(p6);
		p3.add(p7);

		lb6 = new JLabel("수량");
		lb6.setFont(new Font("나눔글꼴", Font.BOLD, 30));
		lb9 = new JLabel("0 개");
		lb9.setFont(new Font("나눔글꼴", Font.BOLD, 30));
		lb7 = new JLabel("총액");
		lb7.setFont(new Font("나눔글꼴", Font.BOLD, 30));
		lb8 = new JLabel("0 원");
		lb8.setFont(new Font("나눔글꼴", Font.BOLD, 30));
		

		p5.add(lb6);
		p5.add(lb9);
		p6.add(lb7);
		p6.add(lb8);
		b13 = new RoundedButton("접수");
		b13.setFont(new Font("나눔글꼴", Font.BOLD, 50));
		p7.add(b13);
		p4.setLayout(new GridBagLayout());

		p1.setBackground(Color.lightGray);
		p2.setBackground(Color.lightGray);
		p3.setBackground(Color.lightGray);
		p4.setBackground(Color.lightGray);
		p5.setBackground(Color.lightGray);
		p6.setBackground(Color.lightGray);
		p7.setBackground(Color.lightGray);
		p8.setBackground(Color.LIGHT_GRAY);
		cols = getColumn();
		model = new DefaultTableModel(v, cols);
		jTable = new JTable(model);
		pane = new JScrollPane(jTable);
		gc.weightx=1;
		gc.weighty=1;
		gc.gridx=0;
		gc.gridy=0;
		gc.fill=GridBagConstraints.BOTH;
		p4.add(pane,gc);
		gc.gridy=1;
		
		
		p4.add(p8,gc);
		
		b15 = new RoundedButton("1개 삭제");
		b16 = new RoundedButton("한줄 삭제");
		b17 = new RoundedButton("갯수 입력");
		
		p8.add(b15);
		p8.add(b16);
		p8.add(b17);
		
		

		b1.setFont(fb);
		b2.setFont(fb);
		b3.setFont(fb);
		b4.setFont(fb);
		b5.setFont(fb);
		b6.setFont(fb);
		b7.setFont(fb);
		b8.setFont(fb);
		b9.setFont(fb);
		b10.setFont(fb);
		b11.setFont(fb);
		b12.setFont(fb);
		b15.setFont(fb);
		b16.setFont(fb);
		b17.setFont(fb);

		jTable.getTableHeader().setFont(ft);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		b13.addActionListener(this);
		b15.addActionListener(this);
		b16.addActionListener(this);
		b17.addActionListener(this);
		// tf1.setEditable(false);
	}

	private Vector getColumn() {
		Vector col = new Vector();
		col.add("번호");
		col.add("메뉴");
		col.add("가격");
		col.add("수량");

		return col;
	}// getColumn

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			win.change("panel03");
		}
	}

	public void jTableRefresh() {
		Vector data2 = new Vector();
		for (int i = 0; i < 12; i++) {
			int j = i + 1;
			if (menunm[i] == 0) {

			} else {
				String st = String.valueOf(j);
				Vector data = new Vector();
				data.add(menuinfo[i][0]);
				data.add(menuinfo[i][1]);
				data.add(menuinfo[i][2]);
				data.add(menunm[i]);
				data2.add(data);
			}
		}

		DefaultTableModel model = new DefaultTableModel(data2, cols);
		jTable.setModel(model);
		jTable.getTableHeader().setFont(ft);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == b1) {
			menunm[0]++;
		} else if (obj == b2) {
			menunm[1]++;
		} else if (obj == b3) {
			menunm[2]++;
		} else if (obj == b4) {
			menunm[3]++;
		} else if (obj == b5) {
			menunm[4]++;
		} else if (obj == b6) {
			menunm[5]++;
		} else if (obj == b7) {
			menunm[6]++;
		} else if (obj == b8) {
			menunm[7]++;
		} else if (obj == b9) {
			menunm[8]++;
		} else if (obj == b10) {
			menunm[9]++;
		} else if (obj == b11) {
			menunm[10]++;
		} else if (obj == b12) {
			menunm[11]++;
		} else if (obj == b13) {
			
			ord();
			
			
		} else if (obj == b14) {
			if(tf4.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요.");
			}else {
				search(tf4.getText()+"-"+tf4_1.getText()+"-"+tf4_2.getText());
				
			}
		} else if (obj == b15) {
			if(jTable.getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(null, "메뉴를 선택해주세요","에러",JOptionPane.WARNING_MESSAGE);
			}else
			{
			String str = (String) jTable.getValueAt(jTable.getSelectedRow(), 0);
			
			int i = Integer.valueOf(str)-1;
			menunm[i]--;
			}
			
		}else if (obj == b16) {
			if(jTable.getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(null, "메뉴를 선택해주세요","에러",JOptionPane.WARNING_MESSAGE);
			}else
			{
			String str = (String) jTable.getValueAt(jTable.getSelectedRow(), 0);
			
			int i = Integer.valueOf(str)-1;
			menunm[i]=0;
			}
		}else if (obj == b17) {
			if(jTable.getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(null, "메뉴를 선택해주세요","에러",JOptionPane.WARNING_MESSAGE);
			}else	{
				String Str;
				Str = JOptionPane.showInputDialog("바꿀 수량을 입력해 주세요");
				String str = (String) jTable.getValueAt(jTable.getSelectedRow(), 0);
				int i = Integer.valueOf(str)-1;
				menunm[i]=Integer.valueOf(Str);
			}
			
			
		}
		jTableRefresh();
		total = String.valueOf(total());

		lb8.setText(total + " 원");
		int j = 0;
		for (int i = 0; i < menunm.length; i++) {
			j = j + menunm[i];
		}
		quantity = String.valueOf(j);
		lb9.setText(quantity + " 개");
	}

	

	public int total() {
		int to = 0;

		for (int i = 0; i < menunm.length; i++) {
			if (menunm[i] == 0) {
			} else {
				to = to + Integer.valueOf(menuinfo[i][2]) * menunm[i];
			}
		}
		return to;

	}

	public void search(String nm) {
		DBConnect dc = new DBConnect();
		if (dc.getsearchphone(nm, 1) != null) {
			custnum = dc.getsearchphone(nm, 1);
			tf1.setText(dc.findorderid());
			tf3.setText(dc.getsearchphone(nm, 2));
			tf5.setText(dc.getsearchphone(nm, 4));
		} else
			JOptionPane.showMessageDialog(null, "등록되지 않은 고객입니다.");
	}

	public void menuload() {
		DBConnect dc = new DBConnect();
		for (int i = 0; i < 12; i++) {
			menuinfo[i][0] = dc.getMenudb(String.valueOf(i + 1), 1);
			menuinfo[i][1] = dc.getMenudb(String.valueOf(i + 1), 2);
			menuinfo[i][2] = dc.getMenudb(String.valueOf(i + 1), 3);

		}

	}
	public void dayload() {
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yy/MM/dd");
		String str = dayTime.format(new Date(time));
		tf2.setText(str);
	}

	public void ord() {
		DBConnect dc = new DBConnect();
		DBOrder dbo = new DBOrder();
		dbo.setordtime(tf2.getText());
		dbo.setordnum(tf1.getText());
		dbo.setcustid(custnum);
		dbo.setname(tf3.getText());
		dbo.setphone(tf4.getText()+"-"+tf4_1.getText()+"-"+tf4_2.getText());
		dbo.setaddress(tf5.getText());
		dbo.setmenu1(String.valueOf(menunm[0]));
		dbo.setmenu2(String.valueOf(menunm[1]));
		dbo.setmenu3(String.valueOf(menunm[2]));
		dbo.setmenu4(String.valueOf(menunm[3]));
		dbo.setmenu5(String.valueOf(menunm[4]));
		dbo.setmenu6(String.valueOf(menunm[5]));
		dbo.setmenu7(String.valueOf(menunm[6]));
		dbo.setmenu8(String.valueOf(menunm[7]));
		dbo.setmenu9(String.valueOf(menunm[8]));
		dbo.setmenu10(String.valueOf(menunm[9]));
		dbo.setmenu11(String.valueOf(menunm[10]));
		dbo.setmenu12(String.valueOf(menunm[11]));
		dbo.setquantity(quantity);
		dbo.settotal(total);
		dc.insertorder(dbo);
		for (int i = 0; i < menunm.length; i++) {
			menunm[i] = 0;
		}
		jTableRefresh();
		dayload();
		custnum=null;
		tf1.setText(dc.findorderid());
		tf3.setText("");
		tf4.setText("");
		tf4_1.setText("");
		tf4_2.setText("");
		tf5.setText("");
	}

}
