package Homework7;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children = new Human[0];
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

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
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
            Human[] children = new Human[this.getChildren().length + 1];
            for (int i = 0; i < this.getChildren().length; i++) {
                children[i] = getChildren()[i];

            }

            children[getChildren().length] = child;
            setChildren(children);
            child.setFamily(this);
        } else {
            getChildren();
        }
    }

    // delete child by index(int)
    public boolean deleteChildByIndex(int index){
        if (index > getChildren().length - 1) {
            getChildren();
        } else {
            Human[] children = new Human[getChildren().length - 1];
            if (children.length == 0) {
                children = new Human[0];
            } else {
                for (int i = 0, k = 0; i < children.length; i++) {
                    if (i == index) {
                        continue;
                    }
                    children[k++] = getChildren()[i];
                }
            }
            setChildren(children);
            return true;
        }
        return false;
    }

    public int countFamily(Family family){
        return family.getChildren().length + 2;
    }

    // delete a child by Human
    public boolean deleteChildByHuman(Human child) {
        if (child != null) {
            for (int i = 0; i < getChildren().length; i++) {
                if (child.equals(getChildren()[i])) {
                    Human[] children = new Human[getChildren().length - 1];
                    for (int k = 0, j = 0; k < getChildren().length; k++) {
                        if (getChildren()[k].getName().equals(child.getName())) continue;
                        children[j++] = getChildren()[k];
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
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Arrays.equals(children, family.children);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother.getName() + " " + mother.getSurname() +
                ", father=" + father.getName() + " " + father.getSurname() +
                ", children=" + Arrays.deepToString(children) +
                ", pet=" + pet +
                '}';
    }
}
