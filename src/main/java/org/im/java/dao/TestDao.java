package org.im.java.dao;

import java.util.List;

import org.im.java.models.Test;

public interface TestDao {

	public int insert(Test test);

	public Test select(int id);

	public List<Test> listAll();
}
