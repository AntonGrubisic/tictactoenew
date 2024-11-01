package com.example.tictactoenew;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    private Model model;

    @BeforeEach
    void setUp() {
        model = new Model();
        model.resetBoard();
    }



    @Test
    void testToCheckForAValidMove(){
        boolean result = model.makeMove(0, 0, 'X');
        assertTrue(result, "Draget borde vara giltigt och returnera true");
        assertEquals('X', model.getBoard()[0][0], "Rutan borde innehålla 'X'");

    }

    @Test
    void testToSeeIfTheRoundIsFinishedOrNot(){
        model.makeMove(0, 0, 'X');
        model.makeMove(1, 1, 'O');
        assertEquals('-', model.checkWinner(), "Rundan borde inte vara klar ännu");

        // 2. Kontrollera att spelare X vinner horisontellt
        model.resetBoard();
        model.makeMove(0, 0, 'X');
        model.makeMove(0, 1, 'X');
        model.makeMove(0, 2, 'X');
        assertEquals('X', model.checkWinner(), "Spelare X borde ha vunnit rundan horisontellt");

        // 3. Kontrollera att spelare O vinner vertikalt
        model.resetBoard();
        model.makeMove(0, 0, 'O');
        model.makeMove(1, 0, 'O');
        model.makeMove(2, 0, 'O');
        assertEquals('O', model.checkWinner(), "Spelare O borde ha vunnit rundan vertikalt");

        // 4. Kontrollera att spelet är oavgjort
        model.resetBoard();
        model.makeMove(0, 0, 'X');
        model.makeMove(0, 1, 'O');
        model.makeMove(0, 2, 'X');
        model.makeMove(1, 0, 'X');
        model.makeMove(1, 1, 'O');
        model.makeMove(1, 2, 'X');
        model.makeMove(2, 0, 'O');
        model.makeMove(2, 1, 'X');
        model.makeMove(2, 2, 'O');
        assertEquals('D', model.checkWinner(), "Rundan borde vara oavgjord");
    }

    }
