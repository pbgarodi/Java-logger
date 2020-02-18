## Java logging 
- Logging is important for development, testing, and in production also.
- Here I will be showing how to implement logging efficiently in java.


### Prerequisites
- `java` (>=1.6)
- `Maven`

##### If Maven not install follow following steps
- Open terminal and execute following command.
- $ sudo apt update
- $ sudo apt install maven

### Code Explanation
1. Java has given logging mechanism to print log or write into file.
2. Here we will write exception into log file automatically by calling **java logger method** like.

	- logger.info() 
	- logger.warn()
	- logger.fatel()
	- logger.error()
	- logger.debug() 
	
3. In order to write log into file we are using **log4j** library

	- **Log4j Components**
		- Log4j has three main components, which are the following:
			1. Logger
    		2. Appender
    		3. Layout
	- **Logger**
		- Logger is a class in log4j. we have five methods in the Logger class.
			1. info()
			2. debug()
			3. warn()
			4. fatal()
			5. error()
	- **Appender**
		- Log4j has 8 different appenders:
		- For this demo we will be using two appender.
			1. FileAppender
			2. ConsoleAppender

	- **Layout**
		- Log4j has different layout support:
			1. PatternLayout
			2. SimpleLayout
			3. XMLLayout
			4. HTMLLayout
		- We will be using **PatternLayout**	
		
	- **Log4j: Configuration**
		- This is an important part where we will specify all configuration for log file. 
		- In configuration file we will add **appender**, **layout** ,**maxsize of log file** and may more.
		- Create **log4j.properties** and put it into **resources/log4j** directory of your project.
		```
		# Root logger option
		log4j.rootLogger=INFO, file, stdout
		
		# configuration to print into file
		log4j.appender.file=org.apache.log4j.RollingFileAppender
		log4j.appender.file.File= resources/application.log
		log4j.appender.file.MaxFileSize=12MB
		log4j.appender.file.MaxBackupIndex=10
		log4j.appender.file.layout=org.apache.log4j.PatternLayout
		log4j.appender.file.layout.ConversionPattern=%d{dd-MM-yyyy HH:mm:ss} %-5p %c{1}:%L - %m%n
		
		# configuration to print on console
		log4j.appender.stdout=org.apache.log4j.ConsoleAppender
		log4j.appender.stdout.Target=System.out
		log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
		log4j.appender.stdout.layout.ConversionPattern=%d{dd-MM-yyyy HH:mm:ss} %-5p %c{1}:%L - %m%n
		
		```
#### Example 
Following is the example how to use a logger in actual project


```java
public class App {

	// This will append class name with log so that we can easily understand in which class code is breaking
	 
	static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {

		logger.debug("This is debug message");

		// info() method is use to write message into log file .
		logger.info("This is info message");

		// warn() method is use to write warning message into log file .
		logger.warn("This is warn message");

		// fatal() method is use to write fatal error into log file.
		logger.fatal("This is fatal message");

		// error() method is use to write error like exception, or logical error into
		// log file.
		logger.error("This is error message");

		System.out.println("Logic executed successfully....");

		// try catch example 
		try {

			FileReader fileReader = new FileReader("/out.py");

		} catch (FileNotFoundException e) {
			logger.error("Getting exception:", e);
		}

	}

}


```
- In above example we can see we are reading **out.py** file and that file dose not exist here we will get an exception and that exception will be written in **application.log** file under resources directory.

### Output
- **application.log**
```
18-02-2020 12:14:11 INFO  App:17 - This is info message
18-02-2020 12:14:11 WARN  App:20 - This is warn message
18-02-2020 12:14:11 FATAL App:23 - This is fatal message
18-02-2020 12:14:11 ERROR App:27 - This is error message
18-02-2020 12:14:11 ERROR App:37 - Getting exception:
java.io.FileNotFoundException: /out.py (No such file or directory)
	at java.io.FileInputStream.open0(Native Method)
	at java.io.FileInputStream.open(FileInputStream.java:195)
	at java.io.FileInputStream.<init>(FileInputStream.java:138)
	at java.io.FileInputStream.<init>(FileInputStream.java:93)
	at java.io.FileReader.<init>(FileReader.java:58)
	at com.logger.App.main(App.java:34)

```




