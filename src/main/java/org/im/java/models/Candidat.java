package org.im.java.models;

public class Candidat {
	private int id;
	private String nom;
	private String prénom;
	private String date_naissance;

	public Candidat() {
		// TODO Auto-generated constructor stub
	}

	public Candidat(int id) {
		this.id = id;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getDate_naissance() {
		return date_naissance;
	}

	public Candidat(String... row) {
		super();
		try {
			this.id = Integer.parseInt(row[0]);

		} catch (Exception e) {

		}
		try {
			this.nom = row[1];

		} catch (Exception e) {

		}
		try {
			this.prénom = row[2];

		} catch (Exception e) {

		}
		try {
			this.date_naissance = row[3];

		} catch (Exception e) {

		}
	}

	public Candidat(int id, String nom, String prénom, String date_naissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.prénom = prénom;
		this.date_naissance = date_naissance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrénom() {
		return prénom;
	}

	public void setPrénom(String prénom) {
		this.prénom = prénom;
	}
	public String toJson() {
		return "{ \"id\" :" +id+", \"nom\" : \""+ nom+"\", \"prenom\" : \""+prénom+"\", \"date_naissance\" : \""+ date_naissance+"\"}";
	}

}
