
package com.mycompany.pojo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ritu
 * this class stores doctor and nurse registration form`s parameters. 
 */
@XmlRootElement
public class StaffPojo {
    private String name;
    private String gender;
    private String marrital_status;
    private String dob;
    private String address;

    public String getQualification() {
        return qualification;
    }

    public StaffPojo(String name, String gender, String marrital_status, String dob, String address,  long phone_no, String dept, String email, String pwd,String qualification,String uniname, String mainSub, String otherSub, int passingYear) {
        this.name = name;
        this.gender = gender;
        this.marrital_status = marrital_status;
        this.dob = dob;
        this.address = address;
        this.qualification = qualification;
        this.uniname = uniname;
        this.mainSub = mainSub;
        this.otherSub = otherSub;
        this.passingYear = passingYear;
        this.phone_no = phone_no;
        this.dept = dept;
        this.email = email;
        this.pwd = pwd;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getUniname() {
        return uniname;
    }

    public void setUniname(String uniname) {
        this.uniname = uniname;
    }

    public String getMainSub() {
        return mainSub;
    }

    public void setMainSub(String mainSub) {
        this.mainSub = mainSub;
    }

    public String getOtherSub() {
        return otherSub;
    }

    public void setOtherSub(String otherSub) {
        this.otherSub = otherSub;
    }

    public int getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(int passingYear) {
        this.passingYear = passingYear;
    }
    private String qualification;
    private String uniname;
    private String mainSub;
    private String otherSub;
    private int passingYear;
    private long phone_no;
    private String dept;
    private String email;
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarrital_status() {
        return marrital_status;
    }

    public void setMarrital_status(String marrital_status) {
        this.marrital_status = marrital_status;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(long phone_no) {
        this.phone_no = phone_no;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public StaffPojo() {
    }
    
    
    
}
