﻿using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Storage;
using NFood.User.Service.Api.Infrastructure;
using NFood.User.Service.Infrastructure.Entities.Seedworks;

namespace NFood.User.Service.Infrastructure.Repository
{
    public class Repository<TEntity> : IRepository<TEntity> where TEntity : class
    {

        private readonly NFoodUserDbContext _appDbContext;

        public Repository(NFoodUserDbContext appDbContext)
        {
            _appDbContext = appDbContext;
        }

        public NFoodUserDbContext DbContext() => _appDbContext;
        private DbSet<TEntity> _entity => _appDbContext.Set<TEntity>();
        public virtual IQueryable<TEntity> GetQueryableNoTracking() => _entity.AsNoTracking();

        public virtual IQueryable<TEntity> GetQueryable() => _entity.AsQueryable();

        public virtual void Delete(long key)
        {
            var dbEntity = _entity.Find(key);
            if (dbEntity == null)
                throw new NullReferenceException();

            if (dbEntity is IDeleteEntity)
            {
                var deletedEntity = (IDeleteEntity)dbEntity;
                deletedEntity.IsDeleted = true;
            }
            _appDbContext.Entry(dbEntity).State = EntityState.Modified;
            SaveChange(dbEntity);
        }

        public virtual TEntity Find(long? key)
        {
            return _entity.Find(key);
        }

        public virtual TEntity Insert(TEntity entity)
        {
            if (entity is IHasCreationTime)
            {
                var hasCreationTimeEntity = (IHasCreationTime)entity;
                hasCreationTimeEntity.CreateAt = DateTime.Now;
            }

            _entity.Add(entity);
            _appDbContext.Entry(entity).State = EntityState.Added;

            SaveChange(entity);
            return entity;
        }

        public virtual TEntity Update(long key, TEntity entity)
        {
            if (entity == null)
                throw new NullReferenceException();

            if (entity is ILastUpdatedTime)
            {
                var lastUpdatedTime = (ILastUpdatedTime)entity;
                lastUpdatedTime.LastUpdate = DateTime.Now;
            }
            _appDbContext.Entry(entity).State = EntityState.Modified;
            SaveChange(entity);
            return entity;
        }

        protected virtual void SaveChange(TEntity entity)
        {
            _appDbContext.SaveChanges();
        }

        protected virtual void SaveChanges()
        {
            _appDbContext.SaveChanges();
        }
        void IRepository<TEntity>.SaveChanges()
        {
            SaveChanges();
        }
    }
}
