package compute

import com.datastax.spark.connector.toSparkContextFunctions
import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object Compute {
  def sessiondata(spark: SparkContext, sess: SparkSession) = {
    val rdd1 = spark.cassandraTable("spark_parallalism_test", "test_table1")
    val rdd2 = spark.cassandraTable("spark_parallalism_test", "test_table2")
    val rdd3 = spark.cassandraTable("spark_parallalism_test", "test_table3")

    println("\n\n\n\n\n Table 1: " + rdd1.take(10).foreach(s => println(s.get[String]("entryid"))))
    println("\n\n\n\n\n Table 2: " + rdd2.first)
    println("\n\n\n\n\n Table 3: " + rdd3.first)

    //println("\n\n\n\n" + sess.sql("desc spark_parallalism_test.test_table1") + "\n\n\n\n")
  }


  def data(): Unit = {
    println("Data from compute package")
  }
}
