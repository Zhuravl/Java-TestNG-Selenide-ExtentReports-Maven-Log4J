# Test Suite-1. "Login and Logout (Positive cases)".
#### Description: *Тест-кейси для перевірки успішної авторизації та виходу з системи з валідними даними.*
___


### [login_tc_1] – Перевірка логіну із валідними даними.

- **Priority:** High

- **Type:** Functional


- **Preconditions:** 
  
    - Сторінка з формою логіну доступна.
  
    - Користувач зареєстрований в системі.


- **Credentials:**

  - email: loginer@usource.com.ua
  - password: TY#pUEcGz7nN%b

  
- **Steps**
  

    Step 1: Відкрити сторінку логіну.
    Expected Result: На сторінці відображається форма логіну з наступними елементами:
        a) поле "Email";
        b) поле "Password";
        c) кнопка "Login".

    Step 2: Ввести валідні дані у поле "Email".
    Expected Result: Введене значення відображається коректно.

    Step 3: Ввести валідний пароль у поле "Password".
    Expected Result: Символи пароля відображаються прихованими.

    Step 4: Натиснути на кнопку "Login".
    Expected Result: 
        a) форма логіну закрилась;
        b) користувач потрапляє на головну сторінку;
        с) у правому верхньому кутку відображається email користувача.

---

### [login_tc_2] – Перевірка вилогінювання.

- **Dependencies:** Успішне виконання Login_TC_1.

- **Priority:** High

- **Type:** Functional


- **Preconditions:** Користувач залогінений на сайті.


- **Steps**


    Step 1: У правому верхньому кутку натиснути на email користувача.
    Expected Result: З'явився випадаючий список, у якому присутній елемент "Logout".

    Step 2: Натиснути на елемент "Logout" у випадаючому списку.
    Expected Result: Користувач потрапляє на сторінку із формою логіну.

---

# Test Suite-2. "Login user (Negative cases)".
#### Description: *Тест-кейси для перевірки некоректних сценаріїв авторизації: відсутні або невалідні дані у полях логіну, неправильні креденшали та інші негативні кейси.*

---


### [login_tc_3] Перевірка логіну з незаповненими полями "Email" та "Password".

- **Priority:** Medium

- **Type:** Functional


- **Preconditions:** Сторінка з формою логіну відкрита.
    


- **Steps**


    Step 1: Залишити поле "Email" порожнім.
    Expected Result: Поле "Email" порожнє.

    Step 2: Залишити поле "Password" порожнім.
    Expected Result: Поле "Password" порожнє.

    Step 3: Натиснути на кнопку "Login".
    Expected Result: 
        a) користувача не залогінено;
        b) під полем "Email" відображається повідомлення про обов’язковість введення email.
        c) під полем "Password" відображається повідомлення про обов’язковість введення пароля.


---

### [login_tc_4] Перевірка логіну з незаповненим полем "Password".

- **Priority:** Medium

- **Type:** Functional


- **Preconditions:** Сторінка з формою логіну відкрита.

- **Credentials:**

  - email: loginernew@usource.com.ua


- **Steps**


    Step 1: Ввести валідні дані у поле "Email".
    Expected Result: Введене значення відображається коректно.

    Step 2: Залишити поле "Password" порожнім.
    Expected Result: Поле "Password" порожнє.

    Step 3: Натиснути на кнопку "Login".
    Expected Result: 
        a) користувача не залогінено;
        b) під полем "Password" відображається повідомлення про обов’язковість введення пароля.


---

### [login_tc_5] Перевірка логіну з email, що не зареєстрований в системі".

- **Priority:** High

- **Type:** Functional


- **Preconditions:** Сторінка з формою логіну відкрита.


- **Credentials:**

  - email: loginernew@usource.com.ua
  - password: TY#pUEcGz7nN%b
  

- **Steps**


    Step 1: Ввести не зареєстрований в системі email у поле "Email".
    Expected Result: Введене значення відображається коректно.

    Step 2: Ввести валідний пароль у поле "Password".
    Expected Result: Символи пароля відображаються прихованими.

    Step 3: Натиснути на кнопку "Login".
    Expected Result: 
        a) користувача не залогінено;
        b) відображається повідомлення "Invalid credentials!".

    Step 4: Перезавантажити сторінку.
    Expected Result: Форма логіну відображається із порожніми полями "Email" та "Password" без повідомлень про помилки.

---


### [login_tc_6] Перевірка логіну з email у некоректному форматі".

- **Priority:** Medium

- **Type:** Functional


- **Credentials:** 
  
    - email: loginer.usource.com.ua
    - password: TY#pUEcGz7nN%b


- **Preconditions:** Сторінка з формою логіну відкрита.



- **Steps**


    Step 1: Ввести email у некоректному форматі в поле "Email".
    Expected Result: Введене значення відображається у відповідному полі.

    Step 2: Ввести валідний пароль у поле "Password".
    Expected Result: Символи пароля відображаються прихованими.

    Step 3: Натиснути на кнопку "Login".
    Expected Result: 
        a) користувача не залогінено;
        b) відображається повідомлення "Invalid credentials!".

---


### [login_tc_7] Перевірка логіну з неправильним паролем".

- **Priority:** Medium

- **Type:** Functional


- **Credentials:**

  - email: loginer@usource.com.ua
  - password: 123@Fgh0lj


- **Preconditions:** Сторінка з формою логіну відкрита.



- **Steps**


    Step 1: Ввести валідні дані у поле "Email".
    Expected Result: Введене значення відображається коректно.

    Step 2: Ввести неправильний пароль у поле "Password".
    Expected Result: Символи пароля відображаються прихованими.

    Step 3: Натиснути на кнопку "Login".
    Expected Result: 
        a) користувача не залогінено;
        b) відображається повідомлення "Invalid credentials!".

---

### [login_tc_8] Перевірка логіну: передаєм email у подвійних лапках.

- **Priority:** Medium

- **Type:** Functional


- **Credentials:**

  - email: "loginer@usource.com.ua"
  - password: TY#pUEcGz7nN%b


- **Preconditions:** Сторінка з формою логіну відкрита.



- **Steps**


    Step 1: Ввести у поле "Email" валідний email у подвійних лапках.
    Expected Result: Введене значення відображається коректно.

    Step 2: Ввести валідний пароль у поле "Password".
    Expected Result: Символи пароля відображаються прихованими.

    Step 3: Натиснути на кнопку "Login".
    Expected Result: 
        a) користувача не залогінено;
        b) відображається повідомлення "Invalid credentials!".

---


### [login_tc_9] Перевірка логіну: передаєм у поле "Email" лише спецсимволи.

- **Priority:** Medium

- **Type:** Functional


- **Credentials:**

  - email: ʼ!"№;%:?*()[]_+\|.<,
  - password: TY#pUEcGz7nN%b


- **Preconditions:** Сторінка з формою логіну відкрита.



- **Steps**


    Step 1: Ввести у поле "Email" спецсимволи.
    Expected Result: Введене значення відображається коректно.

    Step 2: Ввести валідний пароль у поле "Password".
    Expected Result: Символи пароля відображаються прихованими.

    Step 3: Натиснути на кнопку "Login".
    Expected Result: 
        a) користувача не залогінено;
        b) відображається повідомлення "Invalid credentials!".

---


### [login_tc_10] Перевірка логіну: передаєм у поле "Email" SQL-Injection (Test crashed!!).

- **Priority:** Medium

- **Type:** Functional


- **Credentials:**

  - email: ') OR ('1'='1' --
  - password: TY#pUEcGz7nN%b


- **Preconditions:** Сторінка з формою логіну відкрита.



- **Steps**


    Step 1: Ввести у поле "Email" спецсимволи.
    Expected Result: Введене значення відображається коректно.

    Step 2: Ввести валідний пароль у поле "Password".
    Expected Result: Символи пароля відображаються прихованими.

    Step 3: Натиснути на кнопку "Login".
    Expected Result: 
        a) користувача не залогінено;
        b) відображається повідомлення "Invalid credentials!".

---