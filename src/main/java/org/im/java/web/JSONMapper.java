package org.im.java.web;

import java.util.List;

import org.im.java.models.Candidat;

public class JSONMapper {

	public JSONMapper() {
		// TODO Auto-generated constructor stub
	}



	public static String getCandidat(List<Candidat> a) {
		String json = "[";
		if (a.size() > 0) {
			json += a.get(0).toJson();
			for (int i = 1; i < a.size(); i++) {
				json += "," + a.get(i).toJson();
			}
		}
		json += "]";
		return json;

	}

}
