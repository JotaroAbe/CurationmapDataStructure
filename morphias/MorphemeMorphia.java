package dataStructures.morphias;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import models.Morpheme;
import org.bson.types.ObjectId;


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
