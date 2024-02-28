using Microsoft.EntityFrameworkCore.Storage;

namespace NFood.User.Service.Infrastructure
{
    public interface IUnitOfWork
    {
        public IDbContextTransaction Begin();

        public void Complete();

        public void Rollback();
    }
}
