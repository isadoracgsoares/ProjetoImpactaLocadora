package br.com.impacta.imdb.apresentacao;

import java.util.List;
import java.util.Scanner;

import br.com.impacta.imdb.controladores.Controlador;
import br.com.impacta.imdb.negocio.Filme;

public class ConsultarFilmeConsole {
	
	public static void main(String[] args) {
		
		System.out.println("*** CONSULTAR FILME ***");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Informe o titulo (ou parte dele):");
		String titulo = scan.nextLine();
		
		System.out.println("Informe o gênero:");
		String genero = scan.nextLine();
		
		System.out.println("Informe o ano inicial:");
		int anoInicio = scan.nextInt();
		
		System.out.println("Informe o ano final:");
		int anoFinal = scan.nextInt();
		
		List<Filme> filmes;
		try {
			filmes = Controlador.consultar(titulo,genero,
													anoInicio,anoFinal);
			//Se não encontrar nenhum filme
			if(filmes == null || filmes.size() == 0) {
				System.out.println("Nenhum filme foi encontrado!");
			}else {
				System.out.println("---Filmes Encontrados---");
				for(Filme filme : filmes) {
					System.out.println(filme.getTitulo());
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			scan.close();
		}
	}
}
