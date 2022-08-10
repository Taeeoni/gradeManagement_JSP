package kr.ac.kopo.kopo11.repository;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.ac.kopo.kopo11.domain.ScoreItem;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class ScoreItemRepositoryTest {

	@Autowired
	private ScoreItemRepository scoreItemRepository;
	
	@Test
	public void createTest() {
		
		ScoreItem scoreItem = new ScoreItem();
		scoreItem.setName("홍길동");
		scoreItem.setStudentid(209915);
		scoreItem.setKor(100);
		scoreItem.setEng(90);
		scoreItem.setMat(70);
		
		ScoreItem scoreItemOutput = scoreItemRepository.save(scoreItem);
		System.out.println(scoreItemOutput);
	}
	
//	@Test
//	public void readTest() {
//				
//		Optional<ScoreItem> scoreItem = scoreItemRepository.findByStudentid(209915);
//		
//		scoreItem.ifPresent(selectScore -> {
//			System.out.println("score: " + selectScore);
//		});
//		
//	}
//	
//	@Test
//	public void updateTest() {
//				
//		Optional<ScoreItem> scoreItem = scoreItemRepository.findByStudentid(209915);
//		
//		scoreItem.ifPresent(selectScore -> {
//			selectScore.setKor(50);
//			scoreItemRepository.save(selectScore);
//			System.out.println("score: " + selectScore);
//		});
//		
//	}
//	
//	@Test
//	public void deleteTest() {
//				
//		Optional<ScoreItem> scoreItem = scoreItemRepository.findByStudentid(209915);
//		
//		Assert.assertTrue(scoreItem.isPresent());
//		scoreItem.ifPresent(selectScore -> {
//			scoreItemRepository.delete(selectScore);
//		});
//		
//		Optional<ScoreItem> deleteScoreItem = scoreItemRepository.findByStudentid(209915);
//		
//		Assert.assertFalse(deleteScoreItem.isPresent());
//		
//	}
	

}
