package fora;

public class Filme {
	
	private String titulo; //private atributos para manter e serem acessados pela propria classe
	private String genero;
	private double preçoAluguel;
	private static int numeroFilmesAlugados;
	
	//construtor
	public Filme() {
		numeroFilmesAlugados++;		
	}
	
	public Filme(String titutlo, String genero, double preçoAluguel) {
		this(); //chama o construtor sem parametros
		this.setTitutlo(titulo);
		this.setGenero(genero);
		this.setPreçoAluguel(preçoAluguel);
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
		
	public void setPreçoAluguel(double preçoAluguel) {
		if(preçoAluguel >= 0) {
			this.preçoAluguel = preçoAluguel;
		}
	}
	
	public void setTitutlo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setGenero(String genero){
		switch(genero.toUpperCase()) {
		case "DRAMA" : case "FICÇÃO" : case "COMEDIA" :
			this.genero = genero;
			break; 
		}		
	}
	
	public void mostrarDados() {
		//TODO auto-generated method stub
		
		System.out.println("------ Filme -------");
		System.out.printf("Titutlo: %s \n", this.getTitulo()); //esta na propria classe
		System.out.printf("Genero: %s \n", this.genero);
		System.out.printf("Preço do Aluguel: R$ %.2f \n", this.preçoAluguel);
		System.out.printf("*****************************\n");		
		
	}

	public String getTitulo() {
		return titulo;
	}	
}

