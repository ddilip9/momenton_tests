README for Question 2 & 3

1. Download the project from Git hub
2. Import SOAPUI project.xml file (AirVisual_RESTAPI Project will be imported in to SOAPUI from file - Test_On_API_AirViusal_soapui-project.xml)
3. Follow the test results file in order to understand the project structure and related test cases to the given questions for the test
4. Execute the SOAPUI test cases as per the instructions either from SOAPUI IDE by importing project or by modifying runner.bat with necessary details.
5. For Question 3 - Load Test Case please check the Load Tests results or snapshot attached in Testcases execution results excel sheet.
6. If you are planning to execute the SOAPUI project in CICD environment such as Jenkins / Dockers Please follow the below steps
	
	a. Configure simple Jenkins job -> Execute windows batch command with below SOAPUI executable command. In free style project of Jenkins you can configure windows batch command execution for runner.bat file (You can see runner.bat in downloaded files of Github)
	
	b. If you are executing from Dockers, Execute it from curl.sh file. After creating the docker image, Configure the CURL download from the link https://hub.docker.com/r/curlimages/curl and execute the file path for curl_api.sh file for execution.
		(NOTE: I haven't added all the test cases in CURL, I have added only 3 test cases. if you are willing to execute in windows Dockers image, rename the file to curl_api.sh to curl_api.bat)

All the above test cases can be created in Postman, HttpClient with Java code, RESTassured with Java code, KarateDFS framework or any other opensource framework ..etc. but I preffered SOAPUI for test cases just to avoid the usage of JMeter to organise the load on the API. I used Load tests in SOAPUI instead of JMeter.

NOTE: The reference documentation provided in Test paper is not working and gives 404 error. TO generate API key Please refer to the link - https://www.iqair.com/dashboard/api 

Please reach out to me if any case of additional information is required for project setup process.