package GymManagement;

import java.math.BigInteger;

class Member extends Person {
    //private String name;
    //private int age;
    private int membershipType;
    private BigInteger phoneNumber;
    private int plan;

    public Member(BigInteger phoneNumber,String name, int age, int membershipType, int plan) {
    	super(name,age,phoneNumber);
    	this.membershipType = membershipType;
        this.setPlan(plan);
        
    }

    public String getMembershipType() {
    	if(membershipType == 1) {
    		return "Cardio";
    	}else
        return "Strength Training";
    }

    public void setMembershipType(int membershipType) {
        this.membershipType = membershipType;
    }


	public int getPlan() {
		 if(this.plan == 1) {
			return 1000;
		}else if(this.plan == 2) {
			return 2500;
		}else if(this.plan == 3) {
			return 5500;
		}else {
			System.out.println("Give the correct choice!!");
			return 0;
		}
	}

	public void setPlan(int plan) {
		
		this.plan = plan;
	}
	public int price() {
		if(membershipType == 1) {
			return (getPlan() + 1000);
		}else {
			return (getPlan() + 500);
		}
	}
}