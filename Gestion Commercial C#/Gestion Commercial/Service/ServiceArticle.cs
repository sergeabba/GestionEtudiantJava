using Gestion_Commercial.EntityFW;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gestion_Commercial.ServiceEntityFW
{
    class ServiceArticle
    {
        private gestion_commercialEntities4 ctx = new gestion_commercialEntities4();

        public bool CreerArticle(article article)
        {
            ctx.article.Add(article);
            return ctx.SaveChanges() != 0;
        }

        public List<article> ListerArticle()
        {
            return ctx.article.ToList();
        }


    }
}
