package com.example.kirjakauppa.domain;

import com.example.kirjakauppa.domain.Category;
import com.example.kirjakauppa.domain.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categorylist")
    public String showCategoryList(Model model) {
        Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categorylist";
    }
    @GetMapping("/addcategory")
    public String showCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @SuppressWarnings("null")
    @PostMapping("/addcategory")
    public String addCategory(@ModelAttribute Category newCategory) {
        categoryRepository.save(newCategory);
        return "redirect:/categorylist";
    }
}