package org.im.java.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.im.java.models.Emotions;
import org.im.java.models.Quiz;
import org.im.java.models.Resultat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

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
			JsonArray array = (JsonArray) jsonObject.get("Quizz");

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

	@Override
	public void add(String data) {
		try {

	        try (FileWriter file = new FileWriter("C:\\Users\\Administrator\\ws_j2ee\\project-quiz\\ressources\\tests.json")) {
	            file.write(data); 
	            file.flush();
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}catch(Exception e) {
			
		}

	}

	@Override
	public String send(int id) {
		try {
			JsonReader reader = new JsonReader(new FileReader("C:\\Users\\Administrator\\ws_j2ee\\project-quiz\\ressources\\tests.json"));
			Gson gson = new Gson();
	        Resultat res = gson.fromJson(reader, Resultat.class);
	        List<Emotions> emotions = miniserEmotions(res.getEmotions());
	        String contents = getContent(emotions);
	        String neutre = getNeutre(emotions);
	        String Suprise = getSurpris(emotions);
	        String enerve = getenerve(emotions);
	        
	        JSONObject json = new JSONObject();

	        json.put("score", res.getScore());
	        json.put("duree", res.getDure());
	        json.put("content", contents);
	        json.put("neutre",neutre);
	        json.put("surpris", Suprise);
	        json.put("enerve", enerve);




	        
	        return json.toString();

	        
	        
	        
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
        return null;
	}
	public List<Emotions> miniserEmotions(List<Emotions> emotions) {
		List<Emotions> emoReturn = new ArrayList<>();
		int drap=0;
		while(drap < emotions.size()-3) {
			drap+=3;
			emoReturn.add(emotions.get(drap));
			drap++;
		}
		return emoReturn;
	}
	public String getContent(List<Emotions> emotions){
		String contents = "[";;
		for (Emotions emotions2 : emotions) {
			contents+=emotions2.getContent();
			contents+=",";
		}
		contents = contents.substring(0, contents.length()-1);

		contents +="]";
		return contents;
	}
	public String getNeutre(List<Emotions> emotions){
		String  neutre = "[";
		for (Emotions emotions2 : emotions) {
			neutre +=emotions2.getNeutre();
			neutre+=",";

		}
		neutre =neutre.substring(0, neutre.length()-1);

		neutre +="]";
		return neutre;
	}
	public String getSurpris(List<Emotions> emotions){
		String surpris =  "[";
		for (Emotions emotions2 : emotions) {
			surpris +=(emotions2.getSurpris());
			surpris+=",";

		}
		surpris =surpris.substring(0, surpris.length()-1);

		surpris +="]";
		return surpris;
	}
	public String getenerve(List<Emotions> emotions){
		String enerve =  "[";
		for (Emotions emotions2 : emotions) {
			enerve+=emotions2.getEnerve();
			enerve+=",";

		}
		enerve =enerve.substring(0, enerve.length()-1);
		enerve +="]";

		return enerve;
	}

}
