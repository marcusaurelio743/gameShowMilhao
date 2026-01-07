package br.com.showmilhao.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JogadorTable {

	private IntegerProperty linhaTabela;
	private StringProperty nomeTabela;
	private IntegerProperty pontuacaoTable;
	private Jogador jogador;

	public JogadorTable(Jogador jogador) {
		this.jogador = jogador;
		linhaTabela = new SimpleIntegerProperty(jogador.getLinha());
		nomeTabela = new SimpleStringProperty(jogador.getNome());
		pontuacaoTable = new SimpleIntegerProperty(jogador.getPontuacao());

	}

	public Integer getLinhaTabela() {
		return linhaTabela.get();
	}

	public String getNomeTabela() {
		return nomeTabela.get();
	}

	public Integer getPontuacaoTable() {
		return pontuacaoTable.get();
	}

	public Jogador getJogador() {
		return jogador;
	}

}
