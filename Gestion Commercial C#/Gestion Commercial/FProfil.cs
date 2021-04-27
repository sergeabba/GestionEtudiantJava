using System;
using Gestion_Commercial.EntityFW;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Gestion_Commercial.ServiceEntityFW;


namespace Gestion_Commercial
{
    public partial class FProfil : Form
    {

        ServiceProfil metier = new ServiceProfil();

        public FProfil()
        {
            InitializeComponent();
        }

        private void btnAjouter_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textLibelle.Text))
            {
                MessageBox.Show("le libellé est obligatoires", "Message Erreur", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                profil profil = new profil()
                {
                    libelle = textLibelle.Text.Trim(),                   
                };
                if (metier.CreerProfil(profil))
                {
                    MessageBox.Show("Classe créer avec succès", "Message Information", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    textLibelle.Clear();                    


                    LoadDataGridView();

                }
            }
        }

        private void FProfil_Load(object sender, EventArgs e)
        {
            LoadDataGridView();
        }

        private void LoadDataGridView()
        {
            dgvProfil.DataSource = metier.ListerProfil();
        }        
    }
}
