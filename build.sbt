name := "SparkTest"

version := "1.0"

scalaVersion := "2.11.8"


libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.2" % "provided"

libraryDependencies += "com.datastax.spark" % "spark-cassandra-connector_2.11" % "2.4.2" % "provided"
