package kr.ac.kopo.kopo11.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kopo11.domain.ScoreList;

@Repository
public interface ScoreListRepository extends JpaRepository<ScoreList, Long>{
	

	
	List<ScoreList> findByName(String name);

	List<ScoreList> deleteByName(String name);
	
	
	
//	List<ScoreList> findByNameAndKorLessThan(String name, int kor);
	
	@Query("select distinct testName from scoreItem where score_list_id = :id")
	List<String> findTestName(@Param("id") Long id);
	
//	@Query("select t from score_item t where name=:name and kor < :kor")
//	List<ScoreList> findByNameAndKorLessThanSQL(@Param("name") String name, 
//			@Param("kor") int kor);
//	
//	List<ScoreList> findByNameAndKorLessThanOrderByKorDesc(String name, int kor);
	
}
