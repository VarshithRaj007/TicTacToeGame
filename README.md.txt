# Tic Tac Toe Game (Java - CLI)

## 📌 Problem Statement
This project is a **command-line based Tic Tac Toe game** developed in **Java**, where **two players** can play against each other using symbols:
- Player 1: **X**
- Player 2: **O**

The game displays the board after each move, validates user input, checks for win/draw, and asks if the players want to play again.

---

## ✅ Features
- 3×3 Tic Tac Toe board
- Two-player mode (X vs O)
- Input validation (only valid row/column & empty cells allowed)
- Winner detection after every move
- Draw detection
- Play again option
- Clean board display in terminal

---

## 🎮 How to Play
- The game prompts the player to enter:
  - **Row (1-3)**
  - **Column (1-3)**
- Example: `row=1 col=3` places the symbol in the **top-right** cell.
- Players take turns until someone wins or the game ends in a draw.

---

## ▶️ How to Run

### 1) Compile
       javac TicTacToe.java
### 2) Run
       java TicTacToe