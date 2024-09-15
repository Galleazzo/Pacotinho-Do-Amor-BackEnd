package br.com.backEnd.pacotinho.core.domain.type;

public enum AnimalAge {

    BELOW_TWO_MONTHS(0),
    TWO_TO_SIX_MONTHS(1),
    SEVEN_TO_ELEVEN_MONTHS(2),
    ONE_YEARS(3),
    TWO_YEARS(4),
    THREE_YEARS(5),
    FOUR_YEARS(6),
    FIVE_YEARS(7),
    MORE_SIX_YEARS(8);
    private final int value;

    private AnimalAge(int i){
        this.value=i;
    }

    public static AnimalAge getByValue(Long i) {
        for(AnimalAge dt : AnimalAge.values()) {
            if(dt.value == i) {
                return dt;
            }
        }
        throw new IllegalArgumentException("no datatype with " + i + " exists");
    }
    
}
