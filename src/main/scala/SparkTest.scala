import com.datastax.spark.connector._
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}


object SparkTest {
  def main(args: Array[String]) {
    val spark = SparkSession.builder.appName("SparkTest").getOrCreate()
    println("Hello World2")

    val conf = new SparkConf().set("spark.cassandra.connection.host","localhost")
    val sc = new SparkContext(conf)
    val rdd1 = sc.cassandraTable("spark_parallalism_test", "test_table1")
    println(rdd1.first)
    sc.stop()
    spark.stop()
  }
}
