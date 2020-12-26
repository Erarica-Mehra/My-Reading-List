package com.goodreads.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.goodreads.app.model.GoodreadsResponse;
import com.goodreads.app.model.Work;
import com.goodreads.app.service.GoodReadSerivice;
import com.goodreads.app.service.RestClientService;

@RestController
@RequestMapping(value ="/myApp")
public class GoodReadsController {
	
	@Autowired GoodReadSerivice goodReadService;
	
	@Autowired RestClientService client;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@GetMapping(value = "/search/", produces = "application/json")
	public ModelAndView searchBook(@RequestParam("term") String term) {
		GoodreadsResponse response = new GoodreadsResponse();
		ModelAndView modelAndView = new ModelAndView();
		response = client.searchByTitleAuthorISBN(term);
		modelAndView.addObject("books", response.getSearch().getResults().getWork());
		modelAndView.setViewName("searchResults");
		return modelAndView;
	}
	
}
