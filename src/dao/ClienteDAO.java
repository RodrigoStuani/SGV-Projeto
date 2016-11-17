package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Util.ConnectionUtil;
import model.Cliente;

public class ClienteDAO {

	private ArrayList<Cliente> listaClientes = new ArrayList<>();
	
	private Connection con = ConnectionUtil.getConnection();
	
	public void inserir(Cliente cliente){
		try{
		String query = "insert into Cliente (nome, cpf) values (?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1,cliente.getNome());
		pstmt.setString(2, cliente.getCpf());
		pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}	
	}
	public List<Cliente> listaClientes(){
		try{
		String query = "select * from Cliente";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			Cliente c = new Cliente();
			c.setId(rs.getInt("id"));
			c.setNome(rs.getString("nome"));
			c.setCpf(rs.getString("cpf"));
			listaClientes.add(c);
		}
		return listaClientes;
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	public void editar(Cliente cliente){
		try{
			String query = "update cliente set nome = ?, cpf = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, cliente.getNome());
			pstmt.setString(2, cliente.getCpf());
			pstmt.setInt(3, cliente.getId());
			pstmt.executeUpdate();
		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	public void excluir(int id){
		try {
			String query = "delete from cliente where id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
