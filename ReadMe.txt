Objective: -

	Launch https://www.ixigo.com/
	Validate the page
	Enter From – Pune , To – Hyderabad , Departure – 17 Sep 2020 , Return – 24 Oct 2020 , Travelers - 2
	Click on Search, Validate the result page
	Validate filter option for Stops, departure and Airlines
	Select Non-Stop in Stops filter option
	Print the list of airlines details (Only Airline Number, Departure Time and Fare) having fare < 5000
	Note – Create a Maven project using POM design pattern and Use TestNG as a framework


Success OutPut: -

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running TestSuite
Starting ChromeDriver 83.0.4103.39 (ccbf011cb2d2b19b506d844400483861342c20cd-refs/branch-heads/4103@{#416}) on port 48458
Only local connections are allowed.
Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
ChromeDriver was started successfully.
log4j:WARN No appenders could be found for logger (org.apache.http.client.protocol.RequestAddCookies).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
[1597076832.401][WARNING]: This version of ChromeDriver has not been tested with Chrome version 84.
Opening ixigo
ixigo - Flights, Train Reservation, Hotels, Air Tickets, Bus Booking
Page is loaded successfully
Result page is validated
departure is validated
airline is validated
3
Non stop
stop is validated
1 stop
1+ stops
Lowest Price = 6300.0Highest Price = 22300.0
Diff = 16000.0x = 4.375
386
6

IndiGo  6E122	01:15	3160	
IndiGo  6E242	05:30	3160	
IndiGo  6E587	17:25	3160	
IndiGo  6E241	03:40	3774	
IndiGo  6E118	23:30	3774	Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 53.374 sec - in TestSuite

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  57.098 s
[INFO] Finished at: 2020-08-10T21:58:03+05:30
[INFO] ------------------------------------------------------------------------
