package br.com.impacta.imdb.apresentacao;

import java.util.Scanner;

import br.com.impacta.imdb.controladores.Controlador;

public class ImportarFilmesConsole {
	
	public static void main(String[] args) {
		System.out.println("***IMPORTA��O DE FILMES***");
		Scanner scan = new Scanner(System.in);

		//TODO usar o componente gr�fico JFileChooser
		System.out.println("Informe o arquivo:");
		String path = scan.nextLine();
		
		try {
			Controlador.importar(path);
			
			System.out.println("Importa��o realizada com sucesso!");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}finally {
			scan.close();
		}
		
	}
	

}
