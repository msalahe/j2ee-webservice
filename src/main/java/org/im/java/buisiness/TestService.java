package org.im.java.buisiness;

import java.util.List;

import org.im.java.models.Candidat;
import org.im.java.models.Quiz;
import org.im.java.models.Test;

public interface TestService {
	public Test getTestById(int id);

	public List<Candidat> getAllCondidat();

	public int addTest(Test test);

	public int addCandidat(Candidat candidat);

	public List<Test> getAllTest();

	public boolean updateTest(int id, Test test);

	public List<Quiz> listAll();
}
