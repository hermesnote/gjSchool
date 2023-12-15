package dao;

import java.util.List;

import model.student;

public interface studentDao {
	
	// create
//	void add(String name, int chi, int eng);  // Create 取決UI設計
	void add(student s);
	
	// read
	String queryAll1();
	List<student> queryAll2();
	
	// update
	
	
	// delete
}
