package se.apals.brooklynmuseum.models;

import io.realm.RealmObject;

/**
 * Created by apals on 04/09/16.
 */
public class Completeness extends RealmObject {

    private String name;
    private String description;
    private Integer percentage;

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
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The percentage
     */
    public Integer getPercentage() {
        return percentage;
    }

    /**
     * @param percentage The percentage
     */
    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

}
