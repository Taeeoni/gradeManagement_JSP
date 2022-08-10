package kr.ac.kopo.kopo11.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "scoreItem") //table화 시키겠다.
public class ScoreItem {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String testName;

	@Column 
	private int studentid;
	
	@Column
	private int kor;
	@Column
	private int eng;
	@Column
	private int mat;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="score_list_id")
	private ScoreList scoreList;
	
	public ScoreItem() {
		
	}
	
	public ScoreItem(String string, String testName, int i, int j, int k, int l, ScoreList scoreList) {
		// TODO Auto-generated constructor stub
		name = string;
		this.testName = testName;
		studentid = i;
		kor = j;
		eng = k;
		mat = l;
		this.scoreList = scoreList;
	}

	public ScoreList getScoreList() {
		return scoreList;
	}

	public void setScoreList(ScoreList scoreList) {
		this.scoreList = scoreList;
	}

	@Override
	public String toString() {
		String result = "[" + name + "]" + "국어 : " + kor + " 영어 : " + eng + " 수학 : " + mat;
		return result;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}
	
	
}
