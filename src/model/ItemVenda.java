package model;

public class ItemVenda {

	private int qtde;
	private Double precoItem;
	private Produto produto;
	private Double precoTotal;
	
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public Double getPrecoItem() {
		return precoItem;
	}
	public void setPrecoItem(Double precoItem) {
		this.precoItem = precoItem;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	
}
