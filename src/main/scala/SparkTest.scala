import org.apache.spark.sql.SparkSession

object SparkTest {
  def main(args: Array[String]) {
    //val logFile = "YOUR_SPARK_HOME/README.md" // Should be some file on your system
    val spark = SparkSession.builder.appName("SparkTest").getOrCreate()
    //val logData = spark.read.textFile(logFile).cache()
    //val numAs = logData.filter(line => line.contains("a")).count()
    //val numBs = logData.filter(line => line.contains("b")).count()
    println("Hello World")

    spark.stop()
  }
}
