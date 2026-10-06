# 登入視窗測試紀錄

日期：2026-10-06。環境：macOS、Temurin OpenJDK 25.0.4.1。
編譯指令見 [README](README.md)。

## 實際結果

- 編譯 LoginWindow.java 成功（exit 0）。
- 初次受限環境啟動 exit 134，沒有診斷輸出；允許桌面執行後成功。
- 自動驗證程式在 EDT 建立真正的 LoginWindow，透過 setText() 輸入測試值與 JButton.doClick() 觸發事件，完成下列 7 項斷言；全部通過。
- 使用 java.awt.Robot 擷取實際視窗所在的螢幕區域，並人工式視覺檢視三張圖片，未發現元件裁切。

| 操作／檢查 | 預期與實際結果 |
| --- | --- |
| 開啟視窗 | 帳號、密碼、登入按鈕皆顯示 |
| 檢查密碼欄位 | echoChar 非零，截圖可見圓點遮蔽 |
| 兩欄空白送出 | 顯示「請填寫帳號與密碼。」 |
| 只有帳號送出 | 顯示相同缺少資料提示 |
| 帳號為三個空格、密碼有值 | 顯示相同缺少資料提示 |
| 帳號 student-demo、測試密碼有值 | 顯示收到輸入、未進行身分驗證 |
| 送出後 | 密碼欄位為空 |

截圖中的 student-demo 為虛構測試帳號。測試不使用真實帳密。

## 證據與重現

[初始視窗](screenshots/result-01.png)、[輸入資料](screenshots/result-02.png)、[送出結果](screenshots/result-03.png)。

手動重現：啟動程式，先直接按登入，再只填帳號送出，接著測試空格帳號，最後填入任意測試帳密後送出。第二張截圖保留前一次空白測試提示，因提示在下一次送出才更新。

自動檢查使用的工具程式保存在 [verification/LoginCheck.java](verification/LoginCheck.java)，不屬於主程式。從作業目錄可執行：

```sh
javac -encoding UTF-8 -d out src/LoginWindow.java verification/LoginCheck.java
java -cp out LoginCheck screenshots
```

此命令會開啟桌面視窗並覆寫三張結果截圖，需桌面及螢幕擷取權限。測試操作為程式化事件，未宣稱真人滑鼠／鍵盤端到端測試。Enter 鍵、關閉程序、跨平台外觀未直接操作驗證；不是本次額外待補項目。實際身分驗證不在本題範圍。
