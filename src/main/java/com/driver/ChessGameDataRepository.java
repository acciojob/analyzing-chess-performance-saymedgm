package com.driver;

import java.util.ArrayList;
import java.util.List;

public class ChessGameDataRepository {
    private List<ChessGame> chessGames;

    public ChessGameDataRepository() {
        this.chessGames = new ArrayList<>();
    }

    public void storeChessGame(ChessGame chessGame) {
        chessGames.add(chessGame);
    }

    public List<ChessGame> getAllChessGames() {
        return new ArrayList<>(chessGames);
    }
}
