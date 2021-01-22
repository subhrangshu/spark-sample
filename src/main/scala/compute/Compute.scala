package compute

import com.datastax.spark.connector.{SomeColumns, toRDDFunctions, toSparkContextFunctions}
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

case class WordCount(entryid: String, entry1: String, entry2: String, entry3: String)

object Compute {
  def sessiondata(spark: SparkContext, sess: SparkSession) = {
    val rdd1 = spark.cassandraTable("spark_parallalism_test", "test_table1")
    val rdd2 = spark.cassandraTable("spark_parallalism_test", "test_table2")
    val rdd3 = spark.cassandraTable("spark_parallalism_test", "test_table3")

    println("\n\n\n\n\n Table 1: " + rdd1.take(10).foreach(s => println(s.get[String]("entryid"))))
    println("\n\n\n\n\n Table 2: " + rdd2.first)
    println("\n\n\n\n\n Table 3: " + rdd3.first)

    val collection = spark.parallelize(Seq(WordCount("1", "insertion test","insertion test","insertion test")))
    collection.saveToCassandra("spark_parallalism_test", "test_table2", SomeColumns("entryid", "entry1", "entry2", "entry3"))
  }


  def data(): Unit = {
    println("Data from compute package")
  }
}
