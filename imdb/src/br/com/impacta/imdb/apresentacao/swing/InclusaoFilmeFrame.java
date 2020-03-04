package br.com.impacta.imdb.apresentacao.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Year;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import br.com.impacta.imdb.controladores.Controlador;
import br.com.impacta.imdb.negocio.Filme;

/**
 * Tela para incluir o registro da <code>Filme</code>.
 * 
 * @author YaW Tecnologia
 */
public class InclusaoFilmeFrame extends JFrame {

	private JFormattedTextField tfId;
	private JTextField tfTitulo;
	private JTextField tfDiretores;
	private JFormattedTextField tfNota;
	private JFormattedTextField tfDuracao;
	private JFormattedTextField tfAno;
	private JTextField tfGeneros;
	private JFormattedTextField tfNumVotos;
	private JTextField tfURL;

	private JButton bSalvar;
	private JButton bCancelar;
	protected JButton bExcluir;

	private ListaFilmesFrame framePrincipal;

	public InclusaoFilmeFrame(ListaFilmesFrame framePrincipal) {
		this.framePrincipal = framePrincipal;
		setTitle("Incluir Filme");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		inicializaComponentes();
		resetForm();
	}

	private void inicializaComponentes() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(montaPanelEditarFilme(), BorderLayout.CENTER);
		panel.add(montaPanelBotoesEditar(), BorderLayout.SOUTH);
		add(panel);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
	}

	private JPanel montaPanelBotoesEditar() {
		JPanel panel = new JPanel();

		bSalvar = new JButton("Salvar");
		bSalvar.setMnemonic(KeyEvent.VK_S);
		bSalvar.addActionListener(new SalvarFilmeListener());
		panel.add(bSalvar);

		bCancelar = new JButton("Cancelar");
		bCancelar.setMnemonic(KeyEvent.VK_C);
		bCancelar.addActionListener(new CancelarListener());
		panel.add(bCancelar);

		bExcluir = new JButton();
		bExcluir.setText("Excluir");
		bExcluir.setMnemonic(KeyEvent.VK_E);
		bExcluir.addActionListener(new ExcluirFilmeListener());
		bExcluir.setVisible(false);
		panel.add(bExcluir);

		return panel;
	}

	private JPanel montaPanelEditarFilme() {
		JPanel painelEditarFilme = new JPanel();
		painelEditarFilme.setLayout(new GridLayout(9, 2));

		NumberFormat intFormat = NumberFormat.getIntegerInstance();
		NumberFormat notaFormat = new DecimalFormat();

		tfTitulo = new JTextField();
		tfDiretores = new JTextField();
		tfNota = new JFormattedTextField(notaFormat);
		tfDuracao = new JFormattedTextField(intFormat);
		tfAno = new JFormattedTextField(intFormat);
		tfGeneros = new JTextField();
		tfNumVotos = new JFormattedTextField(intFormat);
		tfURL = new JTextField();
		tfId = new JFormattedTextField(intFormat);
		tfId.setEnabled(false);

		painelEditarFilme.add(new JLabel("Id:"));
		painelEditarFilme.add(tfId);
		painelEditarFilme.add(new JLabel("T�tulo:"));
		painelEditarFilme.add(tfTitulo);
		painelEditarFilme.add(new JLabel("Diretores:"));
		painelEditarFilme.add(tfDiretores);
		painelEditarFilme.add(new JLabel("Nota:"));
		painelEditarFilme.add(tfNota);
		painelEditarFilme.add(new JLabel("Dura��o:"));
		painelEditarFilme.add(tfDuracao);
		painelEditarFilme.add(new JLabel("Ano:"));
		painelEditarFilme.add(tfAno);
		painelEditarFilme.add(new JLabel("G�neros:"));
		painelEditarFilme.add(tfGeneros);
		painelEditarFilme.add(new JLabel("Votos:"));
		painelEditarFilme.add(tfNumVotos);
		painelEditarFilme.add(new JLabel("URL:"));
		painelEditarFilme.add(tfURL);

		return painelEditarFilme;
	}

	private void resetForm() {
		tfId.setValue(null);
		tfTitulo.setText("");
		tfDiretores.setText("");
		tfNota.setValue(null);
		tfDuracao.setValue(null);
		tfAno.setValue(null);
		tfGeneros.setText("");
		tfNumVotos.setText(null);
		tfURL.setText("");

	}

	private void populaTextFields(Filme f) {
		tfId.setValue(f.getId()); //TODO id no filme
		tfTitulo.setText(f.getTitulo());
		tfDiretores.setText(f.getDiretores());
		tfDuracao.setValue(f.getDuracao());
		tfNota.setValue(f.getNota());
		tfDuracao.setValue(f.getDuracao());
		tfAno.setValue(f.getAno());
		tfGeneros.setText(f.getGeneros());
		tfNumVotos.setValue(f.getNumDeVotos());
		tfURL.setText(f.getUrl());

	}

	protected Integer getIdFilme() {
		Integer id = null;
		if (tfId.getValue() != null) {
			id = ((Long) tfId.getValue()).intValue();
		}
		return id;
	}

	private String validador() {
		StringBuilder sb = new StringBuilder();
		sb.append(tfTitulo.getText() == null || "".equals(tfTitulo.getText().trim()) ? "Titulo, " : "");
		sb.append(tfNota.getText() == null || "".equals(tfNota.getText().trim()) ? "Nota, " : "");
		sb.append(tfDuracao.getText() == null || "".equals(tfDuracao.getText().trim()) ? "Duracao, " : "");

		if (!sb.toString().isEmpty()) {
			sb.delete(sb.toString().length() - 2, sb.toString().length());
		}
		return sb.toString();
	}

	protected Filme loadFilmeFromPanel() throws Exception {
		String msg = validador();
		if (!msg.isEmpty()) {
			throw new RuntimeException("Informe o(s) campo(s): " + msg);
		}

		Integer id = null;
		if (tfId.getValue() != null) {
			id = ((Long) tfId.getValue()).intValue();
		}

		String titulo = tfTitulo.getText();
		String diretores = tfDiretores.getText();
		String generos = tfGeneros.getText();
		int votos = (tfNumVotos.getValue() != null) ? ((Long) tfNumVotos.getValue()).intValue() : 0;
		String url = tfURL.getText();

		int duracao = 0;
		try {
			if (tfDuracao.getValue() != null) {
				duracao = ((Long) (tfDuracao.getValue())).intValue();
			}
		} catch (NumberFormatException nex) {
			throw new RuntimeException("Erro durante a convers�o do campo duracao (Integer).\nConteudo inv�lido!");
		}
		if (duracao < 0) {
			throw new RuntimeException("O valor m�nimo da duracao deve ser 1!");
		}
		int ano = 0;
		try {
			if (tfAno.getValue() != null) {
				ano = ((Long) tfAno.getValue()).intValue();
			}
		} catch (NumberFormatException nex) {
			throw new RuntimeException("Erro durante a convers�o do campo ano (Integer).\nConteudo inv�lido!");
		}
		if (ano < 1800 || ano > Year.now().getValue()) {
			throw new RuntimeException("O ano deve estar entre 1800 e o ano corrente!");
		}
		double nota = 0;
		try {
			if (tfNota.getValue() != null) {
				nota = (tfNota.getValue() instanceof Double) ? (Double) tfNota.getValue()
						: ((Long) tfNota.getValue()).floatValue();
			}
		} catch (NumberFormatException nex) {
			throw new RuntimeException("Erro durante a convers�o do campo nota (Double).\nConteudo inv�lido!");
		}
		if (nota < 0 || nota > 10) {
			throw new RuntimeException("O valor da nota inv�lido!");
		}

		if (id != null) {
			return new Filme(id, titulo, diretores, generos, nota, ano, duracao, votos, url); //TODO criar construtor
		} else {
			return new Filme(titulo, diretores, generos, nota, ano, duracao, votos, url);
		}
	}

	public void loadPanelFromFilme(Filme f) {
		if (f != null) {
			tfId.setValue(Long.valueOf(f.getId()));//TODO colocar id no filme
			tfTitulo.setText(f.getTitulo());
			tfDiretores.setText(f.getDiretores());
			tfGeneros.setText(f.getGeneros());
			tfNumVotos.setValue(Long.valueOf(f.getNumDeVotos()));
			tfURL.setText(f.getUrl());
			tfDuracao.setValue(Long.valueOf(f.getDuracao()));
			tfAno.setValue(Long.valueOf(f.getAno()));
			tfNota.setValue(f.getNota());
		}

	}

	public void setFilme(Filme m) {
		resetForm();
		if (m != null) {
			populaTextFields(m);
		}
	}

	private class CancelarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			resetForm();
		}
	}

	private class SalvarFilmeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				
				String titulo = tfTitulo.getText();
				String diretores = tfDiretores.getText();
				String generos = tfGeneros.getText();
				String url = tfURL.getText();
				
				double nota = (tfNota.getValue() instanceof Double) ?
								((Double) tfNota.getValue()).doubleValue() :
								((Long) tfNota.getValue()).longValue();
								
				int ano = ((Long) tfAno.getValue()).intValue();
				int duracao = ((Long) tfDuracao.getValue()).intValue();
				int numVotos = ((Long) tfNumVotos.getValue()).intValue();

				if (tfId.getText().isEmpty()) {
					Controlador.criarFilme(titulo, diretores, generos, nota, ano, duracao, numVotos, url);
				} else {
					int id = ((Long) tfId.getValue()).intValue();
					Filme filme = new Filme(id, titulo, diretores, generos, nota, ano, duracao, numVotos, url);
					Controlador.atualizar(filme); 
				}

				setVisible(false);
				resetForm();
				SwingUtilities.invokeLater(framePrincipal.newAtualizaFilmesAction());

			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(InclusaoFilmeFrame.this, ex.getMessage(), "Erro ao incluir Filme",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class ExcluirFilmeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Integer id = getIdFilme();
			if (id != null) {
				try {
					Controlador.remover(id); 
					setVisible(false);
					resetForm();
					SwingUtilities.invokeLater(framePrincipal.newAtualizaFilmesAction());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(InclusaoFilmeFrame.this, ex.getMessage(), "Erro ao excluir Filme",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

}
