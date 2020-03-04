public class Sorvete implements Negociavel{

	private String marca;
	private String sabor;
	
	public Sorvete(String marca, String sabor) {
		this.marca = marca;
		this.sabor = sabor;
	}
	
	@Override
	public double calculaPrecoVenda() {
		return 3.5;
	}
	
	@Override
	public String toString() {
		return String.format("Marca: %s \nSabor: %s \n", 
								this.marca,this.sabor);
	}
}
