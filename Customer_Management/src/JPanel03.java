import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class JPanel03 extends JPanel implements ActionListener {
	private RoundedButton jbutton1,btn1,btn2,btn3,btn4;
	private JPanelChange win;
	Vector v;  
    Vector cols;
    DefaultTableModel model;
    JTable jTable;
    JScrollPane pane;
    JPanel pbtn,jp;
	public JPanel03(JPanelChange win) {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx=1;
		gc.weighty=1;
		gc.gridx=0;
		gc.gridy=0;
		gc.fill=GridBagConstraints.BOTH;
		
		DBConnect dc = new DBConnect();
		v = dc.getMenuList();
        cols = getMenuColumn();
        model = new DefaultTableModel(v, cols);
        jTable = new JTable(model);
        pane = new JScrollPane(jTable);
        add(pane,gc);
        
        jp = new JPanel();
        gc.gridy=1;
		gc.fill=GridBagConstraints.NONE;
		add(jp,gc);
		
        btn1 = new RoundedButton("추가");
		btn2 = new RoundedButton("수정");
		btn3 = new RoundedButton("삭제");
		btn4 = new RoundedButton("새로고침");
		jp.add(btn1);
		jp.add(btn2);
		jp.add(btn3);
		jp.add(btn4);
        this.win = win;
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		setBackground(Color.LIGHT_GRAY);
		jp.setBackground(Color.LIGHT_GRAY);
		pane.setBackground(Color.LIGHT_GRAY);
		jTable.getTableHeader().setFont(new Font("나눔글꼴", Font.BOLD, 15));
	}
	public Vector getMenuColumn(){
        Vector col = new Vector();
        col.add("메뉴번호");
        col.add("메뉴이름");
        col.add("메뉴가격");
        col.add("메뉴이미지");
        
        return col;
    }//getColumn
	public void jTableRefresh(){
	       
        DBConnect dc = new DBConnect();
        DefaultTableModel model= new DefaultTableModel(dc.getMenuList(), getMenuColumn());
        jTable.setModel(model);    
       
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj==btn1) {
			AddMenu am = new AddMenu();
		}else if(obj == btn2) {
			if(jTable.getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(null, "메뉴를 선택해 주세요","에러",JOptionPane.WARNING_MESSAGE);
			}else {
				ChangeMenu cm = new ChangeMenu();
				DBConnect dc = new DBConnect();
				String sr=(String) jTable.getValueAt(jTable.getSelectedRow(), 0);
				cm.viewset(dc.getMenudb(sr,1),dc.getMenudb(sr,2),dc.getMenudb(sr,3),dc.getMenudb(sr,4));
			}
		}else if(obj == btn3) {
			if(jTable.getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(null, "메뉴를 선택해 주세요","에러",JOptionPane.WARNING_MESSAGE);
			}else {
				String sr=(String) jTable.getValueAt(jTable.getSelectedRow(), 0);
				DBConnect dc = new DBConnect();
				dc.deleteMenu(sr);
				jTableRefresh();
			}
		}else if(obj == btn4) {
			jTableRefresh();
		}
	}
	
}
