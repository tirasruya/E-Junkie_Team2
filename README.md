## 🎯 E-Junkie E-Commerce Platform – Test Automation Project

This project covers end-to-end testing of the E-Junkie demo e-commerce platform https://shopdemo.e-junkie.com/
, including adding digital products to the cart, validating promo codes, performing payment operations, handling invalid inputs, and testing navigation and contact functionalities. The tests ensure that the platform provides a reliable and user-friendly checkout experience.


## ✨ Features & User Stories
| ID    | Feature                           | Description                                                                 |
|-------|-----------------------------------|-----------------------------------------------------------------------------|
| US301 | 🛒 Demo E-Book Add to Cart        | Add the demo e-book to the cart, apply an invalid promo code, and verify the warning message. |
| US302 | ❌ Invalid Payment (Empty Fields) | Attempt payment with empty required fields and verify that multiple validation errors appear simultaneously. |
| US303 | 💳 Invalid Credit Card Number     | Enter required information and validate that an incorrect card number triggers the “Invalid card number” message. |
| US304 | ✔️ Successful Payment             | Complete a purchase using valid card details and verify the confirmation message. |
| US305 | 📥 Payment Confirmation + Download| Verify successful payment, correct total amount, and download the purchased e-book. |
| US306 | ✉️ Contact Form Submission        | Fill and submit the contact form and verify that the “Recaptcha Mismatch” warning appears. |
| US307 | 🏠 Navigation to Homepage         | Navigate from the Shopdemo page to the main E-Junkie homepage and verify the redirected URL. |
| US308 | 🎥 Access Information Video       | Access and play the “How It Works” informational video, then close the popup. |


## 🛠️ Tech Stack & Tools
-☕️ Java
-🌐 Selenium WebDriver
-✅ TestNG
-🧩 Cucumber BDD
-✍️ Gherkin
-📄 Page Object Model (POM)
-🛠️ Maven

## 👥 Team
-Ruya Tiras
-Aslihan Gulluoglu
-Taner Ozcelik
-Efe Ersan
