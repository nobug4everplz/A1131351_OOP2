# 骰子模擬器：原理與設計

## 目的與操作流程

程式開啟時顯示點數 0、次數 0、總和 0、平均 0.00。0 表示尚未擲骰，不是一次骰子的結果。按下「擲骰子」後，產生一個 1～6 的數字，更新點數、顏色及統計。

## 類別與元件分工

| 元件／欄位 | 工作 |
| --- | --- |
| DiceSimulator extends JFrame | 一個視窗物件，同時保存本次執行的累計狀態 |
| numberLabel | 中央點數；60pt，水平置中 |
| statsLabel | 上方顯示次數、總和、平均 |
| JButton | 接收使用者的擲骰操作 |
| Random | 提供亂數 |
| count、sum | 跨多次點擊保留次數與總和 |

BorderLayout 的 NORTH、CENTER、SOUTH 對應統計、點數、按鈕。這比指定每個元件的座標簡單，也讓中央區域隨視窗調整。setSize(400, 320) 設定整個視窗尺寸，包含標題列。

## 事件與資料流

```text
main → 在 Swing 事件執行緒建立視窗 → 等待操作
按下按鈕 → ActionListener → rollDice()
         → 產生 value → 累加 count、sum → 計算 average
         → 更新點數文字、顏色與統計文字
```

這是事件驅動：程式等待按鈕事件，不用自己寫無限迴圈讀取輸入。

## 關鍵語法與原因

- `random.nextInt(6) + 1`：nextInt(6) 的結果是 0～5，加一得到 1～6。
- `count++` 與 `sum += value`：每次點擊各更新一次。欄位保存累計值；value、average 是當次呼叫的區域變數。
- `(double) sum / count`：先轉成浮點數再相除，避免整數除法截斷。例如先後擲出 1、6，平均是 7 / 2.0 = 3.5。
- `String.format("已擲 %d 次，總和 %d，平均 %.2f", ...)`：%d 放整數，%.2f 將平均格式化為兩位小數，例如 3.50。數字格式受執行環境預設 Locale 影響。
- `e -> rollDice()`：Lambda 是按鈕事件處理器；e 為這次事件，這裡不需使用其內容。
- `setForeground(...)`：6 綠色、1 紅色，其餘黑色。每次都重新指定，避免保留前一次顏色。
- `SwingUtilities.invokeLater(...)`：在 Swing 的事件派送執行緒建立介面；按鈕處理器也在該執行緒執行，這份程式的更新工作很短。
- `private final JLabel`：private 限制外部直接存取；final 表示欄位不能改指向另一個 JLabel，仍可更新它的文字和顏色。
- `EXIT_ON_CLOSE`：使用者關閉視窗時結束程式。
- `setLocationRelativeTo(null)`：在設定尺寸後將視窗置中。

## 設計取捨

只有一個視窗與少量狀態，因此維持單一類別，將「建立介面」放在建構子、「一次擲骰」放在 rollDice()，不增加套件或建置工具。沒有新增重設、歷史紀錄或機率圖，避免超出題目。

目前 int 累計值適合一般課堂操作，極大量操作可能溢位；本作業未要求長時間壓力用途。程式也不保存資料，重新開啟會歸零。

## 執行與理解檢查

依 [README](README.md) 的指令編譯與執行；實際結果與證據限制（非待辦）見 [TESTING.md](TESTING.md)。

閱讀後可以試著回答：

1. 為何 count、sum 放在欄位，而不是 rollDice() 裡？
2. 為何 `(double) (sum / count)` 不能補回整數除法失去的小數？
3. 為何一般點數也必須指定黑色？
4. 編譯成功為何還不能證明視窗的操作正確？
