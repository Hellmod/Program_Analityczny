package aplikacja;

import static java.lang.Math.sqrt;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Rysuj extends JComponent {

	BazaDanych baza;
	/**
	 * wielkoœæ ma³ego kwadratu
	 */
	private int MalyKwadrat = 25;
	/**
	 * minimalna wielkoœæ du¿ego kwadratu tak ¿eby zmieœci³ siê opis kolumn i wierszy
	 */
	private int DurzyKwadrat = 75;
	/**
	 * wielkoœæ du¿ego kwadratu
	 */
	private int WielkoscDKwadratu = (int) Math.ceil(DurzyKwadrat / MalyKwadrat);
	/**
	 * tablica zawieraj¹ca liczbê ma³ych kwadratów w jednym polu
	 */
	private int[][] wielkosc;
	/**
	 * tablica zawieraj¹ca wartoœci id 
	 */
	private int[][][] id;
	/**
	 * tablica zawieraj¹ca Du¿e kwadraty 
	 */
	private Kwadrat[][] DKwadrat = new Kwadrat[5][5];
	/**
	 * tablica zawieraj¹ca Ma³e kwadraty 
	 */
	private Kwadrat[][][] MKwadrat;

	private Color czerwony = new Color(255, 0, 0);
	private Color pomaranczowy = new Color(255, 165, 0);
	private Color zielony = new Color(0, 255, 0);
	private Color zolty = new Color(255, 255, 0);

	public Rysuj(BazaDanych baza) {

		this.baza = baza;
		czytajBaze();

		WielkoscDKwadratu = (int) Math.ceil(sqrt(WielkoscDKwadratu));
		WielkoscDKwadratu *= MalyKwadrat;
		if (WielkoscDKwadratu < 100)
			WielkoscDKwadratu = 100;
		dodajDoTablicy();

	}

	/**
	 * Ustala rozmieszcenie poszczególnych kwadratów.
	 * Wype³nia tabelê danymi :<p>
	 * DKwadrat- tablica 2 zawieraj¹ca du¿e kwadraty
	 * MKwadrat- tablica 3 zawieraj¹ca ma³e kwadraty
	 */
	private void dodajDoTablicy() {
//spring cpp sys zarzadzania framework js jango paiton bash assembler do 16 


		DKwadrat[0][0] = new Kwadrat(0, 0, WielkoscDKwadratu, new Color(255, 255, 255), "Prawdopodobne");
		DKwadrat[1][0] = new Kwadrat(0, WielkoscDKwadratu, WielkoscDKwadratu, new Color(255, 255, 255), "Œrednie");
		DKwadrat[2][0] = new Kwadrat(0, WielkoscDKwadratu * 2, WielkoscDKwadratu, new Color(255, 255, 255), "Ma³o Prawdopodobne");
		DKwadrat[3][0] = new Kwadrat(0, WielkoscDKwadratu * 3, WielkoscDKwadratu, new Color(255, 255, 255), "Rzadkie");
		DKwadrat[4][0] = new Kwadrat(0, WielkoscDKwadratu * 4, WielkoscDKwadratu, new Color(255, 255, 255));

		DKwadrat[4][1] = new Kwadrat(WielkoscDKwadratu, WielkoscDKwadratu * 4, WielkoscDKwadratu, new Color(255, 255, 255), "Nieznaczne");
		DKwadrat[4][2] = new Kwadrat(WielkoscDKwadratu * 2, WielkoscDKwadratu * 4, WielkoscDKwadratu, new Color(255, 255, 255), "Ma³e");
		DKwadrat[4][3] = new Kwadrat(WielkoscDKwadratu * 3, WielkoscDKwadratu * 4, WielkoscDKwadratu, new Color(255, 255, 255), "Œrednie");
		DKwadrat[4][4] = new Kwadrat(WielkoscDKwadratu * 4, WielkoscDKwadratu * 4, WielkoscDKwadratu, new Color(255, 255, 255), "Powa¿ne");

		DKwadrat[0][1] = new Kwadrat(WielkoscDKwadratu, 0, WielkoscDKwadratu, zolty);
		DKwadrat[1][1] = new Kwadrat(WielkoscDKwadratu, WielkoscDKwadratu, WielkoscDKwadratu, zolty);
		DKwadrat[2][1] = new Kwadrat(WielkoscDKwadratu, WielkoscDKwadratu * 2, WielkoscDKwadratu, zielony);
		DKwadrat[3][1] = new Kwadrat(WielkoscDKwadratu, WielkoscDKwadratu * 3, WielkoscDKwadratu, zielony);

		DKwadrat[0][2] = new Kwadrat(WielkoscDKwadratu * 2, 0, WielkoscDKwadratu, pomaranczowy);
		DKwadrat[1][2] = new Kwadrat(WielkoscDKwadratu * 2, WielkoscDKwadratu, WielkoscDKwadratu, zolty);
		DKwadrat[2][2] = new Kwadrat(WielkoscDKwadratu * 2, WielkoscDKwadratu * 2, WielkoscDKwadratu, zolty);
		DKwadrat[3][2] = new Kwadrat(WielkoscDKwadratu * 2, WielkoscDKwadratu * 3, WielkoscDKwadratu, zielony);

		DKwadrat[0][3] = new Kwadrat(WielkoscDKwadratu * 3, 0, WielkoscDKwadratu, czerwony);
		DKwadrat[1][3] = new Kwadrat(WielkoscDKwadratu * 3, WielkoscDKwadratu, WielkoscDKwadratu, pomaranczowy);
		DKwadrat[2][3] = new Kwadrat(WielkoscDKwadratu * 3, WielkoscDKwadratu * 2, WielkoscDKwadratu, zolty);
		DKwadrat[3][3] = new Kwadrat(WielkoscDKwadratu * 3, WielkoscDKwadratu * 3, WielkoscDKwadratu, zolty);

		DKwadrat[0][4] = new Kwadrat(WielkoscDKwadratu * 4, 0, WielkoscDKwadratu, czerwony);
		DKwadrat[1][4] = new Kwadrat(WielkoscDKwadratu * 4, WielkoscDKwadratu, WielkoscDKwadratu, czerwony);
		DKwadrat[2][4] = new Kwadrat(WielkoscDKwadratu * 4, WielkoscDKwadratu * 2, WielkoscDKwadratu, pomaranczowy);
		DKwadrat[3][4] = new Kwadrat(WielkoscDKwadratu * 4, WielkoscDKwadratu * 3, WielkoscDKwadratu, zolty);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int szerokosc = 0, wyskokosc = 0;

				for (int k = 0; k < MKwadrat[i][j].length; k++) {
					if (MKwadrat[i][j][k] == null) {
						Integer n = id[i][j][k];
						int x, y;
						if (szerokosc > WielkoscDKwadratu - 1) {
							wyskokosc += MalyKwadrat;
							szerokosc = 0;
						}

						x = j * WielkoscDKwadratu + wyskokosc + WielkoscDKwadratu;
						y = i * WielkoscDKwadratu + szerokosc;

						MKwadrat[i][j][k] = new Kwadrat(x, y, MalyKwadrat, new Color(255, 255, 255), n.toString());
						szerokosc += MalyKwadrat;
					}

				}
			}
		}

	}
	/**
	 * Wype³nia tabelê danymi:<p>
	 * wielkosc- tablica 2 wymiarowa mówi¹ca ile ma³ych kwadratów nale¿y zmieœciæ w jednym polu <br>
	 * id- tablica 3 wymiarowa z wartoœciami id <br>
	 * MKwadrat- nadaje odpowiedni rozmiar tablicy
	 */
	private void czytajBaze() {
		id = new int[4][4][];
		MKwadrat = new Kwadrat[5][5][];
		wielkosc = new int[4][4];

		for (int i = 0; i < baza.rekordy.size(); i++) {
			wielkosc[4 - baza.rekordy.get(i).getPrawdopodobienstow()][baza.rekordy.get(i).getZagrozenie() - 1]++;

		}

//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print(wielkosc[i][j] + "|");
//			}
//			System.out.println();
//		}
//		System.out.println("___________________");

		// zerowanie id
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int k = wielkosc[i][j];
				id[i][j] = new int[k];
				if (k > WielkoscDKwadratu)
					WielkoscDKwadratu = k;
				for (int l = 0; l < k; l++) {
					id[i][j][l] = -1;
				}
			}
		}
		
		// serowanie MKwadrat
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int k = wielkosc[i][j];
				MKwadrat[i][j] = new Kwadrat[k];
				for (int l = 0; l < k; l++) {
					MKwadrat[i][j][l] = null;
				}
			}
		}

		for (int i = 0; i < baza.baza.size(); i++) {
			int a = 4 - baza.rekordy.get(i).getPrawdopodobienstow();
			int b = baza.rekordy.get(i).getZagrozenie() - 1;
			for (int j = 0; j < id[a][b].length; j++) {
				if (id[a][b][j] == -1) {
					id[a][b][j] = baza.rekordy.get(i).getId();
					break;
				}
			}

		}

//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				for (int k = 0; k < id[i][j].length; k++) {
//					System.out.print(id[i][j][k] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("_____________");
//		}

	}
	/**
	 * funkcja rysuj¹ca ;)
	 */
	public void paint(Graphics g) {

		for (int i = 0; i < DKwadrat.length; i++) {
			for (int j = 0; j < DKwadrat.length; j++) {
				if (DKwadrat[i][j] != null)
					DKwadrat[i][j].print(g);
			}
		}

		for (int i = 0; i < DKwadrat.length - 1; i++) {
			for (int j = 0; j < DKwadrat.length - 1; j++) {
				for (int k = 0; k < MKwadrat[i][j].length; k++) {
					if (MKwadrat[i][j][k] != null)
						MKwadrat[i][j][k].print(g);
				}

			}
		}

	}

}
