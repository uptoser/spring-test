package me.ibeyond.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.ibeyond.exception.Test1Exception;
import me.ibeyond.vo.Book;

@RestController
@RequestMapping("/")
public class ExceptionHandlerController {

	@RequestMapping(value = "testException", method = RequestMethod.POST)
	public Map<String,Object> test111(Integer a) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(a>0){
			throw new Test1Exception();
		}
		map.put("msg", 111);
		return map;
	}
	
	/**
	 * 这个只能处理一个controller里的异常信息
	 * 如果想要处理所有处理器的异常信息就要用控制器通知
	 * @return
	 */
	@ExceptionHandler(Test1Exception.class)
	public Map<String,Object> testException() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("msg", "test1的异常信息");
		return map;
	}

}
