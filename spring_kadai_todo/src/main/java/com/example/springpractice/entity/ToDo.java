package com.example.springpractice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

// ToDoエンティティ：データベースのToDoテーブルに対応
@Entity
@Table(name = "todos")
@Data
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番
    private Integer id;

    private String title;  // タイトル

    @Enumerated(EnumType.STRING)
    private Priority priority;  // 優先度（ENUM）

    private String status;  // ステータス（例：未完了、完了）

    // 優先度の列挙型（ENUM）
    public enum Priority {
        高, 中, 低
    }
}
