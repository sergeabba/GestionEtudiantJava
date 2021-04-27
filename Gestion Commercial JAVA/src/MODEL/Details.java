/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author serge abba
 */
public class Details {
    private Commande commande;
    private Article article;
    private int qte;
    private int prix;
    private int montant;

    public Details() {
    }

    public Details(Commande commande, Article article, int qte, int prix, int montant) {
        this.commande = commande;
        this.article = article;
        this.qte = qte;
        this.prix = prix;
        this.montant = montant;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Article getArticle() {
        return article;
    }

    public void setArtcle(Article article) {
        this.article = article;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Details{" + "commande=" + commande + ", article=" + article + ", qte=" + qte + ", prix=" + prix + ", montant=" + montant + '}';
    }

    
    
}