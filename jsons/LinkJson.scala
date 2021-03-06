package dataStructures.jsons

import play.api.libs.json.Json

case class LinkJson(/*destText : String,*/
                    destDocNum : Int,
                    weight : Double,
                    /*uuid: String*/)

object LinkJson{
  implicit val jsonWrites = Json.writes[LinkJson]
  implicit val jsonreads = Json.reads[LinkJson]
}