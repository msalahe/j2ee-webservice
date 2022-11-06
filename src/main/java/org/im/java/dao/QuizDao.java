package org.im.java.dao;

import java.util.List;

import org.im.java.models.Quiz;
import org.im.java.models.Resultat;

public interface QuizDao {
    
	public List<Quiz> list();
	public void add(String data);
	public String send(int id);
}
