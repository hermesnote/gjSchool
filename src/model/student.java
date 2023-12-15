package model;

public class student {
	// fields
	private Integer id;
	private String name;
	private Integer chi;
	private Integer eng;
	
	
	// constructor	
	public student() {
		super();
	}
	
	public student(String name, Integer chi, Integer eng) {
		super();
		this.id = id;
		this.name = name;
		this.chi = chi;
		this.eng = eng;
	}

	
	// methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getChi() {
		return chi;
	}

	public void setChi(Integer chi) {
		this.chi = chi;
	}

	public Integer getEng() {
		return eng;
	}

	public void setEng(Integer eng) {
		this.eng = eng;
	}
	
}
