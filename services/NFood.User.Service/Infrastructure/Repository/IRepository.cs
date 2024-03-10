using NFood.User.Service.Api.Infrastructure;

namespace NFood.User.Service.Infrastructure.Repository
{
    public interface IRepository<TEntity>
    {
        TEntity Find(long? key);

        TEntity Insert(TEntity entity);

        TEntity Update(long key, TEntity entity);

        void Delete(long key);

        IQueryable<TEntity> GetQueryableNoTracking();

        IQueryable<TEntity> GetQueryable();

        NFoodUserDbContext DbContext();

        void SaveChanges();

    }
}
