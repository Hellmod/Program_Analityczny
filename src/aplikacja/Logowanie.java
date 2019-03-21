package aplikacja;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Logowanie extends JFrame implements ActionListener, KeyListener {
	JButton bPrzelicz;
	JLabel lLogin, lHaslo;
	JTextField tLogin;
	JPasswordField tHaslo;

	void alert(String tytul, String komunikat) {
		String msg = "<html><center><b><font color=red>" + komunikat + "</font></b></center></html>";
		JOptionPane.showMessageDialog(null, msg, tytul, JOptionPane.WARNING_MESSAGE, null);
	}

	public Logowanie() {
		// setFocusable(true);
		addKeyListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(300, 150);
		setLocation(512, 300);
		setTitle("Logowanie");
		setLayout(null);

		lLogin = new JLabel("Login: ");
		lLogin.setBounds(20, 20, 150, 20);
		add(lLogin);

		tLogin = new JTextField("Admin");
		tLogin.setBounds(100, 20, 150, 20);
		tLogin.setFocusable(true);
		tLogin.addKeyListener(this);
		add(tLogin);

		lHaslo = new JLabel("Hasło: ");
		lHaslo.setBounds(20, 50, 150, 20);
		add(lHaslo);

		tHaslo = new JPasswordField("Admin");
		tHaslo.setBounds(100, 50, 150, 20);
		tHaslo.addKeyListener(this);
		add(tHaslo);

		bPrzelicz = new JButton("Zaloguj");
		bPrzelicz.setBounds(75, 80, 120, 20);
		bPrzelicz.addKeyListener(this);
		bPrzelicz.addActionListener((ActionListener) this);
		add(bPrzelicz);

		setVisible(true);
		// setFocusable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		login();
	}

	@SuppressWarnings("deprecation")
	private void login() {
		// TODO po³¹czenie z baz¹ danych

		if (tLogin.getText().equals("Admin") && tHaslo.getText().equals("Admin")) {
			new Okienko();
			this.dispose();
		} else
			alert("B³¹d logowania", "Niepoprawy login lub has³o");

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int id = e.getKeyCode();

		if (id == KeyEvent.VK_ESCAPE) {
			this.dispose();
		}

		if (id == KeyEvent.VK_ENTER) {
			System.out.println("Enter");
			login();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
