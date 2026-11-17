# Week 02 — Assignment 02：骰子模擬器 2（觸發事件）

[返回本週作業](../README.md) · [返回作業總覽](../../README.md)

狀態：程式已完成，編譯與功能檢查通過；執行截圖、個人心得待補。

## 題目摘要

由 Week 01 骰子模擬器延伸，練習「觸發事件」：按下按鈕後更新數字、統計、顏色，並用自行繪製的骰子圖案顯示點數。

- 視窗標題「骰子模擬器」、400 × 320、開啟置中、關閉結束程式。
- 上方顯示「已擲 N 次，總和 M，平均 X.XX」。
- 中央 60pt 數字，下方為自繪圓點骰子圖案（`paintComponent`）。
- 「擲骰子」按鈕每次產生 1～6；點數 1 紅色、6 綠色、其餘黑色。
- 尚未擲骰時數字顯示「—」，骰子只有外框。

本題規格依同學公開 repo 的做法整理（自繪圖案版本）；原始題目截圖不列為必要資料。

## 檔案說明

- [src/DiceSimulator2.java](src/DiceSimulator2.java)：視窗、按鈕事件、亂數與統計。
- [src/DicePanel.java](src/DicePanel.java)：骰子外框與圓點繪製。
- [TESTING.md](TESTING.md)、[EXPLANATION.md](EXPLANATION.md)、[AI-CONVERSATION.md](AI-CONVERSATION.md)、[screenshots/README.md](screenshots/README.md)。
- [Reflection.md](Reflection.md)：個人心得模板，待本人填寫。

## 編譯與執行

需 JDK 8 以上，並在有桌面介面的環境執行。兩個檔案要一起編譯。從 repo 根目錄：

```sh
cd week02/assignment02
mkdir -p out
javac -encoding UTF-8 -d out src/*.java
java -cp out DiceSimulator2
```

## 繳交檢查清單

- [x] 程式碼已加入
- [x] UTF-8 編譯通過
- [x] 功能檢查通過（300 次按鈕事件）
- [x] 測試紀錄、原理說明、AI 對話紀錄已加入
- [ ] 執行結果截圖已加入
- [ ] 個人 Reflection 已填寫並確認
