using Gestion_Commercial.EntityFW;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gestion_Commercial.Service
{
    class ServiceCategorie
    {
        private gestion_commercialEntities4 ctx = new gestion_commercialEntities4();

        public bool CreerCategorie(categorie categorie)
        {
            ctx.categorie.Add(categorie);
            return ctx.SaveChanges() != 0;
        }

        public List<categorie> ListerCategorie()
        {
            return ctx.categorie.ToList();
        }
    }
}
