# Week 01 — Assignment 02：骰子模擬器

[返回本週作業](../README.md) · [返回作業總覽](../../README.md)

狀態：已有程式，執行驗證與其他資料待補。

## 題目摘要

使用 Java Swing 建立骰子模擬器：

- 視窗標題「骰子模擬器」、尺寸 400 × 320，開啟時置中，關閉時結束程式。
- 中央以 60pt 的 JLabel 顯示目前點數。
- 下方提供「擲骰子」按鈕，每次按下隨機產生 1～6 並更新顯示。
- 上方顯示擲骰次數、點數總和與平均值，平均值保留兩位小數。
- 點數為 6 時顯示綠色，1 時顯示紅色，其餘為黑色。

摘要依已提供的骰子題目整理；原始題目截圖仍待補。

## 檔案說明

- [src/DiceSimulator.java](src/DiceSimulator.java)：原有骰子程式，僅搬移位置。
- [screenshots/README.md](screenshots/README.md)：截圖種類與命名方式。
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
- [ ] 題目截圖已加入
- [ ] 已實際執行並確認符合題目
- [ ] 執行結果截圖已加入
- [ ] AI 對話截圖已加入
- [ ] 個人 Reflection 已填寫並確認

## 執行驗證項目（待驗證）

- 開啟時視窗大小、位置、標題與初始統計正確，關閉後程式結束。
- 按下按鈕後點數介於 1～6，次數每次加一，總和與平均值正確。
- 點數 1 為紅色、6 為綠色，其餘為黑色，平均顯示兩位小數。
