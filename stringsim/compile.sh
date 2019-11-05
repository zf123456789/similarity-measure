rm -f *.class;
rm -f group/*.class;
rm -f unit/*.class;

javac -cp .:./libs/log4j-1.2.15.jar:./libs/secondstring-20120620.jar:./libs/simmetrics_jar_v1_6_2_d07_02_07.jar Main.java -Xlint