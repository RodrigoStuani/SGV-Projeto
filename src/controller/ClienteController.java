package controller;

import java.util.List;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteController {

	public void inserir(Cliente cliente) throws Exception{
		if (cliente.getNome() == null || cliente.getNome().equals("") || cliente.getNome().length() < 3){
			throw new Exception("Nome invalido!");
		}
		if (cliente.getCpf() == null || cliente.getCpf().equals("") || cliente.getCpf().length() != 11){
			throw new Exception("Cpf invalido!!");
		}
		new ClienteDAO().inserir(cliente);
	}
	public void editar(Cliente cliente) throws Exception{
		if (cliente.getNome() == null || cliente.getNome().equals("") || cliente.getNome().length() < 3){
			throw new Exception("Nome invalido!");
		}
		if (cliente.getCpf() == null || cliente.getCpf().equals("") || cliente.getCpf().length() != 11){
			throw new Exception("Cpf invalido!!");
		}
		new ClienteDAO().editar(cliente);
	}
	public void excluir(int id) throws Exception{
		if (id < 0) {
			throw new Exception("Cliente Invalido");
		}
		new ClienteDAO().excluir(id);
	}
	// metodo de consultar no programa junto ao sql.
	public List<Cliente> listaClientes(){
		return new ClienteDAO().listaClientes();
	}

}
