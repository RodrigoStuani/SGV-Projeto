package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProdutoTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private static final int COL_ID = 0;
	private static final int COL_NOME = 1;
	private static final int COL_PRECO = 2;

	private List<Produto> valores;       

	//Esse ï¿½ um construtor, que recebe a nossa lista de clientes
	public ProdutoTableModel(List<Produto> valores) {
		this.valores = new ArrayList<Produto>(valores);
	}

	public int getRowCount() {
		//Quantas linhas tem sua tabela? Uma para cada item da lista.
		return valores.size();
	}

	public int getColumnCount() {
		//Quantas colunas tem a tabela? Nesse exemplo, sï¿½ 2.
		return 3;
	}

	public String getColumnName(int column) {
		//Qual ï¿½ o nome das nossas colunas?
		if (column == COL_ID) return "ID";
		if (column == COL_NOME) return "Nome do Produto";
		if (column == COL_PRECO) return "Preço";
		return ""; //Nunca deve ocorrer
	}

	public Object getValueAt(int row, int column) {
		//Precisamos retornar o valor da coluna column e da linha row.
		Produto produto = valores.get(row);
		if (column == COL_ID)
			return produto.getId();
		else 
			if (column == COL_NOME) 
					return produto.getNome();
			else 
				if (column == COL_PRECO) 
					return produto.getPrecoUnitario();
		return ""; //Nunca deve ocorrer
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Produto produto = valores.get(rowIndex);
		//Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parï¿½metro.
		//Note que vc poderia alterar 2 campos ao invï¿½s de um sï¿½.
		if (columnIndex == COL_ID)
			produto.setId(Integer.parseInt(aValue.toString()));
		else 
			if (columnIndex == COL_NOME) 
				produto.setNome(aValue.toString());
			else 
				if (columnIndex == COL_PRECO) 
					produto.setPrecoUnitario(Double.parseDouble(aValue.toString()));
	}

	public Class<?> getColumnClass(int columnIndex) {
		//Qual a classe das nossas colunas? Como estamos exibindo texto, ï¿½ string.
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		//Indicamos se a cï¿½lula da rowIndex e da columnIndex ï¿½ editï¿½vel. Nossa tabela toda ï¿½.
		return true;
	}
	//Já que esse tableModel é de clientes, vamos fazer um get que retorne um objeto cliente inteiro.
	//Isso elimina a necessidade de chamar o getValueAt() nas telas. 
	public Produto get(int row) {
		return valores.get(row);
	}
}

