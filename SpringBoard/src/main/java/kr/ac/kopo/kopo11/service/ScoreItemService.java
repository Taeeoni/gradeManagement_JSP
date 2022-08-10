package kr.ac.kopo.kopo11.service;

import kr.ac.kopo.kopo11.domain.Pagination;
import kr.ac.kopo.kopo11.repository.ScoreItemRepository;
import kr.ac.kopo.kopo11.repository.ScoreListRepository;


public interface ScoreItemService { // 기계적인 영역이 아니기때문에 (요구사항대로 바꾸어야 하기 때문에) - impl이 필요하다.
	
	
//	private final ScoreListRepository scoreListRepository;
//	private final ScoreItemRepository scoreItemRepository;
	
	
	Pagination getPagination(int currPage, int countPerPage, int pageSize, int totalCount) throws Exception;
	
	
	void test();
	void testAopBefore();
	void testAopAfter();
	String testAopAfterReturning();
	void testAopAfterThrowing();
	void testAopAround();
	
	String testNoTransactional();
	String testTransactional();
	
}
