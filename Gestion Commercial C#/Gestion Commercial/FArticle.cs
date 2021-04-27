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
using Gestion_Commercial.Service;
using Gestion_Commercial.ServiceEntityFW;

namespace Gestion_Commercial
{
    public partial class FArticle : Form
    {


        ServiceArticle metier = new ServiceArticle();

        private ServiceCategorie metierEntity = new Service.ServiceCategorie();

        public FArticle()
        {
            InitializeComponent();
        }

        private void LoadDataGridView()
        {
            dgvArticle.DataSource = metier.ListerArticle();
        }

        private void FArticle_Load_1(object sender, EventArgs e)
        {
            LoadDataGridView();
            cmbCat.DataSource = metierEntity.ListerCategorie();
            cmbCat.DisplayMember = "Libelle";
            cmbCat.ValueMember = "id";
        }

        private void dgvArticle_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void btnAjouter_Click_1(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textReference.Text))
            {
                MessageBox.Show("le libellé est obligatoires", "Message Erreur", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                article article = new article()
                {
                    reference = textReference.Text.Trim(),
                    libelle = textLibelle.Text.Trim(),
                    stock = int.Parse(textStock.Text.Trim()),
                    prix = int.Parse(textPrix.Text.Trim()),
                    categorie_id = int.Parse(cmbCat.SelectedValue.ToString())
                };
                if (metier.CreerArticle(article))
                {
                    MessageBox.Show("Article créer avec succès", "Message Information", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    textReference.Clear();
                    textLibelle.Clear();
                    textStock.Clear();
                    textPrix.Clear();
                    //textCategorie.Clear();


                    LoadDataGridView();

                }
            }
        }
    }
}
