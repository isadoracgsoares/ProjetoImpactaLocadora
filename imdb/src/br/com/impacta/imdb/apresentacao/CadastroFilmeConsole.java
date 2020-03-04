package br.com.impacta.imdb.apresentacao;

import java.util.Scanner;

import br.com.impacta.imdb.controladores.Controlador;

public class CadastroFilmeConsole {
	
	public static void main(String[] args) {
		
		System.out.println("***CADASTRO DE FILME***");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Titulo:");
		String titulo = scan.nextLine();

		System.out.println("Diretores:");
		String diretores = scan.nextLine();
		
		System.out.println("Gêneros:");
		
		String generos = scan.nextLine();
		
		System.out.println("Nota:");
		double nota = scan.nextDouble();

		System.out.println("Ano:");
		int ano = scan.nextInt();

		System.out.println("Duração:");
		int duracao = scan.nextInt();
		
		System.out.println("Num. de Votos:");
		int numVotos = scan.nextInt();
		
		System.out.println("Url:");
		String url = scan.next();
		
		try {
			Controlador.criarFilme(titulo,diretores,generos,nota,
									ano,duracao,numVotos,url);
			System.out.println("Filme criado com sucesso!");

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}finally {
			scan.close();
		}
	}
}
