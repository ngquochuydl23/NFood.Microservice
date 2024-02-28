using NFood.User.Service.Infrastructure.Entities.Seedworks;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;

namespace NFood.User.Service.Infrastructure.Entities.Users
{
    public class UserEntity : Entity<long>
    {
        [NotNull]
        public string FullName { get; set; }

        [NotNull]
        public string PhoneNumber { get; set; }

        [NotNull]
        public string Email { get; set; }

        [NotNull]
        public string HashPassword { get; set; }

        public DateTime Birthday { get; set; }

        public DateTime LastLogin { get; set; }

        public int? Gender { get; set; }

        public string? Avatar { get; set; }

        public string Role { get; set; } = "Customer";
    }
}
