access:
	./gradlew run --args="AccessLog input_access_log outwsl_access1"
	./gradlew run --args="AccessLog2 outwsl_access1 outwsl_access2"
q1:	
	./gradlew run --args="UrlCount input_access_log outwsl_url1"
	./gradlew run --args="UrlCount2 outwsl_url1 outwsl_url2"
q2:
	./gradlew run --args="CodeCount input_access_log outwsl_code1"
q3:
	./gradlew run --args="IpBytes input_access_log outwsl_ipbyte1"
q4:
	./gradlew run --args="IpCount input_access_log outwsl_ipcount1"
	./gradlew run --args="IpCount2 outwsl_ipcount1 outwsl_ipcount2"
q5:
	./gradlew run --args="MonthCount input_access_log outwsl_month1"
	./gradlew run --args="MonthCount2 outwsl_month1 outwsl_month2"
q6:
	./gradlew run --args="DayBytes input_access_log outwsl_day1"
	./gradlew run --args="DayBytes2 outwsl_day1 outwsl_day2"

all:
	./gradlew run --args="UrlCount input_access_log outwsl_url1"
	./gradlew run --args="UrlCount2 outwsl_url1 outwsl_url2"
	./gradlew run --args="CodeCount input_access_log outwsl_code1"
	./gradlew run --args="IpBytes input_access_log outwsl_ipbyte1"
	./gradlew run --args="IpCount input_access_log outwsl_ipcount1"
	./gradlew run --args="IpCount2 outwsl_ipcount1 outwsl_ipcount2"
	./gradlew run --args="MonthCount input_access_log outwsl_month1"
	./gradlew run --args="MonthCount2 outwsl_month1 outwsl_month2"
	./gradlew run --args="DayBytes input_access_log outwsl_day1"
	./gradlew run --args="DayBytes2 outwsl_day1 outwsl_day2"

clean:
	rm -rf outwsl_*
