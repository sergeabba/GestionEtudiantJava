using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Gestion_Commercial
{
    public partial class FMenu : Form
    {
        public FMenu()
        {
            InitializeComponent();
        }
        
        private void ajouterEtListerToolStripMenuItem_Click(object sender, EventArgs e)
        {
            LoadFProfil();
        }

        private void LoadFProfil()
        {
            EffacerFormFils();
            FProfil creerProfil = new FProfil();
            creerProfil.MdiParent = this;
            creerProfil.Show();
        }

        private void ajouterEtListerToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            LoadFUtilisateur();
        }

        private void LoadFUtilisateur()
        {
            EffacerFormFils();
            FUtilisateur enregistrerUtilisateur = new FUtilisateur();
            enregistrerUtilisateur.MdiParent = this;
            enregistrerUtilisateur.Show();
        }

        private void ajouterEtListerToolStripMenuItem2_Click(object sender, EventArgs e)
        {
            LoadFArticle();
        }

        private void LoadFArticle()
        {
            EffacerFormFils();
            FArticle creerArticle = new FArticle();
            creerArticle.MdiParent = this;
            creerArticle.Show();
        }



        private void EffacerFormFils()
        {
            foreach (Form form in this.MdiChildren)
            {
                form.Close();
            }
        }

        private void ajouterEtListerToolStripMenuItem3_Click(object sender, EventArgs e)
        {
            LoadFCategorie();
        }
        private void LoadFCategorie()
        {
            EffacerFormFils();
            FCategorie creerCategorie = new FCategorie();
            creerCategorie.MdiParent = this;
            creerCategorie.Show();
        }

        private void ajouterEtListerToolStripMenuItem4_Click(object sender, EventArgs e)
        {
            LoadFCommande();
        }
        private void LoadFCommande()
        {
            EffacerFormFils();
            FCommande creerCommande = new FCommande();
            creerCommande.MdiParent = this;
            creerCommande.Show();
        }       
    }
}
