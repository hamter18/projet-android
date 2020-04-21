/**Importation du package */
package iut.reignrise.projet.Metiers;

/**Autres importations*/
import java.util.ArrayList;
import java.util.Random;

import iut.reignrise.projet.R;

/**
 * Classe permettant de générer des cartes
 */
public class CreateurCartes {

    /**
     * @param rand : nombre aléatoire pour remplir les tableaux
     */
    private static Random rand = new Random();

    /**
     * Permet d'initialiser de manière aléatoire le tableau d'influences
     * @param tab
     * @return
     */
    private int[] initialiserTab( int tab[]) {
        int nb1 = rand.nextInt(10)+5; /// - grod pour augmenter chance de gagner
        int nb2 = rand.nextInt(10)+5;
        int nb3 = rand.nextInt(5)+5;
        int changement1 = rand.nextInt(2);//1 chance sur 2
        int changement2 = rand.nextInt(10);//1 chance sur 2
        for (int i = 0; i < 3; i++) {
            tab[i] = nb1;
            if (i == 1) {
                tab[i] = nb2;
            }
            if (i == 2) {
                tab[i] = nb3*-1;
            }
        }
        if(changement1==1){
            for (int i = 0; i < 3; i++) {
                tab[i] = tab[i]*-1;
                if (i == 2) {
                    tab[i] = tab[i] + changement2;
                }
            }
        }
        return tab;
    }
/**
 * méthode permettant de remplir un objet ListeCarte
 */
    protected ArrayList<Carte> creerCartes(){
        ArrayList<Carte> listeCarte = new ArrayList<>();
        listeCarte.add(new Carte(1, "Droit", R.drawable.droit_des_femmes, "Voulez-vous donner le droit de vote aux femmes ?", new int[3]));
        listeCarte.add(new Carte(2, "Guerre", R.drawable.guerre, "Les hommes cherchent sans cesse à s'entretuer. Voulez-vous leur en donner les moyens ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(3, "Guerre", R.drawable.orphelin, "C'est la guerre, un groupe d'orphelins vous pris de les aider. Allez-vous leur donner la main ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(4, "Evolution", R.drawable.sorciere, "Les hommes retournent à l'âge de la préhistoire, leur seul moyen pour survivre ? Réussir à faire du feu. Allez-vous leur donner leur chance ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(5, "Evolution", R.drawable.pirate, "Nous sommes dans l'air de la piraterie, des pirates sont perdus en mer en pleine tempête, vas, tu les aider a retourner sain et sauf sur la terre ferme ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(6, "Evolution", R.drawable.jack_l_eventreur, "Vous êtes à Whitechapel en 1888, un tueur en série sévie dans les rues. Vous avez le pouvoir de l'arrêter mais aller vous vraiment le faire ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(7, "Evolution", R.drawable.indiens, "Les Européens voguent sur les océans afin de chercher de nouvelle terre à conquérir, si vous exaucé leurs vœux, cela causerait la mort de millier d'amer-indiens. Qu'allez-vous faire ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(8, "Droit", R.drawable.esclave, "Nous sommes à Rome, alors que la ville est a sont apogé, mais les esclaves sont maltraités et tués par dizaine de millers. Voulez-vous permettre l'instauration d'une loi que vas les protéger ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(9, "Environement", R.drawable.terre, "Les hommes sont en train de détruire la planète. Voulez-vous tous les exterminer pour protéger la planète ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(10, "Sociale", R.drawable.enfants, "Des enfants sont enlevés et tués. Voulez-vous que cela cesse ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(11, "Sociale", R.drawable.animaux, "Voulez-vous que les hommes cessent la chasse ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(12, "Sociale", R.drawable.fete, "Voulez-vous que de nouvelle fêtes nationales soient ajoutées dans le calendrier ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(13, "Santé", R.drawable.virus, "Voulez-vous qu'un virus mortel soit crée ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(14, "Culture", R.drawable.serie_zoo, "Voulez-vous que les animaux deviennent comme dans le film Zoo ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(15, "Culture", R.drawable.la_joconde, "Voulez-vous Léonard de Vinci crée le célèbre tableau 'La Joconde' ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(16, "Divers", R.drawable.pouvoir_magique, "Voulez-vous que le monde dont vous êtes le Dieu dispose de magie ?  ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(17, "Divers", R.drawable.transformation, "Aimeriez-vous que chaque homme sur la terre se transforme en animal ?  ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(18, "Guerre", R.drawable.zombie, "Voulez-vous que les morts reviennent à la vie sous forme de zombie ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(19, "Environement", R.drawable.banquise, "Voulez-vous qu'une nouvelle aire glaciaire commence ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(20, "Société", R.drawable.factions, "Voulez-vous diviser la société en 5 factions ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(21, "Divers", R.drawable.anges_et_demons, "Voulez-vous que des anges et des démons descendent sur Terre ?  ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(22, "Divers", R.drawable.one_open_the_time, "Voulez-vous que les contes de fées deviennent réalité ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(23, "Environement", R.drawable.univers, "Voulez-vous qu'une explosion solaire détruise l'univers ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(24, "Droit", R.drawable.monarchie, "Voulez-vous que la monarchie se ré-installe à travers le monde ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(25, "Société", R.drawable.super_pouvoir, "Voulez-vous que les futurs bébé naissent avec des supers pouvoirs ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(26, "Divers", R.drawable.dieux, "Voulez-vous que d'autres Dieux concurrents apparaissent ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(27, "Divers", R.drawable.enfer, "Voulez-vous que le diable marche sur la terre ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(28, "Droit", R.drawable.esclave_all, "Voulez-vous réduire tous les hommes au niveau d'esclave ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(29, "Société", R.drawable.technologie, "Voulez-vous que les hommes ne découvre jamais les bienfaits de la technologie ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(30, "Société", R.drawable.ecole, "Voulez-vous que l'école soit obligatoire pour tous les enfants ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(31, "Société", R.drawable.psycho_pass, "Voulez-vous mettre en place un système dans lequel les capacités d'une personne détermine son métiers et son rang ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(32, "Société", R.drawable.desert, "Voulez-vous que la température augmente de 30 degrès sur l'ensemble de la terre ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(33, "Société", R.drawable.criminalite, "Voulez-vous que la criminalité augmente à travers le monde ?  ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(34, "Société", R.drawable.nuit, "Voulez-vous que le jour n'existe plus ? C'est-à-dire qu'il y ai une nuit perpétuelle sur le monde ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(35, "Société", R.drawable.jour, "Voulez-vous un jour perpétuel sur le monde ? C'est-à-dire qu'il n'y est plus de nuit ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(36, "Social", R.drawable.tristesse, "Voulez-vous entrainer une grande vague de tristesse sur le monde en empéchant les gens d'être heureux ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(37, "Société", R.drawable.vivre, "Voulez-vous que tous les hommes puissent vivre éternellement ?  ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(38, "Société", R.drawable.robot, "Voulez-vous que des robots prennent le pouvoir sur le monde ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(39, "Société", R.drawable.homme_vs_femme, "Voulez-vous que tous les Hommes changent de sexe ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(40, "Divers", R.drawable.reve, "Voulez-vous permettre que tous les rêves deviennent réalité ?  ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(41, "Santé", R.drawable.cancers, "Voulez-vous permettre aux hommes de trouver le remède contre le cancer ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(42, "Divers", R.drawable.estratereste, "Voulez-vous que des extraterestres envahissent la Terre ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(43, "Environnement", R.drawable.sauterelle, "Voulez-vous que des sauterelles détruisent l'ensemble des cultures du monde ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(44, "Environnement", R.drawable.castastrophe, "Voulez-vous que des catastrophes naturelles surviennent ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(45, "Evolution", R.drawable.elevation, "Voulez-vous que les Hommes atteignent un état supérieur ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(46, "Evolution", R.drawable.avenir, "Voulez-vous que les Hommes aquièrent la capacité de voir l'avenir ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(47, "Société", R.drawable.gentil, "Voulez-vous que tous les Hommes deviennent des personnes pacifiques ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(48, "Environnement", R.drawable.ville_vs_foret, "Voulez-vous mettre transformer chaque ville en forêt ? ", initialiserTab(new int[3])));
        listeCarte.add(new Carte(49, "Social", R.drawable.mal, "Voulez-vous que tout le mal disparaisse de la Terre ?", initialiserTab(new int[3])));
        listeCarte.add(new Carte(50, "Social", R.drawable.entente, "Voulez-vous que les Hommes se comprennent tous enfin ? ", initialiserTab(new int[3])));
        return listeCarte;
    }
}
