package com.example.springpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springpractice.form.ContactForm;

@Controller
public class ContactFormController {

    /**
     * フォーム入力画面を表示するメソッド
     * GETリクエストで"/form"にアクセスされたときに呼ばれる
     * Modelに既にFlash属性で渡されたcontactFormがなければ、新しく空のContactFormを追加してフォームを初期化する
     */
    @GetMapping("/form")
    public String form(Model model) {
        // Flash属性からcontactFormが届いていなければ新規作成
        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactForm());
        }
        // contactFormView.htmlを返し、フォームを表示
        return "contactFormView";
    }

    /**
     * 入力確認画面を表示するメソッド
     * GETリクエストで"/confirm"にアクセスされたときに呼ばれる
     * Flash属性で渡されたcontactFormを@ModelAttributeで受け取り、確認画面に表示する
     */
    @GetMapping("/confirm")
    public String confirm(@ModelAttribute("contactForm") ContactForm form) {
        // 特に処理はせず、確認画面のビュー名を返す
        return "confirmView";
    }

    /**
     * フォーム送信時の処理
     * POSTリクエストで"/form"にアクセスされたときに呼ばれる
     * @ValidatedでContactFormのバリデーションを実行し、BindingResultで結果を受け取る
     * バリデーションエラーがあれば、エラー情報と入力値をFlash属性に入れてリダイレクトし、フォーム画面へ戻す
     * エラーがなければ、入力内容をFlash属性に入れて確認画面へリダイレクトする
     */
    @PostMapping("/form")
    public String formSubmit(
            @Validated ContactForm form,
            BindingResult result,
            Model model,
            RedirectAttributes redirect) {

        if (result.hasErrors()) {
            // バリデーションエラーがある場合
            // 特殊キーでBindingResultをFlash属性に格納し、エラー情報をリダイレクト先に渡す
            redirect.addFlashAttribute("org.springframework.validation.BindingResult.contactForm", result);
            // 入力フォームの内容もFlash属性に格納
            redirect.addFlashAttribute("contactForm", form);
            // フォーム画面にリダイレクト（リダイレクト先でエラー情報を受け取る）
            return "redirect:/form";
        }

        // バリデーション成功時はフォームの内容をFlash属性に格納して確認画面へリダイレクト
        redirect.addFlashAttribute("contactForm", form);
        return "redirect:/confirm";
    }
}


