package org.im.java.models;

public class Quiz {

	private int id;
	private String exercice;
	private String choix1;
	private String choix2;
	private String choix3;
	private String choix4;
	private String description;
	private String resp;

	public Quiz(int id, String exercice, String choix1, String choix2, String choix3, String choix4, String description,
			String resp) {
		super();
		this.id = id;
		this.exercice = exercice;
		this.choix1 = choix1;
		this.choix2 = choix2;
		this.choix3 = choix3;
		this.choix4 = choix4;
		this.description = description;
		this.resp = resp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExercice() {
		return exercice;
	}

	public void setExercice(String exercice) {
		this.exercice = exercice;
	}

	public String getChoix1() {
		return choix1;
	}

	public void setChoix1(String choix1) {
		this.choix1 = choix1;
	}

	public String getChoix2() {
		return choix2;
	}

	public void setChoix2(String choix2) {
		this.choix2 = choix2;
	}

	public String getChoix3() {
		return choix3;
	}

	public void setChoix3(String choix3) {
		this.choix3 = choix3;
	}

	public String getChoix4() {
		return choix4;
	}

	public void setChoix4(String choix4) {
		this.choix4 = choix4;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResp() {
		return resp;
	}

	public void setResp(String resp) {
		this.resp = resp;
	}

	public String toJson() {
		return "sala";
	}

}
