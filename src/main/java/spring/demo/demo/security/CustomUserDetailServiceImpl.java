package spring.demo.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.User;

import spring.demo.demo.entity.Driver;
import spring.demo.demo.repository.DriverRepository;

@Component
public class CustomUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Driver driver = driverRepository.findByPhone(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with phone: " + username));

        // Build UserDetails object based on Driver information
        return User.builder()
                .username(driver.getPhone())
                .password(driver.getPassword()) // Assuming you store hashed passwords
                .roles("DRIVER") // Add any roles/authorities as needed
                .build();
    }
}
