package se.apals.brooklynmuseum.models;

import io.realm.RealmObject;

/**
 * Created by apals on 04/09/16.
 */
public class RightsType extends RealmObject {

    private String name;
    private String publicName;
    private String description;

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
     * @return The publicName
     */
    public String getPublicName() {
        return publicName;
    }

    /**
     * @param publicName The public_name
     */
    public void setPublicName(String publicName) {
        this.publicName = publicName;
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

}
