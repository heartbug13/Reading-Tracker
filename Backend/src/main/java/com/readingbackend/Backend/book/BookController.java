package com.readingbackend.Backend.book;
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

    private final String key = "AIzaSyAHfF-z4fJocywdgL0XiaNRMWroT83idxk";
    private final WebClient webClient = WebClient.builder().baseUrl("https://www.googleapis.com/books/v1").build();

    @GetMapping(value = "/searchTitle")
    public Mono<BookResponse> searchBooksByTitle(@RequestParam String value) {
        String url = String.format("/volumes?q=intitle:%s&key=%s", value, key);

        return webClient.get().uri(url)
                .retrieve()
                .bodyToMono(BookResponse.class);

    }

    @GetMapping(value = "/searchAuthor")
    public Mono<BookResponse> searchBooksByAuthor(@RequestParam String value) {
        String url = String.format("/volumes?q=inauthor:%s&key=%s", value, key);

        return webClient.get().uri(url)
                .retrieve()
                .bodyToMono(BookResponse.class);

    }

    @GetMapping(value = "/searchSubject")
    public Mono<BookResponse> searchBooksBySubject(@RequestParam String value) {
        String url = String.format("/volumes?q=insubject:%s&key=%s", value, key);

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
