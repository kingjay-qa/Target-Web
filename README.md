# Target Web Automation Framework

## 📦 Git Clone Flow

To clone the repository to your local machine, open your terminal and run:

```bash
git clone https://github.com/kingjay-qa/Target-Web

This will create a local copy of the project on your machine.

🧰 IDE Setup (Eclipse)

Download and install Eclipse IDE.

Open Eclipse.

Go to File > Import.

Choose Existing Projects into Workspace.

Navigate to the cloned repository directory and select it.

Click Finish to import the project.

Or any IDE of choice

🚀 Test Case Execution

1. Install Dependencies

Eclipse will automatically download and install required dependencies via Maven. This may take a few minutes on first launch.

2. Locate Test Case

Navigate to:

Target
└── src
    └── test
        └── java
            └── TestsCase
                └── LoginTest.java

3. Run the Test

Right-click on LoginTest.java and select:

Run As > TestNG Test

Test results will appear in the Eclipse console or TestNG results window.

🔐 Credentials Setup

Before running the login test, make sure to update the logintestdata.properties file with a valid Target email address and password:

valid.username=your_email@example.com
valid.password=your_secure_password

⚠️ Credentials are not stored in the repository. You must provide your own for the test to work.

🌐 Browser Configuration

Ensure the appropriate browser driver is installed and configured (e.g., ChromeDriver for Google Chrome). The framework uses WebDriverManager to auto-manage drivers, but internet access is required for first-time setup.

✅ Jenkins Integration

This project supports CI execution via Jenkins. The pipeline is configured to:

Checkout code

Compile and run LoginTest

Collect and report results using Surefire

🙌 Thanks

Special thanks to contributors and testers. For any issues or suggestions, feel free to open an issue or submit a pull request.
