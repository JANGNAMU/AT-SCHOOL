import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ChangeCustomer extends JFrame implements ActionListener {
	private JPanel Mainp;
	private JTextField tfname, tfphone, tfaddress;
	private JLabel lblname, lblphone, lbladdress;
	private JButton ok, cancel;
	private DBConnect2 dc2 = new DBConnect2();
	private String id;
	public ChangeCustomer() {
		setTitle("고객 수정");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		Mainp = new JPanel();
		Mainp.setBackground(Color.lightGray);
		add(Mainp);
		Mainp.setLayout(null);
		lblname = new JLabel("이름 : ");
		lblphone = new JLabel("연락처 : ");
		lbladdress = new JLabel("주소 : ");
		lblname.setBounds(10, 10, 100, 100);
		lblphone.setBounds(10, 50, 100, 100);
		lbladdress.setBounds(10, 100, 100, 100);

		tfname = new JTextField(10);
		tfname.setBounds(65, 45, 100, 30);
		tfphone = new JTextField(20);
		tfphone.setBounds(65, 90, 120, 30);
		tfaddress = new JTextField(30);
		tfaddress.setBounds(65, 140, 300, 30);
		ok = new RoundedButton("확인");
		cancel = new RoundedButton("취소");

		ok.setBounds(100, 190, 90, 30);
		cancel.setBounds(220, 190, 90, 30);
		Mainp.add(lblname);
		Mainp.add(lblphone);
		Mainp.add(lbladdress);
		Mainp.add(tfname);
		Mainp.add(tfphone);
		Mainp.add(tfaddress);
		Mainp.add(ok);
		Mainp.add(cancel);
		setVisible(true);
		ok.addActionListener(this);
		cancel.addActionListener(this);

	}

	public static void main(String[] args) {
		ChangeCustomer mf = new ChangeCustomer(); // ���ο� ��ü�� ���� �ҷ����°�, ���ο��� ���� �������� �ҷ��� �ܼ� ����
													// ����
	}

	public void viewset(String custid, String custname, String custphone, String custaddress) {
		id = custid;

		tfname.setText(custname);
		tfphone.setText(custphone);
		tfaddress.setText(custaddress);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == ok) {
			DBConnect dc = new DBConnect();
			dc2.setCustid(id);
			dc2.setName(tfname.getText());
			dc2.setPhone(tfphone.getText());
			dc2.setAddress(tfaddress.getText());
			dc.updateMember(dc2);
			dispose();
		} else if (obj == cancel) {
			dispose();
		}
	}

}
