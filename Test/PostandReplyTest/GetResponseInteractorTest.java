package PostandReplyTest;

import Entity.PostandReply.MessageFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.postandreply.ChatwithAI.GetResponseInputData;
import use_case.postandreply.ChatwithAI.GetResponseInteractor;
import use_case.postandreply.ChatwithAI.GetResponseOutputData;

import static org.junit.jupiter.api.Assertions.*;

public class GetResponseInteractorTest {
    private ChatgptDataAccessStub chatgptDataAccessStub;
    private GetResponseOutputBoundaryStub outputBoundaryStub;
    private MessageFactory messageFactory;
    private GetResponseInteractor interactor;

    @BeforeEach
    public void setUp() {
        chatgptDataAccessStub = new ChatgptDataAccessStub();
        outputBoundaryStub = new GetResponseOutputBoundaryStub();
        messageFactory = new MessageFactory();
        interactor = new GetResponseInteractor(chatgptDataAccessStub, outputBoundaryStub, messageFactory);
    }

    @Test
    public void testSendMessageSuccess() {
        String predefinedResponse = "Test response";
        chatgptDataAccessStub.setPredefinedResponse(predefinedResponse);

        GetResponseInputData inputData = new GetResponseInputData("user", "Who won the world series in 2020?");
        interactor.SendMessage(inputData);

        GetResponseOutputData outputData = outputBoundaryStub.getLastOutputData();
        assertNotNull(outputData, "The Los Angeles Dodgers won the World Series in 2020.");
        assertEquals(predefinedResponse, outputData.GetAnswer(), "The AI answer should match the predefined response");
    }

    @Test
    public void testSendMessageFailure() {
        chatgptDataAccessStub.setPredefinedResponse(null);

        GetResponseInputData inputData = new GetResponseInputData("user", "content");
        interactor.SendMessage(inputData);

        String failMessage = outputBoundaryStub.getLastFailMessage();
        assertEquals("Responsse did not get successfully", failMessage, "The failure message should match the expected message");
    }
}
