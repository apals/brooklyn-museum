package se.apals.brooklynmuseum.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by apals on 04/09/16.
 */

public class Artist extends RealmObject {

    @PrimaryKey
    private Integer id;
    private String prefix;
    private String name;
    private String suffix;
    private String nationality;
    private String role;
    private String dates;
    private String startYear;
    private String endYear;
    private String dateAdded;
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
     * @return The prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @param prefix The prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
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
     * @return The suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * @param suffix The suffix
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * @return The nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality The nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return The role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role The role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return The dates
     */
    public String getDates() {
        return dates;
    }

    /**
     * @param dates The dates
     */
    public void setDates(String dates) {
        this.dates = dates;
    }

    /**
     * @return The startYear
     */
    public Object getStartYear() {
        return startYear;
    }

    /**
     * @param startYear The start_year
     */
    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    /**
     * @return The endYear
     */
    public Object getEndYear() {
        return endYear;
    }

    /**
     * @param endYear The end_year
     */
    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    /**
     * @return The dateAdded
     */
    public String getDateAdded() {
        return dateAdded;
    }

    /**
     * @param dateAdded The date_added
     */
    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
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

