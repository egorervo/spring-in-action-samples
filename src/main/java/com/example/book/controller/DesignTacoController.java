package com.example.book.controller;

import com.example.book.domain.Ingredient;
import com.example.book.domain.Taco;
import com.example.book.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@SessionAttributes("order")
@RequestMapping("/design")
@RequiredArgsConstructor
public class DesignTacoController {
    private final IngredientRepository ingredientRepository;


    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();

        ingredientRepository.findAll().forEach(i -> ingredients.add(i));
        log.info("INGREDIENTS " + ingredients);
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(Taco design) {
// Save the taco design...
// We'll do this in chapter 3
        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }

    private Object filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients.stream().filter(i -> i.getType() == type).findAny().orElse(null);
    }
}
