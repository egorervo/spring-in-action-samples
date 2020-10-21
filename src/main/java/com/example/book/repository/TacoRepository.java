package com.example.book.repository;

import com.example.book.domain.Ingredient;
import com.example.book.domain.Taco;

public interface TacoRepository {
    Taco save(Taco taco);
}
