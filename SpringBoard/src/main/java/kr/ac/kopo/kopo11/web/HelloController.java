package kr.ac.kopo.kopo11.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.kopo11.domain.Hello;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

	@RequestMapping(value = "")
	public String hello(Model model) {

		model.addAttribute("name", "태언");
		return "hello";

	}

	@RequestMapping(value = "/getParameter")
	public String getParameter(Model model, HttpServletRequest req) {
		String name = req.getParameter("name");
		model.addAttribute("name", name);
		return "hello";

	}

	@RequestMapping(value = "/requestParam") // requestParam ? 뒤값을 통해 input을 받아온다.
	public String requestParam(Model model, @RequestParam(value = "name") String name) {
		model.addAttribute("name", name);
		return "hello";

	}

	@RequestMapping(value = "/pathVariable/{name}") //path 경로에 바로 붙여서 (/뒤에) 바로 input을 받아온다.
	public String pathVariable(Model model, @PathVariable("name") String name) {

		model.addAttribute("name", name);
		return "hello";

	}

	@RequestMapping(value = "/modelAttribute") //parameter를 Hello(id, name)로 받는다. 
	public String modelAttribute(Model model, @ModelAttribute Hello hello) {

		model.addAttribute("name", hello.getName());
		return "hello";

	}

	@RequestMapping(value = "/requestBody1") // requestbody : 통채로 받아와서 쓰겠다. 
	public String hellSpringBoot(Model model, @RequestBody Map<String, Object> obj) {

		model.addAttribute("name", obj.get("name"));
		return "hello";

	}
	// headers 에다가 Content-type , application/json 추가 
	// requestbody : 통채로 받아와서 쓰겠다. 
	@RequestMapping(value = "/requestBody2") // 가독성을 위해 Hello class(domain)으로 받아주는게 좋아보인다.
	public String hellSpringBoot(Model model, @RequestBody Hello hello) {

		model.addAttribute("name", hello.getName());
		return "hello";

	}

}
