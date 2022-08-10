package kr.ac.kopo.kopo11.service;


import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ScoreItemServiceTest2 {
	
	@Autowired
	private ScoreItemService scoreItemService;

	
//	@Test
//	void test() {
//		scoreItemService.test();
//	}
//
//
//	@Test
//	void testAopBefore() {
//		scoreItemService.testAopBefore();
//	}
//
//
//	@Test
//	void testAopAfter() {
//		scoreItemService.testAopAfter();
//	}
//
//
//	@Test
//	void testAopAfterReturning() {
//		scoreItemService.testAopAfterReturning();
//	}
//
//
//	@Test
//	void testAopAfterThrowing() {
//		scoreItemService.testAopAfterThrowing();
//	}
//
//
//	@Test
//	void testAopAround() {
//		scoreItemService.testAopAround();
//	}
	
	@Ignore
	@Test
	void testNoTransactional() {
		scoreItemService.testNoTransactional(); // notransaction 이라서 값이 변경이 된다. kor -> 22 
	}

	@Test
	void testTransactional() {
		scoreItemService.testTransactional(); // transaction 이라서 값이 변경이 안된다. kor -> 99 안되고 그대로 22  
	}

}
