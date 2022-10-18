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

	public int addTest(Candidat user) {
		return service.addCandidat(user);
	}

	public List<Candidat> listTest() {
		return service.getAllCondidat();
	}

	public List<Candidat> passerTest() {
		return service.getAllCondidat();
	}

}
