package me.piccioni.jobstrackerspring.model;

import java.io.Serializable;
import java.net.URI;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Represents a Position to which the user wants to apply
 */
@Entity
@Table(name = "positions")
public class Position implements Serializable{

  private static final long serialVersionUID = 1L;
  
  
  
  private long id;
  private String company;
  private String position;
  private String agency;
  private double salaryMin;
  private double salaryMax;
  private String pointOfContact;
  private URI specificationsLink;
  private boolean closed;
  private String notes;

  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  public long getId() {
    return id;
  }

  
  public void setId(long id) {
    this.id = id;
  }
  
  @Size(max = 255)
  @Column(name="company")
  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  @NotNull
  @Size(min = 2, max = 255)
  @Column(name="position")
  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  @Size(max = 255)
  @Column(name="agency")
  public String getAgency() {
    return agency;
  }

  public void setAgency(String agency) {
    this.agency = agency;
  }

  @Column(name="salary_min")
  public double getSalaryMin() {
    return salaryMin;
  }

  public void setSalaryMin(double salaryMin) {
    this.salaryMin = salaryMin;
  }

  @Column(name="salary_max")
  public double getSalaryMax() {
    return salaryMax;
  }

  public void setSalaryMax(double salaryMax) {
    this.salaryMax = salaryMax;
  }

  @Column(name="point_of_contact")
  public String getPointOfContact() {
    return pointOfContact;
  }

  
  public void setPointOfContact(String pointOfContact) {
    this.pointOfContact = pointOfContact;
  }

  @Column(name="specifications_link")
  public URI getSpecificationsLink() {
    return specificationsLink;
  }

  public void setSpecificationsLink(URI specificationsLink) {
    this.specificationsLink = specificationsLink;
  }

  @Column(name="closed")
  public boolean isClosed() {
    return closed;
  }

  public void setClosed(boolean closed) {
    this.closed = closed;
  }

  @Size(max=10000)
  @Column(name="notes")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  @Override
  public String toString() {
    return "Position{" + "id=" + id + ", company=" + company + ", position=" + position + ", agency=" + agency + ", salaryMin=" + salaryMin + ", salaryMax=" + salaryMax + ", pointOfContact=" + pointOfContact + ", specificationsLink=" + specificationsLink + ", closed=" + closed + ", notes=" + notes + '}';
  }
  
  
  
  
  
  
}
