package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class userDAO {
	
	// �α��� �����ϴ� SQL�� (executeQuery �� ������ 1 ��ȯ)
	public int Login(String userID, String userPW) {
		String SQL = "SELECT userPW FROM user WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPW)) {
					return 1; 	//�α��� ����
				}
				else {
					return 0; 	// ��й�ȣ Ʋ��
				}
			} return -1;		// ���̵� ����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(pstmt != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(rs != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
		}
		return -2;				// DB ����
	}
	
	// ȸ������ �����ϴ� SQL�� (executeUpdate �� ���� �� ������Ʈ)
	public int SignUp(userDTO user) {
		String SQL = "INSERT INTO VALUES (?, ?, ?, ?, ?, ?, ?, ?, false)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPW());
			pstmt.setString(3, user.getUserEmail());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserBirth());
			pstmt.setString(6, user.getUserLoc());
			pstmt.setString(7, user.getUserName());
			pstmt.setString(8, user.getUserEmailHash());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(pstmt != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(rs != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
		}
		return -1;				// ȸ������ ����
	}
	
	// email �� ���� SQL�� (executeUpdate �� )
	public String getUserEmail(String userID) {
		String SQL = "SELECT userEmail FROM USER WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(pstmt != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(rs != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
		}
		return null;				// DB ����
	}
	
	
	// �̸���üũ�� �Ǿ����� Ȯ���ϴ� SQL�� (executeUpdate �� )
	public boolean getUserEmailChecked(String userID) {
		String SQL = "SELECT userEmailChecked FROM USER WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getBoolean(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(pstmt != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(rs != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
		}
		return false;				// DB ����
	}
	
	// �̸��� üũ�� �����ϴ� SQL�� (executeUpdate �� ���� �� true�� ������Ʈ)
	public boolean setUserEmailChecked(String userID) {
		String SQL = "UPDATE USER SET userEmailchecked = true WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(pstmt != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(rs != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
		}
		return false;				// DB ����
	}
}


