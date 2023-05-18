package com.example.main.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class BookRequestModel
{
    private String bookId;
    private  String bookName;
    private  String authorName;
    private  String description;
    private  String price;
}
