package com.ch.ch6_4.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ch.ch6_4.entity.Author;
import com.ch.ch6_4.service.ArticleAndAuthorService;
@Controller
public class TestSortAndPage {
	@Autowired 
	private ArticleAndAuthorService articleAndAuthorService;
	
	@RequestMapping("/getInformation")
	@ResponseBody
	public String get() {
        return "pipeline Test Good, pipeline Test OK1 le 66688166LaLaLa";
    }
	
	@RequestMapping("/save")
	@ResponseBody
	public String save() {
		articleAndAuthorService.saveAll();
		return "保存用户成功！";
	}
	@RequestMapping("/findByAnameContaining")
	@ResponseBody
	public List<Author> findByAnameContaining(String aname, String sortColum){
		return articleAndAuthorService.findByAnameContaining(aname, sortColum);
	}
	@RequestMapping("/findAllAuthorByPage")
	/**
	 * @param page第几页
	 */
	public String findAllAuthorByPage(Integer page, Model model){
		return articleAndAuthorService.findAllAuthorByPage(page, model);
	}
}
