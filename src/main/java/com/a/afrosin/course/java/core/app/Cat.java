package com.a.afrosin.course.java.core.app;

public class Cat extends Animal {


    public Cat(String name, int appetite) {
        super(name, appetite);
    }

    public void eat(Plate p) {
        if (!isSatiety()){
            if (p.decreaseFood(getAppetite())){
                setSatiety(true);
                System.out.printf("%s поел.\nКот сыт? Ответ: %b\n", getName(), isSatiety());
            }
            else{
                System.out.printf("%s остался голоден. В тарелке не хватет %d еды.\nКот сыт? Ответ: %b\n", getName(), getAppetite() - p.getFood(), isSatiety());
            }
        }
        else{
            System.out.printf("Кот %s отказался от трапезы, он не голоден.\n", getName());
        }
    }

}
