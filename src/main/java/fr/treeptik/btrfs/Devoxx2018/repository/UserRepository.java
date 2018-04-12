package fr.treeptik.btrfs.Devoxx2018.repository;

import fr.treeptik.btrfs.Devoxx2018.domain.User;
import fr.treeptik.btrfs.Devoxx2018.domain.FanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select count(name) from User u where u.fanType=:fanType")
    Long compter(FanType fanType);

}
