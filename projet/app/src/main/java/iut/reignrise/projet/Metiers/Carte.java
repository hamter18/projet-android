/**Importation du package */
package iut.reignrise.projet.Metiers;

/**Autres importations*/
import java.util.Arrays;


/**
 * Classe permettant de conserver les données liés aux cartes
 */
public class Carte {
    /**
     * @param id_cartes : conserve l'identifiant de la carte
     * @param name : nom de la carte
     * @param img : permet de stocker l'image de la carte
     * @param dilemme : indique le dilemme de la carte
     * @param influences : tableau contenant la façon dont vont être influencées les jauges
     */
    private int id_carte;
    private String name;
    private int img;
    private String dilemme;
    private int[] influences;

    /**
     * Constructeur de carte
     */
    public Carte(){
        this.id_carte=0;
        this.name="";
        this.img=0;
        this.dilemme="";
        this.influences = new int[3];
    }

    /**
     * Constructeur de cartes
     * @param id
     * @param name
     * @param img
     * @param dilemme
     * @param influences
     */
    public Carte(int id,String name, int img, String dilemme, int[] influences){
        this.id_carte=id;
        this.name=name;
        this.img=img;
        this.dilemme=dilemme;
        this.influences=influences;
    }

    public String getName() {return name;}
    public int getImg() { return img;}
    public String getDilemme() {return dilemme;}
    public int[] getInfluences() {return influences;}
    public void setDilemme(String dilemme) {this.dilemme = dilemme;}
    public void setId_carte(int id_carte) {this.id_carte = id_carte;}
    public void setImg(int img) {this.img = img;}
    public void setName(String name) {this.name = name;}
    public void setInfluences(int[] influences) {this.influences = influences;}

    @Override
    public String toString() {
        return "Carte{" +
                "id_carte=" + id_carte +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", dilemme='" + dilemme + '\'' +
                ", influences=" + Arrays.toString(influences) +
                '}';
    }
}
