package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import game.MineSweeper;

class MineSweeperTest {

    private MineSweeper mineSweeper;
    private final String goodMine = "...*\n..*.\n....";
    private final String badMineWithDoubleN = "*...\n\n..*.\n....";
    private final String badMineWithExtraDot = "*...\n...*.\n....";
    private final String badMineWithWrongChar = "*...\n,.*.\n....";
    private final String badWithEmptyString = "";

    @BeforeEach
    void setUp() {
        mineSweeper = new MineSweeper();
    }

    @Test
    void checkCorrectStringInSetMine() {
        mineSweeper.setMineField(goodMine);
    }

    @Test
    void checkDoubleNStringInSetMine() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> mineSweeper.setMineField(badMineWithDoubleN));
    }

    @Test
    void checkExtraCharInStringInSetMine() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> mineSweeper.setMineField(
            badMineWithExtraDot));
    }

    @Test
    void checkWrongCharInStringInSetMine() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> mineSweeper.setMineField(
            badMineWithWrongChar));
    }

    @Test
    void testIfGetHintThrowExceptionWhenMineFieldIsStillNull() {
        Assertions.assertThrows(IllegalStateException.class, () -> mineSweeper.getHintField());
    }

    @Test
    void tesSetMineWithEmptyString() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> mineSweeper.setMineField(
            badWithEmptyString));
    }

    @Test
    void testIfGetHintWhenMapIsAlreadySetWithCorrectMap() {
        mineSweeper.setMineField(goodMine);
        Assertions.assertEquals("012*\n"
            + "01*2\n"
            + "0111", mineSweeper.getHintField());
    }

}
