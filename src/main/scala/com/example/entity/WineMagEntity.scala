package com.example.entity

case class WineMagEntity(
                          id: Option[Int],
                          country: Option[String],
                          points: Option[Int],
                          price: Option[BigDecimal],
                          title: Option[String],
                          variety: Option[String],
                          winery: Option[String]
                        )
