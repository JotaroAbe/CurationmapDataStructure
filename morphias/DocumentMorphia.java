package dataStructures.morphias;

import dataStructures.jsons.DocumentJson;
import dataStructures.jsons.FragmentJson;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.bson.types.ObjectId;


import java.util.LinkedList;
import java.util.List;

@Entity("docs")
public class DocumentMorphia {
    @Id
    @SuppressWarnings("unused")
    private ObjectId _id;

    public String query;
    public String url;
    public String title;
    public int docNum;
    //public double hub;
    //public double auth;
    public List<FragmentMorphia> fragments;
    public String uuid;

    @SuppressWarnings("unused")
    private DocumentMorphia() {}

    public DocumentMorphia(String query, String url, String title, int docNum, List<FragmentMorphia> fragments, String uuid){
        this.query = query;
        this.url = url;
        this.title = title;
        this.docNum = docNum;
        //this.hub = hub;
        //this.auth = auth;
        this.fragments = fragments;
        this.uuid = uuid;
    }
    public DocumentJson toJson(){
        List<FragmentJson> jList = new LinkedList<>();

        if(fragments != null) {

            for (FragmentMorphia lm : fragments) {
                jList.add(lm.toJson());
            }
        }
        return new DocumentJson(url, title, docNum, 0, 0, jList, uuid);//UUID, HITS
    }
}
