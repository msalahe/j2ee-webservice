package org.im.java.models;

import java.util.List;

public class Resultat {
	private String id;
	private int score;
	private String dure;
	private List<Emotions> emotions;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDure() {
		return dure;
	}

	public void setDure(String dure) {
		this.dure = dure;
	}

	public List<Emotions> getEmotions() {
		return emotions;
	}

	public void setEmotions(List<Emotions> emotions) {
		this.emotions = emotions;
	}

	public Resultat(String id, int score, String dure, List<Emotions> emotions) {
		super();
		this.id = id;
		this.score = score;
		this.dure = dure;
		this.emotions = emotions;
	}

}
