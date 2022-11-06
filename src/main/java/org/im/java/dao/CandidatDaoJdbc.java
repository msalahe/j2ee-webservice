package org.im.java.dao;

import java.util.List;
import java.util.Vector;

import org.im.java.dao.mapper.CandidatMapper;
import org.im.java.jdbc.Database;
import org.im.java.models.Candidat;

public class CandidatDaoJdbc implements CandidatDao {
	private Database db;
	private String tablename = "candidat";

	public CandidatDaoJdbc(Database db) {
		this.db = db;
	}

	@Override
	public int insert(Candidat candidat) {
		return db.insert(tablename,listAll().size()+1,candidat.getNom(),candidat.getPrénom(),candidat.getDate_naissance());
	}

	@Override
	public Candidat select(int id) {
		String data[][] = db.select(tablename, "idC", id);
		for(int i=0;i<data[0].length;i++) {
			System.out.println(data[0].toString());
		}
		if (data != null && data.length >= 1) {
             return CandidatMapper.getCandidat(data[0]);
		}

		return null;
	}

	@Override
	public List<Candidat> listAll() {
		List<Candidat> candidats  = new Vector<Candidat>();
		String data[][] = db.select(tablename);
		for(int i = 1;i<data.length;i++) {
			candidats.add(new Candidat(data[i]));
		}
		return candidats;
	}

}
