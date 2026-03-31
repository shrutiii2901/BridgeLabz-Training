interface ElectionService {
    void registerVoter();
    void addCandidate();
    void castVote() throws DuplicateVoteException;
    void displayResults();
}
