# 骰子模擬器 2：原理與設計說明

## 流程

```text
按下「擲骰子」→ ActionEvent → actionPerformed → rollDice()
  → 產生 1～6、更新次數／總和／平均、數字與顏色
  → dicePanel.setPoint(value, color) → repaint() → paintComponent() 重畫圖案
```

## 元件分工

- `DiceSimulator2`：`JFrame`，BorderLayout。NORTH 統計、CENTER 放 60pt 數字與骰子面板、SOUTH 按鈕。擲骰與統計都在這個類別。
- `DicePanel`：只負責畫圖，保存目前點數與顏色。

## 關鍵語法

- `rollButton.addActionListener(e -> rollDice())`：註冊事件傾聽者（lambda）。
- `repaint()` 只是「請 Swing 稍後重畫」，真正畫圖在 `paintComponent(Graphics g)`；記得先呼叫 `super.paintComponent(g)` 清掉舊圖。
- 圓點位置：把骰子分成 3×3 格，用 `PIPS[點數]` 存要畫的格子索引，如 6 點是 `{0, 2, 3, 5, 6, 8}`，不必寫六套座標。

```java
int cx = x + (idx % 3) * cell + cell / 2;   // 欄
int cy = y + (idx / 3) * cell + cell / 2;   // 列
```

## 設計原因

- 擲骰只發生在按鈕事件中；`paintComponent` 只依目前狀態畫，視窗被拉動重畫時不會重擲。
- 數字與圖案共用同一次的 `value` 與 `color`，兩者不會不一致。
- 自己畫圓點而非用 Unicode 骰子字元，不依賴字型，各平台外觀一致。
- 點數 0 代表尚未擲骰，只畫外框。

## 如何驗證

見 [README](README.md) 的編譯指令與 [TESTING.md](TESTING.md)。
