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
public class Commande {
    private int numero;
    private int date;
    private Client client;

    public Commande() {
    }        

    public Commande(int numero, int date, Client client) {
        this.numero = numero;
        this.date = date;
        this.client = client;
    }

    public Commande(int numero, int date) {
        this.numero = numero;
        this.date = date;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Commande{" + "numero=" + numero + ", date=" + date + ", client=" + client + '}';
    }
    
    
    
}
