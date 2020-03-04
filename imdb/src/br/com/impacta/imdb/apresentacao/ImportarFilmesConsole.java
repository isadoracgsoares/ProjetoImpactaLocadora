package br.com.impacta.imdb.apresentacao;

import java.util.Scanner;

import br.com.impacta.imdb.controladores.Controlador;

public class ImportarFilmesConsole {
	
	public static void main(String[] args) {
		System.out.println("***IMPORTAÇÂO DE FILMES***");
		Scanner scan = new Scanner(System.in);

		//TODO usar o componente gráfico JFileChooser
		System.out.println("Informe o arquivo:");
		String path = scan.nextLine();
		
		try {
			Controlador.importar(path);
			
			System.out.println("Importação realizada com sucesso!");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}finally {
			scan.close();
		}
		
	}
	

}
