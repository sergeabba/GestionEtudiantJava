using Gestion_Commercial.Service;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Gestion_Commercial.EntityFW;

namespace Gestion_Commercial
{
    public partial class FCommande : Form
    {

        ServiceCommande metier = new ServiceCommande();
        ServiceClient metierCli = new ServiceClient();

        public FCommande()
        {
            InitializeComponent();
        }       

        private void btnAjouter_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textNumero.Text))
            {
                MessageBox.Show("le numéro est obligatoires", "Message Erreur", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                commande commande = new commande()
                {
                    numero = int.Parse(textNumero.Text.Trim()),
                    date = int.Parse(textDate.Text.Trim()),
                };
                if (metier.CreerCommande(commande))
                {
                    MessageBox.Show("Commande créer avec succès", "Message Information", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    textNumero.Clear();
                    textDate.Clear();                                     

                }
            }
        }

        private void btnEnregistrer_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textNom.Text                
                ))
            {
                MessageBox.Show("le Champs sont obligatoires", "Message Erreur", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                client client = new client()
                {                   
                    prenom = textPrenom.Text.Trim(),
                    nom = textNom.Text.Trim(),
                    tel = int.Parse(textTel.Text.Trim()),                   

                };
                if (metierCli.CreerClient(client))
                {
                    MessageBox.Show("Client Enregistrer avec succès", "Message Information", MessageBoxButtons.OK, MessageBoxIcon.Information);                   
                    textPrenom.Clear();
                    textNom.Clear();
                    textTel.Clear();
                    textAdresse.Clear();


                }
            }
        }
    }
}
