package dataStructures.morphias;

import dataStructures.jsons.FragmentJson;
import dataStructures.jsons.LinkJson;
import models.Fragment;
import models.Morpheme;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Entity("frags")
public class FragmentMorphia {
    @Id
    @SuppressWarnings("unused")
    private ObjectId _id;

    //public String text;
    public List<MorphemeMorphia> morphemes;
    public List<LinkMorphia> links;
    public String uuid;

    @SuppressWarnings("unused")
    private FragmentMorphia() {}

    public FragmentMorphia(List<Morpheme> morphemes, List<LinkMorphia> links, String uuid){
        //this.text = text;
        this.morphemes = new ArrayList<>();
        this.links = links;
        this.uuid = uuid;

        morphemes.forEach(
                m ->
                        this.morphemes.add(new MorphemeMorphia(m.word(), m.morph())));
    }
    public FragmentJson toJson(){
        List<LinkJson> jList = new LinkedList<>();

        if(links != null) {
            for (LinkMorphia fm : links) {
                jList.add(fm.toJson());
            }
        }

        StringBuilder sb = new StringBuilder();

        morphemes.forEach(
                m ->
                        sb.append(m.word)
        );

        return new FragmentJson(sb.toString(), jList, uuid);//UUID
    }

}
