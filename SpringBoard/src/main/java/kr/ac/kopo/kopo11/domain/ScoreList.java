package kr.ac.kopo.kopo11.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ScoreList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	private String name; 
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="scoreList", orphanRemoval = true) // fetch - eager, lazy 
	private Collection<ScoreItem> scoreItems;
	
	public ScoreList() {
		
	}
	
	public ScoreList(String string) {
		
		name = string;
	}

	public Collection<ScoreItem> getScoreItems(){
		
		if( scoreItems == null) {
			scoreItems = new ArrayList<ScoreItem>();
		}
		return scoreItems;
	}
	
	public void setScoreItems(Collection<ScoreItem> scoreItems) {
		this.scoreItems = scoreItems;
	}
	
	public void addScoreItem (ScoreItem item) {
		Collection<ScoreItem> scoreItems = getScoreItems();
		scoreItems.add(item);
	}
	
	@Override
	public String toString() {
		String result = "[" + id + "] " + name;
		for( ScoreItem item : getScoreItems() ) {
			result += "\n" + item.toString();
		}
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




	
}
