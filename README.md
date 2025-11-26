# 💱 Currency Converter – JavaFX Desktop Application

A simple, modern, and user-friendly **currency converter** built with **Java 17**, **JavaFX 21**, and an organized **MVC architecture**.  
The application converts between dozens of world currencies using **live exchange rates** and includes an advanced, searchable dropdown for smooth and fast selection.

---

## ⭐ Features

### 🎨 User Interface
- Clean and intuitive **JavaFX GUI**
- FXML-based structured layout  
- Searchable currency dropdown using **ControlsFX SearchableComboBox** (**DONE**)  
- Type-to-search autocomplete for fast currency selection (**DONE**)  
- Includes **all world currencies** fetched from the API (**DONE**)  
- Fully editable amount input with error handling

### 💱 Conversion Logic
- Convert between **any two currencies**
- Live exchange-rate loading from:  
  `https://open.er-api.com/v6/latest/USD` (**DONE**)  
- Universal formula for accurate conversion  
- Automatic population of currency list from API data

---

## 🧱 Tech Stack
- **Java 17**
- **JavaFX 21**
- **FXML**
- **MVC Architecture**
- **ControlsFX (SearchableComboBox)**

---

## 📌 How It Works
1. User enters an amount  
2. Selects **From** and **To** currencies (searchable dropdown)  
3. Presses **Convert**  
4. Application shows the converted value with live exchange rates  

---

## 🔧 Future Improvements
- Add conversion history  
- Add custom UI theming with CSS  
- Add currency flag icons next to each currency  
- Offline mode with cached exchange rates  

---

## 🚀 DONE Features Recap
- ✔ Integrated live exchange-rate API  
- ✔ Included all country currencies dynamically  
- ✔ Enabled autocomplete + type-to-search  
- ✔ Implemented modern searchable ComboBox  
- ✔ Any currency → any currency conversion  

---

## 📄 License
This project is open-source and free to modify.
