package br.com.impacta.imdb.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import br.com.impacta.imdb.negocio.Filme;

public class Utilitario {
	
	//TODO apagar quando tiver banco de dados
	public static void main(String[] args) {
		
		List<Filme> filmes = getFilmes("filmes-imdb-ago-2016.csv");
		//filmes.forEach(System.out::println);
		
		//1. Listar os 30 melhores filmes 
		System.out.println("**** Os 30 Melhores Filmes****");
		filmes.stream()
			  .sorted(Comparator.comparing(Filme::getNota).reversed())
			  .limit(30)
			  .forEach(System.out::println);
		
		
		//2. Listar todos os filmes de Steven Spielberg
		System.out.println("\n\n**** Filmes do Spielberg ****");
		filmes.stream()
			  .filter( f -> f.getDiretores().contains("Steven Spielberg"))
			  .forEach(System.out::println);
		
		
		//3. Listar os 10 piores filmes
		System.out.println("\n\n**** Os 10 Piores Filmes****");
		filmes.stream()
			  .filter( f -> f.getNota() > 0)
			  .sorted(Comparator.comparing(Filme::getNota))
			  .limit(10)
			  .forEach(System.out::println);
		
		//4. Listar todos filmes da decada de 90
		System.out.println("\n\n**** Filmes 90's****");
		filmes.stream()
			  .filter( f -> (f.getAno() >=1990 && f.getAno()< 2000))
			  .forEach(System.out::println);
		
	}
	
	
	public static List<Filme> getFilmes(String path){
		
		List<Filme> filmes = new ArrayList<>();
		
		try ( Scanner scan = new Scanner(new FileInputStream(path)) )
		{
			
			scan.nextLine(); //ignorar primeira linha de cabeçalho
			while(scan.hasNextLine()) {
				String linha = scan.nextLine();
				Filme filme = extrairFilme(linha);
				filmes.add(filme);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return filmes;
	}

	private static Filme extrairFilme(String linha) throws Exception {
		
		Filme filme = null;		
		
		String[] atributos = linha.split("\\s*;\\s*");
		
		String titulo = atributos[0];
		String diretores = atributos[1];
		double nota = getDouble(atributos[2]);
		int duracao = getInt(atributos[3]);
		int ano = getInt(atributos[4]);
		String generos = atributos[5];
		int numVotos = getInt(atributos[6]);
		String url = atributos[8];
		//ignorando o indice 7
		
		filme = new Filme(titulo, diretores, generos, nota, ano, duracao, numVotos, url);
		
		return filme;
	}

	private static int getInt(String strInt) {
		try {
			return Integer.parseInt(strInt);
		}catch(Exception e) {
			//ignorado
		}
		return 0;
	}

	private static double getDouble(String strDouble) {
		try {
			return Double.parseDouble(strDouble);
		}catch(Exception e) {
			//ignorar
		}
		return 0;
	}
}
