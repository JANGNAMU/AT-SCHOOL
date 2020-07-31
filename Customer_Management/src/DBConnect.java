
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class DBConnect {
	public Vector getMenuList() {
		Vector data = new Vector(); // Jtable에 값을 쉽게 넣는 방법 1. 2차원배열 2. Vector 에 vector추가
		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과

		try {

			con = getConn();
			String sql = "select * from menu order by menunum asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String menunum = rs.getString("menunum");
				String menuname = rs.getString("menuname");
				String menuprice = rs.getString("menuprice");
				String menuimange = rs.getString("menuimage");

				Vector row = new Vector();
				row.add(menunum);
				row.add(menuname);
				row.add(menuprice);
				row.add(menuimange);

				data.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public Vector getMemberList() {

		Vector data = new Vector(); // Jtable에 값을 쉽게 넣는 방법 1. 2차원배열 2. Vector 에 vector추가

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과

		try {

			con = getConn();
			String sql = "select * from customer order by custid asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String custid = rs.getString("custid");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");

				Vector row = new Vector();
				row.add(custid);
				row.add(name);
				row.add(phone);
				row.add(address);

				data.add(row);
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}// getMemberList()

	public static Connection getConn() {
		Connection con = null;

		try {
			System.out.println("드라이버 로드 성공");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "najavavara", "najavavara");
			System.out.println("DB접속 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e) {
			System.out.println("DB접속 실패" + e);
			e.printStackTrace();
		}

		return con;

	}

	public String getMemberdb(String custid, int num) {
		DBConnect2 dc2 = new DBConnect2();

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과
		try {

			con = getConn();
			String sql = "select * from customer where custid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, custid);

			rs = ps.executeQuery();

			if (rs.next()) {
				dc2.setCustid(rs.getString(1));
				dc2.setName(rs.getString(2));
				dc2.setPhone(rs.getString(3));
				dc2.setAddress(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (num == 1) {
			return dc2.getCustidId();
		} else if (num == 2) {
			return dc2.getName();
		} else if (num == 3) {
			return dc2.getPhone();
		} else if (num == 4) {
			return dc2.getAddress();
		}
		return null;
	}

	public String getsearchphone(String phone, int num) {
		DBConnect2 dc2 = new DBConnect2();
		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과
		try {

			con = getConn();
			String sql = "select * from customer where phone=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, phone);

			rs = ps.executeQuery();
			if (rs.next()) {
				dc2.setCustid(rs.getString(1));
				dc2.setName(rs.getString(2));
				dc2.setPhone(rs.getString(3));
				dc2.setAddress(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (num == 1) {
			return dc2.getCustidId();
		} else if (num == 2) {
			return dc2.getName();
		} else if (num == 3) {
			return dc2.getPhone();
		} else if (num == 4) {
			return dc2.getAddress();
		}
		return null;
	}

	/** 회원 등록 */
	public boolean insertMember(DBConnect2 dc2) {
		boolean ok = false;

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령

		try {

			con = getConn();
			String sql = "INSERT INTO Customer (" + "custid,name,phone,address) " + "values(?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, dc2.getCustidId());
			ps.setString(2, dc2.getName());
			ps.setString(3, dc2.getPhone());
			ps.setString(4, dc2.getAddress());
			int r = ps.executeUpdate(); // 실행 -> 저장

			if (r > 0) {
				System.out.println("등록 성공");
				ok = true;
			} else {
				System.out.println("등록 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}// insertMmeber

	public DBConnect2 findcustid() {
		DBConnect2 dc2 = new DBConnect2();

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과
		try {

			con = getConn();
			String sql = "select Max(custid)+1 from CUSTOMER";
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			if (rs.next()) {
				dc2.setCustid(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dc2;
	}

	public boolean deleteMember(String id) {
		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			String sql = "delete from customer where custid=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			int r = ps.executeUpdate(); // 실행 -> 삭제

			if (r > 0)
				ok = true; // 삭제됨;

		} catch (Exception e) {
			System.out.println(e + "-> 오류발생");
		}
		return ok;
	}

	public boolean updateMember(DBConnect2 dc2) {
		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {

			con = getConn();
			String sql = "update customer set name=?, phone=?, address=?" + "where custid=?";

			ps = con.prepareStatement(sql);

			ps.setString(1, dc2.getName());
			ps.setString(2, dc2.getPhone());
			ps.setString(3, dc2.getAddress());
			ps.setString(4, dc2.getCustidId());

			int r = ps.executeUpdate(); // 실행 -> 수정
			// 1~n: 성공 , 0 : 실패

			if (r > 0)
				ok = true; // 수정이 성공되면 ok값을 true로 변경

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	/** 메뉴 등록 */
	public boolean insertMenu(DBMenu dm) {
		boolean ok = false;

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령

		try {

			con = getConn();
			String sql = "INSERT INTO menu (" + "MENUNUM,MENUNAME,MENUPRICE,MENUIMAGE) " + "values(?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, dm.getMenuNum());
			ps.setString(2, dm.getMenuName());
			ps.setString(3, dm.getMenuPrice());
			ps.setString(4, dm.getMenuImage());
			int r = ps.executeUpdate(); // 실행 -> 저장

			if (r > 0) {
				System.out.println("등록 성공");
				ok = true;
			} else {
				System.out.println("등록 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}// insertMenu

	public boolean updateMenu(DBMenu dm) {
		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {

			con = getConn();
			String sql = "update menu set MENUNAME=?, MENUPRICE=?, MENUIMAGE=?" + "where MENUNUM=?";

			ps = con.prepareStatement(sql);

			ps.setString(1, dm.getMenuName());
			ps.setString(2, dm.getMenuPrice());
			ps.setString(3, dm.getMenuImage());
			ps.setString(4, dm.getMenuNum());

			int r = ps.executeUpdate(); // 실행 -> 수정
			// 1~n: 성공 , 0 : 실패

			if (r > 0)
				ok = true; // 수정이 성공되면 ok값을 true로 변경

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	public boolean deleteMenu(String id) {
		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			String sql = "delete from menu where menunum=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			int r = ps.executeUpdate(); // 실행 -> 삭제

			if (r > 0)
				ok = true; // 삭제됨;

		} catch (Exception e) {
			System.out.println(e + "-> 오류발생");
		}
		return ok;
	}

	public DBMenu findmenunum() {
		DBMenu dm = new DBMenu();

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과
		try {

			con = getConn();
			String sql = "select Max(menunum)+1 from menu";
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			if (rs.next()) {
				dm.setMenuNum(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dm;
	}

	public String getMenudb(String menuid, int num) {
		DBMenu dm = new DBMenu();

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과
		try {

			con = getConn();
			String sql = "select * from menu where menunum=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, menuid);

			rs = ps.executeQuery();

			if (rs.next()) {
				dm.setMenuNum(rs.getString(1));
				dm.setMenuName(rs.getString(2));
				dm.setMenuPrice(rs.getString(3));
				dm.setMenuImage(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (num == 1) {
			return dm.getMenuNum();
		} else if (num == 2) {
			return dm.getMenuName();
		} else if (num == 3) {
			return dm.getMenuPrice();
		} else if (num == 4) {
			return dm.getMenuImage();
		}
		return null;
	}

	public String getMenuname(int i) {
		DBMenu dm = new DBMenu();

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과
		try {

			con = getConn();
			String sql = "select * from menu where menunum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, i);

			rs = ps.executeQuery();

			if (rs.next()) {
				dm.setMenuNum(rs.getString(1));
				dm.setMenuName(rs.getString(2));
				dm.setMenuPrice(rs.getString(3));
				dm.setMenuImage(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dm.getMenuName();
	}

	public int getMenupr(int menuid) {
		DBMenu dm = new DBMenu();

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과
		try {

			con = getConn();
			String sql = "select * from menu where menunum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, menuid);

			rs = ps.executeQuery();

			if (rs.next()) {
				dm.setMenuNum(rs.getString(1));
				dm.setMenuName(rs.getString(2));
				dm.setMenuPrice(rs.getString(3));
				dm.setMenuImage(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Integer.parseInt(dm.getMenuPrice());
	}

	public String findorderid() {
		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과
		String oid = null;
		try {

			con = getConn();
			String sql = "select Max(ordnum)+1 from orders";
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			if (rs.next()) {
				oid = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return oid;
	}

	public boolean insertorder(DBOrder dbo) {
		boolean ok = false;

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령

		try {

			con = getConn();
			String sql = "INSERT INTO orders ("
					+ "ordtime,ordnum,custid,name,phone,address,menu1,menu2,menu3,menu4,menu5,menu6,menu7,menu8,menu9,menu10,menu11,menu12,quantity,total) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, dbo.getordtime());
			ps.setString(2, dbo.getordnum());
			ps.setString(3, dbo.getcustid());
			ps.setString(4, dbo.getname());
			ps.setString(5, dbo.getphone());
			ps.setString(6, dbo.getaddress());
			ps.setString(7, dbo.getmenu1());
			ps.setString(8, dbo.getmenu2());
			ps.setString(9, dbo.getmenu3());
			ps.setString(10, dbo.getmenu4());
			ps.setString(11, dbo.getmenu5());
			ps.setString(12, dbo.getmenu6());
			ps.setString(13, dbo.getmenu7());
			ps.setString(14, dbo.getmenu8());
			ps.setString(15, dbo.getmenu9());
			ps.setString(16, dbo.getmenu10());
			ps.setString(17, dbo.getmenu11());
			ps.setString(18, dbo.getmenu12());
			ps.setString(19, dbo.getquantity());
			ps.setString(20, dbo.gettotal());

			int r = ps.executeUpdate(); // 실행 -> 저장

			if (r > 0) {
				System.out.println("주문 성공");
				ok = true;
				JOptionPane.showMessageDialog(null, "주문이 완료되었습니다.");
			} else {
				System.out.println("주문 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}
}
