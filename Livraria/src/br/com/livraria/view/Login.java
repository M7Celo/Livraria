package br.com.livraria.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.livraria.model.dao.LoginDao;

public class Login extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Declaração de variáveis	
	 */
	private JLabel lbLogin;
	private JLabel lbSenha;
	private final JTextField tfLogin;
	private final JPasswordField pfSenha;
	private JButton btEntrar;
	private JButton btCancelar;
	public String loginRecebido;
	public String senhaRecebido;
	
	/**
	 * Objeto LoginDao
	 */
	private LoginDao loginDao;
	
	/**
	 * Construtor
	 */
	public Login() {
		
		/**
		 * Inicialização de Objetos
		 */
		setTitle("Login");
		lbLogin = new JLabel("Login");
		lbSenha = new JLabel("Senha");
		tfLogin = new JTextField(5);
		pfSenha =  new JPasswordField(5);
		btEntrar = new JButton("Entrar");
		btCancelar = new JButton("Cancelar");
		loginRecebido = "";
		senhaRecebido = "";
		
		/**
		 * Coordenadas
		 */
		setBounds(500, 200, 230, 200);
		btEntrar.setBounds(20,120,90,25);
		btCancelar.setBounds(120,120,90,25);
		lbLogin.setBounds(20, 30, 100, 25);
		tfLogin.setBounds(60, 30, 150, 25);
		lbSenha.setBounds(20, 70, 100, 25);
		pfSenha.setBounds(60, 70, 150, 25);
		
		/**
		 * Adição de Campos em Tela
		 */
		add(lbLogin);
		add(lbSenha);
		add(tfLogin);
		add(pfSenha);
		add(btEntrar);
		add(btCancelar);
		
		/**
		 * Adição de campos para eventos
		 */
		btEntrar.addActionListener(this);
		btCancelar.addActionListener(this);
		
		/**
		 * Execução em Tela
		 */
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent event) {
		
		try {
			loginDao = new LoginDao();
			
			if(btEntrar == event.getSource()){
				loginRecebido = tfLogin.getText();
				senhaRecebido = pfSenha.getText();
				
				if(loginDao.validarLogin(loginRecebido, senhaRecebido)) { // Acesso OK
					JOptionPane.showMessageDialog(null, "Usuário e senha corretos");
					@SuppressWarnings("unused")
					Menu objMenu =  new Menu();
					this.dispose();
				}else{ // Acesso Negado
					JOptionPane.showMessageDialog(this, "Ocorreu um erro ao acessar a base, contate seu fornecedor" );
				}
			}
			
			if (btCancelar == event.getSource()) {
				this.dispose();
			}
			
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro ao acessar a base, contate seu fornecedor", "Erro", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Login();
	}
}
