package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.ClienteController;
import dao.ClienteDAO;
import model.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroClienteUI extends JInternalFrame {
	private JTextField jtfNomeCliente;
	private JTextField jtfCpfCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroClienteUI frame = new CadastroClienteUI(null);
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
	public CadastroClienteUI(Cliente cliente) {
		setClosable(true);
		setTitle("Cadastro de Clientes");
		setBounds(100, 100, 450, 250);
		
		JPanel jpBordaCliente = new JPanel();
		jpBordaCliente.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cliente == null){
					try {
					Cliente cliente = new Cliente();
					cliente.setNome(jtfNomeCliente.getText());
					cliente.setCpf(jtfCpfCliente.getText());
					
					new ClienteController().inserir(cliente);
					
					JOptionPane.showMessageDialog(null, 
							"Cliente cadastrado com sucesso!");
					dispose();
					} catch (Exception e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}else {
					try {
						cliente.setNome(jtfNomeCliente.getText());
						cliente.setCpf(jtfCpfCliente.getText());
					
						new ClienteController().editar(cliente);
					
						JOptionPane.showMessageDialog(null, "Cadastro editado com sucesso!!");
						dispose();
					}catch (Exception e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jpBordaCliente, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpBordaCliente, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnCancelar))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		
		JLabel lblNome = new JLabel("Nome: ");
		
		jtfNomeCliente = new JTextField();
		jtfNomeCliente.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF: ");
		
		jtfCpfCliente = new JTextField();
		jtfCpfCliente.setColumns(10);
		GroupLayout gl_jpBordaCliente = new GroupLayout(jpBordaCliente);
		gl_jpBordaCliente.setHorizontalGroup(
			gl_jpBordaCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpBordaCliente.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpBordaCliente.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCpf)
						.addComponent(lblNome))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpBordaCliente.createParallelGroup(Alignment.LEADING)
						.addComponent(jtfNomeCliente, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
						.addComponent(jtfCpfCliente, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_jpBordaCliente.setVerticalGroup(
			gl_jpBordaCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpBordaCliente.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_jpBordaCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(jtfNomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_jpBordaCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(jtfCpfCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		jpBordaCliente.setLayout(gl_jpBordaCliente);
		getContentPane().setLayout(groupLayout);
		
		if (cliente != null){
			jtfNomeCliente.setText(cliente.getNome());
			jtfCpfCliente.setText(cliente.getCpf());
		}
	}
}
