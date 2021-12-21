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
import com.example.demo.services.ItemService;


@Controller
@RequestMapping("/item")
public class ItemController {





	/**
	 * リポジトリクラスのインスタンス
	 */
	@Autowired
	ItemRepository repository;

	/**
	 * サービスクラスのインスタンス
	 */
	@Autowired 
	public ItemService itemService;

	
	/**
	 * 一覧画面の表示
	 * @param model
	 * @return
	 */
	@GetMapping("/listexport")
	public String index(Model model) { 
		List<ItemEntity> item = itemService.findAll();
		model.addAttribute("itemList", item); 
		return "item/listexport"; 
	}


	/**
	 * 商品登録画面の表示
	 * @param itemForm
	 * @return
	 */


	@GetMapping("/create")
	public String create(@ModelAttribute ItemForm itemForm) {

		return "item/create";
	}


	/**
	 * 編集画面の表示
	 * @param itemForm
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/edit/{id}")
	public String edit(@ModelAttribute ItemForm ItemForm,@PathVariable Long id) {
		ItemEntity itemEntity = itemService.findOne(id);

		ItemForm.setId(itemEntity.getId());
		ItemForm.setName(itemEntity.getName());
		ItemForm.setPrice(itemEntity.getPrice());
		ItemForm.setContent(itemEntity.getContent());

		return "item/edit";
	}



	/**
	 * 商品登録した内容の保存
	 * @param itemForm
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@PostMapping("/create")
	public String createSave(@Validated ItemForm itemForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {

			return "item/create";
		}

	
		itemService.insert(itemForm);

		model.addAttribute("message", "お問い合わせを受け付けました。");
		return "item/create";
	}





	/**
	 * 商品登録情報の変更した内容の保存
	 * @param itemForm
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@PostMapping("/edit")
	public String update(@Validated ItemForm itemForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "item/edit";
		}


		itemService.update(itemForm);

		model.addAttribute("message", "お問い合わせを受け付けました。");
		return "item/edit";
	}





	/**
	 * 商品登録情報の削除
	 * @param id
	 * @return
	 */

	@PostMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		itemService.delete(id);
		return "item/listexport";
	}



}

