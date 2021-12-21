package com.example.demo.controllers;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.ItemEntity;
import com.example.demo.forms.ItemForm;
import com.example.demo.repositries.ItemRepository;





@Controller
@RequestMapping("/")
public class RootController {

    
    
    //初期状態のindex用のGetMapping
    @GetMapping
    public String index() {
        return "root/index";
    }
    



    

    
}

