using Gestion_Commercial.EntityFW;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gestion_Commercial.ServiceEntityFW
{
    interface IService <profil,utilisateur,commande,article,categorie,client>
    {
        bool CreerProfil(profil profil);
        bool CreerUser(utilisateur utilisateur);
        bool CreerArticle(article article);
        bool CreerCategorie(categorie categorie);
        bool AjouterCommande(commande commance);
        bool AjouterClient(client client);
        utilisateur seConnecter(String login, String pwd);
        List<profil> ListerProfil();
        List<article> ListerArticle();
        List<utilisateur> ListerUtilisateur();
        List<categorie> ListerCategorie();
        DataTable ListerCommandeParTel(int telephone);
        DataTable ListerCommandeParRef(int reference);

    }
}
