package se.apals.brooklynmuseum.models;

import io.realm.RealmObject;

/**
 * Created by apals on 04/09/16.
 */
public class MuseumLocation extends RealmObject {

    private Integer id;
    private String name;
    private Integer isPublic;
    private Boolean isFloor;
    private String parentLocationId;

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
     * @return The isPublic
     */
    public Integer getIsPublic() {
        return isPublic;
    }

    /**
     * @param isPublic The is_public
     */
    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * @return The isFloor
     */
    public Boolean getIsFloor() {
        return isFloor;
    }

    /**
     * @param isFloor The is_floor
     */
    public void setIsFloor(Boolean isFloor) {
        this.isFloor = isFloor;
    }

    /**
     * @return The parentLocationId
     */
    public Object getParentLocationId() {
        return parentLocationId;
    }

    /**
     * @param parentLocationId The parent_location_id
     */
    public void setParentLocationId(String parentLocationId) {
        this.parentLocationId = parentLocationId;
    }

}
