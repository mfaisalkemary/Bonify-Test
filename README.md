Bug Reports folder:
------------------
project_root_dir/Bug Reports


Environment setup:
------------------
Please install below :

1-Java version: 15.0.1

2-Maven version: 3.6.3_1

3-Chrome browser version: 92.0.4515.159


How to run the test:
---------------------
1-navigate to the project root directory

2- run below command

'mvn clean test'


Where to find the test report and screen shots:
-----------------------------------------------
1-for screen shots:
project_root_dir/test-results/reports

2-for test reports:
project_root_dir/target/surefire-reports/emailable-report

3-another test report with screen shots: 
project_root_dir/test-results/reports


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
