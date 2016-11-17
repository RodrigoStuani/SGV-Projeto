package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import model.Cliente;
import model.ItemVenda;
import model.ItemVendaTableModel;
import model.Produto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarVendaUI extends JInternalFrame {
	private JTextField jtfDataVenda;
	private JTextField jtfQuantidade;
	private JTable jtItensVenda;
	private ArrayList<ItemVenda> listaItemTemp = new ArrayList<ItemVenda>();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarVendaUI frame = new RegistrarVendaUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrarVendaUI() {
		setClosable(true);
		setTitle("Registrar Venda");
		setBounds(100, 100, 628, 426);
		
		JPanel jpPainelVenda = new JPanel();
		jpPainelVenda.setBorder(new TitledBorder(null, "Venda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnSalvar = new JButton("Salvar");
		
		JButton btnCancelar = new JButton("Cancelar");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jpPainelVenda, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar)))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpPainelVenda, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnCancelar))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		
		JLabel lblData = new JLabel("Data:");
		
		jtfDataVenda = new JTextField();
		jtfDataVenda.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente:");
		
		
		DefaultComboBoxModel<Cliente> modelCliente = new DefaultComboBoxModel<>();
		for (Cliente c : new ClienteDAO().listaClientes()) {
			modelCliente.addElement(c);
		}
		JComboBox jcbCliente = new JComboBox();
		jcbCliente.setModel(modelCliente);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		
		jtfQuantidade = new JTextField();
		jtfQuantidade.setColumns(10);
		
		JLabel lblProduto = new JLabel("Produto:");
		//usado o ComboBox ccm o Default
 		DefaultComboBoxModel<Produto> modelProduto = new DefaultComboBoxModel<>();
		for (Produto p : new ProdutoDAO().listaProdutos()) {
			modelProduto.addElement(p);
		}
		JComboBox jcbProduto = new JComboBox();
		jcbProduto.setModel(modelCliente);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ItemVenda item = new ItemVenda();
				item.setQtde(Integer.parseInt(jtfQuantidade.getText()));
				item.setProduto((Produto)jcbProduto.getSelectedItem());
				item.setPrecoTotal(item.getQtde() * item.getProduto().getPrecoUnitario());
				listaItemTemp.add(item);
				jtItensVenda.setModel( new ItemVendaTableModel(listaItemTemp));
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnRemover = new JButton("Remover");
		
		JLabel lblTotalVenda = new JLabel("Total Venda:  R$ ");
		
		JLabel jlTotalVenda = new JLabel("0,00");
		GroupLayout gl_jpPainelVenda = new GroupLayout(jpPainelVenda);
		gl_jpPainelVenda.setHorizontalGroup(
			gl_jpPainelVenda.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpPainelVenda.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpPainelVenda.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpPainelVenda.createSequentialGroup()
							.addComponent(lblData)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfDataVenda, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblCliente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jcbCliente, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jpPainelVenda.createSequentialGroup()
							.addComponent(lblQuantidade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblProduto)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jcbProduto, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnAdicionar))
						.addGroup(gl_jpPainelVenda.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemover)))
					.addContainerGap(117, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_jpPainelVenda.createSequentialGroup()
					.addContainerGap(354, Short.MAX_VALUE)
					.addComponent(lblTotalVenda)
					.addGap(27)
					.addComponent(jlTotalVenda)
					.addGap(230))
		);
		gl_jpPainelVenda.setVerticalGroup(
			gl_jpPainelVenda.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpPainelVenda.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_jpPainelVenda.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblData)
						.addComponent(jtfDataVenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCliente)
						.addComponent(jcbCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_jpPainelVenda.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantidade)
						.addComponent(jtfQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProduto)
						.addComponent(jcbProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdicionar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpPainelVenda.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRemover))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpPainelVenda.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalVenda)
						.addComponent(jlTotalVenda))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		
		jtItensVenda = new JTable();
		jtItensVenda.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Produto", "Pre\u00E7o Unit\u00E1rio(R$)", "Qtde", "Pre\u00E7o (R$)"
			}
		));
		jtItensVenda.getColumnModel().getColumn(0).setPreferredWidth(29);
		jtItensVenda.getColumnModel().getColumn(1).setPreferredWidth(200);
		jtItensVenda.getColumnModel().getColumn(2).setPreferredWidth(102);
		scrollPane.setViewportView(jtItensVenda);
		jpPainelVenda.setLayout(gl_jpPainelVenda);
		getContentPane().setLayout(groupLayout);

	}
}
