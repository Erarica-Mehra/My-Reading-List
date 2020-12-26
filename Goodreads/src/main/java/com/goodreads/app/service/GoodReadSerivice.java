package com.goodreads.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.goodreads.app.model.GoodreadsResponse;
import com.goodreads.app.model.MyShelf;
import com.goodreads.app.repository.ShelfRepository;

@Service
public class GoodReadSerivice {

	@Autowired private RestClientService client;
	@Autowired ShelfRepository shelfRepo;

	
	public GoodreadsResponse search(String searchTerm) throws JsonMappingException, JsonProcessingException {
		GoodreadsResponse response = client.searchByTitleAuthorISBN(searchTerm);
        return response;
	}
	
	public MyShelf saveToShelf(MyShelf myBook) {
		return shelfRepo.save(myBook);
	}
	
	public MyShelf changeStatus(int id, String status) {
		Optional<MyShelf> bookTobeUpaded = shelfRepo.findById(id);
		bookTobeUpaded.get().setStatus(status);
		return shelfRepo.save(bookTobeUpaded.get());
	}

}
