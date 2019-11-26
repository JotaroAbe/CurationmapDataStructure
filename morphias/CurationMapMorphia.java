package dataStructures.morphias;

import dataStructures.jsons.CurationMapJson;
import dataStructures.jsons.DocumentJson;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.LinkedList;
import java.util.List;

@Entity("maps")
public class CurationMapMorphia {

    @Id @SuppressWarnings("unused")
    private ObjectId _id;

    public String query;
    public Double alpha;
    public List<DocumentMorphia> documents;

    @SuppressWarnings("unused")
    private CurationMapMorphia() {}

    public CurationMapMorphia(String query, Double alpha, List<DocumentMorphia> documents){
        this.query = query;
        this.alpha = alpha;
        this.documents = documents;
    }

    public CurationMapJson toJson(){
        List<DocumentJson> jList = new LinkedList<>();

        if(documents != null) {
            for (DocumentMorphia dm : documents) {
                jList.add(dm.toJson());
            }
        }
        return new CurationMapJson(query, alpha, jList);
    }

}
