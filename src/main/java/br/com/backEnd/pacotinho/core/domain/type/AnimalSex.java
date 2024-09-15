package br.com.backEnd.pacotinho.core.domain.type;

public enum AnimalSex {

    MALE(0),
    FEMALE(1);

    private final int value;

    private AnimalSex(int i){
        this.value=i;
    }

    public static AnimalSex getByValue(Long i) {
        for(AnimalSex dt : AnimalSex.values()) {
            if(dt.value == i) {
                return dt;
            }
        }
        throw new IllegalArgumentException("no datatype with " + i + " exists");
    }
    
}
