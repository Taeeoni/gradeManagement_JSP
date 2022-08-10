package kr.ac.kopo.kopo11.repository;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.kopo11.domain.ScoreItem;
import kr.ac.kopo.kopo11.domain.ScoreList;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ScoreListRepositoryTest {
	
	@Autowired
	private ScoreListRepository scoreListRepository;
	
	@Test
	//@Transactional
	public void oneToMany_TwoWay() {
		
		scoreListRepository.deleteAll();
		
		ScoreList first = new ScoreList("고1");
		
		for(int i = 0; i < 50; i++) {
			ScoreItem scoreItem = new ScoreItem("고1아이유" + Integer.toString(i), "3월모의고사", 209901 + i, 
					(int) (Math.random() * 100) + 1, (int) (Math.random() * 100) + 1, (int) (Math.random() * 100) + 1, first);
			first.addScoreItem(scoreItem);
		}
		
		for(int i = 0; i < 50; i++) {
			ScoreItem scoreItem = new ScoreItem("고1아이유" + Integer.toString(i), "4월모의고사", 209901 + i, 
					(int) (Math.random() * 100) + 1, (int) (Math.random() * 100) + 1, (int) (Math.random() * 100) + 1, first);
			first.addScoreItem(scoreItem);
		}
		

		scoreListRepository.save(first);
		
		ScoreList second = new ScoreList("고2");
		
		for(int i = 0; i < 50; i++) {
			ScoreItem scoreItem = new ScoreItem("고2아이유" + Integer.toString(i), "3월모의고사", 209950 + i, 
					(int) (Math.random() * 100) + 1, (int) (Math.random() * 100) + 1, (int) (Math.random() * 100) + 1, second);
			second.addScoreItem(scoreItem);
		}
		for(int i = 0; i < 50; i++) {
			ScoreItem scoreItem = new ScoreItem("고2아이유" + Integer.toString(i), "4월모의고사", 209950 + i, 
					(int) (Math.random() * 100) + 1, (int) (Math.random() * 100) + 1, (int) (Math.random() * 100) + 1, second);
			second.addScoreItem(scoreItem);
		}
		
		
		
		scoreListRepository.save(second);
		
		ScoreList third = new ScoreList("고3");
		
		
		for(int i = 0; i < 50; i++) {
			ScoreItem scoreItem = new ScoreItem("고3아이유" + Integer.toString(i), "3월모의고사", 210001 + i, 
					(int) (Math.random() * 100) + 1, (int) (Math.random() * 100) + 1, (int) (Math.random() * 100) + 1, third);
			third.addScoreItem(scoreItem);
		}
		for(int i = 0; i < 50; i++) {
			ScoreItem scoreItem = new ScoreItem("고3아이유" + Integer.toString(i), "4월모의고사", 21000 + i, 
					(int) (Math.random() * 100) + 1, (int) (Math.random() * 100) + 1, (int) (Math.random() * 100) + 1, third);
			third.addScoreItem(scoreItem);
		}

		scoreListRepository.save(third);
		
		
//		List<ScoreList> list = scoreListRepository.findAll();
//		
//		for(ScoreList s : list) {
//			System.out.println(s.toString());
//		}
		
		
	}
	
	@Autowired
	private ScoreItemRepository scoreItemRepository;
	
	//@Test
	//@Transactional
	public void checkScoreList() { // 속해있는 list ID값 체크 
		
//		List <ScoreItem> scoreItem = scoreItemRepository.findByStudentidAndKor(209915, 100);
//		
//		ScoreList scoreList = scoreItem.get(0).getScoreList();
//		
//		System.out.println("속한list id : " + scoreList.getId());
			
	}
	
	//@Test
	@Transactional
	public void checkScoreItems() { // 각 리스트의 아이템들이 얼마나 있는지 체크 
		
		List <ScoreList> scoreList = scoreListRepository.findByName("3월모의고사");
		
		List <ScoreItem> itemList = (List) scoreList.get(0).getScoreItems();
		
		for(int i = 0; i < itemList.size(); i++) {
			System.out.println("리스트의 item들 id : " + itemList.get(i).getId());
			
		}
		
	}
	
	//@Test
	@Transactional
	public void deleteScoreItems() { // 부모(list)를 지웠을때 자식(item)도 지워지나 확인 
		
		scoreListRepository.deleteByName("3월모의고사");
		
		List <ScoreList> scoreList = scoreListRepository.findAll();
		
		for(int i = 0; i < scoreList.size(); i++) {
			System.out.println("item id : " + scoreList.get(i).getId());
			
		}
		
	}
	
	
	
	
	
}
