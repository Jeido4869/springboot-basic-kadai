package com.example.springpractice.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springpractice.entity.ToDo;
import com.example.springpractice.service.ToDoService;

// 画面とサービスの橋渡し役（HTTPリクエストを処理）
@Controller
public class ToDoController {

    private final ToDoService todoService;

    // コンストラクタインジェクションでサービスを注入
    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }

    // "/" にアクセスされたとき、全ToDoを取得してテンプレートへ渡す
    @GetMapping("/todo")
    public String showToDoList(Model model) {
        List<ToDo> todos = todoService.getAllToDos();
        model.addAttribute("todos", todos);  // HTMLへ渡す変数名 "todos"
        return "todoView";  // 表示するテンプレートファイル名
    }
}

