using Gestion_Commercial.EntityFW;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gestion_Commercial.Service
{
    class ServiceCommande
    {

        private gestion_commercialEntities4 ctx = new gestion_commercialEntities4();

        public bool CreerCommande(commande commande)
        {
            ctx.commande.Add(commande);
            return ctx.SaveChanges() != 0;
        }
    }
}
