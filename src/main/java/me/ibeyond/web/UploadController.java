package me.ibeyond.web;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;
import me.ibeyond.exception.TestException;

@RestController
@RequestMapping("/upload")
public class UploadController {

	// 上传图片
	@ResponseBody
	@ApiOperation(value = "上传图片", notes = "by barry")
	@RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
	public String uploadPic(@RequestParam(required = true, value = "pic") MultipartFile pic)
			throws IOException {
		System.out.println(pic.getName());
		System.out.println(pic.getOriginalFilename());
		throw new TestException();
//		return "";
	}

}
