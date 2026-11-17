# Week 03 — Assignment 01：我的小房子

[返回本週作業](../README.md) · [返回作業總覽](../../README.md)

狀態：程式已完成，編譯與繪圖檢查通過；執行截圖、個人心得待補。

## 題目摘要

用 Java Swing 的 `paintComponent` 畫一幅 500 × 400 的小房子風景：

| 要求 | 實作 |
| --- | --- |
| 500 × 400 畫布 | `setPreferredSize` + `pack()` |
| 天空與草地 | 兩個 `fillRect`（天藍、綠） |
| 黃色正圓太陽、至少 8 條光芒 | `fillOval` 60×60；迴圈 + `Math.cos/sin` 畫 12 條 `drawLine` |
| 至少 3 個重疊白色橢圓的雲 | 3 個白色 `fillOval` |
| 房屋主體 | `fillRect` + `drawRect` |
| 屋頂只能用三條線段 | 恰好 3 次 `drawLine`，不填色 |
| 門與門把 | `fillRoundRect` + 小 `fillOval` |
| 至少 2 扇十字窗 | `fillRect` + `drawRect` + 2 條 `drawLine`，共 2 扇 |
| 角落簽名 | `drawString("A1131351 孟祥文", 15, 385)` |

規格依同學公開 repo 的題目整理；原始題目截圖不列為必要資料。週次依同學 repo 的編排放在 Week 03，若老師週次不同請調整。

## 檔案說明

- [src/MyLittleHouse.java](src/MyLittleHouse.java)：主程式。
- [TESTING.md](TESTING.md)、[EXPLANATION.md](EXPLANATION.md)、[AI-CONVERSATION.md](AI-CONVERSATION.md)、[screenshots/README.md](screenshots/README.md)。
- [Reflection.md](Reflection.md)：個人心得模板，待本人填寫。

## 編譯與執行

需 JDK 8 以上，並在有桌面介面的環境執行。從 repo 根目錄：

```sh
cd week03/assignment01
mkdir -p out
javac -encoding UTF-8 -d out src/MyLittleHouse.java
java -cp out MyLittleHouse
```

## 繳交檢查清單

- [x] 程式碼已加入
- [x] UTF-8 編譯通過
- [x] 畫面像素與尺寸檢查通過
- [x] 測試紀錄、原理說明、AI 對話紀錄已加入
- [ ] 執行結果截圖已加入
- [ ] 個人 Reflection 已填寫並確認
