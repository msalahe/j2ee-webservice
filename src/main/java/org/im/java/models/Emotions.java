package org.im.java.models;

public class Emotions {
    private int seconds;
    private String neutre;
    private String content;
    private String enerve;
    private String degout;
    private String surpris;

    public Emotions() {
		// TODO Auto-generated constructor stub
	}

    
	public Emotions(int seconds, String neutre, String content, String enerve, String degout, String surpris) {
		super();
		this.seconds = seconds;
		this.neutre = neutre;
		this.content = content;
		this.enerve = enerve;
		this.degout = degout;
		this.surpris = surpris;
	}


	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public String getNeutre() {
		return neutre;
	}

	public void setNeutre(String neutre) {
		this.neutre = neutre;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEnerve() {
		return enerve;
	}

	public void setEnerve(String enerve) {
		this.enerve = enerve;
	}

	public String getDegout() {
		return degout;
	}

	public void setDegout(String degout) {
		this.degout = degout;
	}

	public String getSurpris() {
		return surpris;
	}

	public void setSurpris(String surpris) {
		this.surpris = surpris;
	}
    
    
	

}
