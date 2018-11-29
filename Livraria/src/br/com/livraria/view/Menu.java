package br.com.livraria.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Declaração de variáveis	
	 */
	private JMenuBar barPrincipal;
	private JMenu mnCadastro;
	private JMenuItem miAutores;
	private JMenuItem miClientes;
	private JMenuItem miEditoras;
	private JMenuItem miLivros;
	private JMenuItem miLocacao;
	private JMenuItem miUsuarios;
	private JMenu mnSobre;
	private JMenuItem mitemSobre;
	private JMenuItem mitemVersao;
	private JMenuItem mitemContato;
	private JMenu mnUtilitario;
	private JMenuItem mitemTema_01;
	private JMenuItem mitemTema_02;
	private JMenuItem mitemTema_03;
	private JMenuItem mitemTema_04;
	private JMenuItem mitemTema_05;
	
	/**
	 * Construtor
	 */
	public Menu() {
		
		/**
		 * Inicialização de Objetos
		 */
		setTitle("Menu");
		this.barPrincipal = new JMenuBar();
		this.mnCadastro = new JMenu("Cadastro");
		
		/**
		 * Coordenadas
		 */
		setBounds(250,100,800,600);
		
		/**
		 * Adição de Campos em Tela
		 */
		
		/**
		 * Adição de campos para eventos
		 */
		
		/**
		 * Execução em Tela
		 */
		setLayout(new FlowLayout());
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
	}

}
