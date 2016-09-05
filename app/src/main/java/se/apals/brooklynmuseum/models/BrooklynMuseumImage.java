package se.apals.brooklynmuseum.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by apals on 04/09/16.
 */
public class BrooklynMuseumImage extends RealmObject {

    @PrimaryKey
    private Integer id;
    private String title;
    private String accessionNumber;
    private String accessionDate;
    private String objectDate;
    private Integer objectDateBegin;
    private Integer objectDateEnd;
    private String period;
    private String dynasty;
    private String description;
    private String medium;
    private String dimensions;
    private String edition;
    private String portfolio;
    private String state;
    private String markings;
    private String signed;
    private String inscribed;
    private String creditLine;
    private String copyright;
    private String classification;
    private Integer publicAccess;
    private Integer approvalsMask;
    private Integer copyrightRestricted;
    private Integer visible;
    private String dateAdded;
    private Integer highlight;
    private String primaryImage;
    private String section;
    private MuseumLocation museumLocation;
    private RightsType rightsType;
    private Completeness completeness;
    private RealmList<Label> labels = new RealmList<Label>();
    private RealmList<Artist> artists = new RealmList<Artist>();
    private RealmList<Collection> collections = new RealmList<Collection>();
    private RealmList<GeographicalLocation> geographicalLocations = new RealmList<GeographicalLocation>();

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
     * @return The accessionNumber
     */
    public String getAccessionNumber() {
        return accessionNumber;
    }

    /**
     * @param accessionNumber The accession_number
     */
    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    /**
     * @return The accessionDate
     */
    public String getAccessionDate() {
        return accessionDate;
    }

    /**
     * @param accessionDate The accession_date
     */
    public void setAccessionDate(String accessionDate) {
        this.accessionDate = accessionDate;
    }

    /**
     * @return The objectDate
     */
    public String getObjectDate() {
        return objectDate;
    }

    /**
     * @param objectDate The object_date
     */
    public void setObjectDate(String objectDate) {
        this.objectDate = objectDate;
    }

    /**
     * @return The objectDateBegin
     */
    public Integer getObjectDateBegin() {
        return objectDateBegin;
    }

    /**
     * @param objectDateBegin The object_date_begin
     */
    public void setObjectDateBegin(Integer objectDateBegin) {
        this.objectDateBegin = objectDateBegin;
    }

    /**
     * @return The objectDateEnd
     */
    public Integer getObjectDateEnd() {
        return objectDateEnd;
    }

    /**
     * @param objectDateEnd The object_date_end
     */
    public void setObjectDateEnd(Integer objectDateEnd) {
        this.objectDateEnd = objectDateEnd;
    }

    /**
     * @return The period
     */
    public String getPeriod() {
        return period;
    }

    /**
     * @param period The period
     */
    public void setPeriod(String period) {
        this.period = period;
    }

    /**
     * @return The dynasty
     */
    public String getDynasty() {
        return dynasty;
    }

    /**
     * @param dynasty The dynasty
     */
    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
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
     * @return The medium
     */
    public String getMedium() {
        return medium;
    }

    /**
     * @param medium The medium
     */
    public void setMedium(String medium) {
        this.medium = medium;
    }

    /**
     * @return The dimensions
     */
    public String getDimensions() {
        return dimensions;
    }

    /**
     * @param dimensions The dimensions
     */
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * @return The edition
     */
    public String getEdition() {
        return edition;
    }

    /**
     * @param edition The edition
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    /**
     * @return The portfolio
     */
    public String getPortfolio() {
        return portfolio;
    }

    /**
     * @param portfolio The portfolio
     */
    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    /**
     * @return The state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return The markings
     */
    public String getMarkings() {
        return markings;
    }

    /**
     * @param markings The markings
     */
    public void setMarkings(String markings) {
        this.markings = markings;
    }

    /**
     * @return The signed
     */
    public String getSigned() {
        return signed;
    }

    /**
     * @param signed The signed
     */
    public void setSigned(String signed) {
        this.signed = signed;
    }

    /**
     * @return The inscribed
     */
    public String getInscribed() {
        return inscribed;
    }

    /**
     * @param inscribed The inscribed
     */
    public void setInscribed(String inscribed) {
        this.inscribed = inscribed;
    }

    /**
     * @return The creditLine
     */
    public String getCreditLine() {
        return creditLine;
    }

    /**
     * @param creditLine The credit_line
     */
    public void setCreditLine(String creditLine) {
        this.creditLine = creditLine;
    }

    /**
     * @return The copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * @param copyright The copyright
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * @return The classification
     */
    public String getClassification() {
        return classification;
    }

    /**
     * @param classification The classification
     */
    public void setClassification(String classification) {
        this.classification = classification;
    }

    /**
     * @return The publicAccess
     */
    public Integer getPublicAccess() {
        return publicAccess;
    }

    /**
     * @param publicAccess The public_access
     */
    public void setPublicAccess(Integer publicAccess) {
        this.publicAccess = publicAccess;
    }

    /**
     * @return The approvalsMask
     */
    public Integer getApprovalsMask() {
        return approvalsMask;
    }

    /**
     * @param approvalsMask The approvals_mask
     */
    public void setApprovalsMask(Integer approvalsMask) {
        this.approvalsMask = approvalsMask;
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
     * @return The visible
     */
    public Integer getVisible() {
        return visible;
    }

    /**
     * @param visible The visible
     */
    public void setVisible(Integer visible) {
        this.visible = visible;
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
     * @return The highlight
     */
    public Integer getHighlight() {
        return highlight;
    }

    /**
     * @param highlight The highlight
     */
    public void setHighlight(Integer highlight) {
        this.highlight = highlight;
    }

    /**
     * @return The primaryImage
     */
    public String getPrimaryImage() {
        return primaryImage;
    }

    /**
     * @param primaryImage The primary_image
     */
    public void setPrimaryImage(String primaryImage) {
        this.primaryImage = primaryImage;
    }

    /**
     * @return The section
     */
    public String getSection() {
        return section;
    }

    /**
     * @param section The section
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * @return The museumLocation
     */
    public MuseumLocation getMuseumLocation() {
        return museumLocation;
    }

    /**
     * @param museumLocation The museum_location
     */
    public void setMuseumLocation(MuseumLocation museumLocation) {
        this.museumLocation = museumLocation;
    }

    /**
     * @return The rightsType
     */
    public RightsType getRightsType() {
        return rightsType;
    }

    /**
     * @param rightsType The rights_type
     */
    public void setRightsType(RightsType rightsType) {
        this.rightsType = rightsType;
    }

    /**
     * @return The completeness
     */
    public Completeness getCompleteness() {
        return completeness;
    }

    /**
     * @param completeness The completeness
     */
    public void setCompleteness(Completeness completeness) {
        this.completeness = completeness;
    }

    /**
     * @return The labels
     */
    public RealmList<Label> getLabels() {
        return labels;
    }

    /**
     * @param labels The labels
     */
    public void setLabels(RealmList<Label> labels) {
        this.labels = labels;
    }

    /**
     * @return The artists
     */
    public RealmList<Artist> getArtists() {
        return artists;
    }

    /**
     * @param artists The artists
     */
    public void setArtists(RealmList<Artist> artists) {
        this.artists = artists;
    }

    /**
     * @return The collections
     */
    public RealmList<Collection> getCollections() {
        return collections;
    }

    /**
     * @param collections The collections
     */
    public void setCollections(RealmList<Collection> collections) {
        this.collections = collections;
    }

    /**
     * @return The geographicalLocations
     */
    public RealmList<GeographicalLocation> getGeographicalLocations() {
        return geographicalLocations;
    }

    /**
     * @param geographicalLocations The geographical_locations
     */
    public void setGeographicalLocations(RealmList<GeographicalLocation> geographicalLocations) {
        this.geographicalLocations = geographicalLocations;
    }

}
