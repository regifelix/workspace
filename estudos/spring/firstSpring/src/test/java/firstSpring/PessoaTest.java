package firstSpring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })

@TransactionConfiguration(defaultRollback = false)
public class PessoaTest {
	//@Autowired
	//private PessoaDao pessoaDao;

	@Test
	public void testSave() {
		
	}

	@Test
	public void testDelete() {
		// implementacao do teste
	}

	@Test
	public void testUpdate() {
		// implementacao do teste
	}
}