package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import controller.ClienteController;
import dao.ClienteDAO;
import model.Cliente;
import model.ClienteTableModel;

public class ConsultaClienteUI extends JInternalFrame {
	private JTextField jtfPesquisaCliente;
	private JTable jtListaClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaClienteUI frame = new ConsultaClienteUI();
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
	public ConsultaClienteUI() {
		setClosable(true);
		setTitle("Consulta Clientes");
		setBounds(100, 100, 482, 361);
		
		JLabel lblPesquisa = new JLabel("Pesquisa:");
		
		jtfPesquisaCliente = new JTextField();
		jtfPesquisaCliente.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		
		JPanel jpListaClientes = new JPanel();
		jpListaClientes.setBorder(new TitledBorder(null, "Lista de clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroClienteUI cadClienteUI = new CadastroClienteUI(null);
				cadClienteUI.requestFocus();
				cadClienteUI.setFocusable(true);
				PrincipalUI.obterInstancia().getContentPane().add(cadClienteUI,0);
				cadClienteUI.setVisible(true);
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				int linha = jtListaClientes.getSelectedRow();
				Cliente cliente = new ClienteController().listaClientes().get(linha);
				CadastroClienteUI cadCliente = new CadastroClienteUI(cliente);
				cadCliente.requestFocus();
				cadCliente.setFocusable(true);
				PrincipalUI.obterInstancia().getContentPane().add(cadCliente);
				cadCliente.setVisible(true);
			}
		});
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int linha = jtListaClientes.getSelectedRow();
					Cliente cliente = new ClienteController().listaClientes().get(linha);
					new ClienteController().excluir(cliente.getId());
					
					JOptionPane.showMessageDialog(null, "Clinte excluido com sucesso!!");
					jtListaClientes.setModel(new ClienteTableModel(new ClienteDAO().listaClientes()));
				}catch (Exception e) {
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
							.addGap(20)
							.addComponent(lblPesquisa)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfPesquisaCliente, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBuscar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jpListaClientes, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnInserir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnFechar)))
					.addContainerGap(244, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPesquisa)
						.addComponent(jtfPesquisaCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(27)
					.addComponent(jpListaClientes, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir)
						.addComponent(btnEditar)
						.addComponent(btnExcluir)
						.addComponent(btnFechar))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		
		JScrollPane jspListaClientes = new JScrollPane();
		GroupLayout gl_jpListaClientes = new GroupLayout(jpListaClientes);
		gl_jpListaClientes.setHorizontalGroup(
			gl_jpListaClientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpListaClientes.createSequentialGroup()
					.addContainerGap()
					.addComponent(jspListaClientes, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_jpListaClientes.setVerticalGroup(
			gl_jpListaClientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpListaClientes.createSequentialGroup()
					.addContainerGap()
					.addComponent(jspListaClientes, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		jtListaClientes = new JTable();
		jtListaClientes.setModel(
				new ClienteTableModel(new ClienteDAO().listaClientes()));
		jspListaClientes.setViewportView(jtListaClientes);
		jpListaClientes.setLayout(gl_jpListaClientes);
		getContentPane().setLayout(groupLayout);

	}
}
