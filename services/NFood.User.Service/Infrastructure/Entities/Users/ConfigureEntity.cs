using Microsoft.EntityFrameworkCore;
using NFood.User.Service.Infrastructure.Entities.Users;

namespace NFood.User.Service.Infrastructure.Entities.Users
{
    public static class ConfigureEntity
    {
        public static void AddUserEntities(this ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<UserEntity>(entity =>
            {
                entity.ToTable("User");
                entity.HasKey(x => x.Id);
            });

        }
    }
}
