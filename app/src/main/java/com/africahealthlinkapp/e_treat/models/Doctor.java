package com.africahealthlinkapp.e_treat.models;

public class Doctor {
    private String department;
    private String qualification;
    private String specialization;
    private String education;
    private String CV;
    private String nationalId;
    private String academicDocs;


    public Doctor() {
    }

    public Doctor(String department, String qualification, String specialization, String education, String CV, String nationalId, String academicDocs) {
        this.department = department;
        this.qualification = qualification;
        this.specialization = specialization;
        this.education = education;
        this.CV = CV;
        this.nationalId = nationalId;
        this.academicDocs = academicDocs;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getAcademicDocs() {
        return academicDocs;
    }

    public void setAcademicDocs(String academicDocs) {
        this.academicDocs = academicDocs;
    }
}
