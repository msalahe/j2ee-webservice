package org.im.java.dao;

import java.util.List;
import java.util.Vector;

import org.im.java.dao.mapper.CandidatMapper;
import org.im.java.jdbc.Database;
import org.im.java.models.Candidat;
import org.im.java.models.Test;

public class TestDaoJdbc implements TestDao {
	private Database db;
	private String tablename = "quiz";

	public TestDaoJdbc(Database db) {
		this.db = db;
	}

	@Override
	public int insert(Test test) {
		return db.insert(tablename,listAll().size()+1 ,test.getSujet(), test.getDate(), 0, test.getCandidat().getId());
	}

	@Override
	public Test select(int id) {
		String data[][] = db.select(tablename, "id", id);

		if (data != null && data.length > 1) {
			return CandidatMapper.getTest(data[1]);
		}

		return null;
	}

	@Override
	public List<Test> listAll() {
		List<Test> tests = new Vector<Test>();
		String data[][] = db.select(tablename);
		for (int i = 1; i < data.length; i++) {
			tests.add(new Test(data[i]));
		}
		return tests;
	}

}
