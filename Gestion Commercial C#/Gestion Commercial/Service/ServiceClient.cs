using Gestion_Commercial.EntityFW;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gestion_Commercial.Service
{
    class ServiceClient
    {
        private gestion_commercialEntities4 ctx = new gestion_commercialEntities4();

        public bool CreerClient(client client)
        {
            ctx.client.Add(client);
            return ctx.SaveChanges() != 0;
        }
    }
}
