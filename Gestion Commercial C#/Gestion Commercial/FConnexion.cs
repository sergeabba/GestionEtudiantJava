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
using Gestion_Commercial.EntityFW;

namespace Gestion_Commercial
{
    public partial class FConnexion : Form
    {
        ServiceSeConnecter metier = new ServiceSeConnecter();

        public FConnexion()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textLogin.Text)
               || string.IsNullOrEmpty(textPwd.Text))
            {
                labelError.Text = "Login ou Mots de Passe Obligatoire";
                labelError.Visible = true;
            }
            else
            {
                utilisateur utilisateur = metier.seConnecter(textLogin.Text.Trim(), textPwd.Text.Trim());
                if (utilisateur == null)
                {
                    labelError.Text = "Login ou Mots de Passe Incorrecte";
                    labelError.Visible = true;
                }
                else
                {
                    FMenu frmenu = new FMenu();
                    frmenu.Show();
                    this.Hide();
                }

            }
        }       

        private void btnAnnuler_Click_1(object sender, EventArgs e)
        {
            textLogin.Clear();
            textPwd.Clear();
        }

        private void FConnexion_Load_1(object sender, EventArgs e)
        {
            labelError.Visible = false;
        }

        private void FConnexion_FormClosed_1(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }
    }
}
