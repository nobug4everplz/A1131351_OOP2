# 我的小房子測試紀錄

日期：2026-11-17。環境：macOS Darwin 25.0.0、arm64，OpenJDK Temurin 25.0.4.1。

## 編譯

`javac -encoding UTF-8 -d out src/MyLittleHouse.java` 成功；`-Xlint:all` 僅有 `serial`、`this-escape` 警告。

## 繪圖檢查

用臨時程式（未提交）把面板離屏畫到 500×400 的 `BufferedImage`，檢查像素並目視輸出圖片。

| 項目 | 預期 | 實際 | 判定 |
| --- | --- | --- | --- |
| 畫布大小 | 500×400 | preferredSize 500×400 | 通過 |
| 天空／草地／太陽／房屋／門顏色 | 天藍／綠／黃／米黃／棕 | 取樣像素相符 | 通過 |
| 雲、光芒、屋頂、窗、簽名 | 依題目顯示 | 目視輸出圖片相符 | 通過 |
| 屋頂線段數 | 3 條 `drawLine` | 程式碼檢查：3 次 | 通過 |

## 真實視窗截圖

2026-11-17 在 macOS 實際啟動程式並以 `Robot` 擷取視窗，截圖見 [screenshots/README.md](screenshots/README.md)。天空、草地、太陽與光芒、雲、房屋、三線屋頂、門、兩扇十字窗與簽名皆顯示。

## 未驗證

- 關閉視窗後程式結束：程式設定 `EXIT_ON_CLOSE`，未直接觀察。
