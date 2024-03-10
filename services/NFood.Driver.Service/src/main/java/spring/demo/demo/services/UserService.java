package spring.demo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import spring.demo.demo.entity.Driver;
import spring.demo.demo.repository.DriverRepository;
import spring.demo.demo.security.CustomUserService;

public class UserService implements UserDetailsService {
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Driver driver = driverRepository.findByPhone(username).orElse(null);
        if (driver == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserService((driver));
    }

}
