package dataStructures.morphias

import java.util.UUID

import models._

import scala.collection.mutable

case class Morphia2Scala() {

  def convert(curationMapMorphia: CurationMapMorphia, alpha : Double, beta : Double) : CurationMap ={

    val retDocs = mutable.MutableList.empty[Document]

    if(curationMapMorphia.documents != null) {
      curationMapMorphia.documents.forEach {
        doc =>
          val retFrags = mutable.MutableList.empty[Fragment]
          if(doc.fragments != null) {
            doc.fragments.forEach {
              frag =>
                val retMorphs = mutable.MutableList.empty[Morpheme]
                frag.morphemes.forEach {
                  m =>
                    retMorphs += Morpheme(m.word, m.morphe)
                }
                //println(frag.uuid)
                val f = Fragment(retMorphs.toVector, frag.uuid.toLong)
                //println(f.uuid)
                val retLinks = mutable.MutableList.empty[InclusiveLink]

                if(frag.links != null) {
                  frag.links.forEach {
                    l =>
                      retLinks += InclusiveLink(l.weight, l.destDocNum)
                  }
                }

                f.links = retLinks

                retFrags += f
            }
          }

          retDocs += Document(doc.url, doc.title, retFrags.toVector, doc.docNum, doc.uuid.toLong)
      }
    }

    CurationMap(curationMapMorphia.query, retDocs.toVector, alpha, beta)
  }

}
