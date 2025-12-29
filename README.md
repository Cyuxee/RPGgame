# RPG Game - JavaFX 遊戲專案

## 專案簡介

這是一個使用 JavaFX 開發的 RPG 遊戲，具有完整的戰鬥系統、技能系統、道具系統和角色成長機制。

## 技術架構

### 開發環境
- **語言**: Java
- **GUI 框架**: JavaFX 17.0.10
- **建置工具**: Maven
- **JDK**: Oracle JDK 17+

### 專案結構


```text
RPGgame/
├── src/main/java/
│   ├── Main/        # 主程式入口
│   ├── GUI/         # 圖形介面
│   ├── Entities/    # 實體類別（玩家、怪物）
│   ├── Events/      # 事件處理
│   ├── Skills/      # 技能系統
│   ├── Objects/     # 道具系統
│   └── Datas/       # 資料管理
└── pom.xml
```

## 核心功能

### 🎮 戰鬥系統
- 回合制戰鬥機制
- 即時動畫效果
- 傷害顯示與特效
- 怪物 AI 系統

### ⚔️ 技能系統
- 多樣化技能設計
- 技能冷卻機制
- Buff/Debuff 狀態效果
- 技能動畫展示

### 🎒 道具系統
- HP/MP 恢復道具
- 戰鬥中使用道具
- 道具效果即時顯示

### 📊 角色成長
- 經驗值與等級系統
- 屬性點分配
- 裝備系統
- 角色狀態更新

## 執行方式

### 使用 Maven 執行
```bash
cd RPGgame
mvn javafx:run
```

#### 使用 Maven 打包
```bash
$ mvn clean package
```
#### 執行 JAR 檔
```bash
$ java -jar target/RPGgame-1.0-SNAPSHOT.jar
```

## 近期更新

### 🧵 改進執行緒與效能
- 所有 UI 更新統一透過 `Platform.runLater()` 執行，確保在 JavaFX Application Thread 中安全更新  
- 以 `PauseTransition` 取代 `Thread.sleep()`，避免阻塞 UI、提升介面回應性  
- 移除已廢棄的 `Thread.stop()`，改採 **協作式終止機制**，提升執行緒穩定性與可維護性  

### 🎨 CSS 與介面調整 
- 抑制不必要的 JavaFX CSS 警告訊息，簡化除錯輸出  
- 重新設計進度條與按鈕樣式，提升整體視覺一致性  

### ✨ 動畫與視覺效果更新
- 強化角色移動動畫的流暢度  
- 新增傷害數字彈出效果  
- 改進技能施放特效  
- 狀態變化加入即時視覺回饋  

### 🛠 問題修正
- 修正 UI 更新時可能發生的執行緒競爭問題  
- 忽略 Modena 主題造成的 CSS 警告訊息問題  

Thread.stop() 廢棄問題: 改用 volatile boolean 標誌控制執行緒
### 🔧 持續更新
- 效能調校
- 改善記憶體使用情況
- 更多遊戲內容擴充
- 全面改用 **十六進制色碼**，避免與 Modena 主題發生解析衝突  

Last Updated: 2025-12-29
Version: 1.2.0
