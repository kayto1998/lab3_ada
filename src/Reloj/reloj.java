package Reloj;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

public class reloj {

	private JLayeredPane opciones;
	private JFrame frame;
	private int x;
	private int y;
	private JLabel fondoMenu;
	private JLabel fondoMenu2;
	private JLabel fondoMenu3;
	private JLabel fondoMenu4;
	private JLabel fondoMenu5;
	private JLabel cabecera;
	private JLabel fondoMenu6;
	private JLabel horario1;
	private JLabel horario2;
	private JLabel horario3;
	private JLabel horario4;
	private JLabel horario5;
	private JLabel lblSalir;
	private JLabel hora;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reloj window = new reloj();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public reloj() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 250, 350);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setResizable(false);
		//bordes redondeados
		frame.setShape(new RoundRectangle2D.Double(0, 0, 250, 350, 20, 20));
		
		JLabel lblMobilidad = new JLabel("");
		lblMobilidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		lblMobilidad.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frame.setLocation(frame.getLocation().x + e.getX() - x, frame.getLocation().y + e.getY() - y);
			}
		});
		lblMobilidad.setBounds(0, 0, 216, 36);
		frame.getContentPane().add(lblMobilidad);
		
		/////////////////////////////////////////
		opciones = new JLayeredPane(){

			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
				super.paintComponents(g);
				Color c = new Color(29,75,124,255);
				Color c2 = new Color(25,166,211,255);
				Graphics2D g2d=(Graphics2D)g;
				int w = getWidth();
				int h = getHeight();
				g2d.setPaint(new GradientPaint(0, 0, c, 250, 350, c2));
				g2d.fillRect(0, 0, w, h);
			}
		};
		opciones.setBounds(0, 0, 250, 350);
		frame.getContentPane().add(opciones);
		opciones.setLayout(null);
		
		//SALIR
		lblSalir = new JLabel("");
		lblSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				frame.dispose();
				System.exit(0);
			}
		});
		lblSalir.setIcon(new ImageIcon("images/salir.png"));
		lblSalir.setBounds(216, 11, 25, 25);
		opciones.add(lblSalir);
		
		Color c = new Color(0,0,0,100);
		
		fondoMenu = new JLabel();
		fondoMenu.setBackground(c);
		fondoMenu.setHorizontalAlignment(SwingConstants.CENTER);
		fondoMenu.setForeground(Color.WHITE);
		fondoMenu.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
		fondoMenu.setBounds(0, 0, 250, 47);
		opciones.add(fondoMenu);
		
		fondoMenu2 = new JLabel();
		fondoMenu2.setBackground(c);
		fondoMenu2.setHorizontalAlignment(SwingConstants.CENTER);
		fondoMenu2.setForeground(Color.WHITE);
		fondoMenu2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.white));
		fondoMenu2.setBounds(0, 47, 47, 256);
		opciones.add(fondoMenu2);
		
		fondoMenu3 = new JLabel();
		fondoMenu3.setBackground(c);
		fondoMenu3.setHorizontalAlignment(SwingConstants.CENTER);
		fondoMenu3.setForeground(Color.WHITE);
		fondoMenu3.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.white));
		fondoMenu3.setBounds(203, 47, 47, 256);
		opciones.add(fondoMenu3);
		
		fondoMenu4 = new JLabel();
		fondoMenu4.setBackground(c);
		fondoMenu4.setHorizontalAlignment(SwingConstants.CENTER);
		fondoMenu4.setForeground(Color.WHITE);
		fondoMenu4.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
		fondoMenu4.setBounds(0, 303, 250, 47);
		opciones.add(fondoMenu4);
		
		fondoMenu5 = new JLabel();
		fondoMenu5.setBackground(c);
		fondoMenu5.setHorizontalAlignment(SwingConstants.CENTER);
		fondoMenu5.setForeground(Color.WHITE);
		fondoMenu5.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.white));
		fondoMenu5.setBounds(47, 303, 156, 47);
		opciones.add(fondoMenu5);
		
		fondoMenu6 = new JLabel();
		fondoMenu6.setBackground(c);
		fondoMenu6.setHorizontalAlignment(SwingConstants.CENTER);
		fondoMenu6.setForeground(Color.WHITE);
		fondoMenu6.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		fondoMenu6.setBounds(47, 0, 156, 47);
		opciones.add(fondoMenu6);
		
		horario1 = new JLabel("LUN");
		horario1.setHorizontalAlignment(SwingConstants.CENTER);
		horario1.setForeground(Color.WHITE);
		horario1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		horario1.setBounds(48, 288, 30, 14);
		opciones.add(horario1);
		
		horario2 = new JLabel("MAR");
		horario2.setHorizontalAlignment(SwingConstants.CENTER);
		horario2.setForeground(Color.WHITE);
		horario2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		horario2.setBounds(79, 288, 30, 14);
		opciones.add(horario2);
		
		horario3 = new JLabel("MIE");
		horario3.setHorizontalAlignment(SwingConstants.CENTER);
		horario3.setForeground(Color.WHITE);
		horario3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		horario3.setBounds(110, 288, 30, 14);
		opciones.add(horario3);
		
		horario4 = new JLabel("JUE");
		horario4.setHorizontalAlignment(SwingConstants.CENTER);
		horario4.setForeground(Color.WHITE);
		horario4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		horario4.setBounds(141, 288, 30, 14);
		opciones.add(horario4);
		
		horario5 = new JLabel("VIE");
		horario5.setHorizontalAlignment(SwingConstants.CENTER);
		horario5.setForeground(Color.WHITE);
		horario5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
		horario5.setBounds(172, 288, 30, 14);
		opciones.add(horario5);
		
		cabecera = new JLabel();
		cabecera.setBackground(c);
		cabecera.setHorizontalAlignment(SwingConstants.CENTER);
		cabecera.setForeground(Color.WHITE);
		cabecera.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		cabecera.setBounds(47, 47, 156, 16);
		opciones.add(cabecera);
		
		hora = new JLabel("12:30");
		hora.setBackground(c);
		hora.setHorizontalAlignment(SwingConstants.CENTER);
		hora.setForeground(Color.WHITE);
		hora.setBounds(47, 150, 156, 32);
		hora.setFont(new Font("Tahoma", Font.PLAIN, 40));
		opciones.add(hora);
	}
	
}
