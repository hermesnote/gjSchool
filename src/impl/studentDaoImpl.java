package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.studentDao;
import model.student;

public class studentDaoImpl implements studentDao {

	public static void main(String[] args) {
//		System.out.println(new studentDaoImpl().queryAll1());  // 顯示studentDaoImpl物件下的queryAll1()方法
//		System.out.println(new studentDaoImpl().queryAll2());
//		student s = new student("teacher", 88, 77);
//		new studentDaoImpl().add(s);
		
		List<student> l = new studentDaoImpl().queryAll2();
		int sum = 0;
		for( student o:l ) {
			System.out.println("id:"+o.getId()+"\t名:"+o.getName()+"\t國文:"+o.getChi()+"\t英文:"+o.getEng());
			
			sum = sum+o.getChi()+o.getEng();
		}
		System.out.println("合計:"+sum);
	}

	@Override
	public void add(student s) {
		Connection conn = DbConnection.getDb();
		String SQL = "INSERT INTO student (name, chi, eng) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1,  s.getName());
			ps.setInt(2, s.getChi());
			ps.setInt(3, s.getEng());
			
			ps.executeUpdate();
		}catch( SQLException e ) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String queryAll1() {
		Connection conn = DbConnection.getDb();  // 連線資料表
		String SQL = "SELECT * FROM student";  // SQL語法 -> 查詢
		String show = "";  // 建立空字串準備帶資料
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);  // 帶入SQL語法
			ResultSet rs = ps.executeQuery();  // 執行SQL Query
			
			while (rs.next()) {  // show空字串 = 自己+資料
				show = show+"id:"+rs.getInt("id")+
						"\t姓名:"+rs.getString("name")+
						"\t國文:"+rs.getInt("chi")+
						"\t英文:"+rs.getInt("eng")+"\n";
			}
		}catch( SQLException e) {
			e.printStackTrace();
		}
		return show;  // 回傳 show字串
	}

	@Override
	public List<student> queryAll2() {
		Connection conn = DbConnection.getDb();  // 連線資料表
		String SQL = "SELECT * FROM student";
		List<student> l = new ArrayList();
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				student s = new student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setChi(rs.getInt("chi"));
				s.setEng(rs.getInt("eng"));
				
				l.add(s);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return l;
	}

}
