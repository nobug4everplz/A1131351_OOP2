# 我的小房子：原理與設計說明

## 流程

`main` 建立 `JFrame` 並加入 `MyLittleHouse`（`JPanel` 子類）→ `pack()` 依 `preferredSize` 定窗大小 → Swing 呼叫 `paintComponent(Graphics g)` 繪圖。

## 繪圖順序

後畫的蓋在先畫的上面，所以依序：天空 → 草地 → 太陽 → 雲 → 房屋 → 屋頂 → 門 → 窗 → 簽名。

## 關鍵語法

- 座標原點在左上角，y 向下增加；`fillRect(x, y, w, h)` 的 (x, y) 是左上角。
- 太陽光芒：每 30 度一條，12 條剛好一圈：

```java
double a = Math.toRadians(i * 30);
g.drawLine(sx + (int)(38*Math.cos(a)), sy + (int)(38*Math.sin(a)),
           sx + (int)(52*Math.cos(a)), sy + (int)(52*Math.sin(a)));
```

起點在半徑 38、終點在半徑 52，所以光芒從太陽邊緣向外伸出。
- 屋頂用三條 `drawLine` 圍成三角形，不能用 `fillPolygon`，所以內部是天空色。
- 窗戶抽成 `drawWindow()`，兩扇共用，避免重複程式碼。

## 如何驗證

見 [README](README.md) 的編譯指令與 [TESTING.md](TESTING.md)。
