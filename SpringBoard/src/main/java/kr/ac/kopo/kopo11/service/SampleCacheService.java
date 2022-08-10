package kr.ac.kopo.kopo11.service;

public interface SampleCacheService {
	String testNoCache(Long id);
	String testCache(Long id);
	void testCacheClear(Long id);
	
}
