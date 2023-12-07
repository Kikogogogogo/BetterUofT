package use_case.club.CreateUsecase;

public interface CreateOutputBoundary {
    public void modifyDescription(String description);
    public void prepareSuccessView(CreateOutputData createOutputData);
    public void prepareFailView(CreateOutputData createOutputData);
}
