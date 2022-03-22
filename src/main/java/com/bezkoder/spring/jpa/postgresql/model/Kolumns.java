package com.james.spring.jpa.postgresql.model;
import javax.persistence.*;

@Entity
@Table(name = "tabela_testowa")
public class Kolumns {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "kolumna1")
	private String kolumna1;

	@Column(name = "kolumna2")
	private String kolumna2;

	@Column(name = "kolumna3")
	private String kolumna3;
	@Column(name = "kolumna4")
	private long kolumna4;
//	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
//	private boolean published;

//	public Kolumns(boolean published) {
//		this.published = published;
//	}

	public Kolumns(String kolumna1, String kolumna2, String kolumna3, long kolumna4) {
		this.kolumna1 = kolumna1;
		this.kolumna2 = kolumna2;
		this.kolumna3 = kolumna3;
		this.kolumna4 = kolumna4;
//		this.published = published;
	}

	public Kolumns() {

	}

	public String getKolumna1() {
		return kolumna1;
	}

	public void setKolumna(String kolumna1) {
		this.kolumna1 = kolumna1;
	}

	public String getKolumna2() {
		return kolumna2;
	}

	public void setKolumna2(String kolumna2) {
		this.kolumna2 = kolumna2;
	}

	public String getKolumna3() {
		return kolumna3;
	}

	public void setKolumna3(String kolumna3) {
		this.kolumna3 = kolumna3;
	}

	public long getKolumna4() {
		return kolumna4;
	}

	public void setKolumna4(long kolumna4) {
		this.kolumna4 = kolumna4;
	}
//
//	public void setPublished(boolean isPublished) {
//		this.published = isPublished;
//	}
//
//	public boolean getPublished() {
//		return published;
//	}


}
