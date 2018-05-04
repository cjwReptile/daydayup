package HomeWorkManager.enums;

public enum StateEnum {

    SUCCESS(true),FAILED(false);


    private Boolean state;

    private StateEnum(Boolean state){
          this.state=state;
    }

    public Boolean getValue(){
        return this.state;
    }
}
