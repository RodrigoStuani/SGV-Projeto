package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class HelpUI extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpUI frame = new HelpUI();
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
	public HelpUI() {
		setClosable(true);
		setTitle("Sobre");
		setBounds(100, 100, 450, 300);
		
		JLabel lblSistemaDeVendas = new JLabel("Sistema de Vendas - Vers\u00E3o 0.1");
		
		JLabel lblAutorJaysonNienkotter = new JLabel("Autor: Rodrigo Stuani");
		
		JLabel lblUnidadeCurricularProgramao = new JLabel("Unidade Curricular: Programa\u00E7\u00E3o Orientada a Objetos");
		
		JLabel lblCursoAnliseE = new JLabel("Curso: An\u00E1lise e Desenvolvimento de Sistemas N2");
		
		JLabel lblSenai = new JLabel("SENAI");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(119)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSenai)
						.addComponent(lblCursoAnliseE)
						.addComponent(lblUnidadeCurricularProgramao)
						.addComponent(lblAutorJaysonNienkotter)
						.addComponent(lblSistemaDeVendas))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(70)
					.addComponent(lblSistemaDeVendas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAutorJaysonNienkotter)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUnidadeCurricularProgramao)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCursoAnliseE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSenai)
					.addContainerGap(106, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
