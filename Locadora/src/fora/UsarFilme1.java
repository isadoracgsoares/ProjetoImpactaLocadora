package fora;
public class UsarFilme1 {
	
	public static void main(String[] args) {
		
		Filme f1 = new Filme(); //chamada do construtor
		f1.mostrarDados();
		System.out.println("Alugados: " + Filme.getNumeroFilmesAlugados());
		
		f1.setTitutlo("Panico");
		f1.setGenero("A��o");
		f1.setPre�oAluguel(1250);
		
		f1.mostrarDados();
		
		Filme f2 = new Filme(); //chamada do construtor
		f2.setTitutlo("Esqueceram de Mim");
		f2.setGenero("Com�dia");
		f2.setPre�oAluguel(3005);
		
		f2.mostrarDados();
		System.out.println("Alugados: " + Filme.getNumeroFilmesAlugados());
		
		Filme f3 = new Filme(); //chamada do construtor
		f3.setTitutlo("Matrix");
		f3.setGenero("Drama");
		f3.setPre�oAluguel(4000);
		
		f3.mostrarDados();
		System.out.println("Alugados: " + Filme.getNumeroFilmesAlugados());
		
		//chamando o construtor 5 vezes mais
		new Filme();
		new Filme();
		new Filme();
		new Filme();
		new Filme();
		
		System.out.println("---Contagem de Filmes alugados---");
		System.out.println("Alugados: " + Filme.getNumeroFilmesAlugados());
		
	}
}