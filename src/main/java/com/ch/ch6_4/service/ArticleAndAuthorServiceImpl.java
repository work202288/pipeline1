package com.ch.ch6_4.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.ch.ch6_4.entity.Author;
import com.ch.ch6_4.repository.AuthorRepository;
@Service
public class ArticleAndAuthorServiceImpl implements ArticleAndAuthorService{
	@Autowired
	private AuthorRepository authorRepository;
	@Override
	public List<Author> findByAnameContaining(String aname, String sortColum) {
		//按sortColum降序排序
		return authorRepository.findByAnameContaining(aname, Sort.by(sortColum).descending());
	}
	@Override
	public String findAllAuthorByPage(Integer page, Model model) {
		if(page == null) {//第一次访问findAllAuthorByPage方法时
			page = 1;
		}
		int size = 5;//每页显示5条
		//分页查询，of方法的第一个参数代表第几页（比实际小1），第二个参数代表页面大小，第三个参数代表排序规则
		Page<Author> pageData = authorRepository.findAll(PageRequest.of(page-1, size, Sort.by("id").descending()));
		//获得当前页面数据并转换成List<Author>，转发到视图页面显示
		List<Author> allAuthor = pageData.getContent();
		model.addAttribute("allAuthor",allAuthor);
		//共多少条记录
		model.addAttribute("totalCount", pageData.getTotalElements());
		//共多少页
		model.addAttribute("totalPage", pageData.getTotalPages());
		//当前页
		model.addAttribute("page", page);
		return "index";
	}
	
}
