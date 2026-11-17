# 單位換算器測試紀錄

日期：2026-11-17。環境：macOS Darwin 25.0.0、arm64，OpenJDK Temurin 25.0.4.1。

## 編譯

`javac -encoding UTF-8 -d out src/UnitConverter.java` 成功；`-Xlint:all` 僅有 `serial`、`this-escape` 兩項警告（Swing 子類常見，不影響功能）。

## 功能檢查

用臨時測試程式（未提交）以反射呼叫 `convert`，並以 `JButton.doClick` 驅動實際視窗。

| 項目 | 預期 | 實際 | 判定 |
| --- | --- | --- | --- |
| 標題、尺寸、版面 | 單位換算器、480×280、BorderLayout | 相符 | 通過 |
| 長度 | 1 m→100 cm；1 ft→12 in；30.48 cm→1 ft | 100／12／1 | 通過 |
| 重量 | 1 kg→2.2046 磅；500 g→0.5 kg；1 磅→16 盎司 | 相符 | 通過 |
| 溫度 | 100°C→212°F；32°F→0°C；0°C→273.15 K；273.15 K→32°F | 相符 | 通過 |
| 選單同步 | 切到溫度後兩個單位選單皆為 3 項 | 3、3 | 通過 |
| 結果欄 | 不可編輯 | editable=false | 通過 |
| 關閉設定 | EXIT_ON_CLOSE | true | 通過 |

## 未驗證

- 空白／非數字輸入的錯誤對話框：程式碼會先檢查並 return，但對話框未實際點擊觀察。
- 真實視窗的截圖：尚未加入。
