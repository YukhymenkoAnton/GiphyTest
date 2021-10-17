   ----------------------------------------------
   - To run tests from command line use: ./gradlew cleanTest test
   ----------------------------------------------
   If you would like to use local PC instead of Sauce Labs - navigate to src/test/java/org/yukhymenko/giphy/TestBase.class
   uncomment lines 20-23
   comment lines 25-36 AND 41-42
   ----------------------------------------------
   - Required Chrome Web browser version: 94.0.4606.xyz
   - If you're using different Chrome version - use this steps to download correct driver:
     1) Open Chrome browser
     2) Click on menu button(3 dots top right corner)
     3) Navigate to help/About Google Chrome
     4) Check Chrome Version
     5) Open https://chromedriver.chromium.org/downloads
     6) Download appropriate Chrome driver*
     7) Delete existing chromedriver.exe file from GiphyFramework directory
     8) Place downloaded chromedriver.exe file inside GiphyFramework directory
      * Each version of ChromeDriver supports Chrome with matching major, minor, and build version numbers.
        For example, ChromeDriver 94.0.4606.61 supports all Chrome versions that start with 94.0.4606
   ----------------------------------------------
   -  Report is stored under: build/reports/tests/test/index.html