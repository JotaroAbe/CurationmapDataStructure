package dataStructures.jsons

import java.util.{List => JList}

import play.api.libs.json.Json

import scala.collection.JavaConverters._

case class DocumentJson(url : String,
                        title: String,
                        docNum : Int,
                        hub : Double,
                        auth : Double,
                        fragments : Seq[FragmentJson],
                        /*uuid: String*/){
  def this(url : String,
           title: String,
           docNum : Int,
           hub : Double,
           auth : Double,
           fragments : JList[FragmentJson],
           /*uuid: String*/) = {
    this(url,title,docNum,hub,auth, fragments.asScala)
  }
}
object DocumentJson{
  implicit val jsonWrites = Json.writes[DocumentJson]
  implicit val jsonreads = Json.reads[DocumentJson]
}



