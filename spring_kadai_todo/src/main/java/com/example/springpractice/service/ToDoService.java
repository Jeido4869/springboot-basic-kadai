package com.example.springpractice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springpractice.entity.ToDo;
import com.example.springpractice.repository.ToDoRepository;

// ビジネスロジックを担当（例：DBとのやり取りなど）
@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    // コンストラクタによる依存注入（Springが自動でインスタンスを渡す）
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    // 全ToDoを取得
    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }
}
