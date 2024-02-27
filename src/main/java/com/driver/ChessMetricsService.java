package com.driver;

import java.util.List;
import java.util.stream.Collectors;

public class ChessMetricsService {
    private ChessGameDataRepository chessGameDataRepository;

    public ChessMetricsService(ChessGameDataRepository chessGameDataRepository) {
        this.chessGameDataRepository = chessGameDataRepository;
    }

    public double calculateAverageMoves(String playerName) {
        List<ChessGame> playerGames = getPlayerGames(playerName);
        if (playerGames.isEmpty()) {
            return 0.0;
        }
        int totalMoves = playerGames.stream().mapToInt(ChessGame::getNumberOfMoves).sum();
        return (double) totalMoves / playerGames.size();
    }

    public double calculateWinRate(String playerName) {
        List<ChessGame> playerGames = getPlayerGames(playerName);
        if (playerGames.isEmpty()) {
            return 0.0;
        }
        long wins = playerGames.stream().filter(ChessGame::isWin).count();
        return (double) wins / playerGames.size() * 100;
    }

    private List<ChessGame> getPlayerGames(String playerName) {
        return chessGameDataRepository.getAllChessGames().stream()
                .filter(game -> game.getPlayerName().equals(playerName))
                .collect(Collectors.toList());
    }

    public void storeChessGameData(ChessGameDTO chessGameDTO) {
        ChessGame chessGame = new ChessGameDataConverter().convertToEntity(chessGameDTO);
        chessGameDataRepository.storeChessGame(chessGame);
    }
}