package com.readingbackend.Backend.controller;
import com.readingbackend.Backend.model.Book;
import com.readingbackend.Backend.responses.BookResponse;
import com.readingbackend.Backend.service.BookService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path="api/v1/book")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Value("${api.service.key}")
    private String apiKey;

    private final WebClient webClient = WebClient.builder().baseUrl("https://www.googleapis.com/books/v1").build();

    @GetMapping(value = "/search")
    public Mono<BookResponse> searchBooks(@RequestParam String search, @RequestParam String searchOption, @RequestParam Integer index) {
        if (searchOption.equalsIgnoreCase("title")) {
            System.out.println("title");
            String url = String.format("/volumes?q=intitle:%s&startIndex=%d&maxResults=40&key=%s", search, index, apiKey);

            return webClient.get().uri(url)
                    .retrieve()
                    .bodyToMono(BookResponse.class);
        } else if (searchOption.equalsIgnoreCase("author")) {
            System.out.println("author");
            String url = String.format("/volumes?q=inauthor:%s&startIndex=%d&maxResults=40&key=%s", search, index, apiKey);

            return webClient.get().uri(url)
                    .retrieve()
                    .bodyToMono(BookResponse.class);
        } else if (searchOption.equalsIgnoreCase("subject")) {
            System.out.println("subject");
            String url = String.format("/volumes?q=subject:%s&startIndex=%d&key=%s", search, index, apiKey);

            return webClient.get().uri(url)
                    .retrieve()
                    .bodyToMono(BookResponse.class);
        } else {
            System.out.println("nothing");
            String url = String.format("/volumes?q=%s&startIndex=%d&key=%s", search, index, apiKey);

            return webClient.get().uri(url)
                    .retrieve()
                    .bodyToMono(BookResponse.class);
        }

    }

    @GetMapping(value = "/getBook")
    public Mono<BookResponse> getBook(@RequestParam String id) {
        String url = String.format("/volumes/%s", id);
        System.out.println("https://www.googleapis.com/books/v1" + url);

        return webClient.get().uri(url)
                .retrieve()
                .bodyToMono(BookResponse.class);

    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book createdBook = bookService.addBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

}
