package br.com.showmilhao.model;

public class Jogador {
	private Long id;
	private String nome;
	private Integer pontuacao;

	private Integer linha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Integer getLinha() {
		return linha;
	}

	public void setLinha(Integer linha) {
		this.linha = linha;
	}

	public Jogador() {
		this.nome = "";
		this.linha = 0;
		this.pontuacao = 0;
	}

	public Jogador(Long id, String nome, Integer pontuacao,Integer linha) {
		super();
		this.id = id;
		this.nome = nome;
		this.pontuacao = pontuacao;
		this.linha = linha;
	}

}
