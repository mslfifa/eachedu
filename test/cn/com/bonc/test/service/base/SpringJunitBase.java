package cn.com.bonc.test.service.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:applicationContext-common.xml"})
@TransactionConfiguration(transactionManager="transactionManager")
public abstract class SpringJunitBase {
	@BeforeTransaction
	public void beforeTransaction(){
		System.out.println("@@@@@@ beforeTransaction");
	}
	
	@AfterTransaction
	public void afterTransaction(){
		System.out.println("###### afterTransaction");
	}
}
