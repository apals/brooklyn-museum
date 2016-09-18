package se.apals.brooklynmuseum.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ArchiveImage extends RealmObject {

    @PrimaryKey
    private int id;
    private int archivesSetId;
    private String filename;
    private String caption;
    private String credit;
    private String date;
    private String notes;
    private String page;
    private int isColor;
    private String fileSource;
    private String imageSourceSize;
    private String imagingProjectName;
    private String dateAdded;
    private int imageID;
    private int copyrightRestricted;
    private String rightsStatement;
    private String citation;
    private String title;
    private String shortCaption;
    private String largestDerivativeUrl;
    private String standard_size_url;

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
     * @return The archivesSetId
     */
    public Integer getArchivesSetId() {
        return archivesSetId;
    }

    /**
     * @param archivesSetId The archives_set_id
     */
    public void setArchivesSetId(Integer archivesSetId) {
        this.archivesSetId = archivesSetId;
    }

    /**
     * @return The filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename The filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return The caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * @param caption The caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * @return The credit
     */
    public String getCredit() {
        return credit;
    }

    /**
     * @param credit The credit
     */
    public void setCredit(String credit) {
        this.credit = credit;
    }

    /**
     * @return The date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return The notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes The notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return The page
     */
    public String getPage() {
        return page;
    }

    /**
     * @param page The page
     */
    public void setPage(String page) {
        this.page = page;
    }

    /**
     * @return The isColor
     */
    public Integer getIsColor() {
        return isColor;
    }

    /**
     * @param isColor The is_color
     */
    public void setIsColor(Integer isColor) {
        this.isColor = isColor;
    }

    /**
     * @return The fileSource
     */
    public String getFileSource() {
        return fileSource;
    }

    /**
     * @param fileSource The file_source
     */
    public void setFileSource(String fileSource) {
        this.fileSource = fileSource;
    }

    /**
     * @return The imageSourceSize
     */
    public String getImageSourceSize() {
        return imageSourceSize;
    }

    /**
     * @param imageSourceSize The image_source_size
     */
    public void setImageSourceSize(String imageSourceSize) {
        this.imageSourceSize = imageSourceSize;
    }

    /**
     * @return The imagingProjectName
     */
    public String getImagingProjectName() {
        return imagingProjectName;
    }

    /**
     * @param imagingProjectName The imaging_project_name
     */
    public void setImagingProjectName(String imagingProjectName) {
        this.imagingProjectName = imagingProjectName;
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
     * @return The imageID
     */
    public Integer getImageID() {
        return imageID;
    }

    /**
     * @param imageID The image_ID
     */
    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    /**
     * @return The copyrightRestricted
     */
    public Integer getCopyrightRestricted() {
        return copyrightRestricted;
    }

    /**
     * @param copyrightRestricted The copyright_restricted
     */
    public void setCopyrightRestricted(Integer copyrightRestricted) {
        this.copyrightRestricted = copyrightRestricted;
    }


    /**
     * @param copy The copy
     */
    public void setCopy(String copy) {
    }

    /**
     * @return The rightsStatement
     */
    public String getRightsStatement() {
        return rightsStatement;
    }

    /**
     * @param rightsStatement The rights_statement
     */
    public void setRightsStatement(String rightsStatement) {
        this.rightsStatement = rightsStatement;
    }

    /**
     * @return The citation
     */
    public String getCitation() {
        return citation;
    }

    /**
     * @param citation The citation
     */
    public void setCitation(String citation) {
        this.citation = citation;
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
     * @param archivesCollectionName The archives_collection_name
     */
    public void setArchivesCollectionName(String archivesCollectionName) {
    }

    /**
     * @param archivesCollectionFolder The archives_collection_folder
     */
    public void setArchivesCollectionFolder(String archivesCollectionFolder) {
    }
    /**
     * @param archivesCollectionId The archives_collection_id
     */
    public void setArchivesCollectionId(String archivesCollectionId) {
    }

    /**
     * @return The shortCaption
     */
    public String getShortCaption() {
        return shortCaption;
    }

    /**
     * @param shortCaption The short_caption
     */
    public void setShortCaption(String shortCaption) {
        this.shortCaption = shortCaption;
    }

    /**
     * @return The largestDerivativeUrl
     */
    public String getLargestDerivativeUrl() {
        return largestDerivativeUrl;
    }

    /**
     * @param largestDerivativeUrl The largest_derivative_url
     */
    public void setLargestDerivativeUrl(String largestDerivativeUrl) {
        this.largestDerivativeUrl = largestDerivativeUrl;
    }

    /**
     * @return The standard_size_url
     */
    public String getStandard_size_url() {
        return standard_size_url;
    }

    /**
     * @param standard_size_url The standard_size_url
     */
    public void setStandard_size_url(String standard_size_url) {
        this.standard_size_url = standard_size_url;
    }

    /**
     * @param rightsType The rights_type
     */
    public void setRightsType(RightsType rightsType) {
    }

}