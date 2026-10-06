# Week 01 — Assignment 02：骰子模擬器

[返回本週作業](../README.md) · [返回作業總覽](../../README.md)

狀態：編譯通過，四張執行截圖與 Markdown AI 對話紀錄已加入；原始題目圖、個人心得及部分動態驗證待補。

## 題目摘要

使用 Java Swing 建立骰子模擬器：

- 視窗標題「骰子模擬器」、尺寸 400 × 320，開啟時置中，關閉時結束程式。
- 中央以 60pt 的 JLabel 顯示目前點數。
- 下方提供「擲骰子」按鈕，每次按下隨機產生 1～6 並更新顯示。
- 上方顯示擲骰次數、點數總和與平均值，平均值保留兩位小數。
- 點數為 6 時顯示綠色，1 時顯示紅色，其餘為黑色。

摘要依已提供的骰子題目整理；原始題目截圖仍待補。

## 本次範圍

只整理骰子作業與其完成狀態；保留 src/DiceSimulator.java 原始內容，不新增功能、不修改其他作業。

## 檔案說明

- [src/DiceSimulator.java](src/DiceSimulator.java)：原有骰子程式，僅搬移位置。
- [screenshots/README.md](screenshots/README.md)：截圖種類與命名方式。
- [TESTING.md](TESTING.md)：實際測試結果與 GUI 驗收步驟。
- [EXPLANATION.md](EXPLANATION.md)：原理、元件分工及設計取捨。
- [AI-CONVERSATION.md](AI-CONVERSATION.md)：經使用者同意取代 AI 對話截圖的整理紀錄。
- [Reflection.md](Reflection.md)：個人心得模板，待本人填寫。

## 編譯與執行

需安裝 JDK 8 或更新版本，並在有桌面介面的環境執行。從 repo 根目錄依序執行：

```sh
cd week01/assignment02
mkdir -p out
javac -encoding UTF-8 -d out src/DiceSimulator.java
java -cp out DiceSimulator
```

初始點數為 0，代表尚未擲骰。編譯產物放在已忽略的 `out/`。

## 繳交檢查清單

- [x] 程式碼已加入
- [x] UTF-8 編譯通過
- [x] 測試紀錄與原理說明已加入
- [ ] 題目截圖已加入
- [ ] 已實際執行並確認符合題目
- [x] 執行結果截圖已加入（初始、黑色、綠色、紅色）
- [x] AI 對話紀錄已加入（Markdown）
- [ ] 個人 Reflection 已填寫並確認

## 執行驗證項目

截圖已確認初始狀態、黑／綠／紅三種顏色與所示平均值。以下為完整驗收要求，尚未直接驗證的細項見 [TESTING.md](TESTING.md)。

- 開啟時視窗大小、位置、標題與初始統計正確，關閉後程式結束。
- 按下按鈕後點數介於 1～6，次數每次加一，總和與平均值正確。
- 點數 1 為紅色、6 為綠色，其餘為黑色，平均顯示兩位小數。
