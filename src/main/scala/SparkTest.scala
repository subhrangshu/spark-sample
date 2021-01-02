import com.datastax.spark.connector._
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
import org.glassfish.hk2.utilities.cache.ComputationErrorException
import compute.Compute.sessiondata


object SparkTest {

  def main(args: Array[String]) {
    //val spark = SparkSession.builder.appName("SparkTest").getOrCreate()
    //println("Hello World2")

    val conf = new SparkConf().set("spark.cassandra.connection.host","localhost").setAppName("SparkTest")
    val sparkCTX = new SparkContext(conf)
    val sparkSess = SparkSession.builder.appName("SparkTest").getOrCreate()
    sessiondata(sparkCTX, sparkSess)
    sparkCTX.stop()
  }
}
