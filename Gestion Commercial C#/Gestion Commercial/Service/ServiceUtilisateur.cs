using Gestion_Commercial.EntityFW;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gestion_Commercial.Service
{
    class ServiceUtilisateur
    {
        private gestion_commercialEntities4 ctx = new gestion_commercialEntities4();

        public bool CreerUtilisateur(utilisateur utilisateur)
        {
            ctx.utilisateur.Add(utilisateur);
            return ctx.SaveChanges() != 0;
        }

        public List<utilisateur> ListerUtilisateur()
        {
            return ctx.utilisateur.ToList();
        }
    }
}
