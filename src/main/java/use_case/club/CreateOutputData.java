package use_case.club;

public class CreateOutputData {
    private boolean flag;
    private String message;

    public CreateOutputData(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public boolean getFlag() {
        return flag;
    }

    public String getMessage() {
        return message;
    }
}
