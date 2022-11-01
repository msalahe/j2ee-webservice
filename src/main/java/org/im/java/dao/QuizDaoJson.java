package org.im.java.dao;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.im.java.models.Quiz;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class QuizDaoJson implements QuizDao {
	private FileReader reader;
	Object data;

	public QuizDaoJson() {
		try {
			reader = new FileReader("C:\\Users\\Administrator\\ws_j2ee\\project-quiz\\ressources\\db.json");
			JsonParser jsonParser = new JsonParser();
			data = jsonParser.parse(reader);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Quiz> list() {

		List<Quiz> quizs = new ArrayList<>();
		try {

			JsonObject jsonObject = (JsonObject) data;
			JsonArray array = (JsonArray) jsonObject.get("Calcul_Mentale");

			for (int i = 0; i < array.size(); i++) {
				JsonObject jsonbject = (JsonObject) array.get(i);
				JsonElement exercice = jsonbject.get("exercice");
				JsonElement choix1 = jsonbject.get("choix1");
				JsonElement choix2 = jsonbject.get("choix2");
				JsonElement choix3 = jsonbject.get("choix3");
				JsonElement choix4 = jsonbject.get("choix4");
				JsonElement resp = jsonbject.get("resp");
				JsonElement desc = jsonbject.get("description");

				quizs.add(new Quiz(i + 1, exercice.toString(), choix1.toString(), choix2.toString(), choix3.toString(),
						choix4.toString(), desc.toString(), resp.toString()));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return quizs;
	}

}
