package se.apals.brooklynmuseum.models;

import io.realm.RealmObject;

/**
 * Created by apals on 04/09/16.
 */
public class Collection extends RealmObject {

    private Integer id;
    private String name;
    private String folder;
    private Integer rank;

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The folder
     */
    public String getFolder() {
        return folder;
    }

    /**
     * @param folder The folder
     */
    public void setFolder(String folder) {
        this.folder = folder;
    }

    /**
     * @return The rank
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * @param rank The rank
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

}
