package use_case.set_up_players;

public interface SetUpPlayersOutputBoundary {

    void prepareSuccessView(SetUpPlayersOutputData outputData);

    void prepareFailView(SetUpPlayersOutputData outputData);
}
