package com.africahealthlinkapp.e_treat.models;

public class Doctor {
    private String firstName;
    private String lastName;
    private String email;
    private String userId;
    private String phone;
    private String department;
    private String qualification;
    private String specialization;
    private String education;
    private String CV;
    private String nationalId;
    private String academicDocs;


    public Doctor(String firstName, String lastName, String email, String userId, String phone,
                  String department, String qualification, String specialization, String education,
                  String CV, String nationalId, String academicDocs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userId = userId;
        this.phone = phone;
        this.department = department;
        this.qualification = qualification;
        this.specialization = specialization;
        this.education = education;
        this.CV = CV;
        this.nationalId = nationalId;
        this.academicDocs = academicDocs;
    }

    public Doctor() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
