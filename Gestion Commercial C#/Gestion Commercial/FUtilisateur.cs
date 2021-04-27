using Gestion_Commercial.ServiceEntityFW;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Gestion_Commercial.Service;
using Gestion_Commercial.EntityFW;

namespace Gestion_Commercial
{  
    public partial class FUtilisateur : Form
    {
        ServiceUtilisateur metier = new ServiceUtilisateur();

        private ServiceProfil metierEntity = new ServiceEntityFW.ServiceProfil();

        public FUtilisateur()
        {
            InitializeComponent();
        }
       
        private void FUtilisateur_Load(object sender, EventArgs e)
        {
            LoadDataGridView();
            cmbProfil.DataSource = metierEntity.ListerProfil();
            cmbProfil.DisplayMember = "Libelle";
            cmbProfil.ValueMember = "id";
        }      

        private void btnEnregistrer_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textLogin.Text))
            {
                MessageBox.Show("le libellé est obligatoires", "Message Erreur", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                utilisateur utilisateur = new utilisateur()
                {
                    login = textLogin.Text.Trim(),
                    pwd = textPwd.Text.Trim(),
                    prenom = textPrenom.Text.Trim(),
                    nom = textNom.Text.Trim(),
                    profil_id = int.Parse(cmbProfil.SelectedValue.ToString())
                };
                if (metier.CreerUtilisateur(utilisateur))
                {
                    MessageBox.Show("Article créer avec succès", "Message Information", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    textLogin.Clear();
                    textPwd.Clear();
                    textPrenom.Clear();
                    textNom.Clear();                    

                    LoadDataGridView();

                }
            }
        }
        private void LoadDataGridView()
        {
            dgvUsers.DataSource = metier.ListerUtilisateur();
        }
    }
}
