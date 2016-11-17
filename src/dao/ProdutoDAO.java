package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import Util.ConnectionUtil;
import model.Produto;

public class ProdutoDAO {

	private ArrayList<Produto> listaProdutos = new ArrayList<>();

	private Connection con = ConnectionUtil.getConnection();

	public void inserir(Produto produto){
		try{
			String query = "insert into produto (nomeProduto, preco) values (? , ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, produto.getNome());
			pstmt.setDouble(2, produto.getPrecoUnitario());
			pstmt.executeUpdate();
		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	public List<Produto> listaProdutos(){
		try {
			String query = "select * from produto";	
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Produto p = new Produto();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nomeProduto"));
				p.setPrecoUnitario(rs.getDouble("preco"));
				listaProdutos.add(p);
			}
			return listaProdutos;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public void editar(Produto produto){
		try {
			String query = "update produto set nomeProduto = ?, preco = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, produto.getNome());
			pstmt.setDouble(2, produto.getPrecoUnitario());
			pstmt.setInt(3, produto.getId());
			pstmt.executeUpdate();			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void excluir(int id){
		try{
			String query = "delete from produto where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
}
