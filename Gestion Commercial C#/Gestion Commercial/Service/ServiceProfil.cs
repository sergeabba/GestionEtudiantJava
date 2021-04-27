using Gestion_Commercial.EntityFW;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gestion_Commercial.ServiceEntityFW
{
    class ServiceProfil
    {

        private gestion_commercialEntities4 ctx = new gestion_commercialEntities4();       

        public bool CreerProfil(profil profil)
        {
            ctx.profil.Add(profil);
            return ctx.SaveChanges() != 0;
        }
        
        public List <profil> ListerProfil()
        {
            return ctx.profil.ToList();
        }
       
    }
}
