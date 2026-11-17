# 單位換算器：原理與設計說明

## 目的與操作流程

選類型 → 輸入數值、選來源與目標單位 → 按「換算」→ 第二個文字欄顯示結果。

## 元件分工

| 位置 | 元件 | 作用 |
| --- | --- | --- |
| NORTH | `categoryBox` | 選類型 |
| CENTER（2×2 `GridLayout`） | `inputField`、`fromUnitBox`、`resultField`、`toUnitBox` | 輸入、單位選擇、結果 |
| SOUTH | 換算按鈕 | 觸發換算 |

## 事件與資料流

- `categoryBox` 的 `ActionListener` 呼叫 `updateUnits()`，用 `setModel(new DefaultComboBoxModel<>(units))` 同時換掉兩個單位選單。
- 按鈕事件呼叫 `onConvert()`：解析數字 → 呼叫 `convert(類型索引, 來源索引, 目標索引, 數值)` → `String.format("%.4f")` 寫入結果欄。

## 關鍵設計：先轉基準單位

N 種單位互轉若寫 N×N 條公式太多。改成「來源 → 基準單位 → 目標」：

```java
return value * TO_BASE[category][from] / TO_BASE[category][to];
```

長度基準為公尺、重量為公斤，`TO_BASE` 存各單位換成基準的倍率（如英吋 0.0254）。溫度不是單純倍率（有偏移），所以另用 `toCelsius`／`fromCelsius`，以攝氏為基準。

## 其他取捨

- 用索引而非中文字串比對單位，避免字串打錯。
- 輸入空白、非數字、`NaN`／`Infinity` 一律提示錯誤，是外部輸入的必要檢查。

## 如何驗證

見 [README](README.md) 的編譯指令與 [TESTING.md](TESTING.md)。
