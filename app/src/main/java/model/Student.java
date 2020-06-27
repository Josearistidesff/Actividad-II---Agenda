package model;

public class Student {

    private String name;
    private String lastName;
    private String address;
    private String career;
    private String birthDate;
    private String gender;
    private int profileImg;

    public Student(String name, String lastName, String address, String career, String birthDate, String gender, int profileImg) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.career = career;
        this.birthDate = birthDate;
        this.gender = gender;
        this.profileImg = profileImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(int profileImg) {
        this.profileImg = profileImg;
    }
}
