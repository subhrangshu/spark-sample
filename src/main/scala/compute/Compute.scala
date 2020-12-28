package compute

import com.datastax.spark.connector.{SomeColumns, toRDDFunctions, toSparkContextFunctions}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

object Compute {
  def sessiondata(spark: SparkSession) = {
    println("session data")
    val conf = new SparkConf(true).set("spark.cassandra.connection.host", "127.0.0.1")
    val sc = new SparkContext("dse://127.0.0.1:7077", "test", conf)
    val rdd1 = sc.cassandraTable("spark_parallalism_test", "test_table1")
    val rdd2 = sc.cassandraTable("spark_parallalism_test", "test_table2")
    val rdd3 = sc.cassandraTable("spark_parallalism_test", "test_table3")
    //println(rdd1.first())
    //println(rdd2.first())
    //println(rdd3.first())
    //Save to Database
    /*val collection = sc.parallelize(Seq(("key3", 3), ("key4", 4)))
    collection.saveToCassandra("my_keyspace", "my_table", SomeColumns("key", "value"))*/
  }

  def data(): Unit = {
    println("Data from compute package")
  }
}
