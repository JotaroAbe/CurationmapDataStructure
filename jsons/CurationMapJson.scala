package dataStructures.jsons

import java.util.{List => JList}

import play.api.libs.json._

import scala.collection.JavaConverters._

case class CurationMapJson(query : String,
                           alpha : Double,
                           documents : Seq[DocumentJson]){
  def this(query : String,
           alpha : Double,
           documents : JList[DocumentJson]) = {
    this(query, alpha, documents.asScala)
  }
}

object CurationMapJson{
  implicit val jsonWrites = Json.writes[CurationMapJson]
  implicit val jsonreads = Json.reads[CurationMapJson]
}
