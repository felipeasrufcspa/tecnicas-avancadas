package pacote;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.awt.event.ActionEvent;

public class CarregaImagem extends JFrame {

	private JPanel contentPane;
	private static CarregaImagem frame;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenuItem mntmSelecionaArquivo;
	private JMenuItem mntmFecharJanela;
	private JLabel lblImagem;

	
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CarregaImagem();
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
	
	
	public CarregaImagem() {
		setTitle("Visualizador de Imagens");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);
		contentPane.add(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		mntmSelecionaArquivo = new JMenuItem("Seleciona Arquivo");
		mntmSelecionaArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						imagem();
				}
			});
		mnArquivo.add(mntmSelecionaArquivo);
		mntmFecharJanela = new JMenuItem("Fechar Janela");
		mntmFecharJanela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		mnArquivo.add(mntmFecharJanela);
		
		lblImagem = new JLabel(""); //label vazio para setar a imagem dentro
		lblImagem.setBounds(0, 22, 434, 239);
		contentPane.add(lblImagem); //a imagem vai aparecer dentro do contentPane
	}
	
	
	
		public void imagem() {
			JFileChooser jf = new JFileChooser(); //abre a janela de sele��o de imagens
			jf.showOpenDialog(frame);
				
				try {
					//deixando o tamanho da imagem do tamanho do label
					lblImagem.setIcon(new ImageIcon(ImageIO.read(jf.getSelectedFile()).getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), BufferedImage.TYPE_INT_RGB)));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				}		
		}
		
		
		public void close() {
			System.exit(0); //fechar jfilechooser e encerrar o programa
		}
	
}