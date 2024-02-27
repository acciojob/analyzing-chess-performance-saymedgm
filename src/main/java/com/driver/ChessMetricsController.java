package com.driver;

import java.util.Scanner;

public class ChessMetricsController {
    private ChessMetricsService chessMetricsService;

    public ChessMetricsController(ChessMetricsService chessMetricsService) {
        this.chessMetricsService = chessMetricsService;
    }

    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    storeChessGameData(scanner);
                    break;
                case 2:
                    calculateAverageMoves(scanner);
                    break;
                case 3:
                    calculateWinRate(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void printMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Store Chess Game Data");
        System.out.println("2. Calculate Average Moves");
        System.out.println("3. Calculate Win Rate");
        System.out.println("4. Exit");
    }

    private void storeChessGameData(Scanner scanner) {
        System.out.println("Enter Player Name:");
        scanner.nextLine(); // Consume the newline character
        String playerName = scanner.nextLine();

        System.out.println("Enter Opponent Name:");
        String opponentName = scanner.nextLine();

        System.out.println("Enter Number of Moves:");
        int numberOfMoves = scanner.nextInt();

        System.out.println("Did " + playerName + " win? (true/false):");
        boolean isWin = scanner.nextBoolean();

        ChessGameDTO chessGameDTO = new ChessGameDTO(playerName, opponentName, numberOfMoves, isWin);
        chessMetricsService.storeChessGameData(chessGameDTO);
        System.out.println("Chess Game Data stored successfully.");
    }

    private void calculateAverageMoves(Scanner scanner) {
        System.out.println("Enter Player Name:");
        scanner.nextLine(); // Consume the newline character
        String playerName = scanner.nextLine();

        double averageMoves = chessMetricsService.calculateAverageMoves(playerName);
        System.out.println("Average Moves for " + playerName + ": " + averageMoves);
    }

    private void calculateWinRate(Scanner scanner) {
        System.out.println("Enter Player Name:");
        scanner.nextLine(); // Consume the newline character
        String playerName = scanner.nextLine();

        double winRate = chessMetricsService.calculateWinRate(playerName);
        System.out.println("Win Rate for " + playerName + ": " + winRate + "%");
    }
}