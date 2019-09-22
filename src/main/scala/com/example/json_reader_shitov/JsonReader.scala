package com.example.json_reader_shitov

import com.example.json_reader_shitov.entity.WineMagEntity
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.jackson.Serialization

object JsonReader extends App {

  val spark = SparkSession
    .builder()
    .master("local[*]")
    .appName("json_reader_shitov")
    .getOrCreate()

  import spark.implicits._

  implicit val formats = {
    Serialization.formats(FullTypeHints(List(classOf[WineMagEntity])))
  }


  val inputFileName: String = args {
    0
  }

  val wineMagRdd: RDD[String] = spark.sparkContext.textFile(inputFileName)

  wineMagRdd.map(e => parse(e).extract[WineMagEntity]).foreach(e => println(e))

}
