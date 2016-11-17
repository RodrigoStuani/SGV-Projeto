package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalUI extends JFrame {

	private JPanel contentPane;
	private static PrincipalUI instancia;

	public static PrincipalUI obterInstancia(){
		if ( instancia == null ){
			instancia = new PrincipalUI();
		}
		return instancia;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUI frame = PrincipalUI.obterInstancia();
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
	public PrincipalUI() {
		setTitle("Sistema de Vendas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 455);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroClienteUI cadClienteUI = new CadastroClienteUI(null);
				cadClienteUI.requestFocus();
				cadClienteUI.setFocusable(true);
				getContentPane().add(cadClienteUI,0);
				cadClienteUI.setVisible(true);
			}
		});
		mnCadastros.add(mntmCliente);
		
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroProdutoUI cadProdutoUI = new CadastroProdutoUI(null);
				cadProdutoUI.requestFocus();
				cadProdutoUI.setFocusable(true);
				getContentPane().add(cadProdutoUI,0);
				cadProdutoUI.setVisible(true);
			}
		});
		mnCadastros.add(mntmProduto);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaClienteUI consClienteUI = new ConsultaClienteUI();
				consClienteUI.requestFocus();
				consClienteUI.setFocusable(true);
				getContentPane().add(consClienteUI,0);
				consClienteUI.setVisible(true);
			}
		});
		mnConsultas.add(mntmCliente_1);
		
		JMenuItem mntmProduto_1 = new JMenuItem("Produto");
		mntmProduto_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaProdutoUI consProdutoUI = new ConsultaProdutoUI();
				consProdutoUI.requestFocus();
				consProdutoUI.setFocusable(true);
				getContentPane().add(consProdutoUI,0);
				consProdutoUI.setVisible(true);
			}
		});
		mnConsultas.add(mntmProduto_1);
		
		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);
		
		JMenuItem mntmRealizarVenda = new JMenuItem("Realizar venda");
		mntmRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarVendaUI regVendaUI = new RegistrarVendaUI();
				regVendaUI.requestFocus();
				regVendaUI.setFocusable(true);
				getContentPane().add(regVendaUI,0);
				regVendaUI.setVisible(true);
			}
		});
		mnVendas.add(mntmRealizarVenda);
		
		JMenuItem mntmRelatrioMensalDe = new JMenuItem("Relat\u00F3rio mensal de vendas");
		mnVendas.add(mntmRelatrioMensalDe);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpUI helpUI = new HelpUI();
				helpUI.requestFocus();
				helpUI.setFocusable(true);
				getContentPane().add(helpUI,0);
				helpUI.setVisible(true);
			}
		});
		mnAjuda.add(mntmSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 695, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 406, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
