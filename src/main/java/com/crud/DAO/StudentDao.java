package com.crud.DAO;

import java.sql.ResultSet;

public interface StudentDao {

	public void create();

	public int insertRecord(int id, String name, String city);

	public ResultSet displayRecord();

	public int updateRecord(int id, String name, String city);

	public int deleteRecord(int id);
}
