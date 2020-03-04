
public class UsaMidia5 {
	
	public static void main(String[] args) {
		
		Midia m1 = new Filme("X", "Ficção", 4.1, "Bom");
		
		Midia m2 = new Filme();
		Midia m3 = new Musica();
		Midia m4 = new Jogo();
			
		m1.mostrarDados();
		System.out.println();
		m2.mostrarDados();
		System.out.println();
		m3.mostrarDados();
		System.out.println();
		m4.mostrarDados();
		
		//Atribção não possivel: Nem toda Midia é um Filme
		//Filme filme1 = new Midia();
		System.out.println("\n\n----casting de tipos(referencia)");
		
		Midia midia1 = new Filme("Matrix", "Ficção", 4, "Filme Bom");
		
		//Quero acessar o metodo especifico de filme setSinopse
		if(midia1 instanceof Filme) {
			
			Filme f = (Filme) midia1;
			String sinopse = f.getSinopse();
			System.out.println("Sinopse do filme: " + sinopse);
		}else {
			System.out.println("Objeto referenciado não é um filme.");
			
		}
	}
}