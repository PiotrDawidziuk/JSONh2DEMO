package pl.piotrdawidziuk.repository;

import org.springframework.data.repository.CrudRepository;

import pl.piotrdawidziuk.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {



}