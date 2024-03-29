package control;

import databaseINIT.Provider;
import entity.Review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author dandi on 13/12/16.
 */
public class DatabaseController {

    private static DatabaseController instance = new DatabaseController();
    private static Provider provider = new Provider();

    private DatabaseController(){

    }

    public static DatabaseController getInstance(){
        return instance;
    }

    public boolean setReview(Review review) throws ClassNotFoundException {
        String sql = "INSERT INTO ARTICLES.recensione (SEGNALAZIONE, UTENTE, ARTICOLO, PROPRIETARIO, TESTO, RAITNG, TOCHECK) VALUES ("+
                review.isWarning() +", '" + review.getUser()+"', '" +
                review.getArticle()+"', '"+ review.getOwner() +"' , '" + review.getReview()+
                "' , '" + review.getRating()+"' , TRUE)";

        try {
            Statement stmt = provider.getConnection().createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("fallimento");
            return false;
        }
        return true;
    }

    ArrayList<String> getArticles(String sql) throws SQLException, ClassNotFoundException {
        ArrayList<String> articoli = new ArrayList<>();
        Statement stmt = provider.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs != null){
            while(rs.next()){
                articoli.add(rs.getString("NOME"));
                articoli.add(rs.getString("PROPRIETARIO"));
            }
        }
        return articoli;
    }
}
