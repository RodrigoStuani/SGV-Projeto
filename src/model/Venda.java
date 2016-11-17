package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venda {

	private int id;
	private LocalDate data;
	private Cliente cliente;
	private ArrayList<ItemVenda> listaItensVenda;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ArrayList<ItemVenda> getListaItensVenda() {
		return listaItensVenda;
	}
	public void setListaItensVenda(ArrayList<ItemVenda> listaItensVenda) {
		this.listaItensVenda = listaItensVenda;
	}
	
}
