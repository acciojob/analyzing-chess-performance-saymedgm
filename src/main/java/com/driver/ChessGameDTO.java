package com.driver;

public class ChessGameDTO {
    private String playerName;
    private String opponentName;
    private int numberOfMoves;
    private boolean isWin;

    public ChessGameDTO(String playerName, String opponentName, int numberOfMoves, boolean isWin) {
        this.playerName = playerName;
        this.opponentName = opponentName;
        this.numberOfMoves = numberOfMoves;
        this.isWin = isWin;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public boolean isWin() {
        return isWin;
    }
}

