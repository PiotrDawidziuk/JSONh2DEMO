package pl.piotrdawidziuk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.piotrdawidziuk.domain.User;
import pl.piotrdawidziuk.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> list() {
        return userRepository.findAll();
    }

    public Iterable<User> save(List<User> users) {
        return userRepository.save(users);
    }

}