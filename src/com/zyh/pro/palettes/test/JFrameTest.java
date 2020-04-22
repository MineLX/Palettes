package com.zyh.pro.palettes.test;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFrameTest {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(200, 200);
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("e = " + e.getX() + " , " + e.getY());
			}
		});
		frame.setVisible(true);
	}
}
