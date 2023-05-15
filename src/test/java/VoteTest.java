import org.example.Vote;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VoteTest {

    private static Stream<Arguments> voteConditions() {
        return Stream.of(
                Arguments.of(15, "Sem direito a votar"),
                Arguments.of(16, "Voto facultativo"),
                Arguments.of(17, "Voto facultativo"),
                Arguments.of(18, "Voto obrigatório"),
                Arguments.of(30, "Voto obrigatório"),
                Arguments.of(70, "Voto obrigatório"),
                Arguments.of(71, "Voto facultativo"),
                Arguments.of(80, "Voto facultativo")
        );
    }

    @ParameterizedTest
    @CsvSource({
            "15, Sem direito a votar",
            "16, Voto facultativo",
            "17, Voto facultativo",
            "18, Voto obrigatório",
            "30, Voto obrigatório",
            "70, Voto obrigatório",
            "71, Voto facultativo",
            "80, Voto facultativo"
    })
    public void testCanVoteCsvSource(int age, String expected) {
        String result = Vote.canVote(age);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "dados_teste.csv", numLinesToSkip = 1)
    public void testCanVoteCsvFile(int age, String expected) {
        String result = Vote.canVote(age);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("voteConditions")
    public void testCanVoteMethodSource(int age, String expected) {
        String result = Vote.canVote(age);
        assertEquals(expected, result);
    }

    @Test
    public void testNegativeAgeException() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Vote.canVote(-1));

        Assertions.assertEquals("Idade inválida!", thrown.getMessage());
    }

    @Test
    public void testTooBigAgeException() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> Vote.canVote(151));

        Assertions.assertEquals("Idade inválida!", thrown.getMessage());
    }
}
