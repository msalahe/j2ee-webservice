package org.im.java.dao.mapper;

import org.im.java.models.Candidat;
import org.im.java.models.Test;

public class CandidatMapper {

	public static int toInt(String data) {
		try {
			return Integer.parseInt(data);
		}
		catch(Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return -1;
		}
	}

	public static Candidat getCandidat(String... row) {
		return new Candidat(toInt(row[0]),row[1],row[2],row[3]);
	}
	public static Test getTest(String... row) {
		return new Test(toInt(row[0]),row[1],row[2],toInt(row[3]),toInt(row[4]));
	}
	
	

}
