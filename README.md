Bug Reports folder:
------------------
project_root_dir/Bug Reports


Environment setup:
------------------
(if you are running the code locally)  
Please install below :

1-Java version: 15.0.1

2-Maven version: 3.6.3_1

3-Firefox browser version: 91.0 (64-bit)


How to run the test:
---------------------

There are 2 ways to run the tests:  
  **1- manually on a local machine:**  
1-go to dir   
src/test/java/Tests.java  
2-go to code line 35  
update the value (Configuration.headless) to be 'false'  
3-navigate to the project root directory  
4-run below command  
'mvn clean test'

**2- automatically using GitHub Actions:**  
1- change any file of the project  
2- go to dir   
src/test/java/Tests.java  
3- go to code line 35  
update the value (Configuration.headless) to be 'true'  
4- do any change on any file on the project and push it to the project's master branch
(I have made the repo public) and wait for the build to finish   
5- go the  https://github.com/mfaisalkemary/Bonify-Test/actions then open the last workflow run page  
then download the test-automation-report.rar file  to view the test automation results 









Where to find the test report and screen shots (in case of test failure):
-----------------------------------------------
1-for screen shots:
project_root_dir/test-results/reports

2-for test reports:
project_root_dir/target/surefire-reports/emailable-report




Where to find the test code , test data and  pages classes:
-------------------------------------------------------
1-pages classes  
Pages : project_root_dir/src/main/java/pages/*.class

2-apis classes:  
project_root_dir/src/main/java/apis

2-tests classes:  
project_root_dir/test/java/Tests.class

3-test data files and utils :
utils : project_root_dir/src/main/java/utils/TestData.class  
test data file : project_root_dir/src/main/java/utils/testData.json  

