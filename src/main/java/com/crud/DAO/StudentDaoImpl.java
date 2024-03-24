package com.crud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.crud.Config.DatabaseConfig;

public class StudentDaoImpl implements StudentDao {

	Connection con = DatabaseConfig.getConnection();

	PreparedStatement ptmt;
	Statement stmt = null;
	ResultSet rs = null;

	int flag = 0;
	String query = null;

	@Override
	public void create() {

		try {

			if (con != null) {
				System.out.println("Database Connected!!!");

				query = "create table student(std_id int primary key, std_name varchar(50) not null, std_city varchar(50) not null);";
				stmt = con.createStatement();

				if (stmt.executeUpdate(query) == 0) {
					System.out.println("table Created in Database Successfully!!!");
				} else {
					System.out.println("Error occured in table creation!!!");
				}
			} else {
				System.out.println("Error occured");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertRecord(int id, String name, String city) {

		try {

			if (con != null) {
				System.out.println("Database Connected!!!");

				query = "insert into student(std_id, std_name, std_city) values(?,?,?);";

				ptmt = con.prepareStatement(query);
				ptmt.setInt(1, id);
				ptmt.setString(2, name);
				ptmt.setString(3, city);

				if (ptmt.executeUpdate() == 1) {
					System.out.println("One Record Inserted Successfully into database");
					flag = 1;
				} else {
					System.out.println("Error occured in record insertion!!!");
				}
			} else {
				System.out.println("Error occured during record insertion");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public ResultSet displayRecord() {

		try {
			query = "select * from student";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int updateRecord(int id, String name, String city) {

		try {
			query = "update student set std_name=?, std_city = ? where std_id=?";

			PreparedStatement ptmt = con.prepareStatement(query);
			ptmt.setString(1, name);
			ptmt.setString(2, city);
			ptmt.setInt(3, id);

			if (ptmt.executeUpdate() == 1) {
				System.out.println("Record Updated into Database Successfully!!!");
				flag = 1;
			} else {
				System.out.println("Requested record not available to Update!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deleteRecord(int id) {

		try {
			if (con != null) {
				System.out.println("Database Connected!!!");

				query = "delete from student where std_id= ?;";

				ptmt = con.prepareStatement(query);
				ptmt.setInt(1, id);

				if (ptmt.executeUpdate() == 1) {
					System.out.println("Record with given ID deleted Successfully from database");
					flag = 1;
				} else {
					System.out.println("Error occured during record deletion!!!");
				}
			} else {
				System.out.println("Error occured");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}