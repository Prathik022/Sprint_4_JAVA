package GymManagement;

import java.util.ArrayList;
import java.util.List;

class Gym {
    private List<Member> members;
    private List<Trainer> trainers;

    public Gym() {
        members = new ArrayList<>();
        trainers = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }
}
