package aplikacja;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;




@SuppressWarnings("serial")
public class Wykres extends JFrame implements KeyListener {
	public static Wykres test;
	BazaDanych baza;
	
	public Wykres(BazaDanych baza) {
		this.baza=baza;
		
		setSize(600, 600);
		setLocation(750, 25);
		setTitle("Wykres");
	
		this.add(new Rysuj(baza), BorderLayout.CENTER);
				
		addKeyListener(this);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int id = e.getKeyCode();

		if (id == KeyEvent.VK_ESCAPE) {
			this.dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
