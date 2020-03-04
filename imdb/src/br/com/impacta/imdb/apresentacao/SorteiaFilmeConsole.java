package br.com.impacta.imdb.apresentacao;

import java.util.Scanner;

import br.com.impacta.imdb.controladores.Controlador;
import br.com.impacta.imdb.negocio.Filme;

public class SorteiaFilmeConsole {
	
	public static void main(String[] args) {
		System.out.println("***SORTEIO DE FILME***");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Gênero:");
		String genero = scan.nextLine();
		
		System.out.println("Diretor (ou parte do nome):");
		String diretor = scan.nextLine();
		
		System.out.println("Nota mínima:");
		double notaMin = scan.nextDouble();
		
		System.out.println("Número de votos mínimo:");
		int numVotosMinimo = scan.nextInt();
		
		Filme sorteado;
		
		try {
			sorteado = Controlador.sortear(genero,diretor,
													notaMin,numVotosMinimo);
			
			if(sorteado == null) {
				System.out.println("Seja menos exigente! Nada encontrado.");
			}else {
				System.out.printf("O filme que assistirá hoje é %s \n",
												sorteado.getTitulo());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}