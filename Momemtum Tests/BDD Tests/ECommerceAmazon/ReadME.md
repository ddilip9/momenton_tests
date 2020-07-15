# This is a ReadME.md file to guide for theh project import of Question 1

BDD Cucumber Hybrid framework for Amazon E COmmerce Demo test case

Technology stack used: BDD cucumber, Junit/TestNG Runner, Java, Feature files, JSON, XML for raw results storage, extent reporting libs for rich HTML preview, Eclipse/Intelli J IDE, Selenium libs, Appium libs(In case of Mobile but no mobile use case for this test), browser drivers, Maven, Jenkins can be used for Continuous execution, Other tools ( Galen libs for layout testing, Sikuli libs for Image based execution this is not included in the test)

I will convert all the business requirements in to Feature files as a scenarios, Write couple of scenario’s for the feature which we are intended to automate, Write all the scenario steps, examples, gather test data and complete the creation of feature file. Once the feature file is ready configure the Cucumber Runner class to execute the scenario’s and generate reports..etc. Generate Gluecode for all the scenario steps and implement the logic(Selenium script with Internal framework) On very high level my Internal framework contains KeywordClass, PageObjectClass, ReportingClass, ConfigurationClass, DriverClass, ComponentClass.

In this case Scenario covered are @ , @error,  these are scenario level tags which can be used for controlling the execution. But I have configured @amazon as Feature level tag to execute all the scenarios in the feature file.

KeywordClass – Contains all the keywords of Selenium functionality (For eg: click(), elementSendText(), waitForElementPresence(), dragAndDrop(), wait(), sleep() ..etc) PageObjectClass – All the XPath and other elements are recorded in this classes, for better standard create separate class for separate pages in the application – this is equivalent to page object model.

ReportingClass – reporting class get logs for every test step execution, since every keyword is surrounded with try-catch exception handling, Pass/Fail log status will be recorded as XML tags vis reporting class. ConfigurationClass – used to maintain and supply configuration for test executions, like number of test cases to be execute, which test data sheet to pickup, which browser, which machine(in case of Grid), name of project for reporting, number of devices to execute the script and others.. DriverClass – contains the configuration of drivers and the respective browsers, and mobile devices configurations ComponentClass – is used to hold the components of sequence of test steps.

How to execute ?

1. Check the code from BitBucket,
2. TO understand the framework, have a glance on the ReadME.md file content.
3. Import the code in to Eclipse or IntelliJ IDE
4. Open the Project explorer, you can check the Feature file for the scenarios covered.
5. You can update the project with Maven dependencies
6. Once project build is completed you can execute from Maven or TestRUnner Junit or from Command Line arguements.
7. The same project can be configured in Jenkins using Maven plugin.
8. You can view the reports under target/cucumber-reports/


