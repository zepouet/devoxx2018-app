package fr.treeptik.btrfs.Devoxx2018;

import java.util.List;
import java.util.Map;

import fr.treeptik.btrfs.Devoxx2018.domain.User;
import fr.treeptik.btrfs.Devoxx2018.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@Sql("classpath:test_users.sql")
public class UserDatabaseTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() {
        String selectQuery = "SELECT * from Users";
        List<Map<String, Object>> resultSet = jdbcTemplate
                .queryForList(selectQuery);
        System.out.println(resultSet);
    }

    @Test
    public void create() {
        User cedric = new User(100, "Cédric");
        testEntityManager.persist(cedric);

        User nicolas = new User(200, "Nicolas");
        testEntityManager.persist(nicolas);

        Long nbUsers = repository.count();
        Assert.assertEquals(4, nbUsers.longValue());
    }
}
