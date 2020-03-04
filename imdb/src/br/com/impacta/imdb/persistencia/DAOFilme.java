package br.com.impacta.imdb.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.impacta.imdb.negocio.Filme;

public class DAOFilme {

	//Evitar instancias desnecessárias (classe só com metodos estáticos)
	private DAOFilme() {}
	
	public static void criar(Filme ... filmes) throws Exception {
		Connection conexao = getConnection();
		String sql = "insert into tb_filmes (titulo, diretores, nota, duracao, ano, generos, num_votos, url) "
				+" values (?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps = conexao.prepareStatement(sql);
		
		for(Filme filme : filmes) {
			
			ps.setString(1, filme.getTitulo());
			ps.setString(2, filme.getDiretores());
			ps.setDouble(3, filme.getNota());
			ps.setInt(4, filme.getDuracao());
			ps.setInt(5, filme.getAno());
			ps.setString(6, filme.getGeneros());
			ps.setInt(7, filme.getNumDeVotos());
			ps.setString(8, filme.getUrl());
			
			ps.execute();
		}
		
		closeConnection(conexao);
		
	}
	
		public static List<Filme> consultar() throws Exception{
			
			String sql = "select * from tb_filmes";
			Connection conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			List<Filme> filmes = extrairFromResultSet(result);
			closeConnection(conexao);			
		
			return filmes;
	}

	
	private static void delay(int segundos) {
		try {
			Thread.sleep(segundos*1000);
		}catch(Exception e) {
		}
	}

	public static List<Filme> filtrar(String titulo, String genero, 
									int anoInicio, int anoFinal) throws Exception {

		String sql = "select * from tb_filmes where titulo like ? " +
				" AND generos like ? AND ano >= ? AND ano <= ? ";
		
		Connection conexao = getConnection();
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, (titulo == null) ? "%" : "%"+titulo.trim()+"%");
		ps.setString(2, (genero == null) ? "%" : "%"+genero.trim()+"%");
		ps.setInt(3, anoInicio);
		ps.setInt(4, anoFinal);
		
		ResultSet result = ps.executeQuery();

		List<Filme> filmes = extrairFromResultSet(result);
		closeConnection(conexao);
				
		return filmes;
		
	}

	public static void remover(Integer id) throws Exception {
		
		String sql = "delete from tb_filmes where id = ?";
		Connection conexao = getConnection();
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		
		closeConnection(conexao);
		
	}

	public static List<Filme> filtrar(double notaMin, int numVotosMinimo, 
									String genero, String diretor) throws Exception {
		
		List<Filme> filmes = new ArrayList<>();
		String sql = "select * from tb_filmes where nota >= ? "
				+ " AND num_votos >= ? AND generos like ? AND diretores like ?";
		
		Connection conexao = getConnection();
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setDouble(1, notaMin);
		ps.setInt(2, numVotosMinimo);
		ps.setString(3, (genero == null) ? "%" : "%"+genero.trim()+"%");
		ps.setString(4, (diretor == null) ? "%" : "%"+diretor.trim()+"%");
		
		ResultSet result = ps.executeQuery();
		
		filmes = extrairFromResultSet(result);
		
		return filmes;

	}	
	
	public static void atualizar(Filme filme) throws Exception{
		String sql = "update tb_filmes set titulo = ?, diretores = ?, nota = ?, "
				+ "duracao = ?, ano = ?, genero = ?, num_votos = ?, url = ?, where id = ? ";
		
		Connection conexao = getConnection();
		PreparedStatement ps = conexao.prepareStatement(sql);
		
		ps.setString(1, filme.getTitulo());
		ps.setString(2, filme.getDiretores());
		ps.setDouble(3, filme.getNota());
		ps.setInt(4, filme.getDuracao());
		ps.setInt(5, filme.getAno());
		ps.setString(6, filme.getGeneros());
		ps.setInt(7, filme.getNumDeVotos());
		ps.setString(8, filme.getUrl());
		ps.setInt(9, filme.getId());
		
		ps.executeUpdate();
		
		closeConnection(conexao);
		
		
	}
	
	private static List<Filme> extrairFromResultSet(ResultSet result) throws Exception {
		List<Filme> filmes = new ArrayList<>();
		
		while(result.next()) {
			Integer id = result.getInt("id");
			String titulo = result.getString("titulo");
			String diretores = result.getString("diretores");
			double nota = result.getDouble("nota");
			int duracao = result.getInt("duracao");
			int ano = result.getInt("ano");
			String generos = result.getNString("generos");
			int numDeVotos = result.getInt("num_votos");
			String url = result.getString("url");
			
			Filme filme = new Filme(id, titulo, diretores, generos, nota, ano, duracao, numDeVotos, url);
			
			filmes.add(filme);
			
		}
		return filmes;
	}

	private static Connection getConnection() throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/imdb?user=root&password=Imp@ct@";
		
		Connection conexao = null;
		
		try {
			conexao = DriverManager.getConnection(url);
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Falha ao conectar: " + e.getMessage());
		}
		
		return conexao;
	}
	
	private static void closeConnection(Connection conexao) {
		try {
			if(conexao != null & !conexao.isClosed()) {
				conexao.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		Connection con = getConnection();
		System.out.println("Sucesso!");
		closeConnection(con);
		System.out.println("Fechou!");
		
	}

	

	
}