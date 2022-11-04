package org.im.java.models;

public class Test {
    private int id;
    private String date;
    private String sujet;
    private int score;
    private Candidat candidat;
    
	public Test(int id, String date, String sujet, int score, int candidat) {
		super();
		this.id = id;
		this.date = date;
		this.sujet = sujet;
		this.score = score;
		this.candidat = new Candidat(candidat);
	}
	public Test(String... row) {
		super();
		try {
			this.id = Integer.parseInt(row[0]);

		} catch (Exception e) {

		}
		try {
			this.date = row[1];

		} catch (Exception e) {

		}
		try {
			this.sujet = row[2];

		} catch (Exception e) {

		}
		try {
			this.score = Integer.parseInt(row[3]);

		} catch (Exception e) {

		}
		try {
			this.candidat = new Candidat(Integer.parseInt(row[4]));

		} catch (Exception e) {

		}
	}
	public Test() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Candidat getCandidat() {
		return candidat;
	}
	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}
	public String toJson() {
		return "{ \"id\" :" +id+", \"date\" : \""+ date+"\", \"score\" : \""+score+"\", \"sujet\" : \""+ sujet+"\"}";
	}
	
	

}
