# Week 02 — Assignment 01：單位換算器

[返回本週作業](../README.md) · [返回作業總覽](../../README.md)

狀態：程式已完成，編譯與功能檢查通過；真實視窗截圖已加入；Reflection 為 AI 草稿，待本人修改確認。

## 題目摘要

使用 Java Swing 建立單位換算器：

- 視窗標題「單位換算器」，尺寸 480 × 280，使用 `BorderLayout`。
- `NORTH`：`JComboBox` 選換算類型（長度／重量／溫度）。
- `CENTER`：兩列，每列一個 `JTextField` 加一個單位 `JComboBox`（上列為來源，下列為結果）。
- 切換類型時，兩個單位選單一起更新。
- 長度：公尺、公分、英吋、英尺；重量：公斤、公克、磅、盎司；溫度：攝氏、華氏、克氏。
- `SOUTH`：「換算」按鈕，結果顯示於第二個 `JTextField`（唯讀）。

摘要依同學公開 repo 的題目整理；原始題目截圖不列為必要資料。

## 檔案說明

- [src/UnitConverter.java](src/UnitConverter.java)：主程式。
- [TESTING.md](TESTING.md)：測試紀錄。
- [EXPLANATION.md](EXPLANATION.md)：原理與設計說明。
- [AI-CONVERSATION.md](AI-CONVERSATION.md)：AI 協作重點整理。
- [screenshots/README.md](screenshots/README.md)：截圖說明。
- [Reflection.md](Reflection.md)：個人心得模板，待本人填寫。

## 編譯與執行

需 JDK 8 以上，並在有桌面介面的環境執行。從 repo 根目錄：

```sh
cd week02/assignment01
mkdir -p out
javac -encoding UTF-8 -d out src/UnitConverter.java
java -cp out UnitConverter
```

結果顯示到小數點後 4 位；輸入空白或非數字會跳出錯誤提示、不換算。

## 繳交檢查清單

- [x] 程式碼已加入
- [x] UTF-8 編譯通過
- [x] 功能檢查（換算、選單同步、錯誤輸入）通過
- [x] 測試紀錄、原理說明、AI 對話紀錄已加入
- [x] 執行結果截圖已加入（真實視窗）
- [ ] 個人 Reflection 已確認（AI 草稿已備，待本人修改確認）
