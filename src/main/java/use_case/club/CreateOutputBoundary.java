package use_case.club;

public interface CreateOutputBoundary {
    public void prepareSuccessView(CreateOutputData createOutputData);
    public void prepareFailView(CreateOutputData createOutputData);
}
