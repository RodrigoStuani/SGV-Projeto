package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ProdutoController;
import dao.ProdutoDAO;
import model.Produto;
import model.ProdutoTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaProdutoUI extends JInternalFrame {
	private JTextField jtfPesquisaProduto;
	private JTable jtListaProdutos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaProdutoUI frame = new ConsultaProdutoUI();
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
	public ConsultaProdutoUI() {
		setClosable(true);
		setTitle("Consulta Produtos");
		setBounds(100, 100, 456, 353);
		
		JLabel lblPesquisa = new JLabel("Pesquisa:");
		
		jtfPesquisaProduto = new JTextField();
		jtfPesquisaProduto.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		
		JPanel jpListaProdutos = new JPanel();
		jpListaProdutos.setBorder(new TitledBorder(null, "Lista Produtos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroProdutoUI cadProduto = new CadastroProdutoUI(null);
				cadProduto.requestFocus();
				cadProduto.setFocusable(true);
				PrincipalUI.obterInstancia().getContentPane().add(cadProduto);
				cadProduto.setVisible(true);
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = jtListaProdutos.getSelectedRow();
				Produto produto = new ProdutoController().listaProdutos().get(linha);
				CadastroProdutoUI cadProduto = new CadastroProdutoUI(produto);
				cadProduto.requestFocus();
				cadProduto.setFocusable(true);
				PrincipalUI.obterInstancia().getContentPane().add(cadProduto);
				cadProduto.setVisible(true);
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				int linha = jtListaProdutos.getSelectedRow();
				Produto produto = new ProdutoController().listaProdutos().get(linha);
				new ProdutoController().excluir(produto.getId());
				
				JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
				jtListaProdutos.setModel(new ProdutoTableModel(new ProdutoDAO().listaProdutos()));
				
				}catch (Exception e){
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(lblPesquisa)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfPesquisaProduto, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jpListaProdutos, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnInserir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnFechar)))
					.addContainerGap(202, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPesquisa)
						.addComponent(jtfPesquisaProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(27)
					.addComponent(jpListaProdutos, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnEditar)
						.addComponent(btnExcluir)
						.addComponent(btnFechar))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		
		JScrollPane jspListaProdutos = new JScrollPane();
		GroupLayout gl_jpListaProdutos = new GroupLayout(jpListaProdutos);
		gl_jpListaProdutos.setHorizontalGroup(
			gl_jpListaProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpListaProdutos.createSequentialGroup()
					.addContainerGap()
					.addComponent(jspListaProdutos, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_jpListaProdutos.setVerticalGroup(
			gl_jpListaProdutos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpListaProdutos.createSequentialGroup()
					.addContainerGap()
					.addComponent(jspListaProdutos, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		jtListaProdutos = new JTable();
		jtListaProdutos.setModel( new ProdutoTableModel(new ProdutoDAO().listaProdutos()));
		
		jspListaProdutos.setViewportView(jtListaProdutos);
		jpListaProdutos.setLayout(gl_jpListaProdutos);
		getContentPane().setLayout(groupLayout);

	}

}
