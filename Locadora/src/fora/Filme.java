package fora;

public class Filme {
	
	private String titulo; //private atributos para manter e serem acessados pela propria classe
	private String genero;
	private double pre�oAluguel;
	private static int numeroFilmesAlugados;
	
	//construtor
	public Filme() {
		numeroFilmesAlugados++;		
	}
	
	public Filme(String titutlo, String genero, double pre�oAluguel) {
		this(); //chama o construtor sem parametros
		this.setTitutlo(titulo);
		this.setGenero(genero);
		this.setPre�oAluguel(pre�oAluguel);
	}
	
	public Filme(String titulo) {
		this(); //chama o contrutor sem parametros
		this.setTitutlo(titulo);		
	}

	public static int getNumeroFilmesAlugados() {
		return numeroFilmesAlugados;
	}

	public static void setNumeroFilmesAlugados(int numeroFilmesAlugados) {
		Filme.numeroFilmesAlugados = numeroFilmesAlugados;
	}
		
	public void setPre�oAluguel(double pre�oAluguel) {
		if(pre�oAluguel >= 0) {
			this.pre�oAluguel = pre�oAluguel;
		}
	}
	
	public void setTitutlo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setGenero(String genero){
		switch(genero.toUpperCase()) {
		case "DRAMA" : case "FIC��O" : case "COMEDIA" :
			this.genero = genero;
			break; 
		}		
	}
	
	public void mostrarDados() {
		//TODO auto-generated method stub
		
		System.out.println("------ Filme -------");
		System.out.printf("Titutlo: %s \n", this.getTitulo()); //esta na propria classe
		System.out.printf("Genero: %s \n", this.genero);
		System.out.printf("Pre�o do Aluguel: R$ %.2f \n", this.pre�oAluguel);
		System.out.printf("*****************************\n");		
		
	}

	public String getTitulo() {
		return titulo;
	}	
}

