package kr.ac.kopo.kopo11.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.kopo.kopo11.domain.Pagination;

class ScoreItemServiceTest {
	
	@Autowired
	private ScoreItemService scoreItemService = new ScoreItemServiceImpl(); // service 불러 온 다음 - serviceimpl 사용

	
	@Test
	void testGetPagination1() throws Exception {
		Pagination p = scoreItemService.getPagination(1, 15, 50, 1025); // 현재페이지, 한줄에 보이는 페이지 수, 페이지당글, 총글수
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getNpage(), 16);
		assertEquals(p.getNnPage(), 21);
		assertEquals(p.getcPage(), 1);
	}
	
	@Test
	void testGetPagination2() throws Exception {
		Pagination p = scoreItemService.getPagination(5, 15, 50, 1025); // 현재페이지, 한줄에 보이는 페이지 수, 페이지당글, 총글수
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getNpage(), 20);
		assertEquals(p.getNnPage(), 21);
		assertEquals(p.getcPage(), 5);
	}

	@Test
	void testGetPagination3() throws Exception {
		Pagination p = scoreItemService.getPagination(-100, 15, 50, 1025); // 현재페이지, 한줄에 보이는 페이지 수, 페이지당글, 총글수
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getNpage(), 16);
		assertEquals(p.getNnPage(), 21);
		assertEquals(p.getcPage(), 1);
	}
	
	@Test
	void testGetPagination4() throws Exception {
		Pagination p = scoreItemService.getPagination(21, 15, 50, 1025); // 현재페이지, 한줄에 보이는 페이지 수, 페이지당글, 총글수
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 6);
		assertEquals(p.getNpage(), 21);
		assertEquals(p.getNnPage(), 21);
		assertEquals(p.getcPage(), 21);
	}
	
	@Test
	void testGetPagination5() throws Exception {
		Pagination p = scoreItemService.getPagination(100, 15, 50, 1025); // 현재페이지, 한줄에 보이는 페이지 수, 페이지당글, 총글수
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 6);
		assertEquals(p.getNpage(), 21);
		assertEquals(p.getNnPage(), 21);
		assertEquals(p.getcPage(), 21);
	}
	
	@Test
	void testGetPagination6() throws Exception {
		Pagination p = scoreItemService.getPagination(1, 15, 50, 505); // 현재페이지, 한줄에 보이는 페이지 수, 페이지당글, 총글수
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getNpage(), 11);
		assertEquals(p.getNnPage(), 11);
		assertEquals(p.getcPage(), 1);
	}
	@Test
	void testGetPagination7() throws Exception {
		Pagination p = scoreItemService.getPagination(5, 15, 50, 505); // 현재페이지, 한줄에 보이는 페이지 수, 페이지당글, 총글수
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getNpage(), 11);
		assertEquals(p.getNnPage(), 11);
		assertEquals(p.getcPage(), 5);
	}
	@Test
	void testGetPagination8() throws Exception {
		Pagination p = scoreItemService.getPagination(-100, 15, 50, 505); // 현재페이지, 한줄에 보이는 페이지 수, 페이지당글, 총글수
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getNpage(), 11);
		assertEquals(p.getNnPage(), 11);
		assertEquals(p.getcPage(), 1);
	}

	@Test
	void testGetPagination9() throws Exception {
		Pagination p = scoreItemService.getPagination(11, 15, 50, 505); // 현재페이지, 한줄에 보이는 페이지 수, 페이지당글, 총글수
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getNpage(), 11);
		assertEquals(p.getNnPage(), 11);
		assertEquals(p.getcPage(), 11);
	}
	
	@Test
	void testGetPagination10() throws Exception {
		Pagination p = scoreItemService.getPagination(100, 15, 50, 505); // 현재페이지, 한줄에 보이는 페이지 수, 페이지당글, 총글수
		assertEquals(p.getPpPage(), 1);
		assertEquals(p.getpPage(), 1);
		assertEquals(p.getNpage(), 11);
		assertEquals(p.getNnPage(), 11);
		assertEquals(p.getcPage(), 11);
	}

}
