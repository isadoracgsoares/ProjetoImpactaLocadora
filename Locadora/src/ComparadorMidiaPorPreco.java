import java.util.Comparator;

public class ComparadorMidiaPorPreco implements Comparator<Midia>{

	@Override
	public int compare(Midia midia1, Midia midia2) {
	
	if(midia1.getPrecoAluguel() < midia2.getPrecoAluguel()){
		return -1;
	}
	
	if(midia1.getPrecoAluguel() > midia2.getPrecoAluguel()){
		return 1;
	}
	
	return 0;

	}
}
	
