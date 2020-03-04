package br.com.impacta.imdb.apresentacao.swing;

import br.com.impacta.imdb.negocio.Filme;

public class EdicaoFilmeFrame extends InclusaoFilmeFrame {

	private Filme filme;

	public EdicaoFilmeFrame(ListaFilmesFrame framePrincipal) {
		super(framePrincipal);
		setTitle("Editar Filme");
		bExcluir.setVisible(true);
	}

	@Override
	protected Filme loadFilmeFromPanel() throws Exception {
		this.filme = super.loadFilmeFromPanel();
		filme.setId(getIdFilme()); //TODO incluir o ID na classe Filme
		return filme;
		
	}
}