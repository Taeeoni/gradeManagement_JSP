package kr.ac.kopo.kopo11.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.kopo11.domain.ScoreItem;
import kr.ac.kopo.kopo11.domain.ScoreList;
import kr.ac.kopo.kopo11.repository.ScoreItemRepository;
import kr.ac.kopo.kopo11.repository.ScoreListRepository;
import kr.ac.kopo.kopo11.service.ScoreItemService;

@Controller // component -> singleton으로 생각한다.
public class ScoreItemController { // DI - 객체를 직접생성 X -> 외부에서 생성후 주입

	@Autowired
	private ScoreListRepository scoreListRepository;

	@Autowired
	private ScoreItemRepository scoreItemRepository;

	Long connectionId;

	@RequestMapping(value = "/score")
	public String ScoreListAll(Model model) {

		model.addAttribute("scoreList", scoreListRepository.findAll());
		return "scoreList";
	}

	@RequestMapping(value = "/score/item")
	public String SelectedItem(Model model, @RequestParam(value = "id") Long id) {

		connectionId = id;
		List<String> scoreList = scoreListRepository.findTestName(id);

		model.addAttribute("scoreItem", scoreList);
		return "scoreItem";
	}

	@RequestMapping(value = "/score/item/testScore")
	public String showTestScore(Model model, @RequestParam(value = "testName") String testName) {

		List<ScoreItem> scoreList = scoreItemRepository.findByTestNameAndScoreListId(testName, connectionId);

		model.addAttribute("scoreItemResult", scoreList);
		return "scoreItemResult";
	}

	@RequestMapping(value = "/add")
	public String AddStudents(Model model) {

		return "scoreAdd";
	}

	@RequestMapping(value = "/add/next")
	public String AddStudentsNext(Model model, @ModelAttribute("scoreItem") ScoreItem scoreItem,
			@RequestParam(value = "class") String className) {

		List<ScoreList> first = scoreListRepository.findByName(className);
		int studentid = scoreItemRepository.findLastStudentId(first.get(0).getId(), scoreItem.getTestName());
		scoreItem.setStudentid(studentid + 1);
		scoreItem.setScoreList(first.get(0));
		first.get(0).addScoreItem(scoreItem);
		scoreListRepository.save(first.get(0));

		return "scoreAddNext";
	}

	@RequestMapping(value = "/ud")
	public String UDStudents(Model model) {

		return "scoreUD";
	}

	@RequestMapping(value = "/ud/search")
	public String SearchStudents(Model model, @RequestParam(value = "stu_id") int stu_id) {

		List<ScoreItem> searchedList = scoreItemRepository.findByStudentid(stu_id);
		model.addAttribute("scoreSearch", searchedList);

		return "scoreSearch";
	}

	@RequestMapping(value = "/ud/update")
	public String UpdateStudents(Model model, @ModelAttribute("scoreItem") ScoreItem scoreItem,
			@RequestParam(value = "class") String className) {

		List<ScoreItem> NeedUpdateList = scoreItemRepository.findByStudentidAndTestName(scoreItem.getStudentid(),
				scoreItem.getTestName());
		NeedUpdateList.get(0).setEng(scoreItem.getEng());
		NeedUpdateList.get(0).setKor(scoreItem.getKor());
		NeedUpdateList.get(0).setMat(scoreItem.getMat());

		scoreItemRepository.save(NeedUpdateList.get(0));
		return "scoreUpdate";
	}

	@RequestMapping(value = "/ud/delete")
	public String DeleteStudents(Model model, @ModelAttribute("scoreItem") ScoreItem scoreItem,
			@RequestParam(value = "class") String className) {

		List<ScoreItem> NeedDeleteList = scoreItemRepository.findByStudentidAndTestName(scoreItem.getStudentid(),
				scoreItem.getTestName());
		//cascade 연관관계를 끊어주어야 삭제가 가능하다.. 
		ScoreList scoreList = NeedDeleteList.get(0).getScoreList();//부모를 찾고
		scoreList.getScoreItems().remove(NeedDeleteList.get(0));//부모에서 해당자식의 연관관계를 끊어준다.
		scoreItemRepository.delete(NeedDeleteList.get(0));
		return "scoreDelete";
	}

	
	
	@Autowired
	private ScoreItemService scoreItemService;

	@RequestMapping(value = "/score/noTransactional")
	@ResponseBody
	public String noTransactional() {
		return scoreItemService.testNoTransactional();
	}

	@RequestMapping(value = "/score/transactional")
	@ResponseBody
	public String Transactional() {
		return scoreItemService.testTransactional();
	}

}
