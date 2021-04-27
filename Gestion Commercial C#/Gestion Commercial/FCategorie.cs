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
    public partial class FCategorie : Form
    {

        ServiceCategorie metier = new ServiceCategorie();

        public FCategorie()
        {
            InitializeComponent();
        }                                        

        private void btnAjouter_Click_1(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textLibelle.Text))
            {
                MessageBox.Show("le libellé est obligatoires", "Message Erreur", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                categorie categorie = new categorie()
                {
                    libelle = textLibelle.Text.Trim(),
                };
                if (metier.CreerCategorie(categorie))
                {
                    MessageBox.Show("Catégorie créer avec succès", "Message Information", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    textLibelle.Clear();


                    LoadDataGridView();

                }
            }
        }
        private void LoadDataGridView()
        {
            dgvCategorie.DataSource = metier.ListerCategorie();
        }

        private void FCategorie_Load(object sender, EventArgs e)
        {
            LoadDataGridView();
        }
    }
}
