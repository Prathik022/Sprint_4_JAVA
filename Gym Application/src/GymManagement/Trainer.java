package GymManagement;

import java.math.BigInteger;

class Trainer extends Person{
    
    private String specialty;
    private int experience;

    public Trainer(String name, String specialty, int experience,BigInteger phoneNumber, int age) {
        super(name,age,phoneNumber);
        this.specialty = specialty;
        this.experience = experience;
    }

    
   

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
