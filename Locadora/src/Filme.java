public class Filme extends Midia implements Negociavel {
	
	private String sinopse;
	
	public Filme() {}

	public Filme(String titulo, String genero, 
							double precoAluguel, String sinopse) {
		
		super(titulo,genero,precoAluguel);
		this.setSinopse(sinopse);
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		//Abaixo não acessa elementos privados da classe pai
		//System.out.println("Meu titulo é: "+ this.titulo);
		this.sinopse = sinopse;
	}
	
	@Override
	public void mostrarDados() {
		super.mostrarDados();
		System.out.printf("Sinopse: %s \n", this.sinopse);
	}
	
	@Override
	public String toString() {
		return super.toString() + 
				 String.format("Sinopse: %s \n", this.sinopse);
	}

	public double calculaPrecoVenda() {
		return this.getPrecoAluguel() * 2.5;
	}
	
}	
	