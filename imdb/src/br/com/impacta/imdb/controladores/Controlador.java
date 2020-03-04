package br.com.impacta.imdb.controladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import br.com.impacta.imdb.negocio.Filme;
import br.com.impacta.imdb.persistencia.DAOFilme;
import br.com.impacta.imdb.util.Utilitario;

public class Controlador {
	
	//Evita criação desnecessária de instâncias desta classe
	private Controlador() {}

	public static void criarFilme(String titulo, String diretores, 
									String generos, double nota, 
									int ano, int duracao,
									int numVotos, String url) throws Exception {
		
		Filme filme = new Filme(titulo,diretores,generos,nota,ano,
								 duracao,numVotos,url);
		
		DAOFilme.criar(filme);
		
	}

	public static List<Filme> consultar(String titulo, String genero, 
										int anoInicio, int anoFinal) throws Exception {
		
		List<Filme> filmes = new ArrayList<>(); //array vazio
		
		if(anoInicio > anoFinal) {
			throw new Exception("Ano inicial deve ser menor ou igual ao ano final");
		}
		
		filmes = DAOFilme.filtrar(titulo,genero,anoInicio,anoFinal);
		
		return filmes;
	}
	
	public static void remover(Integer id) throws Exception {
		DAOFilme.remover(id);
	}

	public static Filme sortear(String genero, String diretor, 
								double notaMin, int numVotosMinimo) throws Exception {

		
		List<Filme> filmes = DAOFilme.filtrar(notaMin,numVotosMinimo, 
											genero, diretor);
		
		Collections.shuffle(filmes);//embaralha a lista de filmes
		Filme sorteado = (filmes.size() >0) ? filmes.get(0) : null;
		
		return sorteado; //retornando o primeiro filme da lista
	}

	public static void importar(String path) throws Exception {
		List<Filme> filmes = Utilitario.getFilmes(path);
		DAOFilme.criar(filmes.toArray(new Filme[filmes.size()]));
		
	}

	public static void atualizar(Filme filme) throws Exception {
		DAOFilme.atualizar(filme);
		
	}

	public static List<Filme> consultar() throws Exception {
		return DAOFilme.consultar();
	}

	public static Set<String> getListaDeGeneros() throws Exception {
		return Set.of("action","drama","comedy","adventure","horror","fiction",
				"documentary","thriller","fantasy","romance","history","sci-fi","crime",
				"mystery","animation","musical","family","biography","war","sport","western");
	}
}
