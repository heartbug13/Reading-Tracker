package com.readingbackend.Backend.book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class BookController {

    private String key = "AIzaSyAHfF-z4fJocywdgL0XiaNRMWroT83idxk";
    private WebClient webClient = WebClient.builder().baseUrl("https://www.googleapis.com/books/v1").build();

    @GetMapping(value = "/searchTitle")
    public Mono<Book> searchBooksByTitle(@RequestParam String value) {
        String url = String.format("/volumes?q=intitle:%s&key=%s", value, key);

        return webClient.get().uri(url)
                .retrieve()
                .bodyToMono(Book.class);

    }

    @GetMapping(value = "/searchAuthor")
    public Mono<Book> searchBooksByAuthor(@RequestParam String value) {
        String url = String.format("/volumes?q=inauthor:%s&key=%s", value, key);

        return webClient.get().uri(url)
                .retrieve()
                .bodyToMono(Book.class);

    }

    public Mono<Book> searchBooksBySubject(@RequestParam String value) {
        String url = String.format("/volumes?q=insubject:%s&key=%s", value, key);

        return webClient.get().uri(url)
                .retrieve()
                .bodyToMono(Book.class);

    }

}
