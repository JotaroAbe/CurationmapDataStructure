package dataStructures.morphias;

import dataStructures.jsons.LinkJson;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import models.InclusiveLink;
import org.bson.types.ObjectId;


@Entity("links")
public class LinkMorphia {
    @Id
    @SuppressWarnings("unused")
    private ObjectId _id;

//    public String destText;
    public int destDocNum;
    public double weight;
    //public String uuid;

    @SuppressWarnings("unused")
    private LinkMorphia() {}

    public LinkMorphia(int destDocNum, double weight){
//        this.destText = destText;
        this.destDocNum = destDocNum;
        this.weight = weight;
        //this.uuid = uuid;
    }

    public LinkJson toJson(){
        return new LinkJson(destDocNum, weight);//UUID
    }

    public InclusiveLink toObject(){
       return new InclusiveLink(weight, destDocNum);
    }
}
