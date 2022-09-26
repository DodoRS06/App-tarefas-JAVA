package model;

import java.util.Date;

public class Project {
    
    private int id;
    private String name;
    private String description;
    private Date createdAT;
    private Date updatedAT;

    public Project(int id, String name, String description, Date createdAT, Date updatedAT) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAT = createdAT;
        this.updatedAT = updatedAT;
    }
    
    public Project(){
        this.createdAT = new Date();
        this.updatedAT = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(Date createdAT) {
        this.createdAT = createdAT;
    }

    public Date getUpdatedAT() {
        return updatedAT;
    }

    public void setUpdatedAT(Date updatedAT) {
        this.updatedAT = updatedAT;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
}
