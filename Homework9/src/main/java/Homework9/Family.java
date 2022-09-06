package Homework9;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.pet = getPet();
        mother.setFamily(this);
        father.setFamily(this);
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }



    public void addChild(Human child){
        if (child != null) {
            children.add(child);
            setChildren(children);
            child.setFamily(this);
        }
    }

    // delete child by index(int)
    public boolean deleteChildByIndex(int index){
        if (index < getChildren().size()) {
            children.remove(index);
            for (int i =0; i<getChildren().size(); i++) {
                if (children.get(i) == null) {
                    continue;
                }
                children.add(getChildren().get(i));
            }
            setChildren(children);
            return true;
        }
        return false;
    }

    public int countFamily(){
        return getChildren().size() + 2;
    }

    // delete a child by Human
    public boolean deleteChildByHuman(Human child) {
        if (child != null) {
            // deleting the given child
            for (int i = 0; i < getChildren().size(); i++) {
                if (getChildren().get(i).equals(child)) {
                    children.remove(child);
                }
            }

            // collecting to list without deleted child
            for (int i =0; i<getChildren().size(); i++) {
                if (children.get(i) == null) {
                    continue;
                }
                children.add(getChildren().get(i));
            }
            setChildren(children);

        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Objects.equals(children,
                family.children);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father);
        result = 31 * result + children.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother.getName() + " " + mother.getSurname() +
                ", father=" + father.getName() + " " + father.getSurname() +
                ", children=" + children +
                ", pet=" + pet +
                '}';
    }

}
