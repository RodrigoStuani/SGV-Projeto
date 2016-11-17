package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.ProdutoController;
import dao.ProdutoDAO;
import model.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroProdutoUI extends JInternalFrame {
	private JTextField jtfNomeProduto;
	private JTextField jtfPrecoUnitario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProdutoUI frame = new CadastroProdutoUI(null);
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
	public CadastroProdutoUI(Produto produto) {
		setClosable(true);
		setTitle("Cadastro de Produtos");
		setBounds(100, 100, 450, 232);
		
		JPanel jpBordaProduto = new JPanel();
		jpBordaProduto.setBorder(new TitledBorder(null, "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (produto == null){
					try {
						Produto produto = new Produto();
						produto.setNome(jtfNomeProduto.getText());
						produto.setPrecoUnitario(
								Double.parseDouble(jtfPrecoUnitario.getText()));
						
						new ProdutoController().inserir(produto);
						JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!! ");
						dispose();
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}else {
					try {
						produto.setNome(jtfNomeProduto.getText());
						produto.setPrecoUnitario(Double.parseDouble(jtfPrecoUnitario.getText()));
						
						new ProdutoController().editar(produto);
						
						JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!!");
						dispose();
					}catch(Exception e){
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
						.addComponent(jpBordaProduto, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
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
					.addComponent(jpBordaProduto, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnCancelar))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		
		JLabel lblNome = new JLabel("Nome: ");
		
		jtfNomeProduto = new JTextField();
		jtfNomeProduto.setColumns(10);
		
		JLabel lblPreoUnitrio = new JLabel("Pre\u00E7o Unit\u00E1rio: R$");
		
		jtfPrecoUnitario = new JTextField();
		jtfPrecoUnitario.setColumns(10);
		GroupLayout gl_jpBordaProduto = new GroupLayout(jpBordaProduto);
		gl_jpBordaProduto.setHorizontalGroup(
			gl_jpBordaProduto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpBordaProduto.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpBordaProduto.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpBordaProduto.createSequentialGroup()
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfNomeProduto, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
						.addGroup(gl_jpBordaProduto.createSequentialGroup()
							.addComponent(lblPreoUnitrio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(jtfPrecoUnitario, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_jpBordaProduto.setVerticalGroup(
			gl_jpBordaProduto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpBordaProduto.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_jpBordaProduto.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(jtfNomeProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_jpBordaProduto.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPreoUnitrio)
						.addComponent(jtfPrecoUnitario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		jpBordaProduto.setLayout(gl_jpBordaProduto);
		getContentPane().setLayout(groupLayout);

		if (produto != null){
			jtfNomeProduto.setText(produto.getNome());
			jtfPrecoUnitario.setText(produto.getPrecoUnitario().toString());
		}
	}
}
