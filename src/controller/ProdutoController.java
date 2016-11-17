package controller;

import java.util.List;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoController {

	public void inserir(Produto produto) throws Exception{
		if (produto.getNome() == null || produto.getNome().equals("") || produto.getNome().length() < 3){
			throw new Exception("Nome inv�lido");
		}
		if (produto.getPrecoUnitario() == null || produto.getPrecoUnitario().equals("") || produto.getPrecoUnitario() == 0.0){
			throw new Exception("Pre�o Unit�rio inv�lido!");
		}
		new ProdutoDAO().inserir(produto);
	}
	public void editar(Produto produto) throws Exception{
		if (produto.getNome() == null || produto.getNome().equals("") || produto.getNome().length() < 3){
			throw new Exception("Nome invalido!");
		}
		if (produto.getPrecoUnitario() == null || produto.getPrecoUnitario().equals("") || produto.getPrecoUnitario() == 0.0){
			throw new Exception("Pre�o Unit�rio inv�lido!!");
		}
		new ProdutoDAO().editar(produto);
	}
	public void excluir(int id) throws Exception{
		if (id < 0) {
			throw new Exception("Produto Invalido");
		}
		new ProdutoDAO().excluir(id);;
	}
	public List<Produto> listaProdutos(){
		return new ProdutoDAO().listaProdutos();
	}
}
