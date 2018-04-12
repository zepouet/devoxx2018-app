package fr.treeptik.btrfs.Devoxx2018;

import fr.treeptik.btrfs.Devoxx2018.domain.User;
import fr.treeptik.btrfs.Devoxx2018.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserPgDatabaseTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void create() {
        User cedric = new User(1, "Cédric");
        testEntityManager.persist(cedric);

        User nicolas = new User(2, "Nicolas");
        testEntityManager.persist(nicolas);

        Long nbUsers = repository.count();
        Assert.assertEquals(100002, nbUsers.longValue());
    }
}
