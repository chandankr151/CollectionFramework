package com.crud.Service;

import com.crud.DAO.StudentDao;
import com.crud.DAO.StudentDaoImpl;

public class StudentService {

	/// This method is responsible to create table into database...
	public void createTable() {
		StudentDao dao = new StudentDaoImpl();
		dao.create();
	}

	/// This method is responsible to insert record into database...
	public void insertRecord(int id, String name, String city) {
		StudentDao dao = new StudentDaoImpl();
		dao.insertRecord(id, name, city);
	}

	/// This method is responsible to to display all records from databases...
	public void displayRecord() {
		StudentDao dao = new StudentDaoImpl();
		dao.displayRecord();
	}

	/// This method is responsible to Update Record into databases...
	public void updateRecord(int id, String name, String city) {
		StudentDao dao = new StudentDaoImpl();
		dao.updateRecord(id, name, city);
	}

	/// This method is responsible to Delete Record from database...
	public void deleteRecord(int id) {
		StudentDao dao = new StudentDaoImpl();
		dao.deleteRecord(id);
	}
}