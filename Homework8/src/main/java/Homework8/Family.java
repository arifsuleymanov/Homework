package Homework8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Pet pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }



    public void addChild(Human child){
        if (child != null) {
            List<Human> children = new ArrayList<>();
            for (int i = 0; i < this.getChildren().size(); i++) {
                children.set(i, getChildren().get(i));
            }

            children.set(getChildren().size(), child);
            setChildren(children);
            child.setFamily(this);
        } else {
            getChildren();
        }
    }

    // delete child by index(int)
    public boolean deleteChildByIndex(int index){
        if (index > getChildren().size() - 1) {
            getChildren();
        } else {
            List<Human> children = new ArrayList<>();
            if (children.size() == 0) {
                children = null;
            } else {
                for (int i = 0, k = 0; i < children.size(); i++) {
                    if (i == index) {
                        continue;
                    }
                    children.set(k++, getChildren().get(i));

                }
            }
            setChildren(children);
            return true;
        }
        return false;
    }

    public int countFamily(Family family){
        return family.getChildren().size() + 2;
    }

    // delete a child by Human
    public boolean deleteChildByHuman(Human child) {
        if (child != null) {
            for (int i = 0; i < getChildren().size(); i++) {
                if (child.equals(getChildren().get(i))) {
                    List<Human> children = new ArrayList<>();
                    for (int k = 0, j = 0; k < getChildren().size(); k++) {
                        if (getChildren().get(k).getName().equals(child.getName())) continue;
                        children.set(j++, getChildren().get(k));
                    }
                    setChildren(children);
                    return true;
                } else {
                    getChildren();
                    return false;
                }
            }
        } else {
            getChildren();
            return false;
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
