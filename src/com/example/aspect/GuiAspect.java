package com.example.aspect;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GuiAspect {

	private JFrame frame;
	public static JTextField textMonto;
	private BancoSinAspect Banco1;
	private BancoConAspect Banco2;
	public static JEditorPane textArea;
	private int select;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiAspect window = new GuiAspect();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GuiAspect() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Banco");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textArea = new JEditorPane("text/html", "");
		textArea.setText("");
		textArea.setEditable(false);
		textArea.setBounds(12, 163, 426, 104);
		frame.getContentPane().add(textArea);
		
		JLabel lblConsola = new JLabel("Consola:");
		lblConsola.setBounds(64, 122, 70, 15);
		frame.getContentPane().add(lblConsola);
		
		textMonto = new JTextField();
		textMonto.setBounds(64, 62, 114, 19);
		frame.getContentPane().add(textMonto);
		textMonto.setColumns(10);
		
		JLabel labelMonto = new JLabel("Monto:");
		labelMonto.setBounds(64, 46, 70, 15);
		frame.getContentPane().add(labelMonto);
		
		JRadioButton btnSinAspecto = new JRadioButton("Sin Aspecto");
		btnSinAspecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Banco1=new BancoSinAspect();
				textArea.setText("Sin Aspecto");
				select=1;
			}
		});
		btnSinAspecto.setBounds(64, 8, 149, 23);
		frame.getContentPane().add(btnSinAspecto);
		
		JRadioButton btnConAspecto = new JRadioButton("Con Aspecto");
		btnConAspecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Banco2=new BancoConAspect();
				textArea.setText("Con Aspecto");
				select=2;
			}
		});
		btnConAspecto.setBounds(230, 8, 149, 23);
		frame.getContentPane().add(btnConAspecto);
		
		ButtonGroup grupoBoton=new ButtonGroup();
		grupoBoton.add(btnSinAspecto);
		grupoBoton.add(btnConAspecto);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.setBackground(new Color(144, 238, 144));
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double cantidad=Double.parseDouble(textMonto.getText());
				if(select==1){
					textArea.setText(Banco1.hacerDeposito(cantidad));
				}
				else if(select==2){
					Banco2.hacerDeposito(cantidad);
				}
			}
		});
		btnDepositar.setBounds(262, 39, 117, 25);
		frame.getContentPane().add(btnDepositar);
		
		JButton btnRetirar = new JButton("Retirar");
		btnRetirar.setBackground(new Color(144, 238, 144));
		btnRetirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double cantidad=Double.parseDouble(textMonto.getText());
				if(select==1){
					textArea.setText(Banco1.hacerRetiro(cantidad));
					
				}
				else if(select==2){
					Banco2.hacerRetiro(cantidad);
				}
			}
		});
		btnRetirar.setBounds(262, 76, 117, 25);
		frame.getContentPane().add(btnRetirar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(new Color(144, 238, 144));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(select==1){
					textArea.setText("<h1><b>Saldo:</b> "+Banco1.hacerConsulta());
				}
				else if(select==2){
					textArea.setText("<h1><b>Saldo:</b> "+Banco2.hacerConsulta());
				}
			}
		});
		btnConsultar.setBounds(262, 113, 117, 25);
		frame.getContentPane().add(btnConsultar);
	}
}
