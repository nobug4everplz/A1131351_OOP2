# Week 01 — Assignment 01：登入視窗

[返回本週作業](../README.md) · [返回作業總覽](../../README.md)

狀態：程式、編譯、基本功能檢查、執行截圖與 AI 紀錄已完成；個人 Reflection 待填寫。

## 題目與範圍

依使用者提供的題目，使用 AI 生成「一個有輸入框和按鈕的登入視窗」，並檢視產生結果。提供的「作業_1.png」是課堂範例，不視為必須逐字複製的程式或額外功能規格。

採 Java Swing，提供帳號欄位、遮蔽密碼欄位與登入按鈕。空白帳號或未填密碼時顯示提示；兩欄皆填寫時顯示「已收到輸入；此示範未進行身分驗證。」每次送出清除密碼欄位。Enter 可觸發預設按鈕。
不實作帳號驗證、儲存、資料庫或網路連線。視窗大小由元件需求決定，非題目指定尺寸。

## 檔案

- [Java 原始碼](src/LoginWindow.java)
- [測試紀錄](TESTING.md)
- [執行截圖](screenshots/README.md)
- [AI 對話整理](AI-CONVERSATION.md)
- [原理、設計與範例檢視](EXPLANATION.md)
- [個人心得](Reflection.md)：待本人填寫。

## 編譯與執行

需要 JDK 8 以上及可顯示視窗的桌面環境。從 repo 根目錄執行：

```sh
javac -encoding UTF-8 -d out/week01-assignment01 week01/assignment01/src/LoginWindow.java
java -cp out/week01-assignment01 LoginWindow
```

## 繳交清單

- [x] 程式碼與規格
- [x] 編譯與基本功能檢查
- [x] 實際執行截圖
- [x] AI 對話紀錄（Markdown）
- [x] 原理與產生結果檢視
- [ ] 本人填寫並確認 Reflection
