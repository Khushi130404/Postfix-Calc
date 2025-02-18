# 📱 Postfix-Calc

Postfix-Calc is an Android application built using Java in Android Studio. It is a calculator that uses Infix to Postfix conversion to evaluate mathematical expressions. The calculator provides a simple and intuitive user interface resembling the iOS calculator.

## 🎯 Features
- Converts infix expressions to postfix notation
- Supports the following operations:
  - ➕ Addition (`+`)
  - ➖ Subtraction (`-`)
  - ✖️ Multiplication (`×`)
  - ➗ Division (`÷`)
  - 🔢 Modulus (`%`)
  - 📝 Parentheses (`(` and `)`)
  - ✅ Equals (`=`) to evaluate the expression
  - 🧹 Clear (`AC`) and 🔙 Backspace (`BACK`) operations
- 📱 User-friendly UI designed similar to the iOS calculator

## 🛠 Technologies Used
- **Android Studio**: IDE for development
- **Java**: Programming language
- **Stack Data Structure**: Used for infix to postfix conversion

## 🔢 Infix to Postfix Conversion
The conversion follows these precedence rules:
- **Operators Precedence**:
  - ➕ `+`, ➖ `-` have the lowest precedence
  - ✖️ `×`, ➗ `÷`, 🔢 `%` have higher precedence
  - 📝 `(` has the highest precedence for parsing purposes
- Operands are directly added to the postfix expression
- Operators are pushed onto a stack according to precedence
- Parentheses are handled separately for grouping expressions

## 🏗 Code Structure
The core logic for infix to postfix conversion and evaluation is implemented in:
- **`Infix_To_Postfix1.java`**:
  - `infixPrec(char c)`: Determines the precedence of operators in the infix expression.
  - `stackPrec(char c)`: Determines the precedence of operators in the stack.
  - `rank(char c)`: Returns the rank of an operator to ensure proper expression evaluation.
  - `infix_Postfix()`: Converts an infix expression to postfix notation.
- **`Evaluation1.java`**:
  - `evaluate(float a, float b, char c)`: Performs arithmetic operations based on the operator.
  - `postfixEvaluation()`: Evaluates a postfix expression using a stack.

## 📥 Installation & Usage
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/Postfix-Calc.git
   ```
2. Open the project in Android Studio.
3. Build and run the application on an Android device or emulator.

## 🤝 Contributing
Feel free to contribute to this project by submitting pull requests or reporting issues. Any improvements to the UI or performance optimizations are welcome.

## 📜 License
This project is licensed under the MIT License.

---
Developed by [Your Name] 🚀

