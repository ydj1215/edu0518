package com.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dev.vo.MemberVO;

public class MemberDAO {
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance()
	{
		return dao;
	}
	
	public Connection connect()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:8080/test","root","woehddb5555!");
		}
		catch(Exception e)
		{
			System.out.println("MDAO:connect"+e);
		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement pstmt)
	{
		if(pstmt != null)
		{
			try
			{
				pstmt.close();
			}
			catch(Exception e)
			{
				System.out.println("Pstmt close error"+e);
			}
		}
		if(conn != null)
		{
			try
			{
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println("Conn close error"+e);
			}
		}
	}
		public void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
		{			
			if(rs != null)
			{
				try
				{
					rs.close();
				}
				catch(Exception e) {
					System.out.println("rs close error"+e);
				}
			}
			close(conn,pstmt);
		}
		public void memberInsert(MemberVO member)
		{
			Connection conn = null;
			PreparedStatement pstmt = null;
			try
			{
				conn = connect();
				pstmt = conn.prepareStatement("insert into member values(?,?,?);");
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPwd());
				pstmt.setString(3, member.getName());
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				System.out.println("MDAO:mInsert"+e);				
			}
			finally
			{
				close(conn,pstmt);
			}
		}
		public MemberVO memberSearch(String id)
		{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			MemberVO member = null;
			try
			{
				conn = connect();
				pstmt = conn.prepareStatement("select * from member where id = ?;");
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					member = new MemberVO();
					member.setId(rs.getString(1));
					member.setPwd(rs.getString(2));
					member.setName(rs.getString(3));
				}
			}
			catch(Exception e)
			{
				System.out.println("MSearch error"+e);				
			}
			finally
			{
				close(conn,pstmt);
			}
			return member;
		}
		public void memberUpdate(MemberVO member)
		{
			Connection conn = null;
			PreparedStatement pstmt = null;
			try
			{
				conn = connect();
				pstmt = conn.prepareStatement("update member set pwd =?, name=? where id =?;");
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPwd());
				pstmt.setString(3, member.getName());
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				System.out.println("MDAO:mInsert"+e);				
			}
			finally
			{
				close(conn,pstmt);
			}
		}
		public ArrayList<MemberVO> memberListAll() {
			// TODO Auto-generated method stub
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			MemberVO member = null;
			ArrayList<MemberVO> list = new ArrayList<MemberVO>();
			try
			{
				conn = connect();
				pstmt = conn.prepareStatement("select * from member;");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					member = new MemberVO();
					member.setId(rs.getString(1));
					member.setPwd(rs.getString(2));
					member.setName(rs.getString(3));
					list.add(member);
				}
			}
			catch(Exception e)
			{
				System.out.println("MSearch error"+e);				
			}
			finally
			{
				close(conn,pstmt);
			}
			return list;
		}
		public void memberDelete(MemberVO member)
		{
			Connection conn = null;
			PreparedStatement pstmt = null;
			try
			{
				conn = connect();
				pstmt = conn.prepareStatement("delete from oneline where values(?,?,?);");
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPwd());
				pstmt.setString(3, member.getName());
				pstmt.executeUpdate();
			}
			catch(Exception e)
			{
				System.out.println("MDAO:mInsert"+e);				
			}
			finally
			{
				close(conn,pstmt);
			}
		}
		
		
}
