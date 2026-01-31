package com.readingbackend.Backend.responses;

import java.util.List;

public record VolumeInfo(

    String title,
    List<String> authors,
    String description,
    Integer pageCount,
    List<String> categories,
    ImageLinks imageLinks,
    String previewLink

) {}
