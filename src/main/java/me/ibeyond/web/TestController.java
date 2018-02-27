package me.ibeyond.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.ibeyond.vo.Book;

@RestController
@RequestMapping("/")
public class TestController {

	//----------------------
	@RequestMapping(value = "validator", method = RequestMethod.POST)
	public Map<String,Object> validator(@RequestBody @Valid Book book, Errors errors) {
		System.out.println(book);
		Map<String,Object> map = new HashMap<String,Object>();
		if(errors.hasErrors()){
			map.put("msg", errors.getFieldError().getDefaultMessage());
			return map;
		}
		map.put("msg", 111);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "test", method = RequestMethod.POST)
	public Map<String,Object> test1(String name,String name1) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		System.out.println(name);
		return map;
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public Map<String,Object> test2(String name) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("msg", "哦哦");
		map.put("name", name);
		System.out.println(name);
		return map;
	}

}
