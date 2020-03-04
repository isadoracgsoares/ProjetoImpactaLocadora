public abstract class Midia implements Comparable<Midia>{
		
	private String titulo;
	private String genero;
	private double precoAluguel;
	
	public Midia() {
	}
	
	public Midia(String titulo, String genero, double precoAluguel){
		this(titulo); //chama o construtor sem parametros
		this.setGenero(genero);
		this.setPrecoAluguel(precoAluguel);
	}
	
	public Midia(String titulo) {
		this(); //chama o construtor sem parametros
		this.setTitulo(titulo);
	}
	
	public void setPrecoAluguel(double precoAluguel) {
		if(precoAluguel >= 0) {
			this.precoAluguel = precoAluguel;
		}
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void mostrarDados() {
		System.out.printf("Titulo: %s \n", this.titulo);
		System.out.printf("Genero: %s \n", this.genero);
		System.out.printf("Preço do Aluguel: R$ %.2f \n",this.precoAluguel);
	}
	
	@Override
	public String toString() {
		return String.format("Titulo: %s "
						     + "\nGenero: %s "
							 + "\nPreço do Aluguel: R$ %.2f \n",
							 this.titulo, 
							 this.genero, 
							 this.precoAluguel);
	}	

	public String getTitulo() {
		return titulo;
	}

	public String getGenero() {
		return genero;
	}

	public double getPrecoAluguel() {
		return precoAluguel;
	}
	
	@Override
	public boolean equals(Object outro) {
		Midia aOutra = (Midia) outro;
		
		boolean resultado = this.getTitulo().equalsIgnoreCase(aOutra.getTitulo())&& 
							this.getGenero().equalsIgnoreCase(aOutra.getGenero());
		return resultado;
		
	}
	
	@Override
	public int hashCode() {
		return 1;
		
	}		

	//ordena Midias pelo titulo no exemploSet2
	@Override
	public int compareTo(Midia outra) {
		return this.getTitulo().compareTo(outra.getTitulo());
		
	}
	
//	ordena Midias por preço no exemploSet2
//	@Override
//		public int compareTo(Midia outra) {
//			if(this.getPrecoAluguel()<outra.getPrecoAluguel()) {
//				return -1;
//			}
//			if(this.getPrecoAluguel() > outra.getPrecoAluguel()) {
//				return 1;
//			}
	
//			return 0;
//		}
}