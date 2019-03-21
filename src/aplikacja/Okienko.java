package aplikacja;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class Okienko extends JFrame implements ActionListener, KeyListener {// ,MouseListener, MouseMotionListener
	JButton bDodawanie, bUsunZBazy, bWykres, test, bDodawanieDoBazy;
	JButton bTabela;
	JPanel pButton, pTable, pDodaj, pWykres;
	JSeparator sSeparator;

	JTable table;
	JScrollPane scrollPane;
	JComboBox<String> cPraw, cZagr;
	JTextField tNazwa, tId;
	JLabel lNazwa, lOpis, lPraw, lZagr, lUsun;
	JTextArea tOpis;

	DefaultTableModel model;
	public BazaDanych baza = new BazaDanych();

	int width = 700, height = 500;

	public Okienko() {

		addKeyListener(this);
		setTitle("Projekt");
		setSize(width, height);
		setLocation(50, 50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setLayout(null);

		pButton = new JPanel();
		pButton.setLayout(null);
		pButton.setBounds(0, 0, 400, 200);
		pButton.addKeyListener(this);
		// pButton.setBackground(new Color(0, 0, 255));

		pTable = new JPanel();
		pTable.setLayout(null);
		pTable.setBounds(210, 10, 450, 400);
		pTable.addKeyListener(this);

		// pButton.setBackground(new Color(0, 255, 255));

		pDodaj = new JPanel();
		pDodaj.setLayout(null);
		pDodaj.setBounds(210, 10, 450, 400);
		pDodaj.addKeyListener(this);
		// pDodaj.setBorder(BorderFactory.createTitledBorder("Move the Mouse to Move
		// Duke"));

		pWykres = new JPanel();
		pWykres.setLayout(null);
		pWykres.setBounds(210, 10, 450, 400);
		pWykres.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		pWykres.addKeyListener(this);

//_______________________button________________________________        

		bTabela = new JButton("Tabela");
		bTabela.setBounds(0, 50, 200, 66);
		bTabela.setSize(new Dimension(200, 66));
		// bTabela.setBackground(new Color(53, 38, 255));
		// bTabela.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
		bTabela.addKeyListener(this);
		bTabela.addActionListener((ActionListener) this);
		pButton.add(bTabela);

		bDodawanie = new JButton("Dodaj dane");
		bDodawanie.setBounds(0, 150, 200, 66);
		bDodawanie.addKeyListener(this);
		bDodawanie.addActionListener((ActionListener) this);
		pButton.add(bDodawanie);

		bWykres = new JButton("Wykres");
		bWykres.setBounds(0, 250, 200, 66);
		bWykres.addKeyListener(this);
		bWykres.addActionListener((ActionListener) this);
		pButton.add(bWykres);

//_______________________tabela________________________________

		table = new JTable(new DefaultTableModel(
				new Object[] { "id", "Nazwa", "Prawdopodobieñstow", "zagro¿enie", "ryzyko", "opis" }, 0));

		table.setFillsViewportHeight(true);
		table.addKeyListener(this);
		table.setEnabled(false);

		model = (DefaultTableModel) table.getModel();
		// przeladujTabele();

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 450, 400);
		scrollPane.addKeyListener(this);
		pTable.add(scrollPane);

//_______________________dodawanie_______________________________

		lUsun = new JLabel("Usuñ rekord id:");
		lUsun.setBounds(5, 10, 100, 20);
		pDodaj.add(lUsun);

		tId = new JTextField();
		tId.setBounds(150, 10, 30, 30);
		tId.setFocusable(true);
		tId.addKeyListener(this);
		PlainDocument doc = (PlainDocument) tId.getDocument();
		doc.setDocumentFilter(new MyIntFilter());
		pDodaj.add(tId);

		bUsunZBazy = new JButton("Usun");
		bUsunZBazy.setBounds(190, 10, 100, 30);
		bUsunZBazy.addKeyListener(this);
		bUsunZBazy.addActionListener((ActionListener) this);
		pDodaj.add(bUsunZBazy);

		sSeparator = new JSeparator();
		sSeparator.setBounds(0, 45, 450, 1);
		pDodaj.add(sSeparator);

		tNazwa = new JTextField();
		tNazwa.setBounds(150, 50, 100, 20);
		tNazwa.setFocusable(true);
		tNazwa.addKeyListener(this);
		pDodaj.add(tNazwa);

		cPraw = new JComboBox<>(new String[] { "Rzadkie", "Mało Prawdopodobne", "Średnie", "Prawdopodobne" });
		cPraw.setBounds(150, 100, 100, 20);
		pDodaj.add(cPraw);

		cZagr = new JComboBox<>(new String[] { "Nieznaczne", "Małe", "Średnie", "Poważne" });
		cZagr.setBounds(150, 150, 100, 20);
		pDodaj.add(cZagr);

		tOpis = new JTextArea();
		tOpis.setBounds(150, 200, 300, 200);
		tOpis.setFocusable(true);
		tOpis.addKeyListener(this);
		tOpis.setLineWrap(true);

		pDodaj.add(tOpis);

		bDodawanieDoBazy = new JButton("Dodaj");
		bDodawanieDoBazy.setBounds(300, 150, 100, 33);
		bDodawanieDoBazy.addKeyListener(this);
		bDodawanieDoBazy.addActionListener((ActionListener) this);
		pDodaj.add(bDodawanieDoBazy);

		lNazwa = new JLabel("Nazwa:");
		lNazwa.setBounds(5, 50, 100, 20);
		pDodaj.add(lNazwa);

		lPraw = new JLabel("Prawdopodobieñstwo:");
		lPraw.setBounds(5, 100, 150, 20);
		pDodaj.add(lPraw);

		lZagr = new JLabel("Zagro¿enie:");
		lZagr.setBounds(5, 150, 100, 20);
		pDodaj.add(lZagr);

		lOpis = new JLabel("Opis:");

		lOpis.setBounds(5, 200, 100, 20);
		pDodaj.add(lOpis);

//_______________________wykres_______________________________

//_______________________Jframe_______________________________

		add(pTable);
		add(pDodaj);
		add(pWykres);
		pTable.setVisible(false);
		// pDodaj.setVisible(false);
		pWykres.setVisible(false);
		add(pButton);

		setVisible(true);
	}

	/**
	 * Dodaje Rekord do bazy. Wyci¹gniête dane z komponenkóe
	 */
	void dodajrekord() {
		baza.dodaj(tNazwa.getText().toString(), przetlumacz(cPraw.getSelectedItem().toString()),
				przetlumacz(cZagr.getSelectedItem().toString()), tOpis.getText().toString());
		Start.alert("Sukces", "Dodano nowy rekord");
	}

	/**
	 * Usuwa Rekord z bazy. id pobiera z tId
	 */
	void usunrekord() {
		if (tId.getText().toString().equals(""))
			Start.alert("Sukces", "Podaj id do usuniêcia !!!");
		else {
			baza.usun(Integer.parseInt(tId.getText().toString()));
			Start.alert("Sukces", "Usuniêto rekordo id: " + tId.getText().toString());
		}
	}

	/**
	 * Usuwa wszystkie elementy z tablicy nastêpnie zape³nia j¹ danymi z listy
	 * baza.baza
	 */
	void przeladujTabele() {

		while (model.getRowCount() != 0) {
			model.removeRow(0);
		}

		for (int i = 0; i < baza.baza.size(); i++) {
			model.addRow(baza.baza.get(i));
		}
		// System.out.println(model.getRowCount());

	}

	public void render(Graphics2D g) {

		// k1_1.render(g);

	}

	/**
	 * T³umaczy wartoœci wybrane z listy na inty
	 *
	 * @param s String z listy
	 * @return wartoœc zagro¿enia lub ryzyka
	 * @see <a href="http://vatmar.com.pl/">zobacz stronê napisan¹ przeze mnie</a>
	 */
	public int przetlumacz(String s) {
		if (s.equals("Rzadkie") || s.equals("Nieznaczne"))
			return 1;
		else if (s.equals("Ma³o Prawdopodobne") || s.equals("Ma³e"))
			return 2;
		else if (s.equals("Œrednie") || s.equals("Œrednie"))
			return 3;
		else if (s.equals("Prawdopodobne") || s.equals("Powarzne"))
			return 4;
		return -1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object zrudlo = e.getSource();
		if (zrudlo == bTabela) {
			przeladujTabele();
			pTable.setVisible(true);
			pDodaj.setVisible(false);
			pWykres.setVisible(false);
			this.repaint();
		} else if (zrudlo == bDodawanie) {
			pTable.setVisible(false);
			pDodaj.setVisible(true);
			pWykres.setVisible(false);
			this.repaint();
		} else if (zrudlo == bWykres) {
//			pTable.setVisible(false);
//			pDodaj.setVisible(false);
//			pWykres.setVisible(true);
			this.repaint();
			new Wykres(baza);
		} else if (zrudlo == bDodawanieDoBazy) {
			dodajrekord();
			this.repaint();
		} else if (zrudlo == bUsunZBazy) {
			usunrekord();
			this.repaint();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int id = e.getKeyCode();
		if (id == KeyEvent.VK_ESCAPE) {
			dispose();
		} else if (id == KeyEvent.VK_ENTER && pDodaj.isVisible()) {
			dodajrekord();
			this.repaint();
		}

	}

	@Override
	public void keyReleased(KeyEvent evt) {

		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}

/**
 * Klasa s³u¿¹ca do zabezpieczenia JTextArea przed wprowadzeniem czegoœ innego
 * ni¿ liczba
 */
class MyIntFilter extends DocumentFilter {
	@Override
	public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
			throws BadLocationException {

		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		sb.append(doc.getText(0, doc.getLength()));
		sb.insert(offset, string);

		if (test(sb.toString())) {
			super.insertString(fb, offset, string, attr);
		} else {
			// warn the user and don't allow the insert
		}
	}

	private boolean test(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
			throws BadLocationException {

		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		sb.append(doc.getText(0, doc.getLength()));
		sb.replace(offset, offset + length, text);

		if (test(sb.toString())) {
			super.replace(fb, offset, length, text, attrs);
		} else {
			// warn the user and don't allow the insert
		}

	}

	@Override
	public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		sb.append(doc.getText(0, doc.getLength()));
		sb.delete(offset, offset + length);

		if (test(sb.toString())) {
			super.remove(fb, offset, length);
		} else {
			// warn the user and don't allow the insert
		}

	}
}
