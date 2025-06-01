package com.example.springpractice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springpractice.entity.ToDo;

// ToDoに関するDB操作（SELECT/INSERTなど）を担当するRepository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

    // タイトルで検索する例（任意で追加）
    List<ToDo> findByTitle(String title);
}
