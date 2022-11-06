package org.im.java.actions;

import java.util.List;

import org.im.java.buisiness.TestService;
import org.im.java.buisiness.TestServiceDefault;
import org.im.java.dao.CandidatDao;
import org.im.java.dao.CandidatDaoJdbc;
import org.im.java.dao.TestDao;
import org.im.java.dao.TestDaoJdbc;
import org.im.java.jdbc.DataSource;
import org.im.java.jdbc.Database;
import org.im.java.jdbc.MySqlDataSource;
import org.im.java.models.Candidat;
import org.im.java.models.Quiz;
import org.im.java.models.Test;

public class TestAction {
	private TestService service;

	public TestAction() {
		DataSource ds = new MySqlDataSource("test");
		Database db = new Database(ds);
		CandidatDao candidatDao = new CandidatDaoJdbc(db);
		TestDao testDao = new TestDaoJdbc(db);
		service = new TestServiceDefault(candidatDao, testDao);

	}

	public int addUser(Candidat user) {
		return service.addCandidat(user);
	}

	public List<Candidat> listCandidat() {
		return service.getAllCondidat();
	}

	public int addTest(Test test) {
		return service.addTest(test);
	}

	public List<Test> listTest() {
		return service.getAllTest();
	}

	public List<Candidat> passerTest() {
		return service.getAllCondidat();
	}

	public List<Quiz> listQuiz() {
		return service.listAll();
	}
	public void addQuiz(String data) {
		service.add(data);
	}
	public String send(int id) {
		return service.send(id);
	}
}
