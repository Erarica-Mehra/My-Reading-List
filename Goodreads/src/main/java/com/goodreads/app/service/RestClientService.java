package com.goodreads.app.service;

import java.io.StringReader;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import com.goodreads.app.model.GoodreadsResponse;

@Service
public class RestClientService {
	
	private final RestTemplate restTemplate;

    public RestClientService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

	
	public GoodreadsResponse searchByTitleAuthorISBN(String searchTerm) {
		GoodreadsResponse response = new GoodreadsResponse();
        try {
        	UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://www.goodreads.com/search/index.xml")
    				.queryParam("key", "SECRET_KEY").queryParam("q", searchTerm).queryParam("page", 1);
            ResponseEntity<String> stringResponseEntity = restTemplate
                    .getForEntity(builder.build().toString(),String.class);
            JAXBContext jaxbContext = JAXBContext.newInstance(GoodreadsResponse.class);
            String myresonse = stringResponseEntity.getBody().toString();
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            response = (GoodreadsResponse) unmarshaller
                    .unmarshal(new StringReader(myresonse));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;

	}
	
	public GoodreadsResponse getRecentReviews() {
		GoodreadsResponse response = new GoodreadsResponse();
        try {
        	UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://www.goodreads.com/review/recent_reviews.xml")
    				.queryParam("key", "SECRET_KEY");
            ResponseEntity<String> stringResponseEntity = restTemplate
                    .getForEntity(builder.build().toString(),String.class);
            JAXBContext jaxbContext = JAXBContext.newInstance(GoodreadsResponse.class);
            String myresonse = stringResponseEntity.getBody().toString();
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            response = (GoodreadsResponse) unmarshaller
                    .unmarshal(new StringReader(myresonse));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;

	}
	
	
	

}
