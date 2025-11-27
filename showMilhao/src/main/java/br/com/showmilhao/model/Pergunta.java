package br.com.showmilhao.model;

public class Pergunta {
	private Long id;
	private String nivel;
	private String enumciado;
	private String alter1;
	private String alter2;
	private String alter3;
	private String resp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getAlter1() {
		return alter1;
	}
	public void setAlter1(String alter1) {
		this.alter1 = alter1;
	}
	public String getAlter2() {
		return alter2;
	}
	public void setAlter2(String alter2) {
		this.alter2 = alter2;
	}
	public String getAlter3() {
		return alter3;
	}
	public void setAlter3(String alter3) {
		this.alter3 = alter3;
	}
	public String getResp() {
		return resp;
	}
	public void setResp(String resp) {
		this.resp = resp;
	}
	public String getEnumciado() {
		return enumciado;
	}
	public void setEnumciado(String enumciado) {
		this.enumciado = enumciado;
	}
	public Pergunta(Long id, String nivel, String alter1, String alter2, String alter3, String resp) {
		super();
		this.id = id;
		this.nivel = nivel;
		this.alter1 = alter1;
		this.alter2 = alter2;
		this.alter3 = alter3;
		this.resp = resp;
	}
	public Pergunta() {
		this.alter1 = "";
		this.alter2 = "";
		this.alter3 = "";
		this.nivel = "";
		this.resp = "";
		
	}
	@Override
	public String toString() {
		return "Pergunta [id=" + id + ", nivel=" + nivel + ", enumciado=" + enumciado + ", alter1=" + alter1
				+ ", alter2=" + alter2 + ", alter3=" + alter3 + ", resp=" + resp + "]";
	}
	
	
	

}
