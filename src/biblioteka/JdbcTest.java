package biblioteka;

import java.util.List;

import model.Zagrozenie;
import model.Uzytkownicy;
import biblioteka.Biblioteka;

public class JdbcTest {

    public static void main(String[] args) {
        Biblioteka b = new Biblioteka();
        b.insertZagrozenia("Tsunami", 1, 1, 4, "dużo wody");
        b.insertZagrozenia("Tsunami", 1, 1, 4, "dużo wody");
        b.insertZagrozenia("Tsunami", 1, 1, 4, "dużo wody");
        b.insertZagrozenia("Tsunami", 1, 1, 4, "dużo wody");
        
        b.insertUzytkownik("ala", "as");
        b.insertUzytkownik("ala", "as");
        b.insertUzytkownik("ala", "as");
        b.insertUzytkownik("ala", "as");
       

        List<Zagrozenie> rekordy = b.selectRekord();
        List<Uzytkownicy> urzytkownicy = b.selectUzytkownik();

        System.out.println("Lista rekordów: ");
        for(Zagrozenie c: rekordy)
            System.out.println(c);

        System.out.println("Lista urzytkowników:");
        for(Uzytkownicy k: urzytkownicy)
            System.out.println(k);

        b.closeConnection();
    }
}