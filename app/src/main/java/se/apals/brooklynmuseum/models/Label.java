package se.apals.brooklynmuseum.models;

import io.realm.RealmObject;

/**
 * Created by apals on 04/09/16.
 */
public class Label extends RealmObject {

    private Integer id;
    private String title;
    private String content;
    private String summary;
    private Integer rank;
    private String labelDate;
    private String dateAdded;
    private Integer approvedForWeb;

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
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content The content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return The summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary The summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
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

    /**
     * @return The labelDate
     */
    public String getLabelDate() {
        return labelDate;
    }

    /**
     * @param labelDate The label_date
     */
    public void setLabelDate(String labelDate) {
        this.labelDate = labelDate;
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
     * @return The approvedForWeb
     */
    public Integer getApprovedForWeb() {
        return approvedForWeb;
    }

    /**
     * @param approvedForWeb The approved_for_web
     */
    public void setApprovedForWeb(Integer approvedForWeb) {
        this.approvedForWeb = approvedForWeb;
    }

}
