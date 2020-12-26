package com.goodreads.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.goodreads.app.model.BestBook;
import com.goodreads.app.model.GoodreadsResponse;
import com.goodreads.app.model.MyShelf;
import com.goodreads.app.model.Work;
import com.goodreads.app.repository.ShelfRepository;
import com.goodreads.app.service.GoodReadSerivice;
import com.goodreads.app.service.RestClientService;

@RestController
@RequestMapping(value = "/shelf")
public class BookShelfController {
	
	@Autowired RestClientService client;
	
	@Autowired GoodReadSerivice goodReadsService;
	
	@Autowired ShelfRepository shelfRepo;
	
	@GetMapping(value = "/add/{book}", produces = "application/json")
	public ModelAndView addToList(@PathVariable("book") String title) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(title);
		GoodreadsResponse response = client.searchByTitleAuthorISBN(title);
		Work work = response.getSearch().getResults().getWork().get(0);
		BestBook book = work.getBestBook();
		MyShelf mybook = new MyShelf(book.getId(), book.getTitle(), book.getAuthor().getName(), "INTERESTED", book.getImageUrl(), work.getAverageRating());
		goodReadsService.saveToShelf(mybook);
		List<MyShelf> myBooks = shelfRepo.findAll();
		modelAndView.addObject("books", myBooks);
		modelAndView.setViewName("myShelf");
		return modelAndView;
	}
	
	
	@GetMapping(value = "/viewShelf", produces = "application/json")
	public ModelAndView viewShelf() {
		ModelAndView modelAndView = new ModelAndView();
		List<MyShelf> myBooks = shelfRepo.findAll();
		modelAndView.addObject("books", myBooks);
		modelAndView.setViewName("myShelf");
		return modelAndView;
	}
	
	@GetMapping(value = "/pickNextRead", produces = "application/json")
	public ModelAndView recommendNextRead() {
		ModelAndView modelAndView = new ModelAndView();
		List<MyShelf> myBooks = shelfRepo.findAll();
		MyShelf highestRated = myBooks.get(0);
		for(MyShelf mybook: myBooks) {
			if(mybook.getRating()>= highestRated.getRating())
				highestRated = mybook;
		}
//		Random rand = new Random(); 
//        MyShelf recommendedBook = myBooks.get(rand.nextInt(myBooks.size())); 
        modelAndView.addObject("book", highestRated);
		modelAndView.setViewName("suggestedBook");
		return modelAndView;
	}
	
	@GetMapping(value = "/changeStatus/{id}/{status}", produces = "application/json")
	public ModelAndView changeStatus(@PathVariable("id") int id, @PathVariable("status") String status) {
		ModelAndView modelAndView = new ModelAndView();
		goodReadsService.changeStatus(id, status);
		List<MyShelf> myBooks = shelfRepo.findAll();
		modelAndView.addObject("books", myBooks);
		modelAndView.setViewName("myShelf");
		return modelAndView;
	}
	
}
