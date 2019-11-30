package dataStructures.morphias;

import models.Morpheme;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("morphemes")
public class MorphemeMorphia {
    @Id
    @SuppressWarnings("unused")
    private ObjectId _id;

    public String word;
    public String morphe;

    @SuppressWarnings("unused")
    private MorphemeMorphia(){}

    public MorphemeMorphia(String word, String morphe){

        this.word = word;
        this.morphe = morphe;
    }

    public Morpheme toObject(){
        return new Morpheme(word, morphe);
    }

}
