public class UsaMidia {
	
	public static void main(String[] args) {
		
		Midia f1 = new Filme(); //chamada do construtor
		f1.mostrarDados();
		
		f1.setTitulo("Star Wars");
		f1.setGenero("Ficção");
		f1.setPrecoAluguel(11.9);
		f1.mostrarDados();
		Midia f2 = new Filme(); //chamada do construtor
		f2.setTitulo("Roma");
		f2.setGenero("Drama");
		f2.setPrecoAluguel(8.4);
		
		f2.mostrarDados();
		
			
		
	}

}
