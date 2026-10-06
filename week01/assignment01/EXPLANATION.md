# 登入視窗：原理與設計

## 操作與資料流

main → Swing 事件執行緒建立視窗 → 輸入帳密 → 按下登入 → 檢查有無填寫 → 更新提示 → 清除密碼。
這是表單操作示範；有填資料不代表身分驗證成功。

## 元件分工

| 元件 | 用途 |
| --- | --- |
| JFrame | 承載視窗與關閉行為 |
| JLabel | 顯示欄位名稱及操作結果 |
| JTextField | 接收帳號 |
| JPasswordField | 遮蔽密碼顯示，以 getPassword() 取得 char[] |
| JButton | 發出 ActionEvent，呼叫 submitForm() |
| JPanel 與 Layout | 將欄位、提示及按鈕組成畫面 |

GridLayout 將兩列標籤與欄位排列整齊；BorderLayout 分開表單與底部回饋，FlowLayout 將按鈕靠右。pack() 依元件建議尺寸決定視窗大小，避免手算座標。元件建立完成後才顯示視窗。

## 關鍵語法

- extends JFrame：LoginWindow 繼承視窗功能。
- private final：限制欄位存取，且欄位所指向的元件不再換成另一個物件；元件內容仍可變更。
- addActionListener(event -> submitForm())：lambda 表示按下按鈕後執行的方法。
- trim().isEmpty()：帳號只有一般空白也視為未填。
- try/finally：無論走哪個提示分支，都清除密碼暫存陣列與輸入框；不印出或儲存密碼。
- SwingUtilities.invokeLater：將建立與顯示 Swing 視窗的工作交給事件派送執行緒（EDT）。
- setDefaultButton：讓 Enter 可觸發登入按鈕。

密碼遮蔽只避免畫面直接顯示文字，並不等於加密或完整登入安全機制。

## 課堂範例檢視

以下依使用者提供圖片的可見內容分析，圖片右側程式被截斷，不推測完整密碼條件，也沒有執行範例原碼。

| 可見寫法 | 問題與本次設計 |
| --- | --- |
| setLayout(null)，沒有可見的 setBounds | 元件沒有配置位置與尺寸，可能無法正常呈現；本次使用 Layout Manager |
| setVisible(true) 在加入元件之前 | 顯示時機過早；本次全部配置完成後才顯示 |
| 密碼使用 JTextField | 密碼直接可見；本次使用 JPasswordField |
| 用 == 比較文字 | 比較的是物件參照；比較字串內容通常應用 equals()。本次沒有固定帳密驗證需求，因此不增加驗證條件 |
| main 直接 new 視窗 | 未使用 EDT 建立 GUI；本次使用 invokeLater |
| 成功訊息印在終端 | 使用者難以從視窗知道結果；本次在 JLabel 顯示回饋，且不誤稱驗證成功 |

產生結果已實際檢視：標籤與欄位清楚顯示、密碼以圓點遮蔽、按鈕回饋可見。這些結果由 AI 執行並檢視，不能代替學生自己的個人心得。

## 執行與驗證

依 [README](README.md) 的指令執行。檢查方法與證據見 [TESTING](TESTING.md)。
