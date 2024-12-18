// Déclaration de la classe Film
// "implements Cloneable" permet de clonage des objets

import java.util.Date;

public class Film implements Cloneable {

    // Attributs
    private String titre;
    private String genre;
    private float dureeEnMinutes;
    private float tempsEnMinutes;
    private String realisateurs;
    private Date dateDeSortie;
    private String pays;
    private String isan;
    private String langueOriginale;
    private boolean vfDispo;
    private String langueDeVisionnage;

    // Constructeur classique
    // This. sert à indiquer un objet particulier
    public Film(String titre, String genre, float dureeEnMinutes, float tempsEnMinutes, String realisateurs,
            Date dateDeSortie, String pays, String isan, String langueOriginale, boolean vfDispo, String langueDeVisionnage) {
        this.titre = titre;
        this.genre = genre;
        this.dureeEnMinutes = dureeEnMinutes;
        this.tempsEnMinutes = tempsEnMinutes;
        this.realisateurs = realisateurs;
        this.dateDeSortie = dateDeSortie;
        this.pays = pays;
        this.isan = isan;
        this.langueOriginale = langueOriginale;
        this.vfDispo = vfDispo;
        this.langueDeVisionnage = langueDeVisionnage;
    }

    // Methode toString pour afficher tous les attributs de l'objet
    public String toString() {
        return "Film [titre=" + titre + ", genre=" + genre + ", dureeEnMinutes="
                + dureeEnMinutes + ", tempsEnMinutes=" + tempsEnMinutes + ", realisateurs=" + realisateurs
                + ", dateDeSortie=" + dateDeSortie + ", pays=" + pays + ", isan=" + isan + ", langueOriginale="
                + langueOriginale + ", vfDispo=" + vfDispo + ", langueDeVisionnage=" + langueDeVisionnage +"]";
    }

    public boolean regarder() {
        if (tempsEnMinutes == dureeEnMinutes) {
            System.out.println("Le film est déjà fini");
            return false;
        } else {
            System.out.println("Le film a avancé d'une seconde");
            tempsEnMinutes += 1 / 60;
            return true;
        }
    }

    public boolean stopper() {
        return true;
    }

    public boolean avancer() {
        if (tempsEnMinutes == dureeEnMinutes) {
            System.out.println("Le film est déjà fini");
            return false;
        }else if ( tempsEnMinutes + 5/60 > dureeEnMinutes) {
            System.out.println("Il reste moins de 5 secondes");
            return false;
        } else {
            System.out.println("Le film a avancé de 5 secondes");
            tempsEnMinutes += 5 / 60;
            return true;
        }
    }
    
    public boolean reculer() {
        if (tempsEnMinutes == 0) {
            System.out.println("Le film est déjà au début");
            return false;
        }else if ( tempsEnMinutes - 5/60 < 0) {
            System.out.println("Moins de 5 secondes se sont écoulés depuis le début du film");
            return false;
        } else {
            System.out.println("Le film a reculé de 5 seconde");
            tempsEnMinutes -= 5 / 60;
            return true;
        }
    }

    public boolean revenirAuDebut() {
        if (tempsEnMinutes == 0) {
            System.out.println("Le film est déjà au début");
            return false;
        } else {
            System.out.println("Le film est maintenant revenu au début");
            tempsEnMinutes = 0;
            return true;
        }
    }

    public boolean changerDeLangue() {
        if (vfDispo && langueDeVisionnage != langueOriginale) {
            langueDeVisionnage = langueOriginale;
            System.out.println("Retour à la langue originale");
            return true;
        } else if (vfDispo && langueOriginale != "Français") {
            System.err.println("Le film est maintenant en Français");
            langueDeVisionnage = "Français";
            return true;
        } else {
        System.out.println("Il n'y a pas de VF disponible");
            return false;
        }
    }
}
