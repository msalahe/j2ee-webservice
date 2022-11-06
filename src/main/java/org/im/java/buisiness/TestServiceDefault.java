package org.im.java.buisiness;

import java.util.ArrayList;
import java.util.List;

import org.im.java.dao.CandidatDao;
import org.im.java.dao.QuizDao;
import org.im.java.dao.QuizDaoJson;
import org.im.java.dao.TestDao;
import org.im.java.models.Candidat;
import org.im.java.models.Quiz;
import org.im.java.models.Test;

public class TestServiceDefault implements TestService {
	private CandidatDao candidatDao;
	private TestDao testDao;
	private QuizDao quizDao;

	public TestServiceDefault(CandidatDao candidatDao, TestDao testDao) {
		this.candidatDao = candidatDao;
		this.testDao = testDao;
		this.quizDao = new QuizDaoJson();
	}

	@Override
	public Test getTestById(int id) {
		// TODO Auto-generated method stub
		return testDao.select(id);
	}

	@Override
	public List<Candidat> getAllCondidat() {
		return candidatDao.listAll();
	}

	@Override
	public int addTest(Test test) {
		// TODO Auto-generated method stub
		return testDao.insert(test);
	}

	@Override
	public int addCandidat(Candidat candidat) {
		// TODO Auto-generated method stub
		return candidatDao.insert(candidat);
	}

	@Override
	public List<Test> getAllTest() {
       List<Test> test = testDao.listAll();
		return test;
	}

	@Override
	public boolean updateTest(int id, Test test) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Quiz> listAll() {
		List<Quiz> quizTrier = quizDao.list();
		List<Quiz> quizFinal = new ArrayList<>();
		int max = 20;
		int min = 0;
	      System.out.println(quizTrier.size());
		for (int i = 0; i < 9; i++) {
			 int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
			 Quiz q = quizTrier.get(random_int);
			 quizFinal.add(q);
			 System.out.println(q.getExercice());
			 quizTrier.remove(q);
			 max--;

		}
		return quizTrier;
	}

	@Override
	public void add(String data) {
		quizDao.add(data);
	}

	@Override
	public String send(int id) {
		// TODO Auto-generated method stub
		return quizDao.send(id);
	}

}
