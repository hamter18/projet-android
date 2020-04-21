/**Importation du package */
package iut.reignrise.projet.Metiers;

/**
 * Classe permettant de stocker et manipuler des scores
 */
public class Score {

    /**
     * @param idScore : permet de conserver l'identifiant de score
     * @param pseudo : permet de conserver le pseudo d'un joueur
     * @param score : permet de conserver le score d'un joueur
     */
    private int idScore;
    private String pseudo;
    private int score;

    /**
     * Constructeur de score
     */
    public Score(){
        idScore=0;
        pseudo="";
        score=0;
    }

    /**
     * Constructeur de score
     * @param idScore
     * @param pseudo
     * @param score
     */
    public Score(int idScore, String pseudo, int score) {
        this.idScore = idScore;
        this.pseudo=pseudo;
        this.score=score;
    }


    public void setIdScore(int idScore) {
        this.idScore = idScore;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "idScore=" + idScore +
                ", pseudo='" + pseudo + '\'' +
                ", score=" + score +
                '}';
    }
}
