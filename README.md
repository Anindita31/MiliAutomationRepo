# MiliLoginTest - Selenium Test Setup

## 📌 Setup Instructions

Before running the test, ensure you have **Google Chrome installed** and configured properly.  
Since the test script uses a **Chrome user profile**, you **must update the profile path** in the `setUp()` method.

### 1️⃣ Modify Chrome Profile Path

Open `MiliLoginTest.java` and update the following line in the `setUp()` method:

```java
options.addArguments("user-data-dir=/Users/anindita/Library/Application\\ Support/Google/Chrome"); // Mac
```

Replace anindita with your macOS username.

**🚀 Steps to Run the Project in IntelliJ**

1️⃣ Clone or Open the Project
Open IntelliJ IDEA.

* Select File → Open... and navigate to your project folder.

2️⃣ Ensure Maven Dependencies Are Installed

* If using Maven, open pom.xml and ensure all dependencies, including Selenium and WebDriverManager, are present.

3️⃣ Run the Test Class

* In Project Explorer, right-click MiliLoginTest.java.
* Click Run 'MiliLoginTest'.

4️⃣ View Test Results

* IntelliJ will display test results in the Run tab.
* If a test fails, check the logs and verify that the Chrome profile path is correct.
