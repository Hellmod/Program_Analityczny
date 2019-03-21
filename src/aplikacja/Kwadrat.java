package aplikacja;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Kwadrat extends JPanel {
	public int x, y, wielkosc;
	String nazwa = "";
	Color c;

//TODO dodaæ przezroczyste kwadraty
	public Kwadrat(int x, int y, int wielkosc) {
		this.x = x;
		this.y = y;
		this.wielkosc = wielkosc;
		c = new Color(0, 255, 0);
	}

	public Kwadrat(int x, int y, int wielkosc, Color c) {
		this.x = x;
		this.y = y;
		this.wielkosc = wielkosc;
		this.c = c;
	}

	public Kwadrat(int x, int y, int wielkosc, Color c, String nazwa) {
		this.nazwa = nazwa;
		this.x = x;
		this.y = y;
		this.wielkosc = wielkosc;
		this.c = c;
	}

	public void paint(Graphics g) {

		g.setColor(c);
		g.fillRect(x, y, wielkosc, wielkosc);
		g.setColor(new Color(0, 0, 0));
		g.drawRect(x, y, wielkosc, wielkosc);
		g.drawString(nazwa, x + 2, y + wielkosc / 2);

	}
	/*
	 * void render(Graphics g) { g.setColor(c); g.fillRect(x, y, width, height); }
	 */
}
