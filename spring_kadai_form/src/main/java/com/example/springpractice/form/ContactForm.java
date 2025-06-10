package com.example.springpractice.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

/**
 * お問い合わせフォームの入力値を保持するクラス
 * 
 * バリデーションアノテーションを利用して、必須項目やメール形式のチェックを行う
 */
@Data
public class ContactForm {
	
	/**
	 * お名前
	 * NotBlank: 空白文字やnullを許容せず、必須入力項目とする
	 * message属性でエラーメッセージを指定
	 */
	@NotBlank(message = "お名前を入力してください。")
	private String name;
	
	/**
	 * メールアドレス
	 * NotBlankで必須入力を担保しつつ、Emailアノテーションで形式の妥当性をチェック
	 * Emailのmessage属性で形式が不正な場合のエラーメッセージを指定
	 */
	@NotBlank
	@Email(message = "メールアドレスの入力形式が正しくありません。")
	private String email;
	
	/**
	 * お問い合わせ内容
	 * NotBlankで必須入力項目に設定し、空欄を許可しない
	 * メッセージを指定しユーザーに分かりやすいバリデーションメッセージを提供
	 */
	@NotBlank(message = "お問い合わせ内容を入力してください。")
	private String message;
}
