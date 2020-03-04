package br.com.impacta.imdb.apresentacao.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.Year;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import br.com.impacta.imdb.controladores.Controlador;
import br.com.impacta.imdb.negocio.Filme;

public class BuscaFilmeFrame extends JFrame {

	private JTextField tfTitulo;
	private JComboBox<String> cbGenero;
	private JButton bConsultar;
	private JSpinner spinnerAnoInicial;
	private JSpinner spinnerAnoFinal;
	int anoAtual = Year.now().getValue();

	private ListaFilmesFrame framePrincipal;

	public BuscaFilmeFrame(ListaFilmesFrame framePrincipal) {
		this.framePrincipal = framePrincipal;
		setTitle("Buscar");
		setSize(250, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		inicializaComponentes();
	}

	private void inicializaComponentes() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(montaPanelBuscaFilme(), BorderLayout.CENTER);
		panel.add(montaPanelBotoesBusca(), BorderLayout.SOUTH);
		this.add(panel);

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

	private JPanel montaPanelBotoesBusca() {
		JPanel panel = new JPanel();

		bConsultar = new JButton("Buscar");
		bConsultar.setMnemonic(KeyEvent.VK_B);
		bConsultar.addActionListener(new ConsultarListener());
		panel.add(bConsultar);

		return panel;
	}

	private void resetForm() {
		tfTitulo.setText("");
		cbGenero.setSelectedIndex(-1);
		spinnerAnoInicial.setValue(1950);
		spinnerAnoFinal.setValue(anoAtual);
	}

	private JPanel montaPanelBuscaFilme() {

		JPanel painel = new JPanel();
		GridLayout layout = new GridLayout(8, 1);
		painel.setLayout(layout);

		// Titulo
		painel.add(new JLabel("T�tulo:"));
		tfTitulo = new JTextField();
		painel.add(tfTitulo);
		// Genero
		painel.add(new JLabel("G�nero:"));
		cbGenero = new JComboBox(ListaFilmesFrame.getGeneros());
		painel.add(cbGenero);
		// Ano inicial
		SpinnerModel anoInicioModel = new SpinnerNumberModel(1950, 0, anoAtual, 1);
		spinnerAnoInicial = new JSpinner(anoInicioModel);
		spinnerAnoInicial.setEditor(new JSpinner.NumberEditor(spinnerAnoInicial, "#"));
		painel.add(new JLabel("Ano Inicial:"));
		painel.add(spinnerAnoInicial);
		// Ano final
		SpinnerModel anoFimModel = new SpinnerNumberModel(anoAtual, 1900, anoAtual, 1);
		spinnerAnoFinal = new JSpinner(anoFimModel);
		spinnerAnoFinal.setEditor(new JSpinner.NumberEditor(spinnerAnoFinal, "#"));
		painel.add(new JLabel("Ano Final:"));
		painel.add(spinnerAnoFinal);
		return painel;
	}

	private class ConsultarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String titulo = tfTitulo.getText();
			String genero = (String) cbGenero.getSelectedItem();
			int anoInicial = Integer.parseInt(spinnerAnoInicial.getValue().toString());
			int anoFinal = Integer.parseInt(spinnerAnoFinal.getValue().toString());
			try {
				// Obter a lista de filmes de acordo com o criterio selecionado
				List<Filme> filmes = Controlador.consultar(titulo, genero, anoInicial, anoFinal);
				resetForm();
				setVisible(false);

				framePrincipal.refreshTable(filmes);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(BuscaFilmeFrame.this, ex.getMessage(), "Erro ao buscar Filme(s)",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}