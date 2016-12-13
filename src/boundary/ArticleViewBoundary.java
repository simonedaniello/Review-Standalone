package boundary;

/**
 * Created by dandi on 13/12/16.
 */
public class ArticleViewBoundary {

    private static ArticleViewBoundary instance = new ArticleViewBoundary();

    private ArticleViewBoundary(){

    }

    public static ArticleViewBoundary getInstance(){
        return instance;
    }
}
