package kr.ac.kopo.kopo11.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import kr.ac.kopo.kopo11.domain.ScoreItem;
import kr.ac.kopo.kopo11.domain.ScoreList;

@Repository
public interface ScoreItemRepository extends JpaRepository<ScoreItem, Long> {
	
	//리스트에서 가져올 생각을 해야한다. 
	
	List <ScoreItem> findByStudentid(int studentid);
	List <ScoreItem> findByStudentidAndTestName(int studentid, String testName);
	List<ScoreItem> findByTestNameAndScoreListId(String name, Long id);
	
	@Query("select max(studentid) from scoreItem where score_list_id = :id and testName =:testName")
	int findLastStudentId(@Param("id") Long id, @Param("testName") String testName);
}
