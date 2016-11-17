package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ItemVendaTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private static final int COL_ID = 0;
	private static final int COL_NOME = 1;
	private static final int COL_PRECO = 2;
	private static final int COL_QTDE = 3;
	private static final int COL_TOTAL = 4;

	private List<ItemVenda> valores;       

	//Esse ï¿½ um construtor, que recebe a nossa lista de clientes
	public ItemVendaTableModel(List<ItemVenda> valores) {
		this.valores = new ArrayList<ItemVenda>(valores);
	}

	public int getRowCount() {
		//Quantas linhas tem sua tabela? Uma para cada item da lista.
		return valores.size();
	}

	public int getColumnCount() {
		//Quantas colunas tem a tabela? Nesse exemplo, sï¿½ 2.
		return 5;
	}

	public String getColumnName(int column) {
		//Qual ï¿½ o nome das nossas colunas?
		if (column == COL_ID) return "ID";
		if (column == COL_NOME) return "Nome do Produto";
		if (column == COL_PRECO) return "Preço";
		if (column == COL_QTDE) return "Quantidade";
		if (column == COL_TOTAL) return "Preço Total(R$)";
		return ""; //Nunca deve ocorrer
	}

	public Object getValueAt(int row, int column) {
		//Precisamos retornar o valor da coluna column e da linha row.
		ItemVenda itemVenda = valores.get(row);
		if (column == COL_ID)
			return itemVenda.getProduto().getId();
		else 
			if (column == COL_NOME) 
					return itemVenda.getProduto().getNome();
			else 
				if (column == COL_PRECO) 
					return itemVenda.getProduto().getPrecoUnitario();
				else 
					if (column == COL_QTDE) 
						return itemVenda.getQtde();
					else 
						if (column == COL_TOTAL) 
							return itemVenda.getPrecoTotal();
		return ""; //Nunca deve ocorrer
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		ItemVenda itemVenda = valores.get(rowIndex);
		//Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parï¿½metro.
		//Note que vc poderia alterar 2 campos ao invï¿½s de um sï¿½.
		if (columnIndex == COL_ID)
			itemVenda.getProduto().setId(Integer.parseInt(aValue.toString()));
		else 
			if (columnIndex == COL_NOME) 
				itemVenda.getProduto().setNome(aValue.toString());
			else 
				if (columnIndex == COL_PRECO) 
					itemVenda.getProduto().setPrecoUnitario(Double.parseDouble(aValue.toString()));
				else 
					if (columnIndex == COL_QTDE) 
						itemVenda.setQtde(Integer.parseInt(aValue.toString()));
					else 
						if (columnIndex == COL_TOTAL) 
							itemVenda.setPrecoTotal(Double.parseDouble(aValue.toString()));
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
	public ItemVenda get(int row) {
		return valores.get(row);
	}
}

