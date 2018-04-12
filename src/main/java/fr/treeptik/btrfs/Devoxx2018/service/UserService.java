package fr.treeptik.btrfs.Devoxx2018.service;

import javax.transaction.Transactional;

import fr.treeptik.btrfs.Devoxx2018.domain.FanType;
import fr.treeptik.btrfs.Devoxx2018.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public Long countUser() {
        return userRepository.count();
    }

    public Long countUserByFanType(FanType fanType) {
        return userRepository.compter(fanType);
    }

    @Transactional
    public void deleteAllUsers() {
        userRepository.deleteAllInBatch();
    }

}
