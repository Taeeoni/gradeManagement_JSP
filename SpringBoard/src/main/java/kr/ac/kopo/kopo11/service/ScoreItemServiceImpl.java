package kr.ac.kopo.kopo11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.kopo11.domain.Pagination;
import kr.ac.kopo.kopo11.domain.ScoreItem;
import kr.ac.kopo.kopo11.repository.ScoreItemRepository;

@Service // component -> singleton으로 처리 
public class ScoreItemServiceImpl implements ScoreItemService {
	
	@Autowired
	ScoreItemRepository scoreItemRepository;


	@Override
	public Pagination getPagination(int currPage, int countPerPage, int pageSize, int totalCount) throws Exception {

		Pagination p = new Pagination();
		p.setPpPage(1);
		p.setNnPage((totalCount - 1) / pageSize + 1);
		p.setIsLast(0);

		// set 현재페이지 
		if(currPage < 0) {
			p.setcPage(1);
		} else if(currPage > p.getNnPage()) {
			p.setcPage(p.getNnPage());
		} else {
			p.setcPage(currPage);
		}
		
		// set 이전페이지 
		
		if (p.getcPage() - countPerPage  < 1) {
			p.setpPage(1);
		} 
		else {
			p.setpPage(p.getcPage() - countPerPage);
		}

		// set 다음페이지
		if (p.getcPage() + countPerPage > p.getNnPage()) {
			p.setNpage(p.getNnPage());
		} 
		else {
			p.setNpage(p.getcPage() + countPerPage);
		}
		
		p.setPageStart(((Integer) (p.getcPage() - 1) / countPerPage ) * countPerPage + 1);
		
		if(p.getNpage() == p.getNnPage()) {
			p.setIsLast(1);
		}
		
		return p;
	}


	@Override
	public void test() {
		System.out.println("ScoreItemServiceImpl.test() 메소드 호출");
	}


	@Override
	public void testAopBefore() {
		System.out.println("ScoreItemServiceImpl.testAopBefore() 메소드 호출");		
	}


	@Override
	public void testAopAfter() {
		System.out.println("ScoreItemServiceImpl.testAopAfter() 메소드 호출");		
	}


	@Override
	public String testAopAfterReturning() {
		System.out.println("ScoreItemServiceImpl.testAopAfterReturning() 메소드 호출");
		return "Success";
	}


	@Override
	public void testAopAfterThrowing() {
		System.out.println("ScoreItemServiceImpl.testAopAfterThrowing() 메소드 호출");
		throw new RuntimeException("runtime exception 발생");
	}


	@Override
	public void testAopAround() {
		System.out.println("ScoreItemServiceImpl.testAopAround() 메소드 호출");		
	}

	
	@Override
	public String testNoTransactional() {
		ScoreItem scoreItem = scoreItemRepository.findById(146L).get();
		scoreItem.setKor(22);
		scoreItemRepository.save(scoreItem);
		
		throw new RuntimeException("Spring Boot No Transactional Test");

	}


	@Override
	@Transactional
	public String testTransactional() {
		ScoreItem scoreItem = scoreItemRepository.findById(146L).get();
		scoreItem.setKor(99);
		scoreItemRepository.save(scoreItem);
		
		throw new RuntimeException("Spring Boot Transactional Test");
	}


}
