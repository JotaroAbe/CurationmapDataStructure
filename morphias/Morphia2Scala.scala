package dataStructures.morphias

import models._

import scala.collection.mutable

case class Morphia2Scala() {

  def convert(curationMapMorphia: CurationMapMorphia, alpha : Double, beta : Double) : CurationMap ={

    val retDocs = mutable.MutableList.empty[Document]

    curationMapMorphia.documents.forEach{
      doc =>
        val retFrags = mutable.MutableList.empty[Fragment]

        doc.fragments.forEach{
          frag =>
            val retMorphs = mutable.MutableList.empty[Morpheme]
            frag.morphemes.forEach{
              m =>
                retMorphs += Morpheme(m.word, m.morphe)
            }
            val f = Fragment(retMorphs.toVector)

            val retLinks = mutable.MutableList.empty[InclusiveLink]

            frag.links.forEach{
              l =>
                retLinks += InclusiveLink(l.weight, l.destDocNum)
            }

            f.links = retLinks

            retFrags += f
        }

        retDocs += Document(doc.url, doc.title, retFrags.toVector ,doc.docNum)
    }

    CurationMap(curationMapMorphia.query, retDocs.toVector, alpha, beta)
  }

}
