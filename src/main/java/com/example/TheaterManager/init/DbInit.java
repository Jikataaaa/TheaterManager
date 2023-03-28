package com.example.TheaterManager.init;
import com.example.TheaterManager.models.entities.User;
import com.example.TheaterManager.models.enums.UserRole;
import com.example.TheaterManager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DbInit implements CommandLineRunner {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if(repository.count() == 0){
            User user = User.builder().username("jivko").password(passwordEncoder.encode("jivko")).role(UserRole.ADMIN).build();

            repository.save(user);
        }

    }
}
