package com.readingbackend.Backend.responses;

import java.util.List;

public record BookResponse(Long totalItems, List<BookItem> items) {

}

