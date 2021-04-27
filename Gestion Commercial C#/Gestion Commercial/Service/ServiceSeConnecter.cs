using Gestion_Commercial.EntityFW;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gestion_Commercial.ServiceEntityFW
{
    class ServiceSeConnecter
    {
        private gestion_commercialEntities4 ctx = new gestion_commercialEntities4();

        public utilisateur seConnecter(string login, string pwd)
        {
            return ctx.utilisateur.Where
                (
                    (p) => login.CompareTo(login) == 0 && p.pwd.CompareTo(pwd) == 0
                ).FirstOrDefault();
        }
    }
}
