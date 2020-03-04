package br.com.impacta.imdb.negocio;

import java.time.Year;

public class Filme implements Comparable<Filme>{
	
	private Integer id;
	private String titulo;
	private String diretores;
	private String generos;
	private double nota;
	private int duracao;
	private int numDeVotos;
	private int ano;
	private String url;
	
	public Filme(Integer id, String titulo, String diretores, String generos, 
			 double nota, int ano, int duracao, int numDeVotos,
			 String url) throws Exception {
		
		this(titulo, diretores, generos, nota, ano, duracao, numDeVotos, url);
		this.setId(id);
		
	}
	
	public Filme(String titulo, String diretores, String generos, 
				 double nota, int ano, int duracao, int numDeVotos,
				 String url) throws Exception {
		
		this.setTitulo(titulo);
		this.setDiretores(diretores);
		this.setGeneros(generos);
		this.setNota(nota);
		this.setAno(ano);
		this.setDuracao(duracao);
		this.setNumDeVotos(numDeVotos);
		this.setUrl(url);
	}
	
	public Filme() {}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDiretores() {
		return diretores;
	}
	public void setDiretores(String diretores) {
		this.diretores = diretores;
	}
	public String getGeneros() {
		return generos;
	}
	public void setGeneros(String generos) {
		this.generos = generos;
	}
	public double getNota() {
		return nota;
	}
	
	public void setNota(double nota) throws Exception {
		if(nota >= 0 && nota <= 10) {
			this.nota = nota;
		}else {
			throw new Exception("Nota deve estar entre 0 e 10");
		}
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) throws Exception {
		if(duracao >= 0) {
			this.duracao = duracao;
		}else {
			throw new Exception("Duração não pode ser negativa");
		}
	}
	public int getNumDeVotos() {
		return numDeVotos;
	}
	public void setNumDeVotos(int numDeVotos) throws Exception {
		if(numDeVotos >= 0) {
			this.numDeVotos = numDeVotos;
		}else {
			throw new Exception("Número de votos não pode ser negativo");
		}
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) throws Exception {
		if(ano >= 0 & ano <= Year.now().getValue()) {
			this.ano = ano;
		}else {
			throw new Exception("Ano deve estar entre 1885 e ano corrente");
		}
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (ano != other.ano)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public int compareTo(Filme outro) {
		return this.getTitulo().compareToIgnoreCase(outro.getTitulo());
	}
	
	@Override
	public String toString() {
		
		String format = "%-70s %-70s %5.2f %5d %5d %-70s %8d %-40s";
		
		return String.format(format, this.getTitulo(),
									 this.getDiretores(),
									 this.getNota(),
									 this.getDuracao(),
									 this.getAno(),
									 this.getGeneros(),
									 this.getNumDeVotos(),
									 this.getUrl());
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		
	}	
}