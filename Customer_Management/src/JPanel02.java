import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.security.auth.Refreshable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


public class JPanel02 extends JPanel implements ActionListener{
	private JPanelChange win;
	private JTextField textField;
	private JButton btn1,btn2,btn3,btn4;
	Vector v;  
    Vector cols;
    DefaultTableModel model;
    JTable jTable;
    JScrollPane pane;
    JPanel pbtn,jp;
	public JPanel02(JPanelChange win) {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx=1;
		gc.weighty=1;
		gc.gridx=0;
		gc.gridy=0;
		gc.fill=GridBagConstraints.BOTH;
		DBConnect dc = new DBConnect();
		v = dc.getMemberList();
        cols = getColumn();
        model = new DefaultTableModel(v, cols);
        jTable = new JTable(model);
        pane = new JScrollPane(jTable);
        add(pane,gc);
		
		
		this.win = win;
		gc.gridy=1;
		gc.fill=GridBagConstraints.NONE;
		jp = new JPanel();
		add(jp,gc);
		
		btn1 = new RoundedButton("추가");
		btn2 = new RoundedButton("수정");
		btn3 = new RoundedButton("삭제");
		btn4 = new RoundedButton("새로고침");
		jp.add(btn1);
		btn1.addActionListener(this);
		jp.add(btn2);
		btn2.addActionListener(this);
		jp.add(btn3);
		btn3.addActionListener(this);
		jp.add(btn4);
		btn4.addActionListener(this);
		
		setBackground(Color.LIGHT_GRAY);
		jp.setBackground(Color.LIGHT_GRAY);
		pane.setBackground(Color.LIGHT_GRAY);
		jTable.getTableHeader().setFont(new Font("나눔글꼴", Font.BOLD, 15));
	}
	
	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel01");			
		}
	}
	public Vector getColumn(){
        Vector col = new Vector();
        col.add("고객번호");
        col.add("이름");
        col.add("핸드폰");
        col.add("주소");
        
        return col;
    }//getColumn
	
	public void jTableRefresh(){
	       
        DBConnect dc = new DBConnect();
        DefaultTableModel model= new DefaultTableModel(dc.getMemberList(), getColumn());
        jTable.setModel(model);    
       
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if(obj == btn1) {
			AddCustomer ac = new AddCustomer();
		} else if(obj == btn2) {
			
			if(jTable.getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(null, "고객을 선택해 주세요","에러",JOptionPane.WARNING_MESSAGE);
			}else {
				ChangeCustomer cc = new ChangeCustomer();
				DBConnect dc = new DBConnect();
				String sr=(String) jTable.getValueAt(jTable.getSelectedRow(), 0);
				cc.viewset(dc.getMemberdb(sr,1),dc.getMemberdb(sr,2),dc.getMemberdb(sr,3),dc.getMemberdb(sr,4));
			}
		} else if(obj == btn3) {
			if(jTable.getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(null, "고객을 선택해 주세요","에러",JOptionPane.WARNING_MESSAGE);
			}else {
			String sr=(String) jTable.getValueAt(jTable.getSelectedRow(), 0);
			DBConnect dc = new DBConnect();
			dc.deleteMember(sr);
			jTableRefresh();
			}
		} else if(obj == btn4) {
			
			jTableRefresh();
		} 
			
	}
	
	
}

