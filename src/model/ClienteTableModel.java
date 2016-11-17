package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ClienteTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private static final int COL_ID = 0;
	private static final int COL_NOME = 1;
	private static final int COL_CPF = 2;

	private List<Cliente> valores;       

	//Esse ï¿½ um construtor, que recebe a nossa lista de clientes
	public ClienteTableModel(List<Cliente> valores) {
		this.valores = new ArrayList<Cliente>(valores);
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
		if (column == COL_NOME) return "Nome do Cliente";
		if (column == COL_CPF) return "CPF";
		return ""; //Nunca deve ocorrer
	}

	public Object getValueAt(int row, int column) {
		//Precisamos retornar o valor da coluna column e da linha row.
		Cliente cliente = valores.get(row);
		if (column == COL_ID)
			return cliente.getId();
		else 
			if (column == COL_NOME) 
					return cliente.getNome();
			else 
				if (column == COL_CPF) 
					return cliente.getCpf();
		return ""; //Nunca deve ocorrer
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Cliente cliente = valores.get(rowIndex);
		//Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parï¿½metro.
		//Note que vc poderia alterar 2 campos ao invï¿½s de um sï¿½.
		if (columnIndex == COL_ID)
			cliente.setId(Integer.parseInt(aValue.toString()));
		else 
			if (columnIndex == COL_NOME) 
				cliente.setNome(aValue.toString());
			else 
				if (columnIndex == COL_CPF) 
					cliente.setCpf(aValue.toString());
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
	public Cliente get(int row) {
		return valores.get(row);
	}
}

