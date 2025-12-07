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

    @GetMapping(value = "/search")
    public Mono<BookResponse> searchBooks(@RequestParam(required = false) String title,
                                          @RequestParam(required = false) String author,
                                          @RequestParam(required = false) String subject) {
        System.out.println("test");
        if (title != null) {
            System.out.println("title");
            String url = String.format("/volumes?q=intitle:%s&key=%s", title, key);

            return webClient.get().uri(url)
                    .retrieve()
                    .bodyToMono(BookResponse.class);
        } else if (author != null) {
            System.out.println("author");
            String url = String.format("/volumes?q=inauthor:%s&key=%s", author, key);

            return webClient.get().uri(url)
                    .retrieve()
                    .bodyToMono(BookResponse.class);
        } else if (subject != null) {
            System.out.println("subject");
            String url = String.format("/volumes?q=subject:%s&key=%s", subject, key);

            return webClient.get().uri(url)
                    .retrieve()
                    .bodyToMono(BookResponse.class);
        }

        return null;

    }

    @GetMapping(value = "/getBook")
    public Book getBook(@RequestParam String id) {
        return bookService.getBook(id);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book createdBook = bookService.addBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

}
