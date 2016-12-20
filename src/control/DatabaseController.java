package control;

import databaseINIT.Provider;
import entity.Review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author dandi on 13/12/16.
 */
class DatabaseController {

    private static DatabaseController instance = new DatabaseController();
    private static Provider provider = new Provider();

    private DatabaseController(){

    }

    static DatabaseController getInstance(){
        return instance;
    }

    boolean setReview(Review review){
        String sql = "INSERT INTO ARTICLES.recensione (SEGNALAZIONE, UTENTE, ARTICOLO, PROPRIETARIO, TESTO, RAITNG, TOCHECK) VALUES ("+
                review.isWarning() +", '" + review.getUser()+"', '" +
                review.getArticle()+"', '"+ review.getOwner() +"' , '" + review.getReview()+
                "' , '" + review.getRating()+"' , 'TRUE')";

        try {
            Statement stmt = provider.getConnection().createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

}
