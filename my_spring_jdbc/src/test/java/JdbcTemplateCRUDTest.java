import com.wf.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testQuerryCount() {
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);
    }

    @Test
    public void testQuerryOne() {
        Account account = jdbcTemplate.queryForObject("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), "tom");
        System.out.println(account);
    }

    @Test
    public void testQuerryAll() {
        List<Account> list = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(list);
    }

    @Test
    public void testInsert() {
        jdbcTemplate.update("insert into account values (?,?)", "tom", 5000);
    }

    @Test
    public void testUpdate() {
        jdbcTemplate.update("UPDATE account SET money = ? where name = ?", 10000,"tom");
    }

    @Test
    public void testDelete() {
        jdbcTemplate.update("DELETE FROM account where name = ?", "tom");
    }

}
