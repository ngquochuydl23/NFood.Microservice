
using Microsoft.EntityFrameworkCore;
using NFood.User.Service.Infrastructure.Entities.Users;
using System.Reflection.Emit;

namespace NFood.User.Service.Api.Infrastructure
{
    public class NFoodUserDbContext : DbContext
    {
        public NFoodUserDbContext(DbContextOptions<NFoodUserDbContext> options) : base(options)
        {
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.AddUserEntities();
        }
    }
}
