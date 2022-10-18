package org.im.java.dao;

import java.util.List;

import org.im.java.models.Candidat;

public interface CandidatDao {
	public int insert(Candidat candidat);

	public Candidat select(int id);

	public List<Candidat> listAll();

}
