package com.ssafy.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GuiTest extends JFrame implements ActionListener {

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();

	JLabel l = new JLabel("입력");
	JTextField tf = new JTextField();
	JButton ok = new JButton("확인");

	JTextArea ta = new JTextArea();

	JButton open = new JButton("열기");
	JButton exit = new JButton("종료");

	public GuiTest() {
		super("Swing Test !!!");
		createGUI();
		addEvent();
	}

	private void createGUI() {
//		p1.setBackground(Color.cyan);
		p1.setBackground(new Color(210, 50, 210));
		p1.setLayout(new BorderLayout(10, 0));
		p1.add(l, "West");
		p1.add(tf, "Center");
		p1.add(ok, "East");

		p2.setLayout(new GridLayout(1, 2, 10, 0));
		p2.add(open);
		p2.add(exit);

		this.add(p1, "North");
		this.add(ta, "Center");
		this.add(p2, "South");

		this.setSize(500, 600);
		this.setLocation(500, 300);
		this.setVisible(true);
	}

	private void addEvent() {
//		ok.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String msg = tf.getText();
////				ta.setText(msg);
//				ta.append(msg + "\n");
//				tf.setText("");
//			}
//		});
//		tf.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String msg = tf.getText();
////				ta.setText(msg);
//				ta.append(msg + "\n");
//				tf.setText("");
//			}
//		});
		ok.addActionListener(this);
		tf.addActionListener(this);
		exit.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == ok || ob == tf) {
			String msg = tf.getText();
	//		ta.setText(msg);
			ta.append(msg + "\n");
			tf.setText("");
		} else if (ob == exit) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new GuiTest();
	}

}
