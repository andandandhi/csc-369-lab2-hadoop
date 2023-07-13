# CSC 369 Hadoop Lab2 I/O

all sorts are ascending

1. UrlCount{input: access.log; output: pair of url and request count sorted by url}
   UrlCount2{input: UrlCount out; output: pair of url req count sorted by req count}
2. CodeCount: single mapReduce
3. IpBytes: single mapReduce
4. IpCount: {input: access.log; output: based on URL, pair of client and req count sorted by client}
   IpCount2:{input: IpCount out; output: based on URL, pair of client and req count sorted by req count}
5. MonthCount: {input: access.log; output: pair of mmm/year (ex. "Aug/2021") and its occurances}
   MonthCount2:{input: MonthCount out; output: mmm/year sorted choronologically}
6. DayBytes: {input: access.log; output: pair of day and total bytes}
   DayBytes2:{input: DayBytes out; output: pair of day and total bytes sorted by total bytes}

 

## instructions
Note that these examples use the MRUnit package to simulate a Hadoop cluster.

Hadoop job configuration can be found in `src/main/java/csc369/HadoopApp.java`

To run the sample jobs, used the gradlew command as follows:
`./gradlew run --args="<job name> <input directory> <output directory>"`

This will compile all code, configure a local Hadoop instance and run the requested job for all records in the provided input directory.

For example:
`./gradlew run --args="AccessLog input_access_log out_test"`
