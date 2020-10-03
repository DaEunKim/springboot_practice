package me.dani.springbootjpa.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest //슬라이싱 테스트 : 리파지토리를 포함한 리파지토리 관련된 빈들만 등록을 해서 테스트를 만드는거 -> 이걸 하면 datasource 를 빈으로 받을수잇다. jdbc template도, accountrepository도 빈으로 받을수잇음
public class AccountRepositoryTest {
	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	AccountRepository accountRepository;

	@Test
	public void di() throws SQLException {
//		try(Connection connection= dataSource.getConnection()){
//			DatabaseMetaData metaData = connection.getMetaData();
//			System.out.println(metaData.getURL());
//			System.out.println(metaData.getDriverName());
//			System.out.println(metaData.getUserName());
//
//		}
		Account account = new Account();
		account.setUsername("keesun");
		account.setPassword("pass");
		Account newAccount = accountRepository.save(account);
		assertThat(newAccount).isNotNull();
		Account existingAccount = accountRepository.findByUsername(newAccount.getUsername());
		assertThat(existingAccount).isNotNull();


	}

}