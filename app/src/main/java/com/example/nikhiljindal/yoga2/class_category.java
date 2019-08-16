package com.example.nikhiljindal.yoga2;


public class class_category {
    public String asana_name;
    public String description;
    public String benefits;
    public String precautions;
    public String image;

    public class_category(String asana_name, String description, String benefits, String precautions, String image) {
        this.asana_name = asana_name;
        this.description = description;
        this.benefits = benefits;
        this.precautions = precautions;
        this.image = image;
    }

    public String getAsana_name() {
        return asana_name;
    }

    public void setAsana_name(String asana_name) {
        this.asana_name = asana_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

