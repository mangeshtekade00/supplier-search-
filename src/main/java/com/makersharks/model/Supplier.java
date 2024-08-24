package com.makersharks.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity

@Table(name = "supplier")

public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long supplierId;

    private String companyName;

    private String website;

    private String location;
@Enumerated(EnumType.STRING)
private NatureOfBusiness natureOfBusiness;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "supplier_processes", joinColumns = @JoinColumn(name = "supplier_id"))
    @Column(name = "process")
   private Set<String> manufacturingProcesses;
    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public NatureOfBusiness getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(NatureOfBusiness natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public Set<String> getManufacturingProcesses() {
        return manufacturingProcesses;
    }

    public void setManufacturingProcesses(Set<String> manufacturingProcesses) {
        this.manufacturingProcesses = manufacturingProcesses;
    }




    public enum ManufacturingProcess {
        ;
        public static Table PRINTING_3D;
    }
}