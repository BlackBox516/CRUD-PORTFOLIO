package com.example.demo.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.entities.ItemEntity;
import com.example.demo.forms.ItemForm;
import com.example.demo.repositries.ItemRepository;





@Service
public class ItemService {


	@Autowired
	private ItemRepository itemRepository;

	public ItemEntity findOne(long id) {
		return itemRepository.findById(id).orElse(null);
	}


	/**
	 * 一覧画面の表示のロジック
	 * @return
	 */
	public List<ItemEntity> findAll() {
		return itemRepository.findAll();
	}

	/**
	 * 商品の登録又は変更した内容の保存をするためのロジック
	 * @param itemForm
	 */

	public void insert(ItemForm itemForm) {
		
		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setId(itemForm.getId());
		itemEntity.setName(itemForm.getName());
		itemEntity.setPrice(itemForm.getPrice());
		itemEntity.setContent(itemForm.getContent());
		itemRepository.saveAndFlush(itemEntity);
	}
	
	/**
	*登録した情報の更新した内容を保存するためのロジック
	*/
    public void update(ItemForm itemForm) {

        ItemEntity itemEntity = findOne(itemForm.getId());
        itemEntity.setName(itemForm.getName());
        itemEntity.setPrice(itemForm.getPrice());
        itemEntity.setContent(itemForm.getContent());
        itemRepository.save(itemEntity);
    }

	/**
	 * 商品登録情報の削除のロジック
	 * @param id
	 */
	public void delete(long id) {
		itemRepository.deleteById(id);
	}




}



