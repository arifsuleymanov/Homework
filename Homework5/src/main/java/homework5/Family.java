package homework5;

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

    // add a child
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

    public boolean deleteChild(int index){
        if (index > getChildren().length - 1) {
            getChildren();
        } else {
            Human[] children = new Human[getChildren().length - 1];
            if (children.length == 0) {
                children = new Human[0];
                System.out.println("This family doesn't have children yet!");
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


}
