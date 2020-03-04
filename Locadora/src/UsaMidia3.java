
public class UsaMidia3 {
	
	public static void main(String[] args) {

		Midia f1 = new Filme();
		System.out.println("---USANDO CONSTRUTOR PADRÂO---");
		f1.mostrarDados();
		
		System.out.println("\n---USANDO CONSTRUTOR (titulo,genero,preco)---");
		Midia f2 = new Filme("Matrix", "Ficção", 5.6, "bom");
		f2.mostrarDados();

		System.out.println("\n---USANDO CONSTRUTOR (titulo)---");
		Midia f3 = new Filme();
		f3.mostrarDados();
		
	}

}
